package com.powervision.powersdk.callback;

import com.powervision.powersdk.param.BatteryStatusNotifyParam;
import com.powervision.powersdk.param.HelmControlStatusNotifyParam;

/**
 * 系统状态相关回调
 */
public class SystemStatusCallback {

    /**
     * Default constructor
     */
    public SystemStatusCallback() {
    }










    /**
     * 连接相关回调
     */
    public interface ConnectionListener {

        /**
         * 
         */
        public static final int PVSDK_CONNECTION_CONNECTING = 0;

        /**
         * 
         */
        public static final int PVSDK_CONNECTION_CONNECTED = 1;

        /**
         * 
         */
        public static final int PVSDK_CONNECTION_DISCONNECTED = 2;

        /**
         * 
         */
        public static final int PVSDK_CONNECTION_TIMEOUT = 3;

        /**
         * 
         */
        public static final int PVSDK_CONNECTION_FAILED = 4;

        /**
         * 
         */
        public static final int PVSDK_HEARTBEAT_TIMEOUT = 5;

        /**
         * 
         */
        public static final int PVSDK_STANDARD_REMOTECONTROL_CONNECTED = 6;

        /**
         * 
         */
        public static final int PVSDK_MOTIONSENSING_REMOTECONTROL_CONNECTED = 7;

        /**
         *
         */
        public static final int PVSDK_DRONE_CONNECTING = 8;

        /**
         *
         */
        public static final int PVSDK_DRONE_CONNECTED = 9;

        /**
         *
         */
        public static final int PVSDK_DRONE_DISCONNECTED = 10;

        /**
         *
         */
        public static final int PVSDK_DRONE_CONNECT_TIMEOUT = 11;

        /**
         *
         */
        public static final int PVSDK_DRONE_CONNECT_FAILED = 12;

        /**
         *
         */
        public static final int PVSDK_RAY_CONNECTED = 13;

        /**
         *
         */
        public static final int PVSDK_CONNECTION_TIMEOUT_REPLAY = 14;

        public static final int PVSDK_RAY_BASE_STATION_CONNECT_FAILED = 15;

        /**
         * 链路连接中
         */
        public void onConnecting();

        /**
         * 链路连接成功
         */
        public void onConnectSuccess();

        /**
         * 链路已连接
         */
        public void onDisConnected();

        /**
         * 链路连接超时
         */
        public void onConnectTimeout();

        /**
         * 心跳超时
         */
        public void onHeartbeatTimeout();

        /**
         * 标准遥控器已连接
         */
        public void onConnectedStandardRemotecontrol();

        /**
         * 体感遥控器已连接
         */
        public void onConnectedMotionsensingRemotecontrol();

        /**
         * 链路连接失败
         */
        public void onConnectFailed();

        /**
         * 飞机连接中
         */
        public void onDroneConnecting();

        /**
         * 飞机已连接
         */
        public void onDroneConnected();

        /**
         * 飞机已断开
         */
        public void onDroneDisConnected();

        /**
         * 飞机连接超时
         */
        public void onDroneConnectTimeout();

        /**
         * 飞机连接失败
         */
        public void onDroneConnectFailed();

        /**
         * 水下机器人已连接
         */
        public void onRayConnected();

        /**
         * 心跳恢复
         */
        public void onDroneConnectedReplay();

        /**
         * 连接水下基站失败
         */
        public void onBaseStationConnFailed();
    }

