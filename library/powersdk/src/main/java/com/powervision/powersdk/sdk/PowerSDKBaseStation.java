package com.powervision.powersdk.sdk;

import com.powervision.powersdk.callback.BaseStationCallback;
import com.powervision.powersdk.jni.JniNatives;

/**
 * 基站相关api
 */

public class PowerSDKBaseStation {
    public PowerSDKBaseStation(){

    }

    private static final PowerSDKBaseStation powerSDKBaseStation = new PowerSDKBaseStation();

    public static synchronized PowerSDKBaseStation getInstance(){
        return powerSDKBaseStation;
    }

    /**
     * 设置回调函数
     * */
    public void setCallBack(){
        JniNatives.setCallBack();
    }

    /**
     * 获取天空端连接状态
     * */
    public boolean isGroundConnected(){
        return JniNatives.isGroundConnected();
    }

    /**
     * 获取地面端连接状态
     * */
    public boolean isAirConnected(){
        return JniNatives.isAirConnected();
    }

    /**
     * 带超时连接地面端
     * */
    public void tryConnectGroundWithTimeout(long timeout){
        JniNatives.tryConnectGroundWithTimeout(timeout);
    }

    /**
     * 断开地面端连接
     * */
    public boolean disconnectWithGround(){
        return JniNatives.disconnectWithGround();
    }

    /**
     * 获取Ap的SSID
     * */
    public boolean getApSSID(){
        return JniNatives.getApSSID();
    }

    /**
     * 获取Ap的密码
     * */
    public boolean getApPassword(){
        return JniNatives.getApPassword();
    }

    /**
     * 设置Ap的SSID
     * */
    public boolean setApSSID(String ssid){
        return JniNatives.setApSSID(ssid);
    }

    /**
     * 设置Ap的密码
     * */
    public boolean setApPassword(String password){
        return JniNatives.setApPassword(password);
    }

    /**
     * 接受Ap的配置
     * */
    public boolean applyApConfig(){
        return JniNatives.applyApConfig();
    }

    /**
     * 获取Ap的连接状态
     * */
    public boolean getApConnectStatus(){
        return JniNatives.getApConnectStatus();
    }

    /**
     * 获取地面端国家码
     * */
    public boolean getGroundCountryCode(){
        return JniNatives.getGroundCountryCode();
    }

    /**
     * 获取地面端Model码
     * */
    public boolean getGroundModel(){
        return JniNatives.getGroundModel();
    }

    /**
     * 获取地面端SN码
     * */
    public boolean getGroundSN(){
        return JniNatives.getGroundSN();
    }

    /**
     * 获取地面端主控硬件版本号
     * */
    public boolean getGroundMainCtrlHWVersion(){
        return JniNatives.getGroundMainCtrlHWVersion();
    }

    /**
     * 获取地面端主控软件版本号
     * */
    public boolean getGroundMainCtrlSWVersion(){
        return JniNatives.getGroundMainCtrlSWVersion();
    }

    /**
     * 设置寻鱼器的ssid
     * */
    public int setFishFinderSsid(String pairIp, int pairPort, String ssid){
        return JniNatives.setFishFinderSsid(pairIp, pairPort, ssid);
    }

    /**
     * 遥控器配对
     * */
    public int pairRemodeControl(String pairIp, int pairPort, String ssid){
        return JniNatives.pairRemodeControl(pairIp, pairPort, ssid);
    }

    /**
     *
     * */
    public boolean getGroundRFHWVersion(){
        return JniNatives.getGroundRFHWVersion();
    }

    public boolean getGroundRFSWVersion(){
        return JniNatives.getGroundRFSWVersion();
    }

    public boolean getGroundRFSignalQuality(){
        return JniNatives.getGroundRFSignalQuality();
    }

    public boolean getGroundBatteryPower(){
        return JniNatives.getGroundBatteryPower();
    }

    public boolean resetGroundRF(){
        return JniNatives.resetGroundRF();
    }

    public boolean rebootGroundRF(){
        return JniNatives.rebootGroundRF();
    }

    public boolean applyGroundRFConfig(){
        return JniNatives.applyGroundRFConfig();
    }

    public void tryConnectAirWithTimeout(long timeout){
        JniNatives.tryConnectAirWithTimeout(timeout);
    }

    public boolean disconnectWithAir(){
        return JniNatives.disconnectWithAir();
    }

    public boolean getAirModel(){
        return JniNatives.getAirModel();
    }

    public boolean getAirSN(){
        return JniNatives.getAirSN();
    }

    public boolean getAirMainCtrlHWVersion(){
        return JniNatives.getAirMainCtrlHWVersion();
    }

    public boolean getAirMainCtrlSWVersion(){
        return JniNatives.getAirMainCtrlSWVersion();
    }

    public boolean getAirRFHWVersion(){
        return JniNatives.getAirRFHWVersion();
    }

    public boolean getAirRFSWVersion(){
        return JniNatives.getAirRFSWVersion();
    }

    public boolean getAirRFSignalQuality(){
        return JniNatives.getAirRFSignalQuality();
    }

    public boolean resetAirRF(){
        return JniNatives.resetAirRF();
    }

    public boolean rebootAirRF(){
        return JniNatives.rebootAirRF();
    }

    public boolean applyAirRFConfig(){
        return JniNatives.applyAirRFConfig();
    }

    public boolean pairRF(){
        return JniNatives.pairRF();
    }

    public boolean getRFChannel(){
        return JniNatives.getRFChannel();
    }

    public boolean setRFChannel(int channel){
        return JniNatives.setRFChannel(channel);
    }

    public boolean getRFTxPower(){
        return JniNatives.getRFTxPower();
    }

    public boolean setRFTxPower(int txPower){
        return JniNatives.setRFTxPower(txPower);
    }

    public boolean applyRFConfig(){
        return JniNatives.applyRFConfig();
    }

    public boolean getVideoResolution(){
        return JniNatives.getVideoResolution();
    }

    public boolean setVideoResolution(int resolution){
        return JniNatives.setVideoResolution(resolution);
    }

    public boolean getVideoRate(){
        return JniNatives.getVideoRate();
    }

    public boolean setVideoRate(int rate){
        return JniNatives.setVideoRate(rate);
    }

    private BaseStationCallback.DisconnectToGroundListener disconnectToGroundListener;
    private BaseStationCallback.DisconnectToAirListener disconnectToAirListener;
    private BaseStationCallback.IsPvLinkListener isPvLinkListener;
    private BaseStationCallback.GetApSSIDListener getApSSIDListener;
    private BaseStationCallback.SetApSSIDListener setApSSIDListener;
    private BaseStationCallback.GetApPasswordListener getApPasswordListener;
    private BaseStationCallback.ApplyApConfigListener applyApConfigListener;
    private BaseStationCallback.GetApConnectStatusListener getApConnectStatusListener;

    private BaseStationCallback.GetGroundChannelListener getGroundChannelListener;
    private BaseStationCallback.SetGroundChannelListener setGroundChannelListener;
    private BaseStationCallback.GetGroundTxPowerListener getGroundTxPowerListener;
    private BaseStationCallback.SetGroundTxPowerListener setGroundTxPowerListener;
    private BaseStationCallback.GetGroundCountryCodeListener getGroundCountryCodeListener;
    private BaseStationCallback.GetGroundModelListener getGroundModelListener;
    private BaseStationCallback.GetGroundSNListener getGroundSNListener;
    private BaseStationCallback.GetGroundMainCtrlHWVersionListener getGroundMainCtrlHWVersionListener;
    private BaseStationCallback.GetGroundMainCtrlSWVersionListener getGroundMainCtrlSWVersionListener;
    private BaseStationCallback.GetGroundRFHWVersionListener getGroundRFHWVersionListener;
    private BaseStationCallback.GetGroundRFSWVersionListener getGroundRFSWVersionListener;
    private BaseStationCallback.GetGroundRFSignalQualityListener getGroundRFSignalQualityListener;
    private BaseStationCallback.GetGroundBatteryPowerListener getGroundBatteryPowerListener;
    private BaseStationCallback.ResetGroundRFListener resetGroundRFListener;
    private BaseStationCallback.RebootGroundRFListener rebootGroundRFListener;
    private BaseStationCallback.ApplyGroundRFConfigListener applyGroundRFConfigListener;

