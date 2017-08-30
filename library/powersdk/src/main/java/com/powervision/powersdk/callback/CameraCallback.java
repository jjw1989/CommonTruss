package com.powervision.powersdk.callback;

import com.powervision.powersdk.param.DeviceInfoNotifyParam;

/**
 * 相机回调
 *
 */
public class CameraCallback {

    /**
     * Default constructor
     */
    public CameraCallback() {
    }



    /**
     * 相机拍照/录像相关回调
     */
    public interface CameraListener {

        /**
         * 相机存在
         */
        public static final int PVSDK_CAMERA_EXIST = 0;

        /**
         * 录像停止
         */
        public static final int PVSDK_CAMERA_REC_STOPED = 1;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_REC_RECORDING = 2;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_REC_START_ERROR = 3;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_REC_STOP_ERROR = 4;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_REC_MODE = 5;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_REC_MODE_ERROR = 6;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_STILL_CAPTURE_SUCCESS = 7;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_STILL_CAPTURING = 8;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_STILL_CAPTURE_ERROR = 9;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_STILL_CAPTURE_MODE = 10;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_STILL_CAPTURE_MODE_ERROR = 11;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_FORMAT_SD_SUCCESS = 12;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_FORMAT_SD_FAILED = 13;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_RESET_TO_CAMERA_FACTORY_SUCCESS = 14;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_RESET_TO_CAMERA_FACTORY_FAILED = 15;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_REC_SETTING_SUCCESS = 16;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_REC_SETTING_FAILED = 17;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_CAPTURE_SETTING_SUCCESS = 18;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_CAPTURE_SETTING_FAILED = 19;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_PICTURE_SETTING_SUCCESS = 20;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_PICTURE_SETTING_FAILED = 21;

        /**
         * 
         */
        public static final int PVSDK_CAMERA_CAMERA_FEEDBACK_TIMEOUT = 22;



        /**
         * 判断相机是否存在
         */
        public void onCameraExists();

        /**
         * 录像结束
         */
        public void onCameraRecStopEnd();

        /**
         * 录像中
         */
        public void onCameraRecRecing();

        /**
         * 开始录像错误
         */
        public void onCameraRecStartError();

        /**
         * 结束录像错误
         */
        public void onCameraRecStopError();

        /**
         * 切换录像模式成功
         */
        public void onCameraRecMode();

        /**
         * 换录像模式失败
         */
        public void onCameraRecModeError();

        /**
         * 拍照成功
         */
        public void onCameraStillCaptureEnd();

        /**
         * 拍照中
         */
        public void onCameraStillCaptureing();

        /**
         * 拍照错误
         */
        public void onCameraStillCaptureError();

        /**
         * 切换拍照模式成功
         */
        public void onCameraStillCaptureMode();

        /**
         * 切换拍照模式失败
         */
        public void onCameraStillCaptureModeError();

        /**
         * 格式化sd卡成功
         */
        public void onCameraFormatSDSuccess();

        /**
         * 格式化sd卡失败
         */
        public void onCameraFormatSDFailed();

        /**
         * 相机恢复出厂化设置成功
         */
        public void onCameraResetToCameraFactorySuccess();

        /**
         * 相机恢复出厂化设置失败
         */
        public void onCameraResetToCameraFactoryFailed();

        /**
         * 视频参数设置成功
         */
        public void onCameraRecSettingSuccess();

        /**
         * 视频参数设置失败
         */
        public void onCameraRecSettingFailed();

        /**
         * 拍照参数设置成功
         */
        public void onCameraCaptureSettingSuccess();

        /**
         * 拍照参数设置失败
         */
        public void onCameraCaptureSettingFailed();

        /**
         * 相机照片参数设置成功
         */
        public void onCameraPictureSettingSuccess();

        /**
         * 相机照片参数设置失败
         */
        public void onCameraPictureSettingFailed();

        /**
         * 相机操作超时
         */
        public void onCameraCameraFeedBackTimeout();

    }

    /**
     * 相机参数设置、获取监听器
     */
    public interface CameraParamListener {



        /**
         * 设置相机参数成功
         *
         * @param paramId 相机参数ID
         *
         */
        public void onCameraParamSetSuccess(String paramId);

        /**
         * 设置相机参数超时
         *
         * @param paramId 相机参数ID
         */
        public void onCameraParamSetTimeout(String paramId);

        /**
         * 获取相机参数成功
         *
         * @param paramId 相机参数ID
         */
        public void onCameraParamGetSuccess(String paramId);

        /**
         * 获取相机参数超时
         *
         * @param paramId 相机参数ID
         */
        public void onCameraParamGetTimeout(String paramId);

    }

    /**
     * PowerRay相机连接状态通知
     * */
    public interface PowerRayCameraConnectionListener {
        public static final int PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_CONTROL_CONNECTED = 0;
        public static final int PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_CONTROL_DISCONNECTED = 1;
        public static final int PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_CONTROL_TIMEOUT = 2;
        public static final int PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_CONTROL_FAILED = 3;
        public static final int PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_DATA_CONNECTED = 4;
        public static final int PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_DATA_DISCONNECTED = 5;
        public static final int PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_DATA_TIMEOUT = 6;
        public static final int PVSDK_POWERRAY_CAMERA_CONNECTION_CALLBACK_INFO_DATA_FAILED = 7;

        public void connectionControlConnected();
        public void connectionControlDisconnect();
        public void connectionControlConnectTimeout();
        public void connectionControlConnectFailed();
        public void connectionDataConnected();
        public void connectionDataDisconnect();
        public void connectionDataConnectTimeout();
        public void connectionDataConnectFailed();
    }