    /**
     * 定义了模式改变回调
     */
    public interface ModeChangedListener {
        //设置参数
        int PVSDK_MODE_TYPE_NULL = -1; ///< NULL
        int PVSDK_MODE_TYPE_ARM = 0; ///< ARM
        int PVSDK_MODE_TYPE_DISARM = 1; ///< DISARM
        int PVSDK_MODE_TYPE_TAKEOFF = 2; ///< 起飞
        int PVSDK_MODE_TYPE_FOLLOWME = 3; ///< 跟随
        int PVSDK_MODE_TYPE_AUTOMISSION = 4; ///< 航线飞行
        int PVSDK_MODE_TYPE_AUTOLOITER = 5; ///< 自动悬停
        int PVSDK_MODE_TYPE_LAND = 6; ///< 降落
        int PVSDK_MODE_TYPE_RTL = 7; ///< 自动返航
        int PVSDK_MODE_TYPE_CIRCLE = 8; ///< 自动环绕
        int PVSDK_MODE_TYPE_SUPERSIMPLE = 9; ///< 极简模式
        int PVSDK_MODE_TYPE_MANUAL = 10; ///< 手动模式
        int PVSDK_MODE_TYPE_POSCTL = 11; ///< 定点模式

       //返回值
        public static final int PVSDK_MODE_CHANGED_TIMEOUT = -1;
        public static final int PVSDK_MODE_CHANGED = 0;
        public static final int PVSDK_MODE_CHANGED_MANUAL = 1;
        public static final int PVSDK_MODE_CHANGED_ALTCTL = 2;
        public static final int PVSDK_MODE_CHANGED_POSCTL = 3;
        public static final int PVSDK_MODE_CHANGED_AUTOMISSION = 4;
        public static final int PVSDK_MODE_CHANGED_AUTOTAKEOFF = 5;
        public static final int PVSDK_MODE_CHANGED_AUTOLAND = 6;
        public static final int PVSDK_MODE_CHANGED_AUTORTL = 7;
        public static final int PVSDK_MODE_CHANGED_SUPERSIMPLE = 8;
        public static final int PVSDK_MODE_CHANGED_AUTOCIRCLE = 9;
        public static final int PVSDK_MODE_CHANGED_FOLLOWME = 10;
        public static final int PVSDK_MODE_CHANGED_AUTOLOITER = 11;



        /**
         * 改变
         */
        public void onModeChanged();

        /**
         * 手动
         */
        public void onModeChangedManual();

        /**
         * 定高模式
         */
        public void onModeChangedAltctl();

        /**
         * 定点模式
         */
        public void onModeChangedPosctl();

        /**
         * 航线飞行
         */
        public void onModeChangedAutomission();

        /**
         * 自动起飞
         */
        public void onModeChangedAutoTakeoff();

        /**
         * 自动降落
         */
        public void onModeChangedAutoLand();

        /**
         * 自动返航
         */
        public void onModeChangedAutoRtl();

        /**
         * 极简
         */
        public void onModeChangedSuperSimple();

        /**
         * 自动环绕
         */
        public void onModeChangedAutoCircle();

        /**
         * 跟随
         */
        public void onModeChangedFollowme();

        /**
         * 自动悬停
         */
        public void onModeChangedAutoLoiter();

        /**
         * 超时
         */
        public void onModeChangedTimeout();

    }

    /**
     * 警告状态
     */
    public interface AlarmListener {



        /**
         * 警告回调的信息
         *
         * @param status
         */
        public void onAlarm(long status);

    }

    /**
     * 系统状态
     */
    public interface SysStatusListener {

        /**
         * 
         */
        public static final int PVSDK_SYSSTATUS_CHANGED = 0;



        /**
         * 系统状态回调时的信息
         *
         * @param status
         */
        public void onSysStatusChanged(int status);

    }

    /**
     * 定位方式改变通知
     */
    public interface LocatingTypeChangedListener {

        int PVSDK_LOCATING_TYPE_GPS = 6; ///< GPS定点
        int PVSDK_LOCATING_TYPE_OPTICAL_FLOW = 7; ///< 光流定点



        /**
         * GPS定点
         */
        public void onLocatingTypeGPS();

        /**
         * 光流定点
         */
        public void onLocatingTypeFLOW();

    }

    /**
     * 切换上一次模式相关信息
     */
    public interface BackToLastModeListener {

        /**
         * 
         */
        public static final int PVSDK_BACKTOLASTMODE_TIMEOUT = -1;

