package com.powervision.powersdk.sdk;

import android.graphics.Bitmap;

import com.powervision.powersdk.jni.JniNatives;
import com.powervision.powersdk.param.*;
import com.powervision.powersdk.callback.*;
import com.powervision.powersdk.callback.CameraCallback.*;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 */
public class PowerSDK {
    private static final PowerSDK powerSDK = new PowerSDK();

    /**
     * Default constructor
     */
    private PowerSDK() {
    }

    /**
     *
     */
    private SystemStatusCallback.ConnectionListener connectionListener;

    /**
     *
     */
    private SystemStatusCallback.ModeChangedListener modeChangedListener;

    /**
     *
     */
    private CameraCallback.CameraListener cameraListener;

    /**
     *
     */
    private CameraCallback.CameraParamListener cameraParamListener;

    /**
     *
     */
    private MissionCallback.MissionActionListener missionActionListener;

    /**
     *
     */
    private MissionCallback.MissionRunListener missionRunListener;

    /**
     *
     */
    private MissionCallback.StartWaypointListener startWaypointListener;

    /**
     *
     */
    private PositionCallback.TakeoffLandListener takeoffLandListener;

    /**
     *
     */
    private RemoteControlCallback.FirmwareUpgradeListener firmwareUpgradeListener;

    /**
     *
     */
    private RemoteControlCallback.RemoteControlParamListener remoteControlParamListener;

    /**
     *
     */
    private RemoteControlCallback.RemoteControlLocationListener remoteControlLocationListener;

    /**
     *
     */
    private RemoteControlCallback.RemoteControlCalibrateListener remoteControlCalibrateListener;

    /**
     *
     */
    private RemoteControlCallback.ManualControlDataListener manualControlDataListener;

    /**
     *
     */
    private RemoteControlCallback.MountControlDataListener mountControlDataListener;

    /**
     *
     */
    private SystemStatusCallback.SysStatusListener sysStatusListener;

    /**
     *
     */
    private SystemStatusCallback.SysDoListener sysDoListener;

    /**
     *
     */
    private PositionCallback.PositionChangedListener positionChangedListener;

    /**
     *
     */
    private PositionCallback.HomePositionListener homePositionListener;

    /**
     *
     */
    private PositionCallback.GpsRawIntListener gpsRawIntListener;

    /**
     *
     */
    private SystemStatusCallback.SelfCheckListener selfCheckListener;

    /**
     *
     */
    private ParamCallback.ParamSetGetListener paramSetGetListener;

    /**
     *
     */
    private SystemStatusCallback.BatteryStatusListener batteryStatusListener;

    /**
     *
     */
    private SystemStatusCallback.HelmControlStatusListener helmControlStatusListener;

    /**
     *
     */
    private SystemStatusCallback.AlarmListener alarmListener;

    /**
     *
     */
    private SystemStatusCallback.BackToLastModeListener backToLastModeListener;

    private SystemStatusCallback.UploadRateOfProgressListener uploadRateOfProgressListener;

    /**
     *
     */
    private GimbalCallback.GimbalParamListener gimbalParamListener;

    /**
     *
     */
    private PositionCallback.AttitudeAndGroundspeedChangedListener attitudeAndGroundspeedChangedListener;

    /**
     *
     */
    private GimbalCallback.RequestOperationalSensitivityListener requestOperationalSensitivityListener;

    /**
     *
     */
    private SensorCallback.MagnetometerCalibrateListener magnetometerCalibrateListener;

    /**
     *
     */
    private MissionCallback.MissionListener missionListener;

    /**
     *
     */
    private PositionCallback.DistanceSensorListener distanceSensorListener;

    /**
     *
     */
    private SystemStatusCallback.LocatingTypeChangedListener locatingTypeChangedListener;

    private RayCallback.FishhookStatusListener fishhookStatusListener;

    private RayCallback.AltitudeListener altitudeListener;

    private RayCallback.LightControlListener lightControlListener;

    private RayCallback.MasterControlListener masterControlListener;

    private RayCallback.BaseStationBatteryListener baseStationBatteryListener;

    private RayCallback.RayArmStatusListener rayArmStatusListener;

    private RayCallback.RayAlarmListener rayAlarmListener;

    private RayCallback.RayDepthSettingModeListener rayDepthSettingModeListener;

    private RayCallback.RayConstantSpeedModeListener rayConstantSpeedModeListener;

    private RayCallback.RayRemoteControlInstructionsListener rayRemoteControlInstructionsListener;

    private RayCallback.RayRemoteControlConnectionListener rayRemoteControlConnectionListener;
    private RayCallback.BaseUpgradeStatusListener baseUpgradeStatusListener;
    private RayCallback.ElectronicSpeedControlListener electronicSpeedControlListener;
    private RayCallback.RayRCBatteryNotifyListener rayRCBatteryNotifyListener;

    public RayCallback.RayRCBatteryNotifyListener getRayRCBatteryNotifyListener() {
        return rayRCBatteryNotifyListener;
    }

    public void setRayRCBatteryNotifyListener(RayCallback.RayRCBatteryNotifyListener rayRCBatteryNotifyListener) {
        this.rayRCBatteryNotifyListener = rayRCBatteryNotifyListener;
    }

    public RayCallback.ElectronicSpeedControlListener getElectronicSpeedControlListener() {
        return electronicSpeedControlListener;
    }

    public void setElectronicSpeedControlListener(RayCallback.ElectronicSpeedControlListener electronicSpeedControlListener) {
        this.electronicSpeedControlListener = electronicSpeedControlListener;
    }

    public RayCallback.BaseUpgradeStatusListener getBaseUpgradeStatusListener() {
        return baseUpgradeStatusListener;
    }

    public void setBaseUpgradeStatusListener(RayCallback.BaseUpgradeStatusListener baseUpgradeStatusListener) {
        this.baseUpgradeStatusListener = baseUpgradeStatusListener;
    }

    public RayCallback.RayRemoteControlConnectionListener getRayRemoteControlConnectionListener() {
        return rayRemoteControlConnectionListener;
    }

