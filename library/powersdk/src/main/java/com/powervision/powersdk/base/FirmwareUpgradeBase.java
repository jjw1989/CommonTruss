package com.powervision.powersdk.base;

import com.powervision.powersdk.callback.RemoteControlCallback;
import com.powervision.powersdk.callback.SystemStatusCallback;
import com.powervision.powersdk.model.FlyControlModel;
import com.powervision.powersdk.model.RemoteModel;

/**
 * Created by lewis on 2017/3/20.
 * 固件升级基类
 */

public class FirmwareUpgradeBase implements RemoteControlCallback.FirmwareUpgradeListener, SystemStatusCallback.UploadRateOfProgressListener {

    private FirmwareListener mFirmwareListener;

    protected void setFirmwareListener(FirmwareListener mListener) {
        this.mFirmwareListener = mListener;
    }

    @Override
    public void onFirmwareUpgradeSuccess() {
        if (mFirmwareListener != null) {
            mFirmwareListener.firmwareCallBack(RemoteModel.RC_UPGRADE_SUCCESS, 0);
        }
    }

    @Override
    public void onFirmwareUpgradeProcessing(int progress) {
        if (mFirmwareListener != null) {
            mFirmwareListener.firmwareCallBack(RemoteModel.RC_UPGRADE_PROGRESS, progress);
        }
    }

    @Override
    public void onFirmwareUpgradeFailed() {
        if (mFirmwareListener != null) {
            mFirmwareListener.firmwareCallBack(RemoteModel.RC_UPGRADE_ERROR, 0);
        }
    }

    @Override
    public void onUpgradeing(int progress) {
        if (mFirmwareListener != null) {
            mFirmwareListener.firmwareCallBack(FlyControlModel.UPGRADE_PROGRESS, progress);
        }
    }

    @Override
    public void onUpgraded() {
        if (mFirmwareListener != null) {
            mFirmwareListener.firmwareCallBack(FlyControlModel.UPGRADE_SUCCESS, 0);
        }
    }

    @Override
    public void onUpgradeFailed() {
        if (mFirmwareListener != null) {
            mFirmwareListener.firmwareCallBack(FlyControlModel.UPGRADE_ERROR, 0);
        }
    }

    public interface FirmwareListener {
        void firmwareCallBack(int status, int progress);
    }
}
