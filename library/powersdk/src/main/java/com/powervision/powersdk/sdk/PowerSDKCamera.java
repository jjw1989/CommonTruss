package com.powervision.powersdk.sdk;

import com.powervision.powersdk.callback.CameraCallback;
import com.powervision.powersdk.jni.JniNatives;

/**
 * 相机相关接口
 * */
public class PowerSDKCamera {
    public PowerSDKCamera(){

    }

    private static final PowerSDKCamera powerSDKCamera = new PowerSDKCamera();

    public static synchronized PowerSDKCamera getInstance(){
        return powerSDKCamera;
    }

    private CameraCallback.PowerRayCameraConnectionListener powerRayCameraConnectionListener;
    private CameraCallback.PowerRayCameraStartSessionListener powerRayCameraStartSessionListener;
    private CameraCallback.PowerRayCameraStopSessionListener powerRayCameraStopSessionListener;
    private CameraCallback.PowerRayCameraGetPreviewFileListener powerRayCameraGetPreviewFileListener;
    private CameraCallback.PowerRayCameraReceiverDataListener powerRayCameraReceiverDataListener;
    private CameraCallback.PowerRayCameraLsFileListener powerRayCameraLsFileListener;
    private CameraCallback.PowerRayCameraFormatListener powerRayCameraFormatListener;
    private CameraCallback.PowerRayCameraCdDirectoryListener powerRayCameraCdDirectoryListener;
    private CameraCallback.PowerRayCameraGetFileListener powerRayCameraGetFileListener;
    private CameraCallback.PowerRayCameraGetFileCompleteListener powerRayCameraGetFileCompleteListener;
    private CameraCallback.PowerRayCameraPutFileCompleteListener powerRayCameraPutFileCompleteListener;
    private CameraCallback.PowerRayCameraSetClientInfoListener powerRayCameraSetClientInfoListener;
    private CameraCallback.PowerRayCameraRecordStartListener powerRayCameraRecordStartListener;
    private CameraCallback.PowerRayCameraTakePhotoListener powerRayCameraTakePhotoListener;
    private CameraCallback.PowerRayCameraRecordStopListener powerRayCameraRecordStopListener;
    private CameraCallback.PowerRayCameraSetSettingListener powerRayCameraSetSettingListener;
    private CameraCallback.PowerRayCameraGetSpaceListener powerRayCameraGetSpaceListener;
    private CameraCallback.PowerRayCameraGetSettingListener powerRayCameraGetSettingListener;
    private CameraCallback.PowerRayCameraFwUpgradeCompleteListener powerRayCameraFwUpgradeCompleteListener;
    private CameraCallback.PowerRayCameraBurninFwListener powerRayCameraBurninFwNotifyListener;
    private CameraCallback.PowerRayCameraPutFileListener powerRayCameraPutFileListener;
    private CameraCallback.PowerRayCameraGetDeviceInfoListener powerRayCameraGetDeviceInfoListener;
    private CameraCallback.PowerRayCameraSessionLostListener powerRayCameraSessionLostListener;

    public CameraCallback.PowerRayCameraSessionLostListener getPowerRayCameraSessionLostListener() {
        return powerRayCameraSessionLostListener;
    }

    public void setPowerRayCameraSessionLostListener(CameraCallback.PowerRayCameraSessionLostListener powerRayCameraSessionLostListener) {
        this.powerRayCameraSessionLostListener = powerRayCameraSessionLostListener;
    }

    public CameraCallback.PowerRayCameraGetDeviceInfoListener getPowerRayCameraGetDeviceInfoListener() {
        return powerRayCameraGetDeviceInfoListener;
    }

    public void setPowerRayCameraGetDeviceInfoListener(CameraCallback.PowerRayCameraGetDeviceInfoListener powerRayCameraGetDeviceInfoListener) {
        this.powerRayCameraGetDeviceInfoListener = powerRayCameraGetDeviceInfoListener;
    }

