package com.powervision.powersdk.manage;

import com.powervision.powersdk.base.FirmwareUpgradeBase;
import com.powervision.powersdk.sdk.PowerSDK;

/**
 * Created by lewis on 2017/3/20.
 * 遥控器升级管理
 */

public class FirmwareUpgradeManager extends FirmwareUpgradeBase {
    private static FirmwareUpgradeManager mManager = new FirmwareUpgradeManager();

    private FirmwareUpgradeManager() {
        PowerSDK mPowerSDK = PowerSDK.getInstance();
        mPowerSDK.setFirmwareUpgradeListener(null);
        mPowerSDK.setFirmwareUpgradeListener(this);
    }

    public static FirmwareUpgradeManager getInstance() {
        return mManager;
    }

    public void firmwareCallback(FirmwareListener mListener) {
        setFirmwareListener(mListener);
    }
}