    private BaseStationCallback.GetAirChannelListener getAirChannelListener;
    private BaseStationCallback.SetAirChannelListener setAirChannelListener;
    private BaseStationCallback.GetAirTxPowerListener getAirTxPowerListener;
    private BaseStationCallback.SetAirTxPowerListener setAirTxPowerListener;

    public BaseStationCallback.DisconnectToGroundListener getDisconnectToGroundListener() {
        return disconnectToGroundListener;
    }

    public void setDisconnectToGroundListener(BaseStationCallback.DisconnectToGroundListener disconnectToGroundListener) {
        this.disconnectToGroundListener = disconnectToGroundListener;
    }

    public BaseStationCallback.DisconnectToAirListener getDisconnectToAirListener() {
        return disconnectToAirListener;
    }

    public void setDisconnectToAirListener(BaseStationCallback.DisconnectToAirListener disconnectToAirListener) {
        this.disconnectToAirListener = disconnectToAirListener;
    }

    public BaseStationCallback.IsPvLinkListener getIsPvLinkListener() {
        return isPvLinkListener;
    }

    public void setIsPvLinkListener(BaseStationCallback.IsPvLinkListener isPvLinkListener) {
        this.isPvLinkListener = isPvLinkListener;
    }

    public BaseStationCallback.GetGroundChannelListener getGetGroundChannelListener() {
        return getGroundChannelListener;
    }

    public void setGetGroundChannelListener(BaseStationCallback.GetGroundChannelListener getGroundChannelListener) {
        this.getGroundChannelListener = getGroundChannelListener;
    }

    public BaseStationCallback.SetGroundChannelListener getSetGroundChannelListener() {
        return setGroundChannelListener;
    }

    public void setSetGroundChannelListener(BaseStationCallback.SetGroundChannelListener setGroundChannelListener) {
        this.setGroundChannelListener = setGroundChannelListener;
    }

    public BaseStationCallback.GetGroundTxPowerListener getGetGroundTxPowerListener() {
        return getGroundTxPowerListener;
    }

    public void setGetGroundTxPowerListener(BaseStationCallback.GetGroundTxPowerListener getGroundTxPowerListener) {
        this.getGroundTxPowerListener = getGroundTxPowerListener;
    }

    public BaseStationCallback.SetGroundTxPowerListener getSetGroundTxPowerListener() {
        return setGroundTxPowerListener;
    }

    public void setSetGroundTxPowerListener(BaseStationCallback.SetGroundTxPowerListener setGroundTxPowerListener) {
        this.setGroundTxPowerListener = setGroundTxPowerListener;
    }

    public BaseStationCallback.GetAirChannelListener getGetAirChannelListener() {
        return getAirChannelListener;
    }

    public void setGetAirChannelListener(BaseStationCallback.GetAirChannelListener getAirChannelListener) {
        this.getAirChannelListener = getAirChannelListener;
    }

    public BaseStationCallback.SetAirChannelListener getSetAirChannelListener() {
        return setAirChannelListener;
    }

    public void setSetAirChannelListener(BaseStationCallback.SetAirChannelListener setAirChannelListener) {
        this.setAirChannelListener = setAirChannelListener;
    }

    public BaseStationCallback.GetAirTxPowerListener getGetAirTxPowerListener() {
        return getAirTxPowerListener;
    }

    public void setGetAirTxPowerListener(BaseStationCallback.GetAirTxPowerListener getAirTxPowerListener) {
        this.getAirTxPowerListener = getAirTxPowerListener;
    }

    public BaseStationCallback.SetAirTxPowerListener getSetAirTxPowerListener() {
        return setAirTxPowerListener;
    }

    public void setSetAirTxPowerListener(BaseStationCallback.SetAirTxPowerListener setAirTxPowerListener) {
        this.setAirTxPowerListener = setAirTxPowerListener;
    }

    public BaseStationCallback.GetAirCountryCodeListener getGetAirCountryCodeListener() {
        return getAirCountryCodeListener;
    }