    public CameraCallback.PowerRayCameraPutFileListener getPowerRayCameraPutFileListener() {
        return powerRayCameraPutFileListener;
    }

    public void setPowerRayCameraPutFileListener(CameraCallback.PowerRayCameraPutFileListener powerRayCameraPutFileListener) {
        this.powerRayCameraPutFileListener = powerRayCameraPutFileListener;
    }

    public CameraCallback.PowerRayCameraBurninFwListener getPowerRayCameraBurninFwNotifyListener() {
        return powerRayCameraBurninFwNotifyListener;
    }

    public void setPowerRayCameraBurninFwNotifyListener(CameraCallback.PowerRayCameraBurninFwListener powerRayCameraBurninFwNotifyListener) {
        this.powerRayCameraBurninFwNotifyListener = powerRayCameraBurninFwNotifyListener;
    }

    public CameraCallback.PowerRayCameraFwUpgradeCompleteListener getPowerRayCameraFwUpgradeCompleteListener() {
        return powerRayCameraFwUpgradeCompleteListener;
    }

    public void setPowerRayCameraFwUpgradeCompleteListener(CameraCallback.PowerRayCameraFwUpgradeCompleteListener powerRayCameraFwUpgradeCompleteListener) {
        this.powerRayCameraFwUpgradeCompleteListener = powerRayCameraFwUpgradeCompleteListener;
    }

    public CameraCallback.PowerRayCameraPutFileCompleteListener getPowerRayCameraPutFileCompleteListener() {
        return powerRayCameraPutFileCompleteListener;
    }

    public void setPowerRayCameraPutFileCompleteListener(CameraCallback.PowerRayCameraPutFileCompleteListener powerRayCameraPutFileCompleteListener) {
        this.powerRayCameraPutFileCompleteListener = powerRayCameraPutFileCompleteListener;
    }

    public CameraCallback.PowerRayCameraGetSettingListener getPowerRayCameraGetSettingListener() {
        return powerRayCameraGetSettingListener;
    }

    public void setPowerRayCameraGetSettingListener(CameraCallback.PowerRayCameraGetSettingListener powerRayCameraGetSettingListener) {
        this.powerRayCameraGetSettingListener = powerRayCameraGetSettingListener;
    }

    public CameraCallback.PowerRayCameraConnectionListener getPowerRayCameraConnectionListener() {
        return powerRayCameraConnectionListener;
    }

    public void setPowerRayCameraConnectionListener(CameraCallback.PowerRayCameraConnectionListener powerRayCameraConnectionListener) {
        this.powerRayCameraConnectionListener = powerRayCameraConnectionListener;
    }

    public CameraCallback.PowerRayCameraStartSessionListener getPowerRayCameraStartSessionListener() {
        return powerRayCameraStartSessionListener;
    }

    public void setPowerRayCameraStartSessionListener(CameraCallback.PowerRayCameraStartSessionListener powerRayCameraStartSessionListener) {
        this.powerRayCameraStartSessionListener = powerRayCameraStartSessionListener;
    }

    public CameraCallback.PowerRayCameraStopSessionListener getPowerRayCameraStopSessionListener() {
        return powerRayCameraStopSessionListener;
    }

    public void setPowerRayCameraStopSessionListener(CameraCallback.PowerRayCameraStopSessionListener powerRayCameraStopSessionListener) {
        this.powerRayCameraStopSessionListener = powerRayCameraStopSessionListener;
    }

    public CameraCallback.PowerRayCameraGetPreviewFileListener getPowerRayCameraGetPreviewFileListener() {
        return powerRayCameraGetPreviewFileListener;
    }

    public void setPowerRayCameraGetPreviewFileListener(CameraCallback.PowerRayCameraGetPreviewFileListener powerRayCameraGetPreviewFileListener) {
        this.powerRayCameraGetPreviewFileListener = powerRayCameraGetPreviewFileListener;
    }