    public void setRayRemoteControlConnectionListener(RayCallback.RayRemoteControlConnectionListener rayRemoteControlConnectionListener) {
        this.rayRemoteControlConnectionListener = rayRemoteControlConnectionListener;
    }

    public RayCallback.RayRemoteControlInstructionsListener getRayRemoteControlInstructionsListener() {
        return rayRemoteControlInstructionsListener;
    }

    public void setRayRemoteControlInstructionsListener(RayCallback.RayRemoteControlInstructionsListener rayRemoteControlInstructionsListener) {
        this.rayRemoteControlInstructionsListener = rayRemoteControlInstructionsListener;
    }

    public RayCallback.RayDepthSettingModeListener getRayDepthSettingModeListener() {
        return rayDepthSettingModeListener;
    }

    public void setRayDepthSettingModeListener(RayCallback.RayDepthSettingModeListener rayDepthSettingModeListener) {
        this.rayDepthSettingModeListener = rayDepthSettingModeListener;
    }

    public RayCallback.RayConstantSpeedModeListener getRayConstantSpeedModeListener() {
        return rayConstantSpeedModeListener;
    }

    public void setRayConstantSpeedModeListener(RayCallback.RayConstantSpeedModeListener rayConstantSpeedModeListener) {
        this.rayConstantSpeedModeListener = rayConstantSpeedModeListener;
    }

    public RayCallback.RayAlarmListener getRayAlarmListener() {
        return rayAlarmListener;
    }

    public void setRayAlarmListener(RayCallback.RayAlarmListener rayAlarmListener) {
        this.rayAlarmListener = rayAlarmListener;
    }

    public RayCallback.RayArmStatusListener getRayArmStatusListener() {
        return rayArmStatusListener;
    }

    public void setRayArmStatusListener(RayCallback.RayArmStatusListener rayArmStatusListener) {
        this.rayArmStatusListener = rayArmStatusListener;
    }

    public RayCallback.MasterControlListener getMasterControlListener() {
        return masterControlListener;
    }

    public void setMasterControlListener(RayCallback.MasterControlListener masterControlListener) {
        this.masterControlListener = masterControlListener;
    }

    public RayCallback.BaseStationBatteryListener getBaseStationBatteryListener() {
        return baseStationBatteryListener;
    }

    public void setBaseStationBatteryListener(RayCallback.BaseStationBatteryListener baseStationBatteryListener) {
        this.baseStationBatteryListener = baseStationBatteryListener;
    }

    public RayCallback.LightControlListener getLightControlListener() {
        return lightControlListener;
    }

    public void setLightControlListener(RayCallback.LightControlListener lightControlListener) {
        this.lightControlListener = lightControlListener;
    }

    public RayCallback.AltitudeListener getAltitudeListener() {
        return altitudeListener;
    }

    public void setAltitudeListener(RayCallback.AltitudeListener altitudeListener) {
        this.altitudeListener = altitudeListener;
    }

    public SystemStatusCallback.UploadRateOfProgressListener getUploadRateOfProgressListener() {
        return uploadRateOfProgressListener;
    }

    public void setUploadRateOfProgressListener(SystemStatusCallback.UploadRateOfProgressListener uploadRateOfProgressListener) {
        this.uploadRateOfProgressListener = uploadRateOfProgressListener;
    }

    /**
     * @return 返回PowerSDK的单例
     */
    public static PowerSDK getInstance() {
        return powerSDK;
    }

    /**
     * 初始化SDK
     *
     * @param ip   ip地址
     * @param port 端口
     * @return 0 成功， -1 失败
     */
    public int initSDK(String ip, int port) {
        return JniNatives.initSDK(ip, port);
    }

    /**
     * @param connName
     * @param baudRate
     * @param type
     * @param level
     * @return 0 成功， -1 失败
     */
    public int initSDK(String connName, int baudRate, int type, int level) {
        return JniNatives.initSDK(connName, baudRate, type, level);
    }

    /**
     * 销毁SDK
     *
     * @return 0 成功， -1 失败
     */
    public int unInitSDK() {
        return JniNatives.unInitSDK();
    }

    /**
     * 獲得SDK版本信息
     * 暂时未实现
     *
     * @return 0 成功， -1 失败
     */
    public int getSDKVersion() {
        return JniNatives.getSDKVersion("");
    }

    /**
     * 注册回调接口
     *
     * @return 0 成功， -1 失败
     */
    public int registerCallback() {
        return JniNatives.registerCallback();
    }

    /**
     * 获取设备激活码,type为预留参数，暂时不用
     *
     * @param type
     * @return 失败 激活码
     */
    public int getValiteKey(int type) {
        return JniNatives.getValiteKey(type);
    }

    /**
     * 获取设备psn码,type为预留参数，暂时不用
     *
     * @param type
     * @return 失败 激活码
     */
    public int getPSN(int type) {
        return JniNatives.getPSN(type);
    }

    /**
     * 连接链路
     *
     * @return 0 成功， -1 失败
     */
    public int connect() {
        return JniNatives.connect();
    }

    /**
     * 断开链路连接
     *
     * @return 0 成功， -1 失败
     */
    public int disConnect() {
        return JniNatives.disConnect();
    }

    /**
     * 连接飞机
     *
     * @return 0 成功， -1 失败
     */
    public int connectDrone() {
        return JniNatives.connectDrone();
    }

    /**
     * 断开飞机连接
     *
     * @return 0 成功， -1 失败
     */
    public int disConnectDrone() {
        return JniNatives.disConnectDrone();
    }

    /**
     * 飞机解锁
     * 函数返回成功仅代表函数执行成功,需等待回调函数返回真正执行结果
     *
     * @return 0 成功， -1 失败
     */
    public int arm() {
        return JniNatives.arm();
    }

    /**
     * @return 0 没有Arm， 1 已经Arm
     */
    public int isArmed() {
        return JniNatives.isArmed();
    }

    /**
     * disArm
     *
     * @return 0 成功， -1 失败
     */
    public int disArm() {
        return JniNatives.disArm();
    }

    /**
     * 起飞
     *
     * @return 0 成功， -1 失败
     */
    public int takeOff() {
        return JniNatives.takeOff();
    }