    public void setGetAirCountryCodeListener(BaseStationCallback.GetAirCountryCodeListener getAirCountryCodeListener) {
        this.getAirCountryCodeListener = getAirCountryCodeListener;
    }

    private BaseStationCallback.GetAirCountryCodeListener getAirCountryCodeListener;
    private BaseStationCallback.GetAirModelListener getAirModelListener;
    private BaseStationCallback.GetAirSNListener getAirSNListener;
    private BaseStationCallback.GetAirMainCtrlHWVersionListener getAirMainCtrlHWVersionListener;
    private BaseStationCallback.GetAirMainCtrlSWVersionListener getAirMainCtrlSWVersionListener;
    private BaseStationCallback.GetAirRFHWVersionListener getAirRFHWVersionListener;
    private BaseStationCallback.GetAirRFSWVersionListener getAirRFSWVersionListener;
    private BaseStationCallback.GetAirRFSignalQualityListener getAirRFSignalQualityListener;
    private BaseStationCallback.ResetAirRFListener resetAirRFListener;
    private BaseStationCallback.RebootAirRFListener rebootAirRFListener;
    private BaseStationCallback.ApplyAirRFConfigListener applyAirRFConfigListener;
    private BaseStationCallback.PairRFListener pairRFListener;
    private BaseStationCallback.GetRFChannelListener getRFChannelListener;
    private BaseStationCallback.SetRFChannelListener setRFChannelListener;
    private BaseStationCallback.GetRFTxPowerListener getRFTxPowerListener;
    private BaseStationCallback.SetRFTxPowerListener setRFTxPowerListener;
    private BaseStationCallback.ApplyRFConfigListener applyRFConfigListener;
    private BaseStationCallback.GetVideoResolutionListener getVideoResolutionListener;
    private BaseStationCallback.SetVideoResolutionListener setVideoResolutionListener;
    private BaseStationCallback.GetVideoRateListener getVideoRateListener;
    private BaseStationCallback.SetVideoRateListener setVideoRateListener;
    private BaseStationCallback.RayBaseStationVerListener rayBaseStationVerListener;
    private BaseStationCallback.RayConnectionTerminalListener rayConnectionTerminalListener;
    private BaseStationCallback.RayPairFishFinderListener rayPairFishFinderListener;
    private BaseStationCallback.RayPairRemodeControlListener rayPairRemodeControlListener;

    public BaseStationCallback.RayPairRemodeControlListener getRayPairRemodeControlListener() {
        return rayPairRemodeControlListener;
    }

    public void setRayPairRemodeControlListener(BaseStationCallback.RayPairRemodeControlListener rayPairRemodeControlListener) {
        this.rayPairRemodeControlListener = rayPairRemodeControlListener;
    }

    public BaseStationCallback.RayPairFishFinderListener getRayPairFishFinderListener() {
        return rayPairFishFinderListener;
    }

    public void setRayPairFishFinderListener(BaseStationCallback.RayPairFishFinderListener rayPairFishFinderListener) {
        this.rayPairFishFinderListener = rayPairFishFinderListener;
    }

    public BaseStationCallback.RayConnectionTerminalListener getRayConnectionTerminalListener() {
        return rayConnectionTerminalListener;
    }

    public void setRayConnectionTerminalListener(BaseStationCallback.RayConnectionTerminalListener rayConnectionTerminalListener) {
        this.rayConnectionTerminalListener = rayConnectionTerminalListener;
    }

    public BaseStationCallback.RayBaseStationVerListener getRayBaseStationVerListener() {
        return rayBaseStationVerListener;
    }

    public void setRayBaseStationVerListener(BaseStationCallback.RayBaseStationVerListener rayBaseStationVerListener) {
        this.rayBaseStationVerListener = rayBaseStationVerListener;
    }

    public BaseStationCallback.GetApSSIDListener getGetApSSIDListener() {
        return getApSSIDListener;
    }

    public void setGetApSSIDListener(BaseStationCallback.GetApSSIDListener getApSSIDListener) {
        this.getApSSIDListener = getApSSIDListener;
    }

    public BaseStationCallback.SetApSSIDListener getSetApSSIDListener() {
        return setApSSIDListener;
    }

    public void setSetApSSIDListener(BaseStationCallback.SetApSSIDListener setApSSIDListener) {
        this.setApSSIDListener = setApSSIDListener;
    }

    public BaseStationCallback.GetApPasswordListener getGetApPasswordListener() {
        return getApPasswordListener;
    }

    public void setGetApPasswordListener(BaseStationCallback.GetApPasswordListener getApPasswordListener) {
        this.getApPasswordListener = getApPasswordListener;
    }

    public BaseStationCallback.ApplyApConfigListener getApplyApConfigListener() {
        return applyApConfigListener;
    }

    public void setApplyApConfigListener(BaseStationCallback.ApplyApConfigListener applyApConfigListener) {
        this.applyApConfigListener = applyApConfigListener;
    }

    public BaseStationCallback.GetApConnectStatusListener getGetApConnectStatusListener() {
        return getApConnectStatusListener;
    }

    public void setGetApConnectStatusListener(BaseStationCallback.GetApConnectStatusListener getApConnectStatusListener) {
        this.getApConnectStatusListener = getApConnectStatusListener;
    }

    public BaseStationCallback.GetGroundCountryCodeListener getGetGroundCountryCodeListener() {
        return getGroundCountryCodeListener;
    }

    public void setGetGroundCountryCodeListener(BaseStationCallback.GetGroundCountryCodeListener getGroundCountryCodeListener) {
        this.getGroundCountryCodeListener = getGroundCountryCodeListener;
    }

    public BaseStationCallback.GetGroundModelListener getGetGroundModelListener() {
        return getGroundModelListener;
    }

    public void setGetGroundModelListener(BaseStationCallback.GetGroundModelListener getGroundModelListener) {
        this.getGroundModelListener = getGroundModelListener;
    }

    public BaseStationCallback.GetGroundSNListener getGetGroundSNListener() {
        return getGroundSNListener;
    }

    public void setGetGroundSNListener(BaseStationCallback.GetGroundSNListener getGroundSNListener) {
        this.getGroundSNListener = getGroundSNListener;
    }

    public BaseStationCallback.GetGroundMainCtrlHWVersionListener getGetGroundMainCtrlHWVersionListener() {
        return getGroundMainCtrlHWVersionListener;
    }

    public void setGetGroundMainCtrlHWVersionListener(BaseStationCallback.GetGroundMainCtrlHWVersionListener getGroundMainCtrlHWVersionListener) {
        this.getGroundMainCtrlHWVersionListener = getGroundMainCtrlHWVersionListener;
    }

    public BaseStationCallback.GetGroundMainCtrlSWVersionListener getGetGroundMainCtrlSWVersionListener() {
        return getGroundMainCtrlSWVersionListener;
    }

    public void setGetGroundMainCtrlSWVersionListener(BaseStationCallback.GetGroundMainCtrlSWVersionListener getGroundMainCtrlSWVersionListener) {
        this.getGroundMainCtrlSWVersionListener = getGroundMainCtrlSWVersionListener;
    }

    public BaseStationCallback.GetGroundRFHWVersionListener getGetGroundRFHWVersionListener() {
        return getGroundRFHWVersionListener;
    }

    public void setGetGroundRFHWVersionListener(BaseStationCallback.GetGroundRFHWVersionListener getGroundRFHWVersionListener) {
        this.getGroundRFHWVersionListener = getGroundRFHWVersionListener;
    }

    public BaseStationCallback.GetGroundRFSWVersionListener getGetGroundRFSWVersionListener() {
        return getGroundRFSWVersionListener;
    }

    public void setGetGroundRFSWVersionListener(BaseStationCallback.GetGroundRFSWVersionListener getGroundRFSWVersionListener) {
        this.getGroundRFSWVersionListener = getGroundRFSWVersionListener;
    }

    public BaseStationCallback.GetGroundRFSignalQualityListener getGetGroundRFSignalQualityListener() {
        return getGroundRFSignalQualityListener;
    }

    public void setGetGroundRFSignalQualityListener(BaseStationCallback.GetGroundRFSignalQualityListener getGroundRFSignalQualityListener) {
        this.getGroundRFSignalQualityListener = getGroundRFSignalQualityListener;
    }

    public BaseStationCallback.GetGroundBatteryPowerListener getGetGroundBatteryPowerListener() {
        return getGroundBatteryPowerListener;
    }

    public void setGetGroundBatteryPowerListener(BaseStationCallback.GetGroundBatteryPowerListener getGroundBatteryPowerListener) {
        this.getGroundBatteryPowerListener = getGroundBatteryPowerListener;
    }

    public BaseStationCallback.ResetGroundRFListener getResetGroundRFListener() {
        return resetGroundRFListener;
    }

    public void setResetGroundRFListener(BaseStationCallback.ResetGroundRFListener resetGroundRFListener) {
        this.resetGroundRFListener = resetGroundRFListener;
    }

    public BaseStationCallback.RebootGroundRFListener getRebootGroundRFListener() {
        return rebootGroundRFListener;
    }

    public void setRebootGroundRFListener(BaseStationCallback.RebootGroundRFListener rebootGroundRFListener) {
        this.rebootGroundRFListener = rebootGroundRFListener;
    }

    public BaseStationCallback.ApplyGroundRFConfigListener getApplyGroundRFConfigListener() {
        return applyGroundRFConfigListener;
    }

    public void setApplyGroundRFConfigListener(BaseStationCallback.ApplyGroundRFConfigListener applyGroundRFConfigListener) {
        this.applyGroundRFConfigListener = applyGroundRFConfigListener;
    }

    public BaseStationCallback.GetAirModelListener getGetAirModelListener() {
        return getAirModelListener;
    }

    public void setGetAirModelListener(BaseStationCallback.GetAirModelListener getAirModelListener) {
        this.getAirModelListener = getAirModelListener;
    }

    public BaseStationCallback.GetAirSNListener getGetAirSNListener() {
        return getAirSNListener;
    }

    public void setGetAirSNListener(BaseStationCallback.GetAirSNListener getAirSNListener) {
        this.getAirSNListener = getAirSNListener;
    }

    public BaseStationCallback.GetAirMainCtrlHWVersionListener getGetAirMainCtrlHWVersionListener() {
        return getAirMainCtrlHWVersionListener;
    }

    public void setGetAirMainCtrlHWVersionListener(BaseStationCallback.GetAirMainCtrlHWVersionListener getAirMainCtrlHWVersionListener) {
        this.getAirMainCtrlHWVersionListener = getAirMainCtrlHWVersionListener;
    }

    public BaseStationCallback.GetAirMainCtrlSWVersionListener getGetAirMainCtrlSWVersionListener() {
        return getAirMainCtrlSWVersionListener;
    }

    public void setGetAirMainCtrlSWVersionListener(BaseStationCallback.GetAirMainCtrlSWVersionListener getAirMainCtrlSWVersionListener) {
        this.getAirMainCtrlSWVersionListener = getAirMainCtrlSWVersionListener;
    }

    public BaseStationCallback.GetAirRFHWVersionListener getGetAirRFHWVersionListener() {
        return getAirRFHWVersionListener;
    }

    public void setGetAirRFHWVersionListener(BaseStationCallback.GetAirRFHWVersionListener getAirRFHWVersionListener) {
        this.getAirRFHWVersionListener = getAirRFHWVersionListener;
    }

    public BaseStationCallback.GetAirRFSWVersionListener getGetAirRFSWVersionListener() {
        return getAirRFSWVersionListener;
    }

    public void setGetAirRFSWVersionListener(BaseStationCallback.GetAirRFSWVersionListener getAirRFSWVersionListener) {
        this.getAirRFSWVersionListener = getAirRFSWVersionListener;
    }

    public BaseStationCallback.GetAirRFSignalQualityListener getGetAirRFSignalQualityListener() {
        return getAirRFSignalQualityListener;
    }

    public void setGetAirRFSignalQualityListener(BaseStationCallback.GetAirRFSignalQualityListener getAirRFSignalQualityListener) {
        this.getAirRFSignalQualityListener = getAirRFSignalQualityListener;
    }

    public BaseStationCallback.ResetAirRFListener getResetAirRFListener() {
        return resetAirRFListener;
    }

    public void setResetAirRFListener(BaseStationCallback.ResetAirRFListener resetAirRFListener) {
        this.resetAirRFListener = resetAirRFListener;
    }

    public BaseStationCallback.RebootAirRFListener getRebootAirRFListener() {
        return rebootAirRFListener;
    }

    public void setRebootAirRFListener(BaseStationCallback.RebootAirRFListener rebootAirRFListener) {
        this.rebootAirRFListener = rebootAirRFListener;
    }

    public BaseStationCallback.ApplyAirRFConfigListener getApplyAirRFConfigListener() {
        return applyAirRFConfigListener;
    }

    public void setApplyAirRFConfigListener(BaseStationCallback.ApplyAirRFConfigListener applyAirRFConfigListener) {
        this.applyAirRFConfigListener = applyAirRFConfigListener;
    }

    public BaseStationCallback.PairRFListener getPairRFListener() {
        return pairRFListener;
    }

    public void setPairRFListener(BaseStationCallback.PairRFListener pairRFListener) {
        this.pairRFListener = pairRFListener;
    }

    public BaseStationCallback.GetRFChannelListener getGetRFChannelListener() {
        return getRFChannelListener;
    }

    public void setGetRFChannelListener(BaseStationCallback.GetRFChannelListener getRFChannelListener) {
        this.getRFChannelListener = getRFChannelListener;
    }

    public BaseStationCallback.SetRFChannelListener getSetRFChannelListener() {
        return setRFChannelListener;
    }

    public void setSetRFChannelListener(BaseStationCallback.SetRFChannelListener setRFChannelListener) {
        this.setRFChannelListener = setRFChannelListener;
    }

    public BaseStationCallback.GetRFTxPowerListener getGetRFTxPowerListener() {
        return getRFTxPowerListener;
    }

    public void setGetRFTxPowerListener(BaseStationCallback.GetRFTxPowerListener getRFTxPowerListener) {
        this.getRFTxPowerListener = getRFTxPowerListener;
    }

    public BaseStationCallback.SetRFTxPowerListener getSetRFTxPowerListener() {
        return setRFTxPowerListener;
    }

    public void setSetRFTxPowerListener(BaseStationCallback.SetRFTxPowerListener setRFTxPowerListener) {
        this.setRFTxPowerListener = setRFTxPowerListener;
    }

    public BaseStationCallback.ApplyRFConfigListener getApplyRFConfigListener() {
        return applyRFConfigListener;
    }

    public void setApplyRFConfigListener(BaseStationCallback.ApplyRFConfigListener applyRFConfigListener) {
        this.applyRFConfigListener = applyRFConfigListener;
    }

    public BaseStationCallback.GetVideoResolutionListener getGetVideoResolutionListener() {
        return getVideoResolutionListener;
    }

    public void setGetVideoResolutionListener(BaseStationCallback.GetVideoResolutionListener getVideoResolutionListener) {
        this.getVideoResolutionListener = getVideoResolutionListener;
    }

    public BaseStationCallback.SetVideoResolutionListener getSetVideoResolutionListener() {
        return setVideoResolutionListener;
    }

    public void setSetVideoResolutionListener(BaseStationCallback.SetVideoResolutionListener setVideoResolutionListener) {
        this.setVideoResolutionListener = setVideoResolutionListener;
    }

    public BaseStationCallback.GetVideoRateListener getGetVideoRateListener() {
        return getVideoRateListener;
    }

    public void setGetVideoRateListener(BaseStationCallback.GetVideoRateListener getVideoRateListener) {
        this.getVideoRateListener = getVideoRateListener;
    }

    public BaseStationCallback.SetVideoRateListener getSetVideoRateListener() {
        return setVideoRateListener;
    }

    public void setSetVideoRateListener(BaseStationCallback.SetVideoRateListener setVideoRateListener) {
        this.setVideoRateListener = setVideoRateListener;
    }
}
