package com.powervision.powersdk.jni;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import com.powervision.powersdk.callback.RayCallback;
import com.powervision.powersdk.param.*;
import com.powervision.powersdk.sdk.PowerSDK;
import com.powervision.powersdk.callback.CameraCallback;
import com.powervision.powersdk.callback.GimbalCallback;
import com.powervision.powersdk.callback.MissionCallback;
import com.powervision.powersdk.callback.ParamCallback;
import com.powervision.powersdk.callback.PositionCallback;
import com.powervision.powersdk.callback.RemoteControlCallback;
import com.powervision.powersdk.callback.SensorCallback;
import com.powervision.powersdk.callback.SystemStatusCallback;
import com.powervision.powersdk.sdk.PowerSDKBaseStation;
import com.powervision.powersdk.sdk.PowerSDKCamera;

import java.util.Timer;
import java.util.TimerTask;


/**
 *
 */
public class JniNatives {
    static {
        System.loadLibrary("pvsdk_api-release");
        System.loadLibrary("pvsdk_api_wrapper");
    }

    private static PowerSDK powerSDK;

    /**
     * Default constructor
     */
    public JniNatives() {
        powerSDK = PowerSDK.getInstance();
    }

    /**
     *
     */
    public static final int JNI_NATIVES_RETURN_VALUE_SUCCESS = 0;

    /**
     *
     */
    public static final int JNI_NATIVES_RETURN_VALUE_FAILED = -1;


    /**
     * @param ip
     * @param port
     * @return
     */
    public static native int initSDK(String ip, int port);

    /**
     * @param connName
     * @param baudRate
     * @param type
     * @param level
     * @return
     */
    public static native int initSDK(String connName, int baudRate, int type, int level);

    /**
     * @return
     */
    public static native int unInitSDK();

    /**
     * @param versionString
     * @return
     */
    public static native int getSDKVersion(String versionString);

    /**
     * @param type
     * @return
     */
    public static native int getValiteKey(int type);

    /**
     * @param type
     * @return
     */
    public static native int getPSN(int type);

    /**
     * @return
     */
    public static native int registerCallback();

    /**
     * @return
     */
    public static native int connect();

    /**
     * @return
     */
    public static native int disConnect();

    /**
     * @return
     */
    public static native int connectDrone();

    /**
     * @return
     */
    public static native int disConnectDrone();

    /**
     * @return
     */
    public static native int arm();

    /**
     * @return
     */
    public static native int isArmed();

    /**
     * @return
     */
    public static native int disArm();

    /**
     * @return
     */
    public static native int takeOff();

    /**
     * @return
     */
    public static native int land();

    /**
     * @return
     */
    public static native int rtl();

    /**
     * @param x
     * @param y
     * @param z
     * @param radius
     * @param speed
     * @param isClockWise
     * @param isPause
     * @return
     */
    public static native int circle(float x, float y, float z, float radius, int speed, boolean isClockWise, boolean isPause);

    /**
     * @return
     */
    public static native int loadWayPoints();

    /**
     * @param param1s
     * @param param2s
     * @param param3s
     * @param param4s
     * @param xs
     * @param ys
     * @param zs
     * @param seqs
     * @return
     */
    public static native int setWayPoints(float [] param1s, float [] param2s, float [] param3s, float [] param4s, float [] xs, float [] ys, float [] zs, int [] seqs);

    /**
     * @return
     */
    public static native int startWayPoints();

    /**
     * @param p1x
     * @param p1y
     * @param p1z
     * @param p2x
     * @param p2y
     * @param p2z
     * @param frame
     * @return
     */
    public static native int setSafetyAllowedArea(float p1x, float p1y, float p1z, float p2x, float p2y, float p2z, int frame);

    /**
     * @param modeType
     * @return
     */
    public static native int setMode(int modeType);

    /**
     * @return
     */
    public static native int backToLastMode();

    /**
     * @return
     */
    public static native int followMe();

    /**
     * @param land_lat
     * @param land_lon
     * @param land_alt
     * @param status
     * @return
     */
    public static native int setTakeoffLand(float land_lat, float land_lon, float land_alt, long status);

    /**
     * @return
     */
    public static native int setHome();

    /**
     * @return
     */
    public static native int getHome();

    /**
     * @return
     */
    public static native int setFence();

    /**
     * @return
     */
    public static native int getFence();

    /**
     * @return
     */
    public static native GlobalPositionIntParam getGlobalPositionIntParam();

    public static native GpsRawIntParam getGpsRawIntParam();

    public static native VfrHudParam getVfrHudParam();

    public static native TakeoffLandParam getTakeoffLandParam();

    public static native SafetyAllowedAreaParam getSafetyAllowedAreaParam();

    public static native SystemStatusParam getSystemStatusParam();
    /**
     * @return
     */
    public static native Attitude getAttitude();

    /**
     * @param paramId
     * @return
     */
    public static native float getParameter(String paramId);

    /**
     * @param paramId
     * @return
     */
    public static native int requestParameter(String paramId);

    /**
     * @param paramId
     * @param param
     * @return
     */
    public static native int setParameter(String paramId, float param);

    /**
     * @return
     */
    public static native int changeCaptureMode(int status);

    /**
     * @return
     */
    public static native int stillCaptureMode();

    /**
     * @return
     */
    public static native int stillCapture();

    /**
     * @return
     */
    public static native int stillCaptureFlir();

    /**
     * @return
     */
    public static native int recMode();

    /**
     * @return
     */
    public static native int recStart();

    /**
     * @return
     */
    public static native int recStartFlir();

    /**
     * @return
     */
    public static native int recStop();

    /**
     * @return
     */
    public static native int recStopFlir();

    /**
     * @param param
     * @return
     */
    public static native int formatSD(float param);

    /**
     * @param param
     * @return
     */
    public static native int resetToCameraFactory(float param);

    /**
     * @param param
     * @return
     */
    public static native int captureSet(float param);

    /**
     * @param param
     * @return
     */
    public static native int setPicSize(int param);

    /**
     * @param param
     * @return
     */
    public static native int setRecResolution(int param);

    /**
     * @param param
     * @return
     */
    public static native int setWhiteBlance(int param);

    /**
     * @param param
     * @return
     */
    public static native int meteringSet(int param);

    /**
     * @param param
     * @return
     */
    public static native int shootMode(int param);

    /**
     * @param param
     * @return
     */
    public static native int setBurstSpeed(int param);

    /**
     * @param param
     * @return
     */
    public static native int setPictureFormat(int param);

    /**
     * @param param
     * @return
     */
    public static native int shootStyle(int param);

    /**
     * @param param
     * @return
     */
    public static native int staturationSet(int param);

    /**
     * @param param
     * @return
     */
    public static native int contrastSet(int param);

    /**
     * @return
     */
    public static native int requestPicSize();

    /**
     * @return
     */
    public static native int getPicSize();

    /**
     * @return
     */
    public static native int requestsHootMode();

    /**
     * @return
     */
    public static native int getShootMode();

    /**
     * @return
     */
    public static native int requestShootStyle();

    /**
     * @return
     */
    public static native int getShootStyle();

    /**
     * @return
     */
    public static native int requestVehicleStatus();

    /**
     * @return
     */
    public static native int getVehicleStatus();

    /**
     * @return
     */
    public static native int requestSDCAP();

    /**
     * @return
     */
    public static native int getSDCAP();

    /**
     * @param param
     * @return
     */
    public static native int setCameraAutoZoom(int param);

    /**
     * @param param
     * @return
     */
    public static native int setCameraZoom(int param);

    /**
     * @param pitch
     * @param roll
     * @param yaw
     * @return
     */
    public static native int setGimbalOrientation(int pitch, int roll, int yaw);

    /**
     * @param param
     * @return
     */
    public static native int setPitchAxis(int param);

    /**
     * @return
     */
    public static native int requestPitchAxis();

    /**
     * @param enable
     * @return
     */
    public static native int extendPitchAxisLimit(int enable);

    /**
     * @param factor
     * @return
     */
    public static native int setPitchAxisSmooth(int factor);

    /**
     * @return
     */
    public static native int requestPitchAxisSmooth();

    /**
     * @param factor
     * @return
     */
    public static native int setYawAxisSmooth(int factor);

    /**
     * @return
     */
    public static native int requestYawAxisSmooth();

    /**
     * @param speed
     * @return
     */
    public static native int setAngularSpeed(float speed);

    /**
     * @return
     */
    public static native int requestAngularSpeed();

    /**
     * @return
     */
    public static native int resetParameters();

    /**
     * @param mode
     * @return
     */
    public static native int setGimbalMode(int mode);

    /**
     * @return
     */
    public static native int requestGimbalMode();

    /**
     * @param param
     * @return
     */
    public static native int rollAxisTuning(float param);

    /**
     * @return
     */
    public static native int resetGimbalParams();

    /**
     * @return
     */
    public static native int requestRollAxisTuning();

    /**
     * @return
     */
    public static native int gimbalCalibrate();