    /**
     * 跟随
     *
     * @return 0 成功， -1 失败
     */
    public int followMe() {
        return JniNatives.followMe();
    }

    /**
     * 降落
     *
     * @return 0 成功， -1 失败
     */
    public int land() {
        return JniNatives.land();
    }

    /**
     * 返航
     *
     * @return 0 成功， -1 失败
     */
    public int rtl() {
        return JniNatives.rtl();
    }

    /**
     * 开始环绕
     *
     * @param data 定义了环绕模式所需参数
     * @return 0 成功， -1 失败
     */
    public int circle(CircleParam data) {
        return JniNatives.circle(data.x, data.y, data.z, data.radius, data.speed, data.isClockwise, data.isPause);
    }

    /**
     * 下载航点
     *
     * @return 0 成功， -1 失败
     */
    public int loadWayPoints() {
        return JniNatives.loadWayPoints();
    }

    /**
     * 上传航点
     *
     * WaypointParam的seq 每次发送 都必须从0计数
     *
     * @param waypoints
     * @return 0 成功， -1 失败
     */
    public int setWayPoints(WaypointParam[] waypoints) {
        int len = 0;
        if ((len = waypoints.length) > 0) {
            float param1s[] = new float[len];
            float param2s[] = new float[len];
            float param3s[] = new float[len];
            float param4s[] = new float[len];
            float xs[] = new float[len];
            float ys[] = new float[len];
            float zs[] = new float[len];
            int seqs[] = new int[len];
            for (int i = 0; i < len; i++) {
                param1s[i] = waypoints[i].param1;
                param2s[i] = waypoints[i].param2;
                param3s[i] = waypoints[i].param3;
                param4s[i] = waypoints[i].param4;
                xs[i] = waypoints[i].x;
                ys[i] = waypoints[i].y;
                zs[i] = waypoints[i].z;
                seqs[i] = waypoints[i].seq;
            }
            return JniNatives.setWayPoints(param1s, param2s, param3s, param4s, xs, ys, zs, seqs);
        }
        return -1;
    }

    /**
     * 开始航点飞行
     *
     * @return 0 成功， -1 失败
     */
    public int startWayPoints() {
        return JniNatives.startWayPoints();
    }

    /**
     * 发送安全区域
     *
     * @param area
     * @return 0 成功， -1 失败
     */
    public int setSafetyAllowedArea(SafetyAllowedAreaParam area) {
        return JniNatives.setSafetyAllowedArea(area.p1x, area.p1y, area.p1z, area.p2x, area.p2y, area.p2z, area.frame);
    }

    /**
     * 设置模式
     *
     * @param modeParam
     *
     * @return 0 成功， -1 失败
     */
    public int setMode(int modeParam) {
        return JniNatives.setMode(modeParam);
    }

    /**
     * 返回上一次模式
     *
     * @return 0 成功， -1 失败
     */
    public int backToLastMode() {
        return JniNatives.backToLastMode();
    }

    /**
     * 返回GlobalPositionIntParam
     *
     * @return NULL 失败
     */
    public GlobalPositionIntParam getGlobalPositionIntParam() {
        return JniNatives.getGlobalPositionIntParam();
    }

    /**
     * 返回GpsRawIntParam
     *
     * @return NULL 失败
     */
    public GpsRawIntParam getGpsRawIntParam() {
        return JniNatives.getGpsRawIntParam();
    }

    /**
     *
     * @return NULL 失败
     */
    public VfrHudParam getVfrHudParam() {
        return JniNatives.getVfrHudParam();
    }

    /**
     *
     * @return NULL 失败
     */
    public TakeoffLandParam getTakeoffLandParam() {
        return JniNatives.getTakeoffLandParam();
    }

    /**
     *
     * @return NULL 失败
     */
    public SafetyAllowedAreaParam getSafetyAllowedAreaParam() {
        return JniNatives.getSafetyAllowedAreaParam();
    }

    /**
     * 获取系统状态信息
     * @return NULL 失败
     */
    public SystemStatusParam getSystemStatusParam() {
        return JniNatives.getSystemStatusParam();
    }

    /**
     * 设置HOME点
     *
     * @return 0 成功， -1 失败
     */
    public int setHome() {
        return JniNatives.setHome();
    }

    /**
     * 获取HOME点
     *
     * @return 0 成功， -1 失败
     */
    public int getHome() {
        return JniNatives.getHome();
    }

    /**
     * 设置返航点
     *
     * @param takeOfflandParam 返航点参数
     * @return 0 成功， -1 失败
     */
    public int setTakeoffLand(TakeoffLandParam takeOfflandParam) {
        return JniNatives.setTakeoffLand(takeOfflandParam.land_lat, takeOfflandParam.land_lon, takeOfflandParam.land_alt, takeOfflandParam.status);
    }

    /**
     * 设置禁飞区
     *
     * @return 0 成功， -1 失败
     */
    public int setFence() {
        return JniNatives.setFence();
    }

    /**
     * 获取禁飞区
     *
     * @return 0 成功， -1 失败
     */
    public int getFence() {
        return JniNatives.getFence();
    }

    /**
     * 获取姿态信息
     *
     * @return 0 成功， -1 失败
     */
    public Attitude getAttitude() {
        return JniNatives.getAttitude();
    }

    /**
     * 获取参数
     *
     * @param paramId
     * @return 0 成功， -1 失败
     */
    public float getParameter(String paramId) {
        return JniNatives.getParameter(paramId);
    }

    /**
     * 请求参数
     *
     * @param paramId
     * @return 0 成功， -1 失败
     */
    public int requestParameter(String paramId) {
        return JniNatives.requestParameter(paramId);
    }

    /**
     * 设置参数
     *
     * @param paramId
     * @param value
     * @return 0 成功， -1 失败
     */
    public int setParameter(String paramId, float value) {
        return JniNatives.setParameter(paramId, value);
    }