        /**
         * 
         */
        public static final int PVSDK_BACKTOLASTMODE_SUCCESS = 0;



        /**
         * 成功
         */
        public void onBackToLastModeSuccess();

        /**
         * 超时
         */
        public void onBackToLastModeTimeout();

    }

    /**
     * 自检
     */
    public interface SelfCheckListener {



        /**
         * @param paramID
         */
        public void onSelfCheckSetSuccess(String paramID);

        /**
         * @param paramID
         */
        public void onSelfCheckSetTimeout(String paramID);

        /**
         * @param paramID
         */
        public void onSelfCheckGetSuccess(String paramID);

        /**
         * @param paramID
         */
        public void onSelfCheckGetTimeout(String paramID);

    }

    /**
     * 电池状态
     */
    public interface BatteryStatusListener {



        /**
         * 定义了电池状态信息
         *
         * @param param
         */
        public void onBatteryStatus(BatteryStatusNotifyParam param);

    }

    /**
     * 脚架状态
     */
    public interface HelmControlStatusListener {



        /**
         * 脚架状态的相关参数
         *
         * @param param
         */
        public void onHelmControlStatus(HelmControlStatusNotifyParam param);

    }

    /**
     * 系统通知
     */
    public interface SysDoListener {

        /**
         * 
         */
        public static final int PVSDK_SYSDO_GETVALITEKEY_SUCCESS = 0;

        /**
         * 
         */
        public static final int PVSDK_SYSDO_GETVALITEKEY_TIMEOUT = 1;

        /**
         * 
         */
        public static final int PVSDK_SYSDO_GETVALITEKEYSTATUS_SUCCESS = 2;

        /**
         * 
         */
        public static final int PVSDK_SYSDO_GETVALITEKEYSTATUS_ERROR = 3;

        /**
         * 
         */
        public static final int PVSDK_SYSDO_SETVALITEKEYSTATUS_SUCCESS = 4;

        /**
         * 
         */
        public static final int PVSDK_SYSDO_SETVALITEKEYSTATUS_ERROR = 5;

        /**
         *
         */
        public static final int PVSDK_SYSDO_PSN_SUCCESS = 6;

        /**
         *
         */
        public static final int PVSDK_SYSDO_PSN_ERROR = 7;

        /**
         *
         */
        public static final int PVSDK_SYSDO_PSN_TIMEOUT = 8;
        /**
         * 获取激活码成功
         */
        public void onSysdoGetvalitekeySuccess();

        /**
         * 获取激活码超时
         */
        public void onSysdoGetvalitekeyTimeout();

        /**
         * 获取激活码状态成功
         */
        public void onSysdoGetvalitekeyStatusSuccess();

        /**
         * 获取激活码异常
         */
        public void onSysdoGetvalitekeyStatusError();

        /**
         * 设置激活码状态成功
         */
        public void onSysdoSetvalitekeyStatusSuccess();

        /**
         * 设置激活码异常
         */
        public void onSysdoSetvalitekeyStatusError();

        /**
         * 获取psn码成功
         */
        public void onSysdoGetPSNSuccess();

        /**
         * 获取psn码失败
         */
        public void onSysdoGetPSNFailed();

        /**
         * 获取psn码超时
         */
        public void onSysdoGetPSNTimeout();
    }

    /**
     * 飞机、船 固件升级回调
     * */
    public interface UploadRateOfProgressListener{
        public static final int PVSDK_UPGRADEING = 0; ///< 正在进行升级
        public static final int PVSDK_UPGRADE_OK = 1; ///< 升级成功
        public static final int PVSDK_UPGRADE_FAIL = 2;///< 升级失败

        /**
         * 正在进行升级
         * */
        public void onUpgradeing(int progress);

        /**
         * 升级成功
         * */
        public void onUpgraded();

        /**
         * 升级失败
         * */
        public void onUpgradeFailed();
    }

}