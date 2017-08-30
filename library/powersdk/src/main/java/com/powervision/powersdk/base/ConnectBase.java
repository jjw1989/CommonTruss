package com.powervision.powersdk.base;

import android.util.Log;

import com.powervision.powersdk.callback.SystemStatusCallback;
import com.powervision.powersdk.manage.ConnectManager;
import com.powervision.powersdk.model.ConnectModel;

/**
 * 连接基类
 * Created by Sundy on 2017/1/17.
 */

public abstract class ConnectBase implements SystemStatusCallback.ConnectionListener {
    private static final String TAG = "ConnManage";
    private InterConnectListener listener;

    public void setListener(InterConnectListener listener) {
        this.listener = listener;
    }

    /**
     * 链路连接中
     */
    @Override
    public void onConnecting() {
        Log.i(TAG, "onConnecting: ..................1");
       if(listener!=null){
           listener.onConnectCallBack(ConnectModel.onConnecting);
       }
    }

    /**
     * 链路连接成功
     */
    @Override
    public void onConnectSuccess() {
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onConnectSuccess);
        }
        Log.i(TAG, "onConnectSuccess: ..................1");
    }

    /**
     * 链路已连接
     */
    @Override
    public void onDisConnected() {
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onDisConnected);
        }
        Log.i(TAG, "onDisConnected: ...................1");
    }


    /**
     * 链路连接超时
     */
    @Override
    public void onConnectTimeout() {
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onConnectTimeout);
        }
        Log.i(TAG, "onConnectTimeout: ................1");
    }

    /**
     * 心跳超时
     */
    @Override
    public void onHeartbeatTimeout() {
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onHeartbeatTimeout);
        }
        Log.i(TAG, "onHeartbeatTimeout: ..................1");
    }


    /**
     * 标准遥控器已连接
     */
    @Override
    public void onConnectedStandardRemotecontrol() {
        Log.d(TAG, "标准遥控器....................");

        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onConnectedStandardRemotecontrol);
        }
    }

    /**
     * 体感遥控器已连接
     */
    @Override
    public void onConnectedMotionsensingRemotecontrol() {
        Log.d(TAG, "体感遥控器....................1");
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onConnectedMotionsensingRemotecontrol);
        }
    }

    /**
     * 链路连接失败
     */
    @Override
    public void onConnectFailed() {
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onConnectFailed);
        }
        Log.i(TAG, "onConnectFailed:链路连接失败 ......................1");
    }

    /**
     * 飞机连接中
     */
    @Override
    public void onDroneConnecting() {
        Log.d(TAG, "onDroneConnecting飞机连接中....................1");
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onDroneConnecting);
        }
    }
    /**
     * 飞机已连接
     */
    @Override
    public void onDroneConnected() {
        Log.d(TAG, "onDroneConnected连接成功....................1");
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onDroneConnected);
        }
    }
    /**
     * 飞机已断开
     */
    @Override
    public void onDroneDisConnected() {
        Log.d(TAG, "onDroneDisConnected链路连接断开....................1");
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onDroneDisConnected);
        }
    }

    /**
     * 飞机连接超时
     */
    @Override
    public void onDroneConnectTimeout() {
        Log.d(TAG, "onDroneConnectTimeout飞机连接超时....................1/");
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onDroneConnectTimeout);
        }
    }

    /**
     * 飞机连接失败
     */
    @Override
    public void onDroneConnectFailed() {
        Log.d(TAG, "onDroneConnectFailed飞机连接失败....................1");
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onDroneConnectFailed);
        }
    }

    /**
     * 水下机器人已连接
     */
    @Override
    public void onRayConnected() {
        Log.i(TAG, "onRayConnected: 水下机器人已连接..........................1");
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onRayConnected);
        }
    }

    /**
     * 心跳恢复
     */
    @Override
    public void onDroneConnectedReplay() {
        Log.i(TAG, "onDroneConnectedReplay:心跳恢复 ............................");
        if(listener!=null){
            listener.onConnectCallBack(ConnectModel.onDroneConnectedReplay);
        }
    }
    public interface InterConnectListener{
        public void onConnectCallBack(ConnectModel model);
    }
}
