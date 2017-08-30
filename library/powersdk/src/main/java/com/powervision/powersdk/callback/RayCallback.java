package com.powervision.powersdk.callback;

import com.powervision.powersdk.param.AltitudeNotifyParam;
import com.powervision.powersdk.param.SpeedControlNotifyParam;

/**
 * 水下相关回调
 */

public class RayCallback {

    /**
     * 高度/深度信息通知
     * */
    public interface AltitudeListener{
        void altitude(AltitudeNotifyParam altitude);
    }

    /**
     * 航灯亮度信息
     * */
    public interface LightControlListener{
        void lightControl(int increment);
    }

    /**
     * 基站的电量通知
     * */
    public interface BaseStationBatteryListener{
        void baseStationBattery(char battery_remaining);
    }

    /**
     * 主控状态通知
     * */
    public interface MasterControlListener{
        void masterControl(boolean masterControl);
    }

    /**
     * 收放鱼钩回调
     * */
    public interface FishhookStatusListener{
        int FISHHOOK_STATUS_ON = 0; //放钩
        int FISHHOOK_STATUS_OFF = 1; //收钩

        /**
         * 收鱼钩
         * */
        void hookReceiving();
        /**
         * 放鱼钩
         * */
        void hookPut();
    }

    /**
     * 当前加解锁回调通知
     * */
    public interface RayArmStatusListener {
        int RAY_ARM_BACK = 0; ///< 加锁
        int RAY_DISARM_BACK = 1; ///< 解锁

        /**
         * 加锁成功
         * */
        void rayArm();

        /**
         * 解锁成功
         * */
        void rayDisarm();
    }

    /**
     * 船报警通知
     * */
    public interface RayAlarmListener {
        int PVSDK_RAY_ALARM_LOW_BATTERY_10 = 0; //电池电量过低
        int PVSDK_RAY_ALARM_LOW_BATTERY_20 = 1; //电池电量过低
        int PVSDK_RAY_ALARM_TOO_DEEP = 2; //船体潜水过深
        int PVSDK_RAY_ALARM_MOTOR_STALL = 3; //船体电机堵转

        int PVSDK_RAY_ALARM_MOTOR_STALL_LEFT = 4; // 船体左电机堵转
        int PVSDK_RAY_ALARM_MOTOR_STALL_RIGHT = 5; // 船体右电机堵转
        int PVSDK_RAY_ALARM_MOTOR_STALL_VERTICAL = 6; //船体前置电机堵转
        int PVSDK_RAY_ALARM_NOT_INTO_WATER = 7; //船体未入水不能解锁
        int PVSDK_RAY_ALARM_NOT_ACTIVATED = 8; //船体未激活不能解锁
        int PVSDK_RAY_ALARM_IMPACT_DETECTED = 9; //船体碰撞报警
        int PVSDK_RAY_ALARM_OUT_OF_WATER = 10; //船体出水报警

        void alarm(int type);
    }

    /**
     * 定深模式状态通知
     * */
    public interface RayDepthSettingModeListener {
        int RAY_DEPTH_SETTING_MODE_OFF = 1;
        int RAY_DEPTH_SETTING_MODE_ON = 2;

        void depthSettingMode(int type);
    }

    /**
     * 定速档位状态通知
     * */
    public interface RayConstantSpeedModeListener {
        int RAY_CONSTANT_SPEED_MODE_LOW = 1;
        int RAY_CONSTANT_SPEED_MODE_MID = 2;
        int RAY_CONSTANT_SPEED_MODE_HIGH = 3;

        void constantSpeedMode(int type);
    }

    /**
     * 遥控器指令回调通知
     * */
    public interface RayRemoteControlInstructionsListener {
        int RAY_REMOTE_INSTRUCTIONS_TAKE_PIC = 0;
        int RAY_REMOTE_INSTRUCTIONS_VIDEO = 1;
        int RAY_REMOTE_INSTRUCTIONS_FISH_VIEW = 2;
        int RAY_REMOTE_INSTRUCTIONS_UNSETTLED = 3;
        int RAY_REMOTE_INSTRUCTIONS_VR_PRESS = 4;
        int RAY_REMOTE_INSTRUCTIONS_VR_RELEASE = 5;

        void remoteControlInstructions(int type);
    }

    /**
     * 水下遥控器链接通知
     * */
    public interface RayRemoteControlConnectionListener {

        /**
         * @param rayRCConnection 基站电池电量 传出范围
         * */
        void remoteControlConnection(boolean rayRCConnection);
    }

    /**
     * 基站升级回调
     * */
    public interface BaseUpgradeStatusListener{
        int PVSDK_BASE_UPGRADE_STATE_READ_BOOT_LOADER = 0; //识别bootloader成功
        int PVSDK_BASE_UPGRADE_STATE_GET_FLASH_SIZE = 1; //获得flash size成功
        int PVSDK_BASE_UPGRADE_STATE_ERASE = 2; //擦除基站原程序成功
        int PVSDK_BASE_UPGRADE_STATE_UPLOADING = 3; //上传文件中
        int PVSDK_BASE_UPGRADE_STATE_UPLOAD_OK = 4; //上传文件成功
        int PVSDK_BASE_UPGRADE_STATE_CHECK_FILE_OK = 5; //文件校验成功
        int PVSDK_BASE_UPGRADE_STATE_CHECK_FILE_FAIL = 6; //文件校验失败
        int PVSDK_BASE_UPGRADE_STATE_RESTART = 7; //基站重启

        /**
         * 识别bootloader成功
         * */
        void readBootLoader();

        /**
         * 获得flash size成功
         * */
        void getFlashSize();

        /**
         *擦除基站原程序成功
         * */
        void erase();

        /**
         *上传文件中
         * */
        void upLoading(int progress);

        /**
         *上传文件成功
         * */
        void upLoadOk();

        /**
         *文件校验成功
         * */
        void checkFileOk();

        /**
         *文件校验失败
         * */
        void checkFileFail();

        /**
         *基站重启
         * */
        void restart();
    }

    /**
     * 水下电机相关
     * */
    public interface ElectronicSpeedControlListener{
        void electronicSpeedControl(SpeedControlNotifyParam speedControl);
    }

    /**
     * 水下遥控器电量通知
     * */
    public interface RayRCBatteryNotifyListener{
        void rCBattery(int battery);
    }
}
