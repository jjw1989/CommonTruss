package com.powervision.gcs.sdk;

import android.util.Log;

import com.powervision.powersdk.callback.SystemStatusCallback;
import com.powervision.powersdk.sdk.PowerSDK;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 连接管理
 * Created by Sundy on 2017/8/31.
 * 注意：飞机的sdk初始化和监听全部在主线程，所有上层使用时不要再当前的回调中作什么操作，
 */

public class PVConnManager implements SystemStatusCallback.ConnectionListener {
    private static volatile PVConnManager Instance=null;
    private static final String TAG = "PVConnManager";
    /**
     * 飞控主类成员变量
     */
    private PowerSDK mPowerSDK;
    /**
     * 连接配置文件
     */
    private PVConnConfig mConnConfig;
    /**
     * 链路连接标识
     */
    private boolean isLinkConnectFlag = false;
    /**
     * 飞机连接标识
     */
    private boolean isDroneConnect = false;

    public int connFlag=11;

    private PVConnManager() {
        mPowerSDK = PowerSDK.getInstance();
    }
    public static PVConnManager getInstance(){
        if(Instance==null){
            synchronized (PVConnManager.class) {
                if (Instance == null) {
                    Instance = new PVConnManager();
                }
            }
        }
        return Instance;
    }
    public void initSDK(final PVConnConfig connConfig) {
        this.mConnConfig = connConfig;
        if (mPowerSDK.initSDK(mConnConfig.getIp(), mConnConfig.getPort()) == 0) {//sdk初始化失败会不wei初始化状态
            isLinkConnectFlag = true;
            mPowerSDK.registerCallback();
            mPowerSDK.setConnectionListener(PVConnManager.this);
            mPowerSDK.connect();
        }

    }

    /**
     * 链路重连
     */
    public void linkReconnect() {


    }

    public void unInitSDK() {
        if (mPowerSDK != null) {
            //断开飞机
            mPowerSDK.disConnectDrone();
            //断开链路
            mPowerSDK.disConnect();
            // 注销sdk
            mPowerSDK.unInitSDK();
        }
    }

    /**
     * 使用
     */
    @Override
    public void onConnecting() {
        Log.i(TAG, "onConnecting: ");
    }

    @Override
    public void onConnectSuccess() {
        isLinkConnectFlag = true;
        mPowerSDK.connectDrone();
        Log.i(TAG, "onConnectSuccess: link=" + isLinkConnectFlag);
    }

    /**
     * link断开
     */
    @Override
    public void onDisConnected() {
        isLinkConnectFlag = false;
        Log.i(TAG, "onDisConnected: ");
    }

    @Override
    public void onConnectTimeout() {
        isLinkConnectFlag=false;
        Log.i(TAG, "onConnectTimeout: ");
    }

    /**
     *
     */
    @Override
    public void onHeartbeatTimeout() {
        isDroneConnect=false;
        Log.i(TAG, "onHeartbeatTimeout: ");
    }

    @Override
    public void onConnectedStandardRemotecontrol() {
        Log.i(TAG, "onConnectedStandardRemotecontrol: ");
    }

    @Override
    public void onConnectedMotionsensingRemotecontrol() {
        Log.i(TAG, "onConnectedMotionsensingRemotecontrol: ");
    }

    /**
     * link没有连接上
     */
    @Override
    public void onConnectFailed() {
        Log.i(TAG, "onConnectFailed: ");
    }

    @Override
    public void onDroneConnecting() {
        Log.i(TAG, "onDroneConnecting: ");
    }

    @Override
    public void onDroneConnected() {
        isDroneConnect = true;
        connFlag=12;
        Log.i(TAG, "onDroneConnected: ");
    }

    @Override
    public void onDroneDisConnected() {
        isDroneConnect=false;
        Log.i(TAG, "onDroneDisConnected: ");
    }

    /**
     * 飞机创建连接时一直连不上调用
     */
    @Override
    public void onDroneConnectTimeout() {
        isDroneConnect=false;
        Log.i(TAG, "onDroneConnectTimeout: ");
    }

    @Override
    public void onDroneConnectFailed() {
        isDroneConnect=false;
        Log.i(TAG, "onDroneConnectFailed: ");
    }

    @Override
    public void onRayConnected() {
        Log.i(TAG, "onRayConnected: ");
    }

    @Override
    public void onDroneConnectedReplay() {
        Log.i(TAG, "onDroneConnectedReplay: ");
    }

    @Override
    public void onBaseStationConnFailed() {
        Log.i(TAG, "onBaseStationConnFailed: ");
    }
}
