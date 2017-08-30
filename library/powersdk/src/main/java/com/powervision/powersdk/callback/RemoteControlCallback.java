package com.powervision.powersdk.callback;

import com.powervision.powersdk.param.ManualControlDateNotifyParam;
import com.powervision.powersdk.param.MountControlDateNotifyParam;
import com.powervision.powersdk.param.RemoteControlLocationNotifyParam;

/**
 * 遥控器相关
 */
public class RemoteControlCallback {

    /**
     * Default constructor
     */
    public RemoteControlCallback() {
    }







    /**
     * 设置，获取遥控器参数回调
     */
    public interface RemoteControlParamListener {



        /**
         * @param paramID 
         * @return
         */
        public void onRemoteControlSetSuccess(String paramID);

        /**
         * @param paramID 
         * @return
         */
        public void onRemoteControlSetTimeout(String paramID);

        /**
         * @param paramID 
         * @return
         */
        public void onRemoteControlGetSuccess(String paramID);

        /**
         * @param paramID 
         * @return
         */
        public void onRemoteControlGetTimeout(String paramID);

    }

    /**
     * 遥控器固件升级结果
     */
    public interface FirmwareUpgradeListener {

        /**
         * 
         */
        public static final int PVSDK_FIRMWAREUPGRADE_CALLBACK_STATUS_FAILED = -1;

        /**
         * 
         */
        public static final int PVSDK_FIRMWAREUPGRADE_CALLBACK_STATUS_SUCCESS = 0;

        /**
         * 
         */
        public static final int PVSDK_FIRMWAREUPGRADE_CALLBACK_STATUS_UPGRADING = 1;



        /**
         * 升级成功
         */
        public void onFirmwareUpgradeSuccess();

        /**
         * 升级中
         *
         * @param progress 上传固件进度 0-100
         */
        public void onFirmwareUpgradeProcessing(int progress);

        /**
         * 升级失败
         */
        public void onFirmwareUpgradeFailed();

    }

    /**
     * 遥控器校准回调
     */
    public interface RemoteControlCalibrateListener {

        /**
         * 
         */
        public static final int PVSDK_REMOTECONTROLCALIBRATE_CALLBACK_INFO_CALIBRATE_SUCCESS = 0;

        /**
         * 
         */
        public static final int PVSDK_REMOTECONTROLCALIBRATE_CALLBACK_INFO_CALIBRATE_FAILED = 1;

        /**
         * 
         */
        public static final int PVSDK_REMOTECONTROLCALIBRATE_CALLBACK_INFO_COMPLETE_SUCCESS = 2;

        /**
         * 
         */
        public static final int PVSDK_REMOTECONTROLCALIBRATE_CALLBACK_INFO_COMPLETE_FAILED = 3;



        /**
         * 校准成功
         */
        public void onRemoteControlCalibrateSuccess();

        /**
         * 校准失败
         */
        public void onRemoteControlCalibrateFailed();

        /**
         * 校准完成成功
         */
        public void onRemoteControlCompleteSuccess();

        /**
         * 校准完成失败
         */
        public void onRemoteControlCompleteFailed();

    }

    /**
     * 遥控器信息
     */
    public interface ManualControlDataListener {



        /**
         * 遥控器信息数据
         *
         * @param data 遥控器数据
         */
        public void onManualControlDataReceived(ManualControlDateNotifyParam data);

    }

    /**
     * 遥控器拨轮数据
     */
    public interface MountControlDataListener {



        /**
         * 遥控器拨轮数据接收回调
         *
         * @param data 
         * @return
         */
        public void onMountControlDataReceived(MountControlDateNotifyParam data);

    }

    /**
     * 遥控器位置
     */
    public interface RemoteControlLocationListener {



        /**
         * 遥控器位置
         *
         * @param param 
         * @return
         */
        public void onRemoteControlLocation(RemoteControlLocationNotifyParam param);

    }

}