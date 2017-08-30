package com.powervision.powersdk.manage;

import android.os.Handler;
import android.support.annotation.IntDef;
import android.util.Log;

import com.powervision.powersdk.PVSdk;
import com.powervision.powersdk.base.ConnectBase;
import com.powervision.powersdk.sdk.PowerSDK;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.TimerTask;

/**
 * 连接管理
 * Created by Sundy on 2017/1/13.
 */

public class ConnectManager extends ConnectBase{
    private Handler mHandler;
    private PowerSDK powerSDK;
    private Conn conn;
    private String tcpIp;
    private int tcpPort;
    //初始化状态
    private static final int INIT=0;
    //链路连接状态
    private static final int CONN=1;
    private static final int CONN_DRONE=2;
    //连接飞机状态
    private static final int DRONE=3;
    //连接成功状态
    private static final int DONE=4;

    //心跳超时开始计时，如果10s还没有重连成功，表示可以保存日志了
    private int second = 0;

    @IntDef({INIT,CONN, DRONE,CONN_DRONE,DONE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnState{}
    @PVSdk.ConnState int currentState =INIT;

    public void initSDK(final String tcpIp, final int tcpPort) {
        //1 获得powerSDK实例
        powerSDK = PowerSDK.getInstance();
        connDrone();
    }
    /**
     * 连接飞机操作
     *
     * 如果连接飞机超时 需要在onConnectTimeout中重新调用handler.postDelayed(conn,3100);
     * */
    private class Conn extends TimerTask {
        @Override
        public void run() {
            Log.e("SDK","Conn==>111");
            switch (currentState){
                case INIT:
                    if (powerSDK.initSDK(tcpIp, tcpPort)==0) {
                        powerSDK.registerCallback();
                        powerSDK.setConnectionListener(ConnectManager.this);
                        currentState = CONN;
                    }else {
                        break;
                    }
                    Log.e("SDK","==>INIT");
                case CONN:
                    powerSDK.connect();
                    Log.e("SDK","==>CONN");
                    break;
                case CONN_DRONE://socket连接成功连接飞机失败
                    powerSDK.disConnect();
                    currentState = CONN;
                    mHandler.postDelayed(this,300);
                    Log.e("SDK","==>CONN_DRONE");
                    return;
                case DRONE:
                    if(powerSDK.connectDrone()==0){
                        conn = this;
                    }
                    currentState = CONN_DRONE;

                    Log.e("SDK","==>DRONE");
//                        while(true);
                    break;
                case DONE:
                    Log.e("SDK","conn success");
                    return;
            }
            mHandler.postDelayed(this,3100);
            Log.e("SDK","Conn==>222");
        }
    };


    /**
     * 连接成功后 去除handler 防止重连
     * 需要调用的回调
     * */
    private void connSuccess(){
        if (mHandler!=null && conn!=null) {
            mHandler.removeCallbacks(conn);
        }
        currentState = DONE;
    }

    private void connDrone(){
        Conn conn=new Conn();
        currentState =INIT;
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

    @Override
    public void onConnectTimeout() {
        super.onConnectTimeout();
        mHandler.postDelayed(conn,3100);
    }

    @Override
    public void onBaseStationConnFailed() {

    }
}