    /**
     * 相机开始会话
     * */
    public interface PowerRayCameraStartSessionListener {
        public static final int PVSDK_POWERRAY_CAMERA_STARTSESSION_CALLBACK_INFO_SUCCESS = 0;
        public static final int PVSDK_POWERRAY_CAMERA_STARTSESSION_CALLBACK_INFO_TIMEOUT = 1;
        public static final int PVSDK_POWERRAY_CAMERA_STARTSESSION_CALLBACK_INFO_FAILED = 2;

        public void startSessionSuccess();
        public void startSessionTimeout();
        public void startSessionFailed();
    }

    /**
     * 相机停止会话
     * */
    public interface PowerRayCameraStopSessionListener {
        public static final int PVSDK_POWERRAY_CAMERA_STOPSESSION_CALLBACK_INFO_SUCCESS = 0;
        public static final int PVSDK_POWERRAY_CAMERA_STOPSESSION_CALLBACK_INFO_TIMEOUT = 1;
        public static final int PVSDK_POWERRAY_CAMERA_STOPSESSION_CALLBACK_INFO_FAILED = 2;

        public void startSessionSuccess();
        public void startSessionTimeout();
        public void startSessionFailed();
    }

    /**
     * PowerRay相机预览文件下载回调
     * */
    public interface PowerRayCameraGetPreviewFileListener {
        public void getPreview(int rval, int size, String type, String md5sum);
    }

    /**
     * PowerRay相机文件接收回调
     * */
    public interface PowerRayCameraReceiverDataListener {
        public void receiverData(String buf, int len);
    }

    /**
     * PowerRay列出相机文件回调
     * */
    public interface PowerRayCameraLsFileListener {
        public void lsFile(int rval, String files[]);
    }

    /**
     * PowerRay格式化相机SD卡回调
     * */
    public interface PowerRayCameraFormatListener {
        public void format(int rval);
    }

    /**
     * PowerRay进入相机目录回调
     * */
    public interface PowerRayCameraCdDirectoryListener {
        public void cdDirectory(int rval, String pwd);
    }

    /**
     * PowerRay获取相机文件回调
     * */
    public interface PowerRayCameraGetFileListener {
        public void getFile(int rval, long size, long remSize);
    }

    /**
     * PowerRay获取相机文件完成回调
     * */
    public interface PowerRayCameraGetFileCompleteListener {
        public void getFileComplete(String type, int bytesSent, String md5sum);
    }

    /**
     * PowerRay获取相机文件完成回调
     * */
    public interface PowerRayCameraPutFileCompleteListener {
        public void putFileComplete(String type, long param, String md5sum);
    }

    /**
     * PowerRay上传文件到相机的回调参数
     * */
    public interface PowerRayCameraPutFileListener {
        public void putFile(int rval);
    }

    /**
     * PowerRay获取相机文件完成回调
     * */
    public interface PowerRayCameraFwUpgradeCompleteListener {
        public void fwUpgradeComplete(String type);
    }

    /**
     * PowerRay烧写相机固件的回调
     * */
    public interface PowerRayCameraBurninFwListener {
        public void burninFw(int rval);
    }

    /**
     * PowerRay设置相机客户端信息回调
     * */
    public interface PowerRayCameraSetClientInfoListener {
        public static final int PVSDK_POWERRAY_CAMERA_SET_CLIENT_INFO_CALLBACK_INFO_SUCCESS = 0;
        public static final int PVSDK_POWERRAY_CAMERA_SET_CLIENT_INFO_CALLBACK_INFO_FAILED = 1;

        public void setClientInfoSuccess();
        public void setClientInfoFailed();
    }

    /**
     * PowerRay相机开始录像
     * */
    public interface PowerRayCameraRecordStartListener {
        public static final int PVSDK_POWERRAY_CAMERA_RECORDSTART_CALLBACK_INFO_SUCCESS = 0;
        public static final int PVSDK_POWERRAY_CAMERA_RECORDSTART_CALLBACK_INFO_TIMEOUT = 1;
        public static final int PVSDK_POWERRAY_CAMERA_RECORDSTART_CALLBACK_INFO_FAILED = 2;

        public void recordStartSuccess();
        public void recordStartTimeOut();
        public void recordStartFailed();
    }

    /**
     * PowerRay相机拍照
     * */
    public interface PowerRayCameraTakePhotoListener {
        /**
         * PowerRay相机拍照
         *
         * @param captureMode 拍照模式
         * @param param 若captureMode为“precise quality”，则param为照片路径，否则为空
         * */
        public void takePhoto(int rval, String captureMode, String param);
    }

    /**
     * PowerRay相机停止录像
     * */
    public interface PowerRayCameraRecordStopListener {

        /**
         * 停止录像
         *
         * @param filePath 照片路径
         * */
        public void recordStop(int rval, String filePath);
    }

    /**
     * PowerRay设置相机参数
     * */
    public interface PowerRayCameraSetSettingListener {

        /**
         * 设置相机参数
         *
         * @param type 设置完成的相机参数
         * */
        public void setSetting(int rval, String type);
    }

    /**
     * PowerRay查询相机容量的回调
     * */
    public interface PowerRayCameraGetSpaceListener {

        public void getSpace(int rval, int param);
    }

    /**
     * PowerRay获取相机参数的回调参数
     * */
    public interface PowerRayCameraGetSettingListener {

        public void cameraGetSetting(int rval, String type, String param);
    }

    /**
     * PowerRay获取设备信息的回调
     * */
    public interface PowerRayCameraGetDeviceInfoListener {

        public void getDeviceInfo(DeviceInfoNotifyParam dinp);
    }

    /**
     * PowerRay当失去相机控制权时的回调
     * */
    public interface PowerRayCameraSessionLostListener {

        public void sessionLost();
    }
}