    /**
     * @return
     */
    public static native int gimbalControl(int mount_mode, int stab_pitch, int stab_roll, int stab_yaw);

    /**
     * @param orientation
     * @param param
     * @return
     */
    public static native int operationalSensitivityConfig(int orientation, float param);

    /**
     * @param orientation
     * @return
     */
    public static native int requestOperationalSensitivity(int orientation);

    /**
     * @param enable
     * @return
     */
    public static native int enableVisualLocating(int enable);

    /**
     * @return
     */
    public static native int magnetometerCalibrate();

    /**
     * @return
     */
    public static native int magnetometerCalibrateClose();

    /**
     * @param mode
     * @return
     */
    public static native int hlemChangeMode(int mode);

    /**
     * @return
     */
    public static native int hlemControlOpen();

    /**
     * @return
     */
    public static native int hlemControlClose();

    /**
     * @param param
     * @return
     */
    public static native int rcCalibrateBeginEnd(int param);

    /**
     * @return
     */
    public static native int startRemoteControlCalibrate();

    /**
     * @return
     */
    public static native int completeRemoteControlCalibrate();

    /**
     * @param filePath
     * @return
     */
    public static native int firmwareUpgrade(String filePath);

    /**
     * @return
     */
    public static native int startAutodyne();

    /**
     * @param type
     * @param fileNameWithPath
     * @return
     */
    public static native int startRecord(int type, String fileNameWithPath);

    /**
     * @param flightDate
     * @param cityName
     * @param flightPosition
     * @param userId
     * @param aircraftId
     * @param longVideo
     * @param flightTime
     * @param isCollection
     * @param maxAltitude
     * @param flightDistance
     * @param cameraCounts
     * @return
     */
    public static native int stopRecord(String flightDate, String cityName, String flightPosition, int userId, String aircraftId, long longVideo, long flightTime, boolean isCollection, float maxAltitude, float flightDistance, int cameraCounts, float maxSpeed, String psn);

    /**
     * @return
     */
    public static native int setPosition(int x, int y, int z, int r, int buttons);

    /**
     * @return
     */
    public static native int setCustomMode(int main_mode, int sub_mode);

    /**
     * @return
     */
    public static native int setLightControl(int info);

    /**
     * @return
     */
    public static native int setCommandFishhook(int data);

    public static native int setCommandArm(int isArm);

    public static native int setForceCommandArm(boolean arm);

    /**
     * @return
     */
    public static native int setMasterControl(int info);

    public static native int startSonarBitmap(String ip, int port, int bmWidth);
    public static native int updateSonarBitmap(Bitmap bm);
    public static native int stopSonarBitmap();

    public static native int planeFirmwareUpgrade(String filePath);
    public static native int resetRayNotify();

    public static native int connectControlChannel();
    public static native int disConnectControlChannel();
    public static native int connectDataChannel();
    public static native int disConnectDataChannel();
    public static native int startSession();
    public static native int stopSession();
    public static native int getPreviewFileStart(String fileName, int token);
    public static native int getPreviewFileStop();
    public static native int lsFile(int info);
    public static native int format(String sd);
    public static native int cdDirectory(String directory);
    public static native int getFile(String fileName, int offset, int fetchSize);
    public static native int putFile(String fileName, long size, int offset, String md5sum);
    public static native int setClientInfo(int type, String ip);
    public static native int setSetting(String type, String param, int paramType);
    public static native int recordStart();
    public static native int recordStop();
    public static native int takePhoto();
    public static native int setHoldSessionState(boolean state);
    public static native int burninFw(String fileFullPath);
    public static native int getSpace(int type);
    public static native int setRayBaseStationAddress(String ip, int port);
    public static native int initRayCameraLink(String ip, int controlPort, int dataPort);
    public static native int getSetting(String type);
    public static native int changeFishView(int info);
    public static native int startBaseStationUpgrade(String fileFullPath);
    public static native int initRayUuid(String uuid);
    public static native int setFishFinderSsid(String pairIp, int pairPort, String ssid);
    public static native int pairRemodeControl(String pairIp, int pairPort, String ssid);

    //相机
    public static native void setCallBack();
    public static native boolean isGroundConnected();
    public static native boolean isAirConnected();
    public static native void tryConnectGroundWithTimeout(long timeout);
    public static native boolean disconnectWithGround();
    public static native boolean getApSSID();
    public static native boolean getApPassword();
    public static native boolean setApSSID(String pssid);
    public static native boolean setApPassword(String password);
    public static native boolean applyApConfig();
    public static native boolean getApConnectStatus();
    public static native boolean getGroundChannel();
    public static native boolean setGroundChannel(int channel);
    public static native boolean getGroundTxPower();
    public static native boolean setGroundTxPower(int txPower);
    public static native boolean getGroundCountryCode();
    public static native boolean setGroundCountryCode(int countryCode);
    public static native boolean getGroundModel();
    public static native boolean getGroundSN();
    public static native boolean setGroundSN(String SN);
    public static native boolean getGroundNetworkId();
    public static native boolean setGroundNetworkId(String networkId);
    public static native boolean getGroundMainCtrlHWVersion();
    public static native boolean getGroundMainCtrlSWVersion();
    public static native boolean getGroundRFHWVersion();
    public static native boolean getGroundRFSWVersion();
    public static native boolean getGroundRFSignalQuality();
    public static native boolean getGroundBatteryPower();
    public static native boolean resetGroundRF();
    public static native boolean rebootGroundRF();
    public static native boolean applyGroundRFConfig();
    public static native void tryConnectAirWithTimeout(long timeout);
    public static native boolean disconnectWithAir();
    public static native boolean getAirChannel();
    public static native boolean setAirChannel(int channel);
    public static native boolean getAirTxPower();
    public static native boolean setAirTxPower(int txPower);
    public static native boolean getAirCountryCode();
    public static native boolean setAirCountryCode(int countryCode);
    public static native boolean getAirModel();
    public static native boolean getAirSN();
    public static native boolean setAirSN(String sn);
    public static native boolean getAirNetworkId();
    public static native boolean setAirNetworkId(String networkId);
    public static native boolean getAirMainCtrlHWVersion();
    public static native boolean getAirMainCtrlSWVersion();
    public static native boolean getAirRFHWVersion();
    public static native boolean getAirRFSWVersion();
    public static native boolean getAirRFSignalQuality();
    public static native boolean resetAirRF();
    public static native boolean rebootAirRF();
    public static native boolean applyAirRFConfig();
    public static native boolean pairRF();
    public static native boolean getRFChannel();
    public static native boolean setRFChannel(int channel);
    public static native boolean getRFTxPower();
    public static native boolean setRFTxPower(int txPower);
    public static native boolean getRFNetworkId();
    public static native boolean setRFNetworkId(String networkId);
    public static native boolean applyRFConfig();
    public static native boolean getVideoResolution();
    public static native boolean setVideoResolution(int resolution);
    public static native boolean getVideoRate();
    public static native boolean setVideoRate(int rate);



