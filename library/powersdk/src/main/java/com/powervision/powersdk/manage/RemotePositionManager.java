package com.powervision.powersdk.manage;

import android.os.Handler;
import android.os.Looper;

import com.powervision.powersdk.base.RemotePositionBase;
import com.powervision.powersdk.sdk.PowerSDK;

/**
 * 要控制器位
 * Created by Sundy on 2017/6/1.
 */

public class RemotePositionManager extends RemotePositionBase{
    private static RemotePositionManager remotePositionManager = null;
    private PowerSDK powerSDK;
    private Handler mHandler;
    private RemotePositionManager() {
        mHandler = new Handler(Looper.getMainLooper());
        powerSDK = PowerSDK.getInstance();
        powerSDK.setRemoteControlLocationListener(this);
    }
    public static RemotePositionManager getInstance() {
        if (remotePositionManager == null) {
            remotePositionManager = new RemotePositionManager();
        }
        return remotePositionManager;
    }
    /**
     * 飞机位置回调监听
     * @param listener
     */
    public void onRemotePositionCallBack(final RemotePositionListener listener){
        mHandler.post(new Runnable() {
            @Override
            public void run() {
             setListener(listener);
            }
        });
    }
}