    public CameraCallback.PowerRayCameraReceiverDataListener getPowerRayCameraReceiverDataListener() {
        return powerRayCameraReceiverDataListener;
    }

    public void setPowerRayCameraReceiverDataListener(CameraCallback.PowerRayCameraReceiverDataListener powerRayCameraReceiverDataListener) {
        this.powerRayCameraReceiverDataListener = powerRayCameraReceiverDataListener;
    }

    public CameraCallback.PowerRayCameraLsFileListener getPowerRayCameraLsFileListener() {
        return powerRayCameraLsFileListener;
    }

    public void setPowerRayCameraLsFileListener(CameraCallback.PowerRayCameraLsFileListener powerRayCameraLsFileListener) {
        this.powerRayCameraLsFileListener = powerRayCameraLsFileListener;
    }

    public CameraCallback.PowerRayCameraFormatListener getPowerRayCameraFormatListener() {
        return powerRayCameraFormatListener;
    }

    public void setPowerRayCameraFormatListener(CameraCallback.PowerRayCameraFormatListener powerRayCameraFormatListener) {
        this.powerRayCameraFormatListener = powerRayCameraFormatListener;
    }

    public CameraCallback.PowerRayCameraCdDirectoryListener getPowerRayCameraCdDirectoryListener() {
        return powerRayCameraCdDirectoryListener;
    }

    public void setPowerRayCameraCdDirectoryListener(CameraCallback.PowerRayCameraCdDirectoryListener powerRayCameraCdDirectoryListener) {
        this.powerRayCameraCdDirectoryListener = powerRayCameraCdDirectoryListener;
    }

    public CameraCallback.PowerRayCameraGetFileListener getPowerRayCameraGetFileListener() {
        return powerRayCameraGetFileListener;
    }

    public void setPowerRayCameraGetFileListener(CameraCallback.PowerRayCameraGetFileListener powerRayCameraGetFileListener) {
        this.powerRayCameraGetFileListener = powerRayCameraGetFileListener;
    }

    public CameraCallback.PowerRayCameraGetFileCompleteListener getPowerRayCameraGetFileCompleteListener() {
        return powerRayCameraGetFileCompleteListener;
    }

    public void setPowerRayCameraGetFileCompleteListener(CameraCallback.PowerRayCameraGetFileCompleteListener powerRayCameraGetFileCompleteListener) {
        this.powerRayCameraGetFileCompleteListener = powerRayCameraGetFileCompleteListener;
    }

    public CameraCallback.PowerRayCameraSetClientInfoListener getPowerRayCameraSetClientInfoListener() {
        return powerRayCameraSetClientInfoListener;
    }

    public void setPowerRayCameraSetClientInfoListener(CameraCallback.PowerRayCameraSetClientInfoListener powerRayCameraSetClientInfoListener) {
        this.powerRayCameraSetClientInfoListener = powerRayCameraSetClientInfoListener;
    }

    public CameraCallback.PowerRayCameraRecordStartListener getPowerRayCameraRecordStartListener() {
        return powerRayCameraRecordStartListener;
    }

    public void setPowerRayCameraRecordStartListener(CameraCallback.PowerRayCameraRecordStartListener powerRayCameraRecordStartListener) {
        this.powerRayCameraRecordStartListener = powerRayCameraRecordStartListener;
    }

    public CameraCallback.PowerRayCameraTakePhotoListener getPowerRayCameraTakePhotoListener() {
        return powerRayCameraTakePhotoListener;
    }

    public void setPowerRayCameraTakePhotoListener(CameraCallback.PowerRayCameraTakePhotoListener powerRayCameraTakePhotoListener) {
        this.powerRayCameraTakePhotoListener = powerRayCameraTakePhotoListener;
    }

    public CameraCallback.PowerRayCameraRecordStopListener getPowerRayCameraRecordStopListener() {
        return powerRayCameraRecordStopListener;
    }

