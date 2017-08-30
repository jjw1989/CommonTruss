package com.powervision.powersdk.manage;

import com.powervision.powersdk.base.RemoteBase;
import com.powervision.powersdk.sdk.PowerSDK;

/**
 * Created by lewis on 2017/3/16.
 * 遥控器管理类
 */

public class RemoteManager extends RemoteBase {

    private static RemoteManager mRemoteManager = new RemoteManager();

    public static RemoteManager getInstance() {
        return mRemoteManager;
    }

    private RemoteManager() {
        PowerSDK mPowerSDK = PowerSDK.getInstance();
        mPowerSDK.setRemoteControlParamListener(null);
        mPowerSDK.setRemoteControlParamListener(this);
    }

    public void remoteCallback(RemoteListener listener) {
        setRemoteListener(listener);
    }
}

