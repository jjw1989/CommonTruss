package com.powervision.powersdk.manage;

import com.powervision.powersdk.base.ModeChangeBase;
import com.powervision.powersdk.sdk.PowerSDK;

/**
 * Created by lewis on 2017/3/20.
 * 模式
 */

public class ModeChangeManager extends ModeChangeBase {

    private static ModeChangeManager mModeManager = new ModeChangeManager();

    private ModeChangeManager(){
        PowerSDK mPowerSDK = PowerSDK.getInstance();
        mPowerSDK.setModeChangedListener(this);
    }

    public static ModeChangeManager getInstance(){
        return mModeManager;
    }

    public void onModeCallback(RCModeChangeListener listener){
        setRcModeChangeListener(listener);
    }
}