    private Timer timer = new Timer();
    private TimerTask timerTask;
    /**
     * 激活方法
     *
     * 防止其他方法回调onSysdoSetvalitekeyStatusSuccess
     * ParameterManager中的PV_V_KEY_FLAG消息不准确
     * */
    public int activate(float param){
        JniNatives.activateFlagPowerSDK = true;
        int res = this.setParameter("PV_V_KEY_FLAG", param);

        if(timerTask != null)
            timerTask.cancel();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                JniNatives.activateFlagPowerSDK = false;
            }
        };
        timer.schedule(timerTask, 2000);

        return res;
    }

    /**
     * change camera type
     *
     * PV_CMD_CHANGE_TO_CAMERA=9, //普通相机
     * PV_CMD_CHANGE_TO_FLIR=10,  //FLIR相机
     *
     * @return 0 成功， -1 失败
     */
    public int changeCaptureMode(int status) {
        return JniNatives.changeCaptureMode(status);
    }

    /**
     * 切换拍照模式
     *
     * @return 0 成功， -1 失败
     */
    public int stillCaptureMode() {
        return JniNatives.stillCaptureMode();
    }

    /**
     * 拍照
     *
     * @return 0 成功， -1 失败
     */
    public int stillCapture() {
        return JniNatives.stillCapture();
    }

    /**
     * 拍照 红外
     *
     * @return 0 成功， -1 失败
     */
    public int stillCaptureFlir() {
        return JniNatives.stillCaptureFlir();
    }

    /**
     * 切换摄像模式
     *
     * @return 0 成功， -1 失败
     */
    public int recMode() {
        return JniNatives.recMode();
    }

    /**
     * 摄像开始
     *
     * @return 0 成功， -1 失败
     */
    public int recStart() {
        return JniNatives.recStart();
    }

    /**
     * 摄像开始
     *
     * @return 0 成功， -1 失败
     */
    public int recStartFlir() {
        return JniNatives.recStartFlir();
    }

    /**
     * 摄像停止
     *
     * @return 0 成功， -1 失败
     */
    public int recStop() {
        return JniNatives.recStop();
    }

    /**
     * 摄像停止
     *
     * @return 0 成功， -1 失败
     */
    public int recStopFlir() {
        return JniNatives.recStopFlir();
    }

    /**
     * 格式化sd卡
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int formatSD(float param) {
        return JniNatives.formatSD(param);
    }

    /**
     * 恢复相机出厂设置
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int resetToCameraFactory(float param) {
        return JniNatives.resetToCameraFactory(param);
    }

    /**
     * 相机相关参数设置 暂时不可用
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int captureSet(float param) {
        // TODO implement here
        return JniNatives.captureSet(param);
    }

    /**
     * 照片大小设置
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int setPicSize(int param) {
        return JniNatives.setPicSize(param);
    }

    /**
     * 照片大小设置
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int setRecResolution(int param) {
        return JniNatives.setRecResolution(param);
    }

    /**
     * 白平衡设置
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int setWhiteBlance(int param) {
        return JniNatives.setWhiteBlance(param);
    }

    /**
     * 测光设置
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int meteringSet(int param) {
        return JniNatives.meteringSet(param);
    }

    /**
     * 设置拍照风格
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int shootMode(int param) {
        return JniNatives.shootMode(param);
    }

    /**
     * 连拍设置
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int setBurstSpeed(int param) {
        return JniNatives.setBurstSpeed(param);
    }

    /**
     * 照片格式设置
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int setPictureFormat(int param) {
        return JniNatives.setPictureFormat(param);
    }

    /**
     * 设置拍照风格
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int shootStyle(int param) {
        return JniNatives.shootMode(param);
    }

    /**
     * 饱和度设置
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int staturationSet(int param) {
        return JniNatives.staturationSet(param);
    }

    /**
     * 对比度设置
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int contrastSet(int param) {
        return JniNatives.contrastSet(param);
    }

    /**
     * 相机请求照片大小
     *
     * @return 0 成功， -1 失败
     */
    public int requestPicSize() {
        return JniNatives.requestPicSize();
    }

    /**
     * 获取相机照片大小
     *
     * @return 0 成功， -1 失败
     */
    public float getPicSize() {
        return JniNatives.getPicSize();
    }

    /**
     * 相机请求拍照模式
     *
     * @return 0 成功， -1 失败
     */
    public int requestsHootMode() {
        return JniNatives.requestsHootMode();
    }

    /**
     * 获取相机拍照模式
     *
     * @return 0 成功， -1 失败
     */
    public float getShootMode() {
        return JniNatives.getShootMode();
    }

    /**
     * 请求获取相机拍照风格
     *
     * @return 0 成功， -1 失败
     */
    public int requestShootStyle() {
        return JniNatives.requestShootStyle();
    }

    /**
     * 获取相机拍照风格
     *
     * @return 0 成功， -1 失败
     */
    public float getShootStyle() {
        return JniNatives.getShootStyle();
    }

    /**
     * 请求获取硬件设备状态
     *
     * @return 0 成功， -1 失败
     */
    public int requestVehicleStatus() {
        return JniNatives.requestVehicleStatus();
    }

    /**
     * 获取硬件设备状态
     *
     * @return 0 成功， -1 失败
     */
    public int getVehicleStatus() {
        return JniNatives.getVehicleStatus();
    }

    /**
     * 请求获取SD卡容量
     *
     * @return 0 成功， -1 失败
     */
    public int requestSDCAP() {
        return JniNatives.requestSDCAP();
    }

    /**
     * 获取SD卡容量
     *
     * @return 0 成功， -1 失败
     */
    public float getSDCAP() {
        return JniNatives.getSDCAP();
    }

    /**
     * 相机自动变焦指令
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int setCameraAutoZoom(int param) {
        return JniNatives.setCameraAutoZoom(param);
    }

    /**
     * 手动变焦指令
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int setCameraZoom(int param) {
        return JniNatives.setCameraZoom(param);
    }

    /**
     * 云台姿态设置
     *
     * @param pitch
     * @param roll
     * @param yaw
     * @return 0 成功， -1 失败
     */
    public int setGimbalOrientation(int pitch, int roll, int yaw) {
        return JniNatives.setGimbalOrientation(pitch, roll, yaw);
    }

    /**
     * 俯仰轴参数设置
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int setPitchAxis(int param) {
        return JniNatives.setPitchAxis(param);
    }

    /**
     * 获取俯仰轴设置参数
     *
     * @return 俯仰轴参数
     */
    public int requestPitchAxis() {
        return JniNatives.requestPitchAxis();
    }

    /**
     * 扩展俯仰轴限位参数至上30度设置
     *
     * @param enable
     * @return 0 成功， -1 失败
     */
    public int extendPitchAxisLimit(int enable) {
        return JniNatives.extendPitchAxisLimit(enable);
    }

    /**
     * 俯仰平滑参数设置
     *
     * @param factor 平滑因子，取值0-30
     * @return 0 成功， -1 失败
     */
    public int setPitchAxisSmooth(int factor) {
        return JniNatives.setPitchAxisSmooth(factor);
    }

    /**
     * 获取俯仰平滑参数
     *
     * @return 俯仰轴平滑参数
     */
    public int requestPitchAxisSmooth() {
        return JniNatives.requestPitchAxisSmooth();
    }

    /**
     * 偏航平滑参数设置
     *
     * @param factor 平滑因子，取值0-30
     * @return 0 成功， -1 失败
     */
    public int setYawAxisSmooth(int factor) {
        return JniNatives.setYawAxisSmooth(factor);
    }

    /**
     * 获取偏航平滑参数
     *
     * @return 偏航平参数
     */
    public int requestYawAxisSmooth() {
        return JniNatives.requestYawAxisSmooth();
    }

    /**
     * 角速度设置
     *
     * @param speed
     * @return 0 成功， -1 失败
     */
    public int setAngularSpeed(float speed) {
        return JniNatives.setAngularSpeed(speed);
    }

    /**
     * 获取云台角速度
     *
     * @return 云台角度参数
     */
    public float requestAngularSpeed() {
        return JniNatives.requestAngularSpeed();
    }

    /**
     * 参数复位
     *
     * @return 0 成功， -1 失败
     */
    public int resetParameters() {
        return JniNatives.resetParameters();
    }

    /**
     * 模式设置
     *
     * @param mode
     * @return 0 成功， -1 失败
     */
    public int setGimbalMode(int mode) {
        return JniNatives.setGimbalMode(mode);
    }

    /**
     * 获取云台模式
     *
     * @return 云台模式参数
     */
    public int requestGimbalMode() {
        return JniNatives.requestGimbalMode();
    }

    /**
     * 云台参数复位
     *
     * @return 0 成功， -1 失败
     */
    public int resetGimbalParams() {
        return JniNatives.resetGimbalParams();
    }

    /**
     * 翻滚角微调
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    public int rollAxisTuning(float param) {
        return JniNatives.rollAxisTuning(param);
    }

    /**
     * 获取云台翻滚角参数
     *
     * @return 云台翻滚角参数
     */
    public int requestRollAxisTuning() {
        return JniNatives.requestRollAxisTuning();
    }

    /**
     * 自动校准
     *
     * @return 0 成功， -1 失败
     */
    public int gimbalCalibrate() {
        return JniNatives.gimbalCalibrate();
    }


    /**
     * 控制云台参数
     *
     * @return 0 成功， -1 失败
     */
    public int gimbalControl(GimbalControlParam param) {
        return JniNatives.gimbalControl(param.mount_mode, param.stab_pitch, param.stab_roll, param.stab_yaw);
    }

    /**
     * 操作感度设置
     *
     * @param orientation   方向
     * @param param 感度值，范围0.15~0.25
     * @return 0 成功， -1 失败
     */
    public int operationalSensitivityConfig(int orientation, float param) {
        return JniNatives.operationalSensitivityConfig(orientation, param);
    }

    /**
     * 操作感度查询
     *
     * @param orientation
     * @return 0 成功， -1 失败
     */
    public int requestOperationalSensitivity(int orientation) {
        return JniNatives.requestOperationalSensitivity(orientation);
    }

    /**
     * 启用视觉定位
     *
     * @param enable 是否启用，0-不启用 1-启用
     * @return 0 成功， -1 失败
     */
    public int enableVisualLocating(int enable) {
        return JniNatives.enableVisualLocating(enable);
    }

    /**
     * 指南针校准
     *
     * @return 0 成功， -1 失败
     */
    public int magnetometerCalibrate() {
        return JniNatives.magnetometerCalibrate();
    }

    /**
     * 关闭指南针校准
     *
     * @return 0 成功， -1 失败
     */
    public int magnetometerCalibrateClose() {
        return JniNatives.magnetometerCalibrateClose();
    }

    /**
     * 设置脚架模式
     *
     * @param mode 0手动，1自动
     * @return 0 成功， -1 失败
     */
    public int hlemChangeMode(int mode) {
        return JniNatives.hlemChangeMode(mode);
    }

    /**
     * 设置脚架打开
     *
     * @return 0 成功， -1 失败
     */
    public int hlemControlOpen() {
        return JniNatives.hlemControlOpen();
    }

    /**
     * 设置脚架收起
     *
     * @return 0 成功， -1 失败
     */
    public int hlemControlClose() {
        return JniNatives.hlemControlClose();
    }

    /**
     * 遥控器校准
     *
     * @param param
     * @return 0 成功， -1 失败
     */
    @Deprecated
    public int rcCalibrateBeginEnd(int param) {
        return JniNatives.rcCalibrateBeginEnd(param);
    }

    /**
     * 开始遥控器校准
     * @return 0 成功， -1 失败
     */
    public int startRemoteControlCalibrate() {
        return JniNatives.startRemoteControlCalibrate();
    }

    /**
     * 遥控器校准完成
     *
     * @return 0 成功， -1 失败
     */
    public int completeRemoteControlCalibrate() {
        return JniNatives.completeRemoteControlCalibrate();
    }

    /**
     * 固件升级
     *
     * @param filePath 固件绝对路径
     * @return 0 成功， -1 失败
     */
    public int firmwareUpgrade(String filePath) {
        return JniNatives.firmwareUpgrade(filePath);
    }

    /**
     * 启动自拍
     *
     * @return 0 成功， -1 失败
     */
    public int startAutodyne() {
        return JniNatives.startAutodyne();
    }

    /**
     * 启动飞行日志
     *
     * @param info 飞行日志开始参数
     * @return 0 成功， -1 失败
     */
    public int startRecord(FlightRecordStartParam info) {
        return JniNatives.startRecord(info.type,info.fileNameWithPath);
    }

    /**
     * 停止飞行日志
     *
     * @param info
     * @return 0 成功， -1 失败
     */
    public int stopRecord(FlightRecordStopParam info) {
        return JniNatives.stopRecord(info.flightDate,info.cityName,info.flightPosition,info.userId,info.aircraftId,info.longVideo,info.flightTime,info.isCollection,info.maxAltitude,info.flightDistance,info.cameraCounts,info.maxSpeed,info.psn);
    }

    /**
     * 设置Ray位置
     *
     * @param positionParam
     * @return 0 成功， -1 失败
     * */
    public int setPosition(PositionParam positionParam){
        if(positionParam == null)
            return -1;
        return JniNatives.setPosition(positionParam.x, positionParam.y, positionParam.z, positionParam.r, positionParam.buttons);
    }

    /**
     * 设置Ray位置
     *
     * @param main_mode 定深 不关心时传0，非定深模式1，定深模式2
     * @param sub_mode 定速档位 不关心时传0， 三个档位对应1、2、3、
     * @return 0 成功， -1 失败
     * */
    public int setCustomMode(int main_mode, int sub_mode){
        return JniNatives.setCustomMode(main_mode, sub_mode);
    }

    /**
     * 设置航灯亮度
     *
     * @param info 取值范围： 0~100
     * @return 0 成功， -1 失败
     * */
    public int setLightControl(int info){
        return JniNatives.setLightControl(info);
    }

    /**
     * 设置放钩
     *
     * @param data
     * @return 0 成功， -1 失败
     * */
    public int setCommandFishhook(int data){
        return JniNatives.setCommandFishhook(data);
    }

    /**
     * 设置加解锁
     *
     * @param isArm 0 加锁
     * @return 0 成功， -1 失败
     * */
    public int setCommandArm(int isArm){
        return JniNatives.setCommandArm(isArm);
    }

    /**
     * 船加解锁  false 加锁
     *
     * @param isArm 0 加锁
     * @return 0 成功， -1 失败
     * */
    public int setForceCommandArm(boolean isArm){
        return JniNatives.setForceCommandArm(isArm);
    }

    /**
     * 设置主从设备
     *
     * @param info
     * @return 0 成功， -1 失败
     * */
    public int setMasterControl(int info){
        return JniNatives.setMasterControl(info);
    }

    /**
     * 开始获取基站电量
     * 回调baseStationBatteryListener
     * 必须在connectionDrone之前调用
     *
     * @param ip
     * @param port
     * @return 0 成功， -1 失败
     * */
    public int setRayBaseStationAddress(String ip, int port){
        return JniNatives.setRayBaseStationAddress(ip, port);
    }

    /**
     * 初始化水下相机ip 端口
     *
     * @return 0 成功， -1 失败
     * */
    public int initRayCameraLink(String ip, int ctrPort, int dataPort){
        return JniNatives.initRayCameraLink(ip, ctrPort, dataPort);
    }

    /**
     * 重置水下回调初始值
     * */
    public int resetRayNotify(){
        return JniNatives.resetRayNotify();
    }

    /**
     * 连接状态通知
     *
     * @return 0 成功， -1 失败
     */
    public SystemStatusCallback.ConnectionListener getConnectionListener() {
        return connectionListener;
    }

    /**
     * 设置连接状态通知
     *
     * @param value
     */
    public void setConnectionListener(SystemStatusCallback.ConnectionListener value) {
        this.connectionListener = value;
    }

    /**
     * 获得模式改变通知
     * @return 0 成功， -1 失败
     */
    public SystemStatusCallback.ModeChangedListener getModeChangedListener() {
        return modeChangedListener;
    }

    /**
     * 设置模式改变通知
     * @param value
     */
    public void setModeChangedListener(SystemStatusCallback.ModeChangedListener value) {
        this.modeChangedListener = value;
    }

    /**
     * 相机相关通知
     *
     * @return 0 成功， -1 失败
     */
    public CameraListener getCameraListener() {
        return cameraListener;
    }

    /**
     * 相机相关通知
     * @param value
     */
    public void setCameraListener(CameraListener value) {
        this.cameraListener = value;
    }

    /**
     * 相机参数相关结果通知
     *
     * @return 0 成功， -1 失败
     */
    public CameraParamListener getCameraParamListener() {
        return cameraParamListener;
    }

    /**
     * 相机参数相关结果通知
     *
     * @param value
     */
    public void setCameraParamListener(CameraParamListener value) {
        this.cameraParamListener = value;
    }

    /**
     * 任务执行通知
     *
     * @return 0 成功， -1 失败
     */
    public MissionCallback.MissionActionListener getMissionActionListener() {
        return missionActionListener;
    }

    /**
     * 任务执行通知
     *
     * @param value
     */
    public void setMissionActionListener(MissionCallback.MissionActionListener value) {
        this.missionActionListener = value;
    }

    /**
     * 开始任务通知
     *
     * @return 0 成功， -1 失败
     */
    public MissionCallback.MissionRunListener getMissionRunListener() {
        return this.missionRunListener;
    }

    /**
     * 开始任务通知
     *
     * @param value
     */
    public void setMissionRunListener(MissionCallback.MissionRunListener value) {
        this.missionRunListener = value;
    }

    /**
     * 开始航线飞行通知
     *
     * @return 0 成功， -1 失败
     */
    public MissionCallback.StartWaypointListener getStartWaypointListener() {
        return startWaypointListener;
    }

    /**
     * 开始航线飞行通知
     *
     * @param value
     */
    public void setStartWaypointListener(MissionCallback.StartWaypointListener value) {
        this.startWaypointListener = value;
    }

    /**
     * 返航点通知
     *
     * @return 0 成功， -1 失败
     */
    public PositionCallback.TakeoffLandListener getTakeoffLandListener() {
        return takeoffLandListener;
    }

    /**
     * 返航点通知
     *
     * @param value
     */
    public void setTakeoffLandListener(PositionCallback.TakeoffLandListener value) {
        this.takeoffLandListener = value;
    }

    /**
     * 固件升级相关通知
     *
     * @return 0 成功， -1 失败
     */
    public RemoteControlCallback.FirmwareUpgradeListener getFirmwareUpgradeListener() {
        return firmwareUpgradeListener;
    }

    /**
     * 固件升级相关通知
     *
     * @param value
     */
    public void setFirmwareUpgradeListener(RemoteControlCallback.FirmwareUpgradeListener value) {
        firmwareUpgradeListener = value;
    }

    /**
     * 遥控器参数相关通知
     *
     * @return 0 成功， -1 失败
     */
    public RemoteControlCallback.RemoteControlParamListener getRemoteControlParamListener() {
        return remoteControlParamListener;
    }

    /**
     * 遥控器参数相关通知
     *
     * @param value
     */
    public void setRemoteControlParamListener(RemoteControlCallback.RemoteControlParamListener value) {
        remoteControlParamListener = value;
    }

    /**
     * 遥控器位置数据
     *
     * @return 0 成功， -1 失败
     */
    public RemoteControlCallback.RemoteControlLocationListener getRemoteControlLocationListener() {
        return remoteControlLocationListener;
    }

    /**
     * 遥控器位置数据
     *
     * @param value
     */
    public void setRemoteControlLocationListener(RemoteControlCallback.RemoteControlLocationListener value) {
        remoteControlLocationListener = value;
    }

    /**
     * 遥控器摇杆量数据接收的通知
     *
     * @return 0 成功， -1 失败
     */
    public RemoteControlCallback.ManualControlDataListener getManualControlDataListener() {
        return manualControlDataListener;
    }

    /**
     * 遥控器摇杆量数据接收的通知
     *
     * @param value
     */
    public void setManualControlDataListener(RemoteControlCallback.ManualControlDataListener value) {
        manualControlDataListener = value;
    }

    /**
     * 系统状态通知
     *
     * @return 0 成功， -1 失败
     */
    public SystemStatusCallback.SysStatusListener getSysStatusListener() {
        return sysStatusListener;
    }

    /**
     * 系统状态通知
     *
     * @param value
     */
    public void setSysStatusListener(SystemStatusCallback.SysStatusListener value) {
        sysStatusListener = value;
    }

    /**
     * 系统行为通知
     *
     * @return 0 成功， -1 失败
     */
    public SystemStatusCallback.SysDoListener getSysDoListener() {
        return sysDoListener;
    }

    /**
     * 系统行为通知
     *
     * @param value
     */
    public void setSysDoListener(SystemStatusCallback.SysDoListener value) {
        sysDoListener = value;
    }

    /**
     * 位置改变通知
     *
     * @return 0 成功， -1 失败
     */
    public PositionCallback.PositionChangedListener getPositionChangeListener() {
        return positionChangedListener;
    }

    /**
     * 位置改变通知
     *
     * @param value
     */
    public void setPositionChangeListener(PositionCallback.PositionChangedListener value) {
        positionChangedListener = value;
    }

    /**
     * HOME点通知
     *
     * @return 0 成功， -1 失败
     */
    public PositionCallback.HomePositionListener getHomePositionListener() {
        return homePositionListener;
    }

    /**
     * HOME点通知
     *
     * @param value
     */
    public void setHomePositionListener(PositionCallback.HomePositionListener value) {
        homePositionListener = value;
    }

    /**
     * GPSRAWINT通知
     *
     * @return 0 成功， -1 失败
     */
    public PositionCallback.GpsRawIntListener getGpsRawIntListener() {
        return gpsRawIntListener;
    }

    /**
     * GPSRAWINT通知
     *
     * @param value
     */
    public void setGpsRawIntListener(PositionCallback.GpsRawIntListener value) {
        gpsRawIntListener = value;
    }

    /**
     * 自检结果通知
     *
     * @return 0 成功， -1 失败
     */
    public SystemStatusCallback.SelfCheckListener getSelfCheckListener() {
        return selfCheckListener;
    }

    /**
     * 自检结果通知
     *
     * @param value
     */
    public void setSelfCheckListener(SystemStatusCallback.SelfCheckListener value) {
        selfCheckListener = value;
    }

    /**
     * 参数设置通知
     *
     * @return 0 成功， -1 失败
     */
    public ParamCallback.ParamSetGetListener getParamSetGetListener() {
        return paramSetGetListener;
    }

    /**
     * 参数设置通知
     *
     * @param value
     */
    public void setParamSetGetListener(ParamCallback.ParamSetGetListener value) {
        paramSetGetListener = value;
    }

    /**
     * 电池信息数据
     *
     * @return 0 成功， -1 失败
     */
    public SystemStatusCallback.BatteryStatusListener getBatteryStatusListener() {
        return batteryStatusListener;
    }

    /**
     * 电池信息数据
     *
     * @param value
     */
    public void setBatteryStatusListener(SystemStatusCallback.BatteryStatusListener value) {
        batteryStatusListener = value;
    }

    /**
     * 脚架状态数据
     *
     * @return 0 成功， -1 失败
     */
    public SystemStatusCallback.HelmControlStatusListener getHelmControlStatusListener() {
        return helmControlStatusListener;
    }

    /**
     * 脚架状态数据
     *
     * @param value
     */
    public void setHelmControlStatusListener(SystemStatusCallback.HelmControlStatusListener value) {
        helmControlStatusListener = value;
    }

    /**
     * 警告通知
     *
     * @return 0 成功， -1 失败
     */
    public SystemStatusCallback.AlarmListener getAlarmListener() {
        return alarmListener;
    }

    /**
     * 警告通知
     *
     * @param value
     */
    public void setAlarmListener(SystemStatusCallback.AlarmListener value) {
        alarmListener = value;
    }

    /**
     * 切换上一次模式通知
     *
     * @return 0 成功， -1 失败
     */
    public SystemStatusCallback.BackToLastModeListener getBackToLastModeListener() {
        return backToLastModeListener;
    }

    /**
     * 切换上一次模式通知
     *
     * @param value
     */
    public void setBackToLastModeListener(SystemStatusCallback.BackToLastModeListener value) {
        backToLastModeListener = value;
    }

    /**
     * 云台参数相关通知
     *
     * @return 0 成功， -1 失败
     */
    public GimbalCallback.GimbalParamListener getGimbalParamListener() {
        return gimbalParamListener;
    }

    /**
     * 云台参数相关通知
     *
     * @param value
     */
    public void setGimbalParamListener(GimbalCallback.GimbalParamListener value) {
        gimbalParamListener = value;
    }

    /**
     * Attitude、GroundSpeed改变结果通知
     *
     * @return 0 成功， -1 失败
     */
    public PositionCallback.AttitudeAndGroundspeedChangedListener getAttitudeAndGroundspeedChangedListener() {
        return attitudeAndGroundspeedChangedListener;
    }

    /**
     * Attitude、GroundSpeed改变结果通知
     *
     * @param value
     */
    public void setAttitudeAndGroundspeedChangedListener(PositionCallback.AttitudeAndGroundspeedChangedListener value) {
        attitudeAndGroundspeedChangedListener = value;
    }

    /**
     * 磁力计校准相关通知
     *
     * @return 0 成功， -1 失败
     */
    public GimbalCallback.RequestOperationalSensitivityListener getRequestOperationalSensitivityListener() {
        return requestOperationalSensitivityListener;
    }

    /**
     * 磁力计校准相关通知
     *
     * @param value
     */
    public void setRequestOperationalSensitivityListener(GimbalCallback.RequestOperationalSensitivityListener value) {
        requestOperationalSensitivityListener = value;
    }

    /**
     * 磁感校准结果通知
     *
     * @return 0 成功， -1 失败
     */
    public SensorCallback.MagnetometerCalibrateListener getMagnetometerCalibrateListener() {
        return magnetometerCalibrateListener;
    }

    /**
     * 磁感校准结果通知
     *
     * @param value
     */
    public void setMagnetometerCalibrateListener(SensorCallback.MagnetometerCalibrateListener value) {
        magnetometerCalibrateListener = value;
    }

    /**
     * 任务通知
     *
     * @return 0 成功， -1 失败
     */
    public MissionCallback.MissionListener getMissionListener() {
        return missionListener;
    }

    /**
     * 距离传感器通知
     *
     * @return 0 成功， -1 失败
     */
    public PositionCallback.DistanceSensorListener getDistanceSensorListener() {
        return distanceSensorListener;
    }

    /**
     * 任务通知
     *
     * @param value
     */
    public void setMissionListener(MissionCallback.MissionListener value) {
        missionListener = value;
    }

    /**
     * 距离传感器通知
     *
     * @param value
     */
    public void setDistanceSensorListener(PositionCallback.DistanceSensorListener value) {
        distanceSensorListener = value;
    }

    /**
     * @return 0 成功， -1 失败
     */
    public RemoteControlCallback.MountControlDataListener getMountControlDataListener() {
        return mountControlDataListener;
    }

    /**
     * @return 0 成功， -1 失败
     */
    public void setMountControlDataListener(RemoteControlCallback.MountControlDataListener value) {
        mountControlDataListener = value;
    }

    /**
     * 遥控器校准结果通知
     *
     * @return 0 成功， -1 失败
     */
    public RemoteControlCallback.RemoteControlCalibrateListener getRemoteControlCalibrateListener() {
        return remoteControlCalibrateListener;
    }

    /**
     * 遥控器校准结果通知
     *
     * @param value
     */
    public void setRemoteControlCalibrateListener(RemoteControlCallback.RemoteControlCalibrateListener value) {
        remoteControlCalibrateListener = value;
    }


    /**
     * 定位方式改变通知
     *
     * @return 0 成功， -1 失败
     */
    public SystemStatusCallback.LocatingTypeChangedListener getLocatingTypeChangedListener() {
        return locatingTypeChangedListener;
    }

    /**
     * 定位方式改变通知
     *
     */
    public void setLocatingTypeChangedListener(SystemStatusCallback.LocatingTypeChangedListener value) {
        locatingTypeChangedListener = value;
    }

    /**
     * 收放鱼钩回调
     * */
    public void setFishhookStatusListener(RayCallback.FishhookStatusListener value){
        fishhookStatusListener = value;
    }

    /**
     * 收放鱼钩回调
     * */
    public RayCallback.FishhookStatusListener getFishhookStatusListener(){
        return fishhookStatusListener;
    }

    /**
     * 更新声呐图片
     * */
    public int updateSonarBitmap(Bitmap bm){
        return JniNatives.updateSonarBitmap(bm);
    }

    /**
     * 开始传输声呐信息
     *
     * @param ip
     * @param port
     * @param bmWidth 图片高度 px
     * */
    public int startSonarBitmap(String ip, int port, int bmWidth){
        return JniNatives.startSonarBitmap(ip, port, bmWidth);
    }

    /**
     * 声呐信息传输停止
     * */
    public int stopSonarBitmap(){
        return JniNatives.stopSonarBitmap();
    }

    /**
     * 飞机、船 固件升级
     * */
    public int planeFirmwareUpgrade(String filePath){
        return JniNatives.planeFirmwareUpgrade(filePath);
    }

    /**
     * 寻鱼模式通知
     * */
    public int changeFishView(int info){
        return JniNatives.changeFishView(info);
    }

    /**
     * 开始基站升级
     *
     * @param fileFullPath 文件全路径
     * */
    public int startBaseStationUpgrade(String fileFullPath){
        return JniNatives.startBaseStationUpgrade(fileFullPath);
    }

    /**
     * 初始化ray的唯一标识符
     *
     * @param uuid
     * */
    public int initRayUuid(String uuid){
        return JniNatives.initRayUuid(uuid);
    }
}
