package com.powervision.powersdk;

import android.content.SharedPreferences;
import android.os.Handler;
import android.support.annotation.IntDef;
import android.util.Log;

import com.powervision.powersdk.base.ModeChangeBase;
import com.powervision.powersdk.callback.RayCallback;
import com.powervision.powersdk.callback.SystemStatusCallback;
import com.powervision.powersdk.interfaces.ConnectionListener;
import com.powervision.powersdk.interfaces.MasterControl;
import com.powervision.powersdk.interfaces.OnFlyControllModeChnageListener;
import com.powervision.powersdk.manage.ModeChangeManager;
import com.powervision.powersdk.sdk.PowerSDK;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.TimerTask;


/**
 * GCSLib包装
 * Created by sundy on 2016/8/25.
 */

public class PVSdk implements SystemStatusCallback.ConnectionListener {
    private static final PVSdk SDK = new PVSdk();
    private static final String TAG = "ConnState";
    public int connStatus = -1;
    private Handler mHandler;
    private PowerSDK powerSDK;
    private String tcpIp;
    private int tcpPort;
    //初始化状态
    private static final int INIT = 0;
    //链路连接状态
    private static final int CONN = 1;
    private static final int CONN_DRONE = 2;
    //连接飞机状态
    private static final int DRONE = 3;
    //连接成功状态
    private static final int DONE = 4;

    //心跳超时开始计时，如果10s还没有重连成功，表示可以保存日志了
    private int second = 0;
    private ReConnRunnable reConn;
    private boolean reConnStatus = false;

    @IntDef({INIT, CONN, DRONE, CONN_DRONE, DONE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnState {
    }

    @ConnState
    int currentState = INIT;

    public int getConnStatus() {
        return connStatus;
    }

    public void setConnStatus(int connStatus) {
        this.connStatus = connStatus;
    }

    private PVSdk() {
        mHandler = new Handler();
    }

    public static PVSdk instance() {
        return SDK;
    }

    /**
     * 链路连接标识
     */
    private boolean isConnectFlag = false;
    /**
     * 飞机连接标识
     */
    private boolean isDroneConnect = false;
    /**
     * 船连接标识
     */
    private boolean isRayConnect = false;
    private ConnectionListener connectionListener = null;
    private ModeChangeManager mModeChangeManager;
    private int flyMode;
    private SharedPreferences sharedPreferences;
    /**
     * 判断ray主从设备
     */
    private boolean mIsMaster;
    private MasterControl mMasterControl;

    /**
     * 设置连接监听
     *
     * @param connectionListener
     */
    public void setConnectionListener(ConnectionListener connectionListener) {
        this.connectionListener = connectionListener;
    }

    /**
     * 设置主从模式监听
     */
    public void setMasterControl(MasterControl mMasterControl) {
        this.mMasterControl = mMasterControl;
    }

    public void initSDK(final String tcpIp, final int tcpPort) {
        //1 获得powerSDK实例
        powerSDK = PowerSDK.getInstance();
        reConn = new ReConnRunnable();
        onStart(tcpIp, tcpPort);
    }

    private void initModeChange() {
        mModeChangeManager = ModeChangeManager.getInstance();
        modeChangeCallBack();
    }

    /***
     * 初始化sdk
     *
     * @param tcpIp
     * @param tcpPort
     */
    private void onStart(final String tcpIp, final int tcpPort) {
        this.tcpIp = tcpIp;
        this.tcpPort = tcpPort;
        connDrone();
    }

    private Conn conn;

    /**
     * 连接飞机操作
     * <p>
     * 如果连接飞机超时 需要在onConnectTimeout中重新调用handler.postDelayed(conn,3100);
     */
    private class Conn extends TimerTask {
        @Override
        public void run() {
            Log.e("SDK", "Conn==>111");
            switch (currentState) {
                case INIT:
                    if (powerSDK.initSDK(tcpIp, tcpPort) == 0) {
                        initRayUUID();
                        powerSDK.setRayBaseStationAddress("192.168.1.11", 8080);//船基站ip
                        powerSDK.registerCallback();
                        powerSDK.setConnectionListener(PVSdk.this);
                        currentState = CONN;
                    } else {
                        break;
                    }
                    Log.e("SDK", "==>INIT");
                case CONN:
                    powerSDK.connect();
                    Log.e("SDK", "==>CONN");
                    break;
                case CONN_DRONE://socket连接成功连接飞机失败
                    powerSDK.disConnect();
                    currentState = CONN;
                    mHandler.postDelayed(this, 300);
                    Log.e("SDK", "==>CONN_DRONE");
                    return;
                case DRONE:
                    if (powerSDK.connectDrone() == 0) {
                        conn = this;
                    }
                    currentState = PVSdk.CONN_DRONE;

                    Log.e("SDK", "==>DRONE");
//                        while(true);
                    break;
                case DONE:
                    Log.e("SDK", "conn success");
                    return;
            }
            mHandler.postDelayed(this, 3100);
            Log.e("SDK", "Conn==>222");
        }
    }

    ;


    /**
     * 连接成功后 去除handler 防止重连
     * 需要调用的回调
     */
    private void connSuccess() {
        if (mHandler != null && conn != null) {
            mHandler.removeCallbacks(conn);
            conn.cancel();
            conn = null;
        }
        currentState = DONE;
    }

    public void connDrone() {
        Conn conn = new Conn();
        currentState = INIT;
        conn.run();
    }

    public void unInitSDK() {
        //断开飞机
        powerSDK.disConnectDrone();
        //断开链路
        powerSDK.disConnect();
        // 注销sdk
        powerSDK.unInitSDK();
    }

    public PowerSDK getPowerSDK() {
        return powerSDK;
    }

    /**
     * 链路连接状态
     *
     * @return
     */
    public boolean isConnectStatus() {
        return isConnectFlag;
    }

    /**
     * 飞机连接状态（不能直接用在初始化的方）
     */
    public boolean isDroneConnectStatus() {
        return isDroneConnect;
    }

    /**
     * 船连接状态
     */
    public boolean isRayConnStatus() {
        return isRayConnect;
    }

    /**
     * 保存日志，true-保存 false-不处理
     *
     * @return
     */
    public boolean saveRecord() {
        return second > 10;
    }

    /**
     * 返回主从模式true-主模式 false-从模式
     */
    public boolean isMaster() {
        return mIsMaster;
    }

    /**
     * 飞机连接状态
     */

    @Override
    public void onConnecting() {
        Log.i(TAG, "onConnecting: .............");
        if (connectionListener != null) {
            connectionListener.onConnecting();
        }
    }

    @Override
    public void onConnectSuccess() {
        Log.i(TAG, "onConnectSuccess: ................");
        if (connectionListener != null) {
            connectionListener.onConnectSuccess();
        }
        currentState = DRONE;
        isConnectFlag = true;
    }

    @Override
    public void onDisConnected() {
        Log.i(TAG, "onDisConnected: ..................");
        if (connectionListener != null) {
            connectionListener.onDisConnected();
        }
        isConnectFlag = false;
        isDroneConnect = false;
        isRayConnect = false;
        mIsMaster = false;
    }

    @Override
    public void onConnectTimeout() {
        Log.i(TAG, "onConnectTimeout: .............");
        if (connectionListener != null) {
            connectionListener.onConnectTimeout();
        }
        mHandler.postDelayed(conn, 3100);
        isConnectFlag = false;
    }

    @Override
    public void onHeartbeatTimeout() {
        Log.i(TAG, "onHeartbeatTimeout: ..................");
        if (connectionListener != null) {
            connectionListener.onHeartbeatTimeout();
        }
        isDroneConnect = false;
        isRayConnect = false;
        reConnStatus = true;
        mIsMaster = false;
        //链路断开十秒之后开始重连
        mHandler.postDelayed(reConn, 10000);
        //保存日志计时
        if (second == 0) {
            mHandler.post(timerRunnable);
        }
    }

    class ReConnRunnable implements Runnable {

        @Override
        public void run() {
            Log.i(TAG, "run: 开始重连飞机。。。。。。");
            connDrone();
        }
    }

    @Override
    public void onConnectedStandardRemotecontrol() {
        Log.i(TAG, "onConnectedStandardRemotecontrol: ....................");
        if (connectionListener != null) {
            connectionListener.onConnectedStandardRemotecontrol();
        }
        connSuccess();

    }

    @Override
    public void onConnectedMotionsensingRemotecontrol() {
        Log.i(TAG, "onConnectedMotionsensingRemotecontrol: ...............");
        if (connectionListener != null) {
            connectionListener.onConnectedMotionsensingRemotecontrol();
        }
        connSuccess();
    }

    @Override
    public void onConnectFailed() {
        Log.i(TAG, "onConnectFailed: .....................");
        if (connectionListener != null) {
            connectionListener.onConnectFailed();
        }
        isConnectFlag = false;
        Log.e("SDK", "onConnectFailed()");
    }

    @Override
    public void onDroneConnecting() {
        Log.i(TAG, "onDroneConnecting: ..................");
        if (connectionListener != null) {
            connectionListener.onDroneConnecting();
        }
    }

    @Override
    public void onDroneConnected() {
        Log.i(TAG, "onDroneConnected: ....................");
        if (reConnStatus) {
            mHandler.removeCallbacks(reConn);
            reConnStatus = false;
        }
        initModeChange();
        if (connectionListener != null) {
            connectionListener.onDroneConnected();
        } else {
            Log.i(TAG, "onDroneConnected==null: ....................");
        }
        isDroneConnect = true;
        connSuccess();
    }

    @Override
    public void onDroneDisConnected() {
        Log.i(TAG, "onDroneDisConnected: ..................");
        if (connectionListener != null) {
            connectionListener.onDroneDisConnected();
        }
        isDroneConnect = false;
    }

    @Override
    public void onDroneConnectTimeout() {
        Log.i(TAG, "onDroneConnectTimeout: .................");
        if (connectionListener != null) {
            connectionListener.onDroneConnectTimeout();
        }
        isDroneConnect = false;
        Log.e("SDK", "==>onDroneConnectTimeout");
    }

    @Override
    public void onDroneConnectFailed() {
        Log.i(TAG, "onDroneConnectFailed: .........................");
        if (connectionListener != null) {
            connectionListener.onDroneConnectFailed();
        }
        isDroneConnect = false;
    }

    @Override
    public void onRayConnected() {
        Log.i(TAG, "onRayConnected: .........................");
        if (connectionListener != null) {
            connectionListener.onRayConnected();
        }
        powerSDK.setMasterControlListener(mMasterControlListener);
        isRayConnect = true;
        connSuccess();
    }

    @Override
    public void onDroneConnectedReplay() {
        mHandler.removeCallbacks(reConn);
        Log.i(TAG, "onDroneConnectedReplay: 心跳恢复。。。。。。。。。。。。。。。。。");
        if (connectionListener != null) {
            connectionListener.onDroneConnectedReplay();
        }
        isDroneConnect = true;
        isRayConnect = true;
        //取消计时器
        second = 0;
        mHandler.removeCallbacks(timerRunnable);
    }

    /**
     * 基站电量获取失败
     */
    @Override
    public void onBaseStationConnFailed() {

    }

    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            second++;
            mHandler.postDelayed(this, 1000);
        }
    };

    /**
     * 获取飞行器模式
     *
     * @return
     */
    public int getFlyMode() {
        return flyMode;
    }

    private OnFlyControllModeChnageListener onFlyControllModeChnageListener;

    public void setOnFlyControllModeChnageListener(OnFlyControllModeChnageListener onFlyControllModeChnageListener) {
        this.onFlyControllModeChnageListener = onFlyControllModeChnageListener;
    }

    /**
     * 遥控器模式回调
     */
    private void modeChangeCallBack() {
        mModeChangeManager.onModeCallback(new ModeChangeBase.RCModeChangeListener() {
            @Override
            public void onModeChangeCallback(int mode) {
                Log.e("mode", "mode == >" + mode);
                flyMode = mode;
                if (onFlyControllModeChnageListener != null) {
                    onFlyControllModeChnageListener.setMode(mode);
                }
            }
        });
    }

    private void initRayUUID() {
        powerSDK.initRayUuid(android.os.Build.SERIAL.toString() + android.os.Build.SERIAL.toString());
        Log.e("miaojx", "rayuuid" + android.os.Build.SERIAL.toString() + android.os.Build.SERIAL.toString());
    }

    /**
     * 主从模式回调
     */
    private RayCallback.MasterControlListener mMasterControlListener = new RayCallback.MasterControlListener() {
        @Override
        public void masterControl(boolean masterControl) {
            if (mMasterControl != null) {
                mMasterControl.masterControl(masterControl);
            }
            mIsMaster = masterControl;
        }
    };

}