    public void setPowerRayCameraRecordStopListener(CameraCallback.PowerRayCameraRecordStopListener powerRayCameraRecordStopListener) {
        this.powerRayCameraRecordStopListener = powerRayCameraRecordStopListener;
    }

    public CameraCallback.PowerRayCameraSetSettingListener getPowerRayCameraSetSettingListener() {
        return powerRayCameraSetSettingListener;
    }

    public void setPowerRayCameraSetSettingListener(CameraCallback.PowerRayCameraSetSettingListener powerRayCameraSetSettingListener) {
        this.powerRayCameraSetSettingListener = powerRayCameraSetSettingListener;
    }

    public CameraCallback.PowerRayCameraGetSpaceListener getPowerRayCameraGetSpaceListener() {
        return powerRayCameraGetSpaceListener;
    }

    public void setPowerRayCameraGetSpaceListener(CameraCallback.PowerRayCameraGetSpaceListener powerRayCameraGetSpaceListener) {
        this.powerRayCameraGetSpaceListener = powerRayCameraGetSpaceListener;
    }

    /**
     * 打开相机控制链路
     * */
    public int connectControlChannel(){
        return JniNatives.connectControlChannel();
    }

    /**
     * 断开相机控制链路
     * */
    public int disConnectControlChannel(){
        return JniNatives.disConnectControlChannel();
    }

    /**
     * 打开相机数据链路
     * */
    public int connectDataChannel(){
        return JniNatives.connectDataChannel();
    }

    /**
     * 断开相机数据链路
     * */
    public int disConnectDataChannel(){
        return JniNatives.disConnectDataChannel();
    }

    /**
     *  启动相机会话
     * */
    public int startSession(){
        return JniNatives.startSession();
    }

    /**
     * 停止相机会话
     * */
    public int stopSession(){
        return JniNatives.stopSession();
    }

    /**
     * 开始下载预览文件
     * */
    public int getPreviewFileStart(String fileName, int token){
        return JniNatives.getPreviewFileStart(fileName, token);
    }

    /**
     * 停止下载预览文件
     * */
    public int getPreviewFileStop(){
        return JniNatives.getPreviewFileStop();
    }

    /**
     * 列出相机目录文件
     *
     * @param info 参照LsFileParam
     * */
    public int lsFile(int info){
        return JniNatives.lsFile(info);
    }

    /**
     * 格式化相机SD卡
     * */
    public int format(String sd){
        return JniNatives.format(sd);
    }

    /**
     * 进入相机目录
     * */
    public int cdDirectory(String directory){
        return JniNatives.cdDirectory(directory);
    }

    /**
     * 获取相机文件
     * */
    public int getFile(String fileName, int offset, int fetchSize){
        return JniNatives.getFile(fileName, offset, fetchSize);
    }

    /**
     * 设置相机客户端信息
     * */
    public int setClientInfo(int type, String ip){
        return JniNatives.setClientInfo(type, ip);
    }

    /**
     * 设置相机参数
     * */
    public int setSetting(String type, String param, int paramType){
        return JniNatives.setSetting(type, param, paramType);
    }

    /**
     * 启动相机录像
     * */
    public int recordStart(){
        return JniNatives.recordStart();
    }

    /**
     * 停止相机录像
     * */
    public int recordStop(){
        return JniNatives.recordStop();
    }

    /**
     * 启动相机拍照
     * */
    public int takePhoto(){
        return JniNatives.takePhoto();
    }

    /**
     * 设置是否独占相机
     * */
    public int setHoldSessionState(boolean state){
        return JniNatives.setHoldSessionState(state);
    }

    /**
     * 烧写相机固件
     * */
    public int burninFw(String fileFullPath){
        return JniNatives.takePhoto();
    }

    /**
     * 上传文件到相机
     * */
    public int putFile(String fileName, long size, int offset, String md5sum){
        return JniNatives.putFile(fileName, size, offset, md5sum);
    }
}