    /**
     * @param status
     * @return
     */
    public static int connectionNotify(int status) {
        if (PowerSDK.getInstance().getConnectionListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }
	switch (status) {
            case SystemStatusCallback.ConnectionListener.PVSDK_CONNECTION_CONNECTING:
                PowerSDK.getInstance().getConnectionListener().onConnecting();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_CONNECTION_CONNECTED:
                PowerSDK.getInstance().getConnectionListener().onConnectSuccess();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_CONNECTION_DISCONNECTED:
                PowerSDK.getInstance().getConnectionListener().onDisConnected();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_CONNECTION_TIMEOUT:
                PowerSDK.getInstance().getConnectionListener().onConnectTimeout();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_HEARTBEAT_TIMEOUT:
                PowerSDK.getInstance().getConnectionListener().onHeartbeatTimeout();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_CONNECTION_FAILED:
                PowerSDK.getInstance().getConnectionListener().onConnectFailed();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_STANDARD_REMOTECONTROL_CONNECTED:
                PowerSDK.getInstance().getConnectionListener().onConnectedStandardRemotecontrol();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_MOTIONSENSING_REMOTECONTROL_CONNECTED:
                PowerSDK.getInstance().getConnectionListener().onConnectedMotionsensingRemotecontrol();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_DRONE_CONNECTING:
                PowerSDK.getInstance().getConnectionListener().onDroneConnecting();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_DRONE_CONNECTED:
                PowerSDK.getInstance().getConnectionListener().onDroneConnected();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_DRONE_DISCONNECTED:
                PowerSDK.getInstance().getConnectionListener().onDroneDisConnected();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_DRONE_CONNECT_TIMEOUT:
                PowerSDK.getInstance().getConnectionListener().onDroneConnectTimeout();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_DRONE_CONNECT_FAILED:
                PowerSDK.getInstance().getConnectionListener().onDroneConnectFailed();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_RAY_CONNECTED:
                PowerSDK.getInstance().getConnectionListener().onRayConnected();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_CONNECTION_TIMEOUT_REPLAY:
                PowerSDK.getInstance().getConnectionListener().onDroneConnectedReplay();
                break;
            case SystemStatusCallback.ConnectionListener.PVSDK_RAY_BASE_STATION_CONNECT_FAILED:
                PowerSDK.getInstance().getConnectionListener().onBaseStationConnFailed();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int modeChangedNotify(int status) {
        if (PowerSDK.getInstance().getModeChangedListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_TIMEOUT:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedTimeout();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED:
                PowerSDK.getInstance().getModeChangedListener().onModeChanged();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_MANUAL:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedManual();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_ALTCTL:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedAltctl();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_POSCTL:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedPosctl();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_AUTOMISSION:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedAutomission();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_AUTOTAKEOFF:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedAutoTakeoff();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_AUTOLAND:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedAutoLand();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_AUTORTL:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedAutoRtl();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_SUPERSIMPLE:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedSuperSimple();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_AUTOCIRCLE:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedAutoCircle();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_FOLLOWME:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedFollowme();
                break;
            case SystemStatusCallback.ModeChangedListener.PVSDK_MODE_CHANGED_AUTOLOITER:
                PowerSDK.getInstance().getModeChangedListener().onModeChangedAutoLoiter();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int missionNotify(int status) {
        if (PowerSDK.getInstance().getMissionListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case MissionCallback.MissionListener.PVSDK_MISSION_SEND_TIMEOUT:
                PowerSDK.getInstance().getMissionListener().onMissionSendTimeout();
                break;
            case MissionCallback.MissionListener.PVSDK_MISSION_CURRENT:
                PowerSDK.getInstance().getMissionListener().onMissionCurrent();
                break;
            case MissionCallback.MissionListener.PVSDK_MISSION_CLEAR_SUCCESS:
                PowerSDK.getInstance().getMissionListener().onMissionClearSuccess();
                break;
            case MissionCallback.MissionListener.PVSDK_MISSION_SEND_SUCCESS:
                PowerSDK.getInstance().getMissionListener().onMissionSendSuccess();
                break;
            case MissionCallback.MissionListener.PVSDK_MISSION_RECEIVE_SUCCESS:
                PowerSDK.getInstance().getMissionListener().onMissionReceiveSuccess();
                break;
            case MissionCallback.MissionListener.PVSDK_MISSION_SEND_ERROR:
                PowerSDK.getInstance().getMissionListener().onMissionSendFailed();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int missionActionNotify(int status) {
        if (PowerSDK.getInstance().getMissionActionListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case MissionCallback.MissionActionListener.PVSDK_MISSION_ACTION_UNKNOWN:
                PowerSDK.getInstance().getMissionActionListener().onMissionActionUnknown();
                break;
            case MissionCallback.MissionActionListener.PVSDK_MISSION_ACTION_TIMEOUT:
                PowerSDK.getInstance().getMissionActionListener().onMissionActionTimeout();
                break;
            case MissionCallback.MissionActionListener.PVSDK_MISSION_ACTION_ARM:
                PowerSDK.getInstance().getMissionActionListener().onMissionActionArm();
                break;
            case MissionCallback.MissionActionListener.PVSDK_MISSION_ACTION_DISARM:
                PowerSDK.getInstance().getMissionActionListener().onMissionActionDisarm();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int startWaypointNotify(int status) {
        if (PowerSDK.getInstance().getStartWaypointListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case MissionCallback.StartWaypointListener.PVSDK_START_WAYPOINT_TIMEOUT:
                PowerSDK.getInstance().getStartWaypointListener().onWaypointTimeout();
                break;
            case MissionCallback.StartWaypointListener.PVSDK_START_WAYPOINT_START:
                PowerSDK.getInstance().getStartWaypointListener().onWaypointStart();
                break;
            case MissionCallback.StartWaypointListener.PVSDK_START_WAYPOINT_STOP:
                PowerSDK.getInstance().getStartWaypointListener().onWaypointStop();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param type
     * @param seq
     * @return
     */
    public static int missionRunNotify(int type, int seq) {
        if (PowerSDK.getInstance().getMissionRunListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (type) {
            case MissionCallback.MissionRunListener.PVSDK_MISSIONRUN_INFO_CURRENT:
                PowerSDK.getInstance().getMissionRunListener().onMissionRunCurrent(seq);
                break;
            case MissionCallback.MissionRunListener.PVSDK_MISSIONRUN_INFO_REACHED:
                PowerSDK.getInstance().getMissionRunListener().onMissionRunReached(seq);
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int alarmNotify(long status) {
        if (PowerSDK.getInstance().getAlarmListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDK.getInstance().getAlarmListener().onAlarm(status);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @param paramId
     * @return
     */
    public static int paramSetGetNotify(int status, String paramId) {
        if (PowerSDK.getInstance().getParamSetGetListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_SET_SUCCESS:
                PowerSDK.getInstance().getParamSetGetListener().onParamSetSuccess(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_SET_TIMEOUT:
                PowerSDK.getInstance().getParamSetGetListener().onParamSetTimeout(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_GET_SUCCESS:
                PowerSDK.getInstance().getParamSetGetListener().onParamGetSuccess(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_GET_TIMEOUT:
                PowerSDK.getInstance().getParamSetGetListener().onParamGetTimeout(paramId);
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int takeoffLandNotify(int status) {
        if (PowerSDK.getInstance().getTakeoffLandListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case PositionCallback.TakeoffLandListener.PVSDK_TAKEOFFLAND_SET_SUCCESS:
                PowerSDK.getInstance().getTakeoffLandListener().onTakeoffLandSetSuccess();
                break;
            case PositionCallback.TakeoffLandListener.PVSDK_TAKEOFFLAND_RECEIVE_SUCCESS:
                PowerSDK.getInstance().getTakeoffLandListener().onTakeoffLandRecieveSuccess();
                break;
            case PositionCallback.TakeoffLandListener.PVSDK_TAKEOFFLAND_SEND_TIMEOUT:
                PowerSDK.getInstance().getTakeoffLandListener().onTakeoffLandSendTimeout();
                break;
            case PositionCallback.TakeoffLandListener.PVSDK_TAKEOFFLAND_SEND_FAILED:
                PowerSDK.getInstance().getTakeoffLandListener().onTakeoffLandSendFailed();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int gpsRawIntNotify(int status) {
        if (PowerSDK.getInstance().getGpsRawIntListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case PositionCallback.GpsRawIntListener.PVSDK_GPSRAWINT_CHANGED:
                PowerSDK.getInstance().getGpsRawIntListener().onGPSRawIntChanged();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int sysStatusNotify(int status) {
        if (PowerSDK.getInstance().getSysStatusListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case SystemStatusCallback.SysStatusListener.PVSDK_SYSSTATUS_CHANGED:
                PowerSDK.getInstance().getSysStatusListener().onSysStatusChanged(status);
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int positionChangedNotify(int status) {
        if (PowerSDK.getInstance().getPositionChangeListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case PositionCallback.PositionChangedListener.PVSDK_POSITION_CHANGED:
                PowerSDK.getInstance().getPositionChangeListener().onPositionChanged();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param lat
     * @param lon
     * @param alt
     * @return
     */
    public static int homePositionNotify(int lat, int lon, int alt) {
        if (PowerSDK.getInstance().getHomePositionListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        HomePositionNotifyParam param = new HomePositionNotifyParam();
        param.lat = lat;
        param.lon = lon;
        param.alt = alt;
        PowerSDK.getInstance().getHomePositionListener().onHomePosition(param);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int backToLastModeNotify(int status) {
        if (PowerSDK.getInstance().getBackToLastModeListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case SystemStatusCallback.BackToLastModeListener.PVSDK_BACKTOLASTMODE_TIMEOUT:
                PowerSDK.getInstance().getBackToLastModeListener().onBackToLastModeTimeout();
                break;
            case SystemStatusCallback.BackToLastModeListener.PVSDK_BACKTOLASTMODE_SUCCESS:
                PowerSDK.getInstance().getBackToLastModeListener().onBackToLastModeSuccess();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int cameraNotify(int status) {
        if (PowerSDK.getInstance().getCameraListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case CameraCallback.CameraListener.PVSDK_CAMERA_EXIST:
                PowerSDK.getInstance().getCameraListener().onCameraExists();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_REC_STOPED:
                PowerSDK.getInstance().getCameraListener().onCameraRecStopEnd();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_REC_RECORDING:
                PowerSDK.getInstance().getCameraListener().onCameraRecRecing();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_REC_START_ERROR:
                PowerSDK.getInstance().getCameraListener().onCameraRecStartError();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_REC_STOP_ERROR:
                PowerSDK.getInstance().getCameraListener().onCameraRecStopError();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_REC_MODE:
                PowerSDK.getInstance().getCameraListener().onCameraRecMode();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_REC_MODE_ERROR:
                PowerSDK.getInstance().getCameraListener().onCameraRecModeError();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_STILL_CAPTURE_SUCCESS:
                PowerSDK.getInstance().getCameraListener().onCameraStillCaptureEnd();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_STILL_CAPTURING:
                PowerSDK.getInstance().getCameraListener().onCameraStillCaptureing();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_STILL_CAPTURE_ERROR:
                PowerSDK.getInstance().getCameraListener().onCameraStillCaptureError();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_STILL_CAPTURE_MODE:
                PowerSDK.getInstance().getCameraListener().onCameraStillCaptureMode();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_STILL_CAPTURE_MODE_ERROR:
                PowerSDK.getInstance().getCameraListener().onCameraStillCaptureModeError();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_FORMAT_SD_SUCCESS:
                PowerSDK.getInstance().getCameraListener().onCameraFormatSDSuccess();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_FORMAT_SD_FAILED:
                PowerSDK.getInstance().getCameraListener().onCameraFormatSDFailed();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_RESET_TO_CAMERA_FACTORY_SUCCESS:
                PowerSDK.getInstance().getCameraListener().onCameraResetToCameraFactorySuccess();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_RESET_TO_CAMERA_FACTORY_FAILED:
                PowerSDK.getInstance().getCameraListener().onCameraResetToCameraFactoryFailed();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_REC_SETTING_SUCCESS:
                PowerSDK.getInstance().getCameraListener().onCameraRecSettingSuccess();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_REC_SETTING_FAILED:
                PowerSDK.getInstance().getCameraListener().onCameraRecSettingFailed();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_CAPTURE_SETTING_SUCCESS:
                PowerSDK.getInstance().getCameraListener().onCameraCaptureSettingSuccess();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_CAPTURE_SETTING_FAILED:
                PowerSDK.getInstance().getCameraListener().onCameraCaptureSettingFailed();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_PICTURE_SETTING_SUCCESS:
                PowerSDK.getInstance().getCameraListener().onCameraPictureSettingSuccess();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_PICTURE_SETTING_FAILED:
                PowerSDK.getInstance().getCameraListener().onCameraPictureSettingFailed();
                break;
            case CameraCallback.CameraListener.PVSDK_CAMERA_CAMERA_FEEDBACK_TIMEOUT:
                PowerSDK.getInstance().getCameraListener().onCameraCameraFeedBackTimeout();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status  参数状态返回值 @see ParamSetGetListener
     * @param paramId 参数ID,用以检测是否和发送的参数ID相同
     * @return
     */
    public static int selfCheckNotify(int status, String paramId) {
        if (PowerSDK.getInstance().getSelfCheckListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_SET_SUCCESS:
                PowerSDK.getInstance().getSelfCheckListener().onSelfCheckSetSuccess(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_SET_TIMEOUT:
                PowerSDK.getInstance().getSelfCheckListener().onSelfCheckSetTimeout(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_GET_SUCCESS:
                PowerSDK.getInstance().getSelfCheckListener().onSelfCheckGetSuccess(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_GET_TIMEOUT:
                PowerSDK.getInstance().getSelfCheckListener().onSelfCheckGetTimeout(paramId);
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status  参数状态返回值 @see ParamSetGetListener
     * @param paramId 参数ID,用以检测是否和发送的参数ID相同
     * @return
     */
    public static int cameraParamNotify(int status, String paramId) {
        if (PowerSDK.getInstance().getCameraParamListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_SET_SUCCESS:
                PowerSDK.getInstance().getCameraParamListener().onCameraParamSetSuccess(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_SET_TIMEOUT:
                PowerSDK.getInstance().getCameraParamListener().onCameraParamSetTimeout(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_GET_SUCCESS:
                PowerSDK.getInstance().getCameraParamListener().onCameraParamGetSuccess(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_GET_TIMEOUT:
                PowerSDK.getInstance().getCameraParamListener().onCameraParamGetTimeout(paramId);
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int attitudeAndGroundspeedChangedNotify(int status) {
        if (PowerSDK.getInstance().getAttitudeAndGroundspeedChangedListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case PositionCallback.AttitudeAndGroundspeedChangedListener.PVSDK_ATTITUDEANDGROUNDSPEED_CHANGED:
                PowerSDK.getInstance().getAttitudeAndGroundspeedChangedListener().onAttitudeAndGroundSpeedChanged(status);
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status  参数状态返回值 @see ParamSetGetListener
     * @param paramId 参数ID,用以检测是否和发送的参数ID相同
     * @return
     */
    public static int gimbalParamNotify(int status, String paramId) {
        if (PowerSDK.getInstance().getGimbalParamListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_SET_SUCCESS:
                PowerSDK.getInstance().getGimbalParamListener().onGimbalParamsSetSuccess(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_SET_TIMEOUT:
                PowerSDK.getInstance().getGimbalParamListener().onGimbalParamsSetTimeout(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_GET_SUCCESS:
                PowerSDK.getInstance().getGimbalParamListener().onGimbalParamsGetSuccess(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_GET_TIMEOUT:
                PowerSDK.getInstance().getGimbalParamListener().onGimbalParamsGetTimeout(paramId);
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status  参数状态返回值 @see ParamSetGetListener
     * @param paramId 参数ID,用以检测是否和发送的参数ID相同
     * @return
     */
    public static int remoteControlParamNotify(int status, String paramId) {
        if (PowerSDK.getInstance().getRemoteControlParamListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_SET_SUCCESS:
                PowerSDK.getInstance().getRemoteControlParamListener().onRemoteControlSetSuccess(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_SET_TIMEOUT:
                PowerSDK.getInstance().getRemoteControlParamListener().onRemoteControlSetTimeout(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_GET_SUCCESS:
                PowerSDK.getInstance().getRemoteControlParamListener().onRemoteControlGetSuccess(paramId);
                break;
            case ParamCallback.ParamSetGetListener.PVSDK_PARAMSETGET_INFO_GET_TIMEOUT:
                PowerSDK.getInstance().getRemoteControlParamListener().onRemoteControlGetTimeout(paramId);
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param orientation
     * @param param
     * @return
     */
    public static int requestOperationalSensitivityNotify(int orientation, float param) {
        if (PowerSDK.getInstance().getRequestOperationalSensitivityListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (orientation) {
            case GimbalCallback.RequestOperationalSensitivityListener.PVSDK_OPERATIONALSENSITIVITYCONFIG_INFO_PITCH:
                PowerSDK.getInstance().getRequestOperationalSensitivityListener().onOperationalsenSitivityConfigPitch(param);
                break;
            case GimbalCallback.RequestOperationalSensitivityListener.PVSDK_OPERATIONALSENSITIVITYCONFIG_INFO_ROLL:
                PowerSDK.getInstance().getRequestOperationalSensitivityListener().onOperationalsenSitivityConfigRoll(param);
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int magnetometerCalibrateNotify(int status) {
        if (PowerSDK.getInstance().getMagnetometerCalibrateListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_INVALID:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateInvalid();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_LEFT_ORIENTATION_DETECTED:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateLeftOrientationDetected();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_LEFT_SIDE_DONE:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateLeftSideDone();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_RIGHT_ORIENTATION_DETECTED:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateRightOrientationDetected();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_RIGHT_SIDE_DONE:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateRightSideDone();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_UP_ORIENTATION_DETECTED:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateUpOrientationDetected();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_UP_SIDE_DONE:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateUpSideDone();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_DOWN_ORIENTATION_DETECTED:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateDownOrientationDetected();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_DOWN_SIDE_DONE:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateDownSideDone();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_FRONT_ORIENTATION_DETECTED:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateFrontOrientationDetected();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_FRONT_SIDE_DONE:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateFrontSideDone();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_BACK_ORIENTATION_DETECTED:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateBackOrientationDetected();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_BACK_SIDE_DONE:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateBackSideDone();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_DONE:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateDone();
                break;
            case SensorCallback.MagnetometerCalibrateListener.PVSDK_MAGNETOMETERCALIBRATE_INFO_FAILED:
                PowerSDK.getInstance().getMagnetometerCalibrateListener().onMagnetometerCalibrateFailed();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @param param
     * @return
     */
    public static int firmwareUpgradeNotify(int status, int param) {
        if (PowerSDK.getInstance().getFirmwareUpgradeListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case RemoteControlCallback.FirmwareUpgradeListener.PVSDK_FIRMWAREUPGRADE_CALLBACK_STATUS_SUCCESS:
                PowerSDK.getInstance().getFirmwareUpgradeListener().onFirmwareUpgradeSuccess();
                break;
            case RemoteControlCallback.FirmwareUpgradeListener.PVSDK_FIRMWAREUPGRADE_CALLBACK_STATUS_FAILED:
                PowerSDK.getInstance().getFirmwareUpgradeListener().onFirmwareUpgradeFailed();
                break;
            case RemoteControlCallback.FirmwareUpgradeListener.PVSDK_FIRMWAREUPGRADE_CALLBACK_STATUS_UPGRADING:
                PowerSDK.getInstance().getFirmwareUpgradeListener().onFirmwareUpgradeProcessing(param);
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static int remoteControlCalibrateNotify(int status) {
        if (PowerSDK.getInstance().getRemoteControlCalibrateListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case RemoteControlCallback.RemoteControlCalibrateListener.PVSDK_REMOTECONTROLCALIBRATE_CALLBACK_INFO_CALIBRATE_SUCCESS:
                PowerSDK.getInstance().getRemoteControlCalibrateListener().onRemoteControlCalibrateSuccess();
                break;
            case RemoteControlCallback.RemoteControlCalibrateListener.PVSDK_REMOTECONTROLCALIBRATE_CALLBACK_INFO_CALIBRATE_FAILED:
                PowerSDK.getInstance().getRemoteControlCalibrateListener().onRemoteControlCalibrateFailed();
                break;
            case RemoteControlCallback.RemoteControlCalibrateListener.PVSDK_REMOTECONTROLCALIBRATE_CALLBACK_INFO_COMPLETE_SUCCESS:
                PowerSDK.getInstance().getRemoteControlCalibrateListener().onRemoteControlCompleteSuccess();
                break;
            case RemoteControlCallback.RemoteControlCalibrateListener.PVSDK_REMOTECONTROLCALIBRATE_CALLBACK_INFO_COMPLETE_FAILED:
                PowerSDK.getInstance().getRemoteControlCalibrateListener().onRemoteControlCompleteFailed();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param x
     * @param y
     * @param z
     * @param r
     * @param buttons
     * @param target
     * @return
     */
    public static int manualControlDataNotify(int x, int y, int z, int r, long buttons, int target) {
        if (PowerSDK.getInstance().getManualControlDataListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        ManualControlDateNotifyParam param = new ManualControlDateNotifyParam();
        param.x = x;
        param.y = y;
        param.z = z;
        param.r = r;
        param.buttons = buttons;
        param.target = target;
        PowerSDK.getInstance().getManualControlDataListener().onManualControlDataReceived(param);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param pitch
     * @param roll
     * @param yaw
     * @return
     */
    public static int mountControlDataNotify(int pitch, int roll, int yaw) {
        if (PowerSDK.getInstance().getMountControlDataListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        MountControlDateNotifyParam param = new MountControlDateNotifyParam();
        param.pitch = pitch;
        param.roll = roll;
        param.yaw = yaw;
        PowerSDK.getInstance().getMountControlDataListener().onMountControlDataReceived(param);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param voltages
     * @param temperature
     * @param battery_remaining
     * @return
     */
    public static int batteryStatusNotify(int[] voltages, int temperature, int battery_remaining) {
        if (PowerSDK.getInstance().getBatteryStatusListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        BatteryStatusNotifyParam param = new BatteryStatusNotifyParam();
        if (voltages != null && voltages.length > 0) {
            param.voltages = new int[voltages.length];
            for (int i = 0; i < voltages.length; i++) {
                param.voltages[i] = voltages[i];
            }
        }
        param.temperature = temperature;
        param.battery_remaining = battery_remaining;
        PowerSDK.getInstance().getBatteryStatusListener().onBatteryStatus(param);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param land_lat
     * @param land_lon
     * @param land_alt
     * @param status
     * @return
     */
    public static int remoteControlLocationNotify(float land_lat, float land_lon, float land_alt, int status) {
        if (PowerSDK.getInstance().getRemoteControlLocationListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        RemoteControlLocationNotifyParam param = new RemoteControlLocationNotifyParam();
        param.land_lat = land_lat;
        param.land_lon = land_lon;
        param.land_alt = land_alt;
        param.status = status;
        PowerSDK.getInstance().getRemoteControlLocationListener().onRemoteControlLocation(param);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param mode
     * @param expect
     * @return
     */
    public static int helmControlStatusNotify(int mode, int expect) {
        if (PowerSDK.getInstance().getHelmControlStatusListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        HelmControlStatusNotifyParam param = new HelmControlStatusNotifyParam();
        param.mode = mode;
        param.expect = expect;
        PowerSDK.getInstance().getHelmControlStatusListener().onHelmControlStatus(param);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param status
     * @return
     */
    public static boolean activateFlagPowerSDK = false;
    public static int sysDoNotify(int status) {
        if (PowerSDK.getInstance().getSysDoListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case SystemStatusCallback.SysDoListener.PVSDK_SYSDO_GETVALITEKEY_SUCCESS:
                PowerSDK.getInstance().getSysDoListener().onSysdoGetvalitekeySuccess();
                break;
            case SystemStatusCallback.SysDoListener.PVSDK_SYSDO_GETVALITEKEY_TIMEOUT:
                PowerSDK.getInstance().getSysDoListener().onSysdoGetvalitekeyTimeout();
                break;
            case SystemStatusCallback.SysDoListener.PVSDK_SYSDO_GETVALITEKEYSTATUS_SUCCESS:
                PowerSDK.getInstance().getSysDoListener().onSysdoGetvalitekeyStatusSuccess();
                break;
            case SystemStatusCallback.SysDoListener.PVSDK_SYSDO_GETVALITEKEYSTATUS_ERROR:
                PowerSDK.getInstance().getSysDoListener().onSysdoGetvalitekeyStatusError();
                break;
            case SystemStatusCallback.SysDoListener.PVSDK_SYSDO_SETVALITEKEYSTATUS_SUCCESS:
                if (activateFlagPowerSDK) {
                    PowerSDK.getInstance().getSysDoListener().onSysdoSetvalitekeyStatusSuccess();
                    activateFlagPowerSDK = false;
                }
                break;
            case SystemStatusCallback.SysDoListener.PVSDK_SYSDO_SETVALITEKEYSTATUS_ERROR:
                activateFlagPowerSDK = false;
                PowerSDK.getInstance().getSysDoListener().onSysdoSetvalitekeyStatusError();
                break;
            case SystemStatusCallback.SysDoListener.PVSDK_SYSDO_PSN_SUCCESS:
                PowerSDK.getInstance().getSysDoListener().onSysdoGetPSNSuccess();
                break;
            case SystemStatusCallback.SysDoListener.PVSDK_SYSDO_PSN_ERROR:
                PowerSDK.getInstance().getSysDoListener().onSysdoGetPSNFailed();
                break;
            case SystemStatusCallback.SysDoListener.PVSDK_SYSDO_PSN_TIMEOUT:
                PowerSDK.getInstance().getSysDoListener().onSysdoGetPSNTimeout();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @param currentDistance
     * @return
     */
    public static int distanceSensorNotify(int currentDistance) {
        if (PowerSDK.getInstance().getDistanceSensorListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        DistanceSensorNotifyParam param = new DistanceSensorNotifyParam();
        param.currentDistance = currentDistance;
        PowerSDK.getInstance().getDistanceSensorListener().onDistanceSensorDataReceived(param);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @return
     */
    public static int locatingTypeChangedNotify(int status) {
        if (PowerSDK.getInstance().getLocatingTypeChangedListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        if(status == SystemStatusCallback.LocatingTypeChangedListener.PVSDK_LOCATING_TYPE_GPS)
            PowerSDK.getInstance().getLocatingTypeChangedListener().onLocatingTypeGPS();
        else if(status == SystemStatusCallback.LocatingTypeChangedListener.PVSDK_LOCATING_TYPE_OPTICAL_FLOW){
            PowerSDK.getInstance().getLocatingTypeChangedListener().onLocatingTypeFLOW();
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @return
     */
    public static int altitudeNotify(int time_usec, float altitude_monotonic, float altitude_amsl, float altitude_local, float altitude_relative, float altitude_terrain, float bottom_clearance) {
        if (PowerSDK.getInstance().getAltitudeListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        AltitudeNotifyParam altitudeNotifyParam=new AltitudeNotifyParam();
        altitudeNotifyParam.time_usec = time_usec;
        altitudeNotifyParam.altitude_monotonic = altitude_monotonic;
        altitudeNotifyParam.altitude_amsl = altitude_amsl;
        altitudeNotifyParam.altitude_local = altitude_local;
        altitudeNotifyParam.altitude_relative = altitude_relative;
        altitudeNotifyParam.altitude_terrain = altitude_terrain;
        altitudeNotifyParam.bottom_clearance = bottom_clearance;

        PowerSDK.getInstance().getAltitudeListener().altitude(altitudeNotifyParam);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @return
     */
    public static int lightControlNotify(int increment) {
        if (PowerSDK.getInstance().getLightControlListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDK.getInstance().getLightControlListener().lightControl(increment);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @return
     */
    public static int baseStationBatteryNotify(char battery_remaining) {
        if (PowerSDK.getInstance().getBaseStationBatteryListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDK.getInstance().getBaseStationBatteryListener().baseStationBattery(battery_remaining);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    /**
     * @return
     */
    public static int masterControlNotify(boolean masterControl) {
        if (PowerSDK.getInstance().getMasterControlListener() == null) {
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDK.getInstance().getMasterControlListener().masterControl(masterControl);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int fishhookStatusNotify(int status) {
        if(PowerSDK.getInstance().getFishhookStatusListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        if(status == RayCallback.FishhookStatusListener.FISHHOOK_STATUS_ON) {
            PowerSDK.getInstance().getFishhookStatusListener().hookPut();
        } else if(status == RayCallback.FishhookStatusListener.FISHHOOK_STATUS_OFF){
            PowerSDK.getInstance().getFishhookStatusListener().hookReceiving();
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int uploadRateOfProgressNotify(int status, int progress) {
        if(PowerSDK.getInstance().getUploadRateOfProgressListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        if(status == SystemStatusCallback.UploadRateOfProgressListener.PVSDK_UPGRADE_OK) {
            PowerSDK.getInstance().getUploadRateOfProgressListener().onUpgraded();
        } else if(status == SystemStatusCallback.UploadRateOfProgressListener.PVSDK_UPGRADE_FAIL){
            PowerSDK.getInstance().getUploadRateOfProgressListener().onUpgradeFailed();
        } else if(status == SystemStatusCallback.UploadRateOfProgressListener.PVSDK_UPGRADEING){
            PowerSDK.getInstance().getUploadRateOfProgressListener().onUpgradeing(progress);
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraConnectionNotify(int status) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraConnectionListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status){
            case CameraCallback.PowerRayCameraConnectionListener.PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_CONTROL_CONNECTED:
                PowerSDKCamera.getInstance().getPowerRayCameraConnectionListener().connectionControlConnected();
                break;
            case CameraCallback.PowerRayCameraConnectionListener.PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_CONTROL_DISCONNECTED:
                PowerSDKCamera.getInstance().getPowerRayCameraConnectionListener().connectionControlDisconnect();
                break;
            case CameraCallback.PowerRayCameraConnectionListener.PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_CONTROL_TIMEOUT:
                PowerSDKCamera.getInstance().getPowerRayCameraConnectionListener().connectionControlConnectTimeout();
                break;
            case CameraCallback.PowerRayCameraConnectionListener.PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_CONTROL_FAILED:
                PowerSDKCamera.getInstance().getPowerRayCameraConnectionListener().connectionControlConnectFailed();
                break;
            case CameraCallback.PowerRayCameraConnectionListener.PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_DATA_CONNECTED:
                PowerSDKCamera.getInstance().getPowerRayCameraConnectionListener().connectionDataConnected();
                break;
            case CameraCallback.PowerRayCameraConnectionListener.PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_DATA_FAILED:
                PowerSDKCamera.getInstance().getPowerRayCameraConnectionListener().connectionDataConnectFailed();
                break;
            case CameraCallback.PowerRayCameraConnectionListener.PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_DATA_TIMEOUT:
                PowerSDKCamera.getInstance().getPowerRayCameraConnectionListener().connectionDataConnectTimeout();
                break;
            case CameraCallback.PowerRayCameraConnectionListener.PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_DATA_DISCONNECTED:
                PowerSDKCamera.getInstance().getPowerRayCameraConnectionListener().connectionDataDisconnect();
                break;

        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraStartSessionNotify(int status) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraStartSessionListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case CameraCallback.PowerRayCameraStartSessionListener.PVSDK_POWERRAY_CAMERA_STARTSESSION_CALLBACK_INFO_SUCCESS:
                PowerSDKCamera.getInstance().getPowerRayCameraStartSessionListener().startSessionSuccess();
                break;
            case CameraCallback.PowerRayCameraStartSessionListener.PVSDK_POWERRAY_CAMERA_STARTSESSION_CALLBACK_INFO_TIMEOUT:
                PowerSDKCamera.getInstance().getPowerRayCameraStartSessionListener().startSessionTimeout();
                break;
            case CameraCallback.PowerRayCameraStartSessionListener.PVSDK_POWERRAY_CAMERA_STARTSESSION_CALLBACK_INFO_FAILED:
                PowerSDKCamera.getInstance().getPowerRayCameraStartSessionListener().startSessionFailed();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraStopSessionNotify(int status) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraStopSessionListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch (status) {
            case CameraCallback.PowerRayCameraStopSessionListener.PVSDK_POWERRAY_CAMERA_STOPSESSION_CALLBACK_INFO_SUCCESS:
                PowerSDKCamera.getInstance().getPowerRayCameraStopSessionListener().startSessionSuccess();
                break;
            case CameraCallback.PowerRayCameraStopSessionListener.PVSDK_POWERRAY_CAMERA_STOPSESSION_CALLBACK_INFO_TIMEOUT:
                PowerSDKCamera.getInstance().getPowerRayCameraStopSessionListener().startSessionTimeout();
                break;
            case CameraCallback.PowerRayCameraStopSessionListener.PVSDK_POWERRAY_CAMERA_STOPSESSION_CALLBACK_INFO_FAILED:
                PowerSDKCamera.getInstance().getPowerRayCameraStopSessionListener().startSessionFailed();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraGetPreviewFileNotify(int rval, int size, String type, String md5sum) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraGetPreviewFileListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraGetPreviewFileListener().getPreview(rval, size, type, md5sum);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraReceiverDataNotify(String buf, int len) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraReceiverDataListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraReceiverDataListener().receiverData(buf, len);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraLsFileNotify(int rval, String files[]) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraLsFileListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraLsFileListener().lsFile(rval, files);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraFormatNotify(int rval) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraFormatListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraFormatListener().format(rval);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraCdDirectoryNotify(int rval, String pwd) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraCdDirectoryListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraCdDirectoryListener().cdDirectory(rval, pwd);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraGetFileCompleteNotify(String type, int bytesSent, String md5sum) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraGetFileCompleteListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraGetFileCompleteListener().getFileComplete(type, bytesSent, md5sum);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraGetFileNotify(int rval, long size, long remSize) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraGetFileListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraGetFileListener().getFile(rval, size, remSize);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraPutFileNotify(int rval) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraPutFileListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraPutFileListener().putFile(rval);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraPutFileCompleteNotify(String type, long param, String md5sum) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraPutFileCompleteListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraPutFileCompleteListener().putFileComplete(type, param, md5sum);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraFwUpgradeCompleteNotify(String type){
        if(PowerSDKCamera.getInstance().getPowerRayCameraFwUpgradeCompleteListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraFwUpgradeCompleteListener().fwUpgradeComplete(type);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraBurninFwNotify(int rval){
        if(PowerSDKCamera.getInstance().getPowerRayCameraBurninFwNotifyListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraBurninFwNotifyListener().burninFw(rval);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraSetClientInfoNotify(int info) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraSetClientInfoListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch(info) {
            case CameraCallback.PowerRayCameraSetClientInfoListener.PVSDK_POWERRAY_CAMERA_SET_CLIENT_INFO_CALLBACK_INFO_SUCCESS:
                PowerSDKCamera.getInstance().getPowerRayCameraSetClientInfoListener().setClientInfoSuccess();
                break;
            case CameraCallback.PowerRayCameraSetClientInfoListener.PVSDK_POWERRAY_CAMERA_SET_CLIENT_INFO_CALLBACK_INFO_FAILED:
                PowerSDKCamera.getInstance().getPowerRayCameraSetClientInfoListener().setClientInfoFailed();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraRecordStartNotify(int info) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraRecordStartListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch(info) {
            case CameraCallback.PowerRayCameraRecordStartListener.PVSDK_POWERRAY_CAMERA_RECORDSTART_CALLBACK_INFO_SUCCESS:
                PowerSDKCamera.getInstance().getPowerRayCameraRecordStartListener().recordStartSuccess();
                break;
            case CameraCallback.PowerRayCameraRecordStartListener.PVSDK_POWERRAY_CAMERA_RECORDSTART_CALLBACK_INFO_TIMEOUT:
                PowerSDKCamera.getInstance().getPowerRayCameraRecordStartListener().recordStartTimeOut();
                break;
            case CameraCallback.PowerRayCameraRecordStartListener.PVSDK_POWERRAY_CAMERA_RECORDSTART_CALLBACK_INFO_FAILED:
                PowerSDKCamera.getInstance().getPowerRayCameraRecordStartListener().recordStartFailed();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraTakePhotoNotify(int rval, String captureMode, String param) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraTakePhotoListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraTakePhotoListener().takePhoto(rval, captureMode, param);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraRecordStopNotify(int rval, String param) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraRecordStopListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraRecordStopListener().recordStop(rval, param);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraSetSettingNotify(int rval, String type) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraSetSettingListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraSetSettingListener().setSetting(rval, type);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraGetSpaceNotify(int rval, int param) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraGetSpaceListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraGetSpaceListener().getSpace(rval, param);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraGetSettingNotify(int rval, String type, String param) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraGetSettingListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraGetSettingListener().cameraGetSetting(rval, type, param);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraGetDeviceInfoNotify(int rval, String returnMsg, String brand, String model, String chip,
                                                        String app_type, String fw_ver, String api_ver, String media_folder, String event_folder,
                                                        String http, String auth, String vodeo_main_section, String vodeo_sensor_section, String vodeo_stream_section,
                                                        String photo_main_section, String photo_offset_section) {
        if(PowerSDKCamera.getInstance().getPowerRayCameraGetDeviceInfoListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        DeviceInfoNotifyParam dinp = new DeviceInfoNotifyParam();
        dinp.rval = rval;
        dinp.returnMsg = returnMsg;
        dinp.brand = brand;
        dinp.model = model;
        dinp.chip  = chip;
        dinp.app_type = app_type;
        dinp.fw_ver = fw_ver;
        dinp.api_ver = api_ver;
        dinp.media_folder = media_folder;
        dinp.event_folder = event_folder;
        dinp.http = http;
        dinp.auth = auth;
        dinp.vodeo_main_section = vodeo_main_section;
        dinp.vodeo_sensor_section = vodeo_sensor_section;
        dinp.vodeo_stream_section = vodeo_stream_section;
        dinp.photo_main_section = photo_main_section;
        dinp.photo_offset_section = photo_offset_section;

        PowerSDKCamera.getInstance().getPowerRayCameraGetDeviceInfoListener().getDeviceInfo(dinp);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int powerRayCameraSessionLostNotify() {
        if(PowerSDKCamera.getInstance().getPowerRayCameraSessionLostListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDKCamera.getInstance().getPowerRayCameraSessionLostListener().sessionLost();

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int rayArmStatusNotify(int isArm) {
        if(PowerSDK.getInstance().getRayArmStatusListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        if(isArm == RayCallback.RayArmStatusListener.RAY_ARM_BACK) {
            PowerSDK.getInstance().getRayArmStatusListener().rayArm();
        } else if(isArm == RayCallback.RayArmStatusListener.RAY_DISARM_BACK) {
            PowerSDK.getInstance().getRayArmStatusListener().rayDisarm();
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }


    public static int rayAlarmNotify(int type) {
        if(PowerSDK.getInstance().getRayAlarmListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDK.getInstance().getRayAlarmListener().alarm(type);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int rayDepthSettingModeNotify(int type) {
        if(PowerSDK.getInstance().getRayDepthSettingModeListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDK.getInstance().getRayDepthSettingModeListener().depthSettingMode(type);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int rayConstantSpeedModeNotify(int type) {
        if(PowerSDK.getInstance().getRayConstantSpeedModeListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDK.getInstance().getRayConstantSpeedModeListener().constantSpeedMode(type);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int rayRemoteControlInstructionsNotify(int type) {
        if(PowerSDK.getInstance().getRayRemoteControlInstructionsListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDK.getInstance().getRayRemoteControlInstructionsListener().remoteControlInstructions(type);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int rayRemoteControlConnectionNotify(boolean rayRCConnection) {
        if(PowerSDK.getInstance().getRayRemoteControlConnectionListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        PowerSDK.getInstance().getRayRemoteControlConnectionListener().remoteControlConnection(rayRCConnection);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int baseUpgradeStatusNotify(int status, int uploadPercent) {
        Log.e("SDK", "baseUpgradeStatusNotify  status==>"+status+"  uploadPercent==>"+uploadPercent);
        if(PowerSDK.getInstance().getBaseUpgradeStatusListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }

        switch(status) {
            case RayCallback.BaseUpgradeStatusListener.PVSDK_BASE_UPGRADE_STATE_READ_BOOT_LOADER:
                PowerSDK.getInstance().getBaseUpgradeStatusListener().readBootLoader();
                break;
            case RayCallback.BaseUpgradeStatusListener.PVSDK_BASE_UPGRADE_STATE_GET_FLASH_SIZE:
                PowerSDK.getInstance().getBaseUpgradeStatusListener().getFlashSize();
                break;
            case RayCallback.BaseUpgradeStatusListener.PVSDK_BASE_UPGRADE_STATE_ERASE:
                PowerSDK.getInstance().getBaseUpgradeStatusListener().erase();
                break;
            case RayCallback.BaseUpgradeStatusListener.PVSDK_BASE_UPGRADE_STATE_UPLOADING:
                PowerSDK.getInstance().getBaseUpgradeStatusListener().upLoading(uploadPercent);
                break;
            case RayCallback.BaseUpgradeStatusListener.PVSDK_BASE_UPGRADE_STATE_UPLOAD_OK:
                PowerSDK.getInstance().getBaseUpgradeStatusListener().upLoadOk();
                break;
            case RayCallback.BaseUpgradeStatusListener.PVSDK_BASE_UPGRADE_STATE_CHECK_FILE_OK:
                PowerSDK.getInstance().getBaseUpgradeStatusListener().checkFileOk();
                break;
            case RayCallback.BaseUpgradeStatusListener.PVSDK_BASE_UPGRADE_STATE_CHECK_FILE_FAIL:
                PowerSDK.getInstance().getBaseUpgradeStatusListener().checkFileFail();
                break;
            case RayCallback.BaseUpgradeStatusListener.PVSDK_BASE_UPGRADE_STATE_RESTART:
                PowerSDK.getInstance().getBaseUpgradeStatusListener().restart();
                break;
        }

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static int electronicSpeedControlNotify(String data){
        if(PowerSDK.getInstance().getElectronicSpeedControlListener() == null){
            return JNI_NATIVES_RETURN_VALUE_FAILED;
        }
	
	String[] dataArr = data.split(",");

        SpeedControlNotifyParam sc=new SpeedControlNotifyParam();
	sc.voltage = Float.valueOf(dataArr[0]);
        sc.current = Float.valueOf(dataArr[1]);
        sc.phasecurrent = Float.valueOf(dataArr[2]);
        sc.revocount = Integer.valueOf(dataArr[3]);
        sc.data1 = Integer.valueOf(dataArr[4]);
        sc.data2 = Integer.valueOf(dataArr[5]);
        sc.data3 = Integer.valueOf(dataArr[6]);
        sc.rxthr = Integer.valueOf(dataArr[7]);
        sc.realthr = Integer.valueOf(dataArr[8]);
        sc.rpm = Integer.valueOf(dataArr[9]);
        sc.mostemp = Integer.valueOf(dataArr[10]);
        sc.statuscode = Integer.valueOf(dataArr[11]);
        sc.port = Integer.valueOf(dataArr[12]);
        sc.direction = Integer.valueOf(dataArr[13]);

        PowerSDK.getInstance().getElectronicSpeedControlListener().electronicSpeedControl(sc);

        return JNI_NATIVES_RETURN_VALUE_SUCCESS;
    }

    public static void disConnectToGroundNotify(){
        if(PowerSDKBaseStation.getInstance().getDisconnectToGroundListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getDisconnectToGroundListener().onDisconnectToGround();
    }

    public static void disconnectToAirNotify(){
        if(PowerSDKBaseStation.getInstance().getDisconnectToAirListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getDisconnectToAirListener().onDisconnectToAir();
    }

    public static void connectedToGroundNotify(){
        if(PowerSDKBaseStation.getInstance().getConnectedToGroundListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getConnectedToGroundListener().connectedToGround();
    }

    public static void connectedToAirNotify(){
        if(PowerSDKBaseStation.getInstance().getConnectedToAirListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getConnectedToAirListener().connectedToAir();
    }

    public static void isPvLinkNotify(boolean result){
        if(PowerSDKBaseStation.getInstance().getIsPvLinkListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getIsPvLinkListener().onIsPvLink(result);
    }

    public static void getApSSIDNotify(String ssid, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetApSSIDListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetApSSIDListener().getApSSID(ssid, result);
    }

    public static void setApSSIDNotify(String ssid, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetApSSIDListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetApSSIDListener().setApSSID(ssid, result);
    }

    public static void getApPasswordNotify(String password, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetApPasswordListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetApPasswordListener().getApPassword(password, result);
    }

    public static void applyApConfigNotify(boolean result){
        if(PowerSDKBaseStation.getInstance().getApplyApConfigListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getApplyApConfigListener().applyApConfig(result);
    }

    public static void getApConnectStatusNotify(int status, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetApConnectStatusListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetApConnectStatusListener().getApConnectStatus(status, result);
    }

    public static void getGroundChannelNotify(int channel, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundChannelListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundChannelListener().onGetGroundChannel(channel, result);
    }

    public static void setGroundChannelNotify(int channel, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetGroundChannelListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetGroundChannelListener().onSetGroundChannel(channel, result);
    }

    public static void getGroundTxPowerNotify(int txPower, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundTxPowerListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundTxPowerListener().onGetGroundTxPower(txPower, result);
    }

    public static void setGroundTxPowerNotify(int txPower, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetGroundTxPowerListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetGroundTxPowerListener().onSetGroundTxPower(txPower, result);
    }

    public static void getGroundCountryCodeNotify(int country_code, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundCountryCodeListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundCountryCodeListener().getGroundCountryCode(country_code, result);
    }

    public static void setGroundCountryCodeNotify(int country_code, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetGroundCountryCodeListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetGroundCountryCodeListener().setGroundCountryCode(country_code, result);
    }

    public static void getGroundModelNotify(String model, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundModelListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundModelListener().getGroundModel(model, result);
    }

    public static void getGroundSNNotify(String sn, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundSNListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundSNListener().getGroundSN(sn, result);
    }

    public static void setGroundSNNotify(String sn, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetGroundSNListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetGroundSNListener().setGroundSN(sn, result);
    }

    public static void getGroundNetworkIdNotify(String pnetwork_id, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundNetworkIdListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundNetworkIdListener().getGroundNetworkId(pnetwork_id, result);
    }

    public static void setGroundNetworkIdNotify(String pnetwork_id, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetGroundNetworkIdListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetGroundNetworkIdListener().setGroundNetworkId(pnetwork_id, result);
    }

    public static void getGroundMainCtrlHWVersionNotify(String version, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundMainCtrlHWVersionListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundMainCtrlHWVersionListener().getGroundMainCtrlHWVersion(version, result);
    }

    public static void getGroundMainCtrlSWVersionNotify(String version, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundMainCtrlSWVersionListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundMainCtrlSWVersionListener().getGroundMainCtrlSWVersion(version, result);
    }

    public static void getGroundRFHWVersionNotify(String version, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundRFHWVersionListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundRFHWVersionListener().getGroundRFHWVersion(version, result);
    }

    public static void getGroundRFSWVersionNotify(String version, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundRFSWVersionListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundRFSWVersionListener().getGroundRFSWVersion(version, result);
    }

    public static void getGroundRFSignalQualityNotify(int ssid, int snr, int noise, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundRFSignalQualityListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundRFSignalQualityListener().getGroundRFSignalQuality(ssid, snr, noise, result);
    }

    public static void getGroundBatteryPowerNotify(float power, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetGroundBatteryPowerListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetGroundBatteryPowerListener().getGroundBatteryPower(power, result);
    }

    public static void resetGroundRFNotify(boolean result){
        if(PowerSDKBaseStation.getInstance().getResetGroundRFListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getResetGroundRFListener().resetGroundRF(result);
    }

    public static void rebootGroundRFNotify(boolean result){
        if(PowerSDKBaseStation.getInstance().getRebootGroundRFListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getRebootGroundRFListener().rebootGroundRF(result);
    }

    public static void applyGroundRFConfigNotify(boolean result){
        if(PowerSDKBaseStation.getInstance().getApplyGroundRFConfigListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getApplyGroundRFConfigListener().applyGroundRFConfig(result);
    }

    public static void getAirChannelNotify(int channel, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetAirChannelListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetAirChannelListener().onGetAirChannel(channel, result);
    }

    public static void setAirChannelNotify(int channel, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetAirChannelListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetAirChannelListener().onSetAirChannel(channel, result);
    }

    public static void getAirTxPowerNotify(int txPower, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetAirTxPowerListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetAirTxPowerListener().onGetAirTxPower(txPower, result);
    }

    public static void setAirTxPowerNotify(int txPower, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetAirTxPowerListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetAirTxPowerListener().onSetAirTxPower(txPower, result);
    }

    public static void getAirCountryCodeNotify(int countryCode, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetAirCountryCodeListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetAirCountryCodeListener().onGetAirCountryCode(countryCode, result);
    }

    public static void setAirCountryCodeNotify(int countryCode, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetAirCountryCodeListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetAirCountryCodeListener().setAirCountryCode(countryCode, result);
    }

    public static void getAirModelNotify(String model, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetAirModelListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetAirModelListener().getAirModel(model, result);
    }

    public static void getAirSNNotify(String sn, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetAirSNListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetAirSNListener().getAirSN(sn, result);
    }

    public static void setAirSNNotify(String sn, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetAirSNListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetAirSNListener().setAirSN(sn, result);
    }

    public static void getAirNetworkIdNotify(String pnetwork_id, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetAirNetworkIdListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetAirNetworkIdListener().getAirNetworkId(pnetwork_id, result);
    }

    public static void setAirNetworkIdNotify(String pnetwork_id, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetAirNetworkIdListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetAirNetworkIdListener().setAirNetworkId(pnetwork_id, result);
    }

    public static void getAirMainCtrlHWVersionNotify(String version, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetAirMainCtrlHWVersionListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetAirMainCtrlHWVersionListener().getAirMainCtrlHWVersion(version, result);
    }

    public static void getAirMainCtrlSWVersionNotify(String version, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetAirMainCtrlSWVersionListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetAirMainCtrlSWVersionListener().getAirMainCtrlSWVersion(version, result);
    }

    public static void getAirRFHWVersionNotify(String version, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetAirRFHWVersionListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetAirRFHWVersionListener().getAirRFHWVersion(version, result);
    }

    public static void getAirRFSWVersionNotify(String version, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetAirRFSWVersionListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetAirRFSWVersionListener().getAirRFSWVersion(version, result);
    }

    public static void getAirRFSignalQualityNotify(int ssid, int snr, int noise, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetAirRFSignalQualityListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetAirRFSignalQualityListener().getAirRFSignalQuality(ssid, snr, noise, result);
    }

    public static void resetAirRFNotify(boolean result){
        if(PowerSDKBaseStation.getInstance().getResetAirRFListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getResetAirRFListener().resetAirRF(result);
    }

    public static void rebootAirRFNotify(boolean result){
        if(PowerSDKBaseStation.getInstance().getRebootAirRFListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getRebootAirRFListener().rebootAirRF(result);
    }

    public static void applyAirRFConfigNotify(boolean result){
        if(PowerSDKBaseStation.getInstance().getApplyAirRFConfigListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getApplyAirRFConfigListener().applyAirRFConfig(result);
    }

    public static void pairRFNotify(boolean result){
        if(PowerSDKBaseStation.getInstance().getPairRFListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getPairRFListener().pairRF(result);
    }

    public static void getRFChannelNotify(int channel, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetRFChannelListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetRFChannelListener().getRFChannel(channel, result);
    }

    public static void setRFChannelNotify(int channel, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetRFChannelListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetRFChannelListener().setRFChannel(channel, result);
    }

    public static void getRFTxPowerNotify(int tx_power, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetRFTxPowerListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetRFTxPowerListener().getRFTxPower(tx_power, result);
    }

    public static void setRFTxPowerNotify(int tx_power, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetRFTxPowerListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetRFTxPowerListener().setRFTxPower(tx_power, result);
    }

    public static void getRFNetworkIdNotify(String pnetwork_id, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetRFNetworkIdListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetRFNetworkIdListener().getRFNetworkId(pnetwork_id, result);
    }

    public static void setRFNetworkIdNotify(String pnetwork_id, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetRFNetworkIdListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetRFNetworkIdListener().setRFNetworkId(pnetwork_id, result);
    }

    public static void applyRFConfigNotify(boolean result){
        if(PowerSDKBaseStation.getInstance().getApplyRFConfigListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getApplyRFConfigListener().applyRFConfig(result);
    }

    public static void getVideoResolutionNotify(int resolution, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetVideoResolutionListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetVideoResolutionListener().getVideoResolution(resolution, result);
    }

    public static void setVideoResolutionNotify(int resolution, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetVideoResolutionListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetVideoResolutionListener().setVideoResolution(resolution, result);
    }

    public static void getVideoRateNotify(int rate, boolean result){
        if(PowerSDKBaseStation.getInstance().getGetVideoRateListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getGetVideoRateListener().getVideoRate(rate, result);
    }

    public static void setVideoRateNotify(int rate, boolean result){
        if(PowerSDKBaseStation.getInstance().getSetVideoRateListener() == null){
            return;
        }

        PowerSDKBaseStation.getInstance().getSetVideoRateListener().setVideoRate(rate, result);
    }

	//设置为参数设置为void崩溃 原因未找到
    public static int rayBaseStationVerNotify(int tmp){
	    if(PowerSDKBaseStation.getInstance().getRayBaseStationVerListener() == null){
		    return 0;
	    }

	    PowerSDKBaseStation.getInstance().getRayBaseStationVerListener().baseStationVer();
        return 0;
    }

    public static int rayConnectionTerminalNotify(int terminalNumber){
        if(PowerSDKBaseStation.getInstance().getRayConnectionTerminalListener() == null){
            return 0;
        }

        PowerSDKBaseStation.getInstance().getRayConnectionTerminalListener().connectionTerminal(terminalNumber);
        return 0;
    }

    public static int rayPairFishFinderNotify(int state){
        if(PowerSDKBaseStation.getInstance().getRayPairFishFinderListener() == null){
            return 0;
        }

        PowerSDKBaseStation.getInstance().getRayPairFishFinderListener().pairFishFinder(state);
        return 0;
    }

    public static int rayPairRemodeControlNotify(int state){
        if(PowerSDKBaseStation.getInstance().getRayPairRemodeControlListener() == null){
            return 0;
        }

        PowerSDKBaseStation.getInstance().getRayPairRemodeControlListener().pairRemode(state);
        return 0;
    }

    public static int rayRCBatteryNotify(int battery){
        if(PowerSDK.getInstance().getRayRCBatteryNotifyListener() == null){
            return 0;
        }

        PowerSDK.getInstance().getRayRCBatteryNotifyListener().rCBattery(battery);
        return 0;
    }
}
