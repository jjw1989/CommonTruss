package com.powervision.powersdk.callback;

/**
 * 基站相关回调
 */
public class BaseStationCallback {
    public interface DisconnectToGroundListener {
        void onDisconnectToGround();
    }

    public interface DisconnectToAirListener {
        void onDisconnectToAir();
    }

    public interface IsPvLinkListener {
        void onIsPvLink(boolean result);
    }

    public interface GetApSSIDListener {
        void getApSSID(String pssid, boolean result);
    }

    public interface SetApSSIDListener {
        void setApSSID(String pssid, boolean result);
    }

    public interface GetApPasswordListener {
        void getApPassword(String password, boolean result);
    }

    public interface ApplyApConfigListener {
        void applyApConfig(boolean result);
    }

    public interface GetApConnectStatusListener {
        void getApConnectStatus(int status, boolean result);
    }

    public interface GetGroundChannelListener {
        void onGetGroundChannel(int channel, boolean result);
    }

    public interface SetGroundChannelListener {
        void onSetGroundChannel(int channel, boolean result);
    }

    public interface GetGroundTxPowerListener {
        void onGetGroundTxPower(int txPower, boolean result);
    }

    public interface SetGroundTxPowerListener {
        void onSetGroundTxPower(int txPower, boolean result);
    }

    public interface GetGroundCountryCodeListener {
        void getGroundCountryCode(int country_code, boolean result);
    }

    public interface GetGroundModelListener {
        void getGroundModel(String model, boolean result);
    }

    public interface GetGroundSNListener {
        void getGroundSN(String sn, boolean result);
    }

    public interface GetGroundMainCtrlHWVersionListener {
        void getGroundMainCtrlHWVersion(String version, boolean result);
    }

    public interface GetGroundMainCtrlSWVersionListener {
        void getGroundMainCtrlSWVersion(String version, boolean result);
    }

    public interface GetGroundRFHWVersionListener {
        void getGroundRFHWVersion(String version, boolean result);
    }

    public interface GetGroundRFSWVersionListener {
        void getGroundRFSWVersion(String version, boolean result);
    }

    public interface GetGroundRFSignalQualityListener {
        void getGroundRFSignalQuality(int ssid, int snr, int noise, boolean result);
    }

    public interface GetGroundBatteryPowerListener {
        void getGroundBatteryPower(float power, boolean result);
    }

    public interface ResetGroundRFListener {
        void resetGroundRF(boolean result);
    }

    public interface RebootGroundRFListener {
        void rebootGroundRF(boolean result);
    }

    public interface ApplyGroundRFConfigListener {
        void applyGroundRFConfig(boolean result);
    }

    public interface GetAirChannelListener {
        void onGetAirChannel(int channel, boolean result);
    }

    public interface SetAirChannelListener {
        void onSetAirChannel(int channel, boolean result);
    }

    public interface GetAirTxPowerListener {
        void onGetAirTxPower(int txPower, boolean result);
    }

    public interface SetAirTxPowerListener {
        void onSetAirTxPower(int txPower, boolean result);
    }

    public interface GetAirModelListener {
        void getAirModel(String model, boolean result);
    }

    public interface GetAirCountryCodeListener {
        void onGetAirCountryCode(int countryCode, boolean result);
    }

    public interface GetAirSNListener {
        void getAirSN(String sn, boolean result);
    }

    public interface GetAirMainCtrlHWVersionListener {
        void getAirMainCtrlHWVersion(String version, boolean result);
    }

    public interface GetAirMainCtrlSWVersionListener {
        void getAirMainCtrlSWVersion(String version, boolean result);
    }

    public interface GetAirRFHWVersionListener {
        void getAirRFHWVersion(String version, boolean result);
    }

    public interface GetAirRFSWVersionListener {
        void getAirRFSWVersion(String version, boolean result);
    }

    public interface GetAirRFSignalQualityListener {
        void getAirRFSignalQuality(int ssid, int snr, int noise, boolean result);
    }

    public interface ResetAirRFListener {
        void resetAirRF(boolean result);
    }

    public interface RebootAirRFListener {
        void rebootAirRF(boolean result);
    }

    public interface ApplyAirRFConfigListener {
        void applyAirRFConfig(boolean result);
    }

    public interface PairRFListener {
        void pairRF(boolean result);
    }

    public interface GetRFChannelListener {
        void getRFChannel(int channel, boolean result);
    }

    public interface SetRFChannelListener {
        void setRFChannel(int channel, boolean result);
    }

    public interface GetRFTxPowerListener {
        void getRFTxPower(int tx_power, boolean result);
    }

    public interface SetRFTxPowerListener {
        void setRFTxPower(int tx_power, boolean result);
    }

    public interface ApplyRFConfigListener {
        void applyRFConfig(boolean result);
    }

    public interface GetVideoResolutionListener {
        void getVideoResolution(int resolution, boolean result);
    }

    public interface SetVideoResolutionListener {
        void setVideoResolution(int resolution, boolean result);
    }

    public interface GetVideoRateListener {
        void getVideoRate(int rate, boolean result);
    }

    public interface SetVideoRateListener {
        void setVideoRate(int rate, boolean result);
    }

    public interface RayBaseStationVerListener {
        void baseStationVer();
    }

    public interface RayConnectionTerminalListener {
        void connectionTerminal(int terminalNumber);
    }

    public interface RayPairFishFinderListener{
        void pairFishFinder(int state);
    }

    public interface RayPairRemodeControlListener{
        int PVSDK_PAIR_REMODE_CONTROL_STATE_CONNECT_ERROR = 0; //连接失败
        int PVSDK_PAIR_REMODE_CONTROL_STATE_CURRENT_OK = 1; //当前配对的ssid与要配对的ssid相同
        int PVSDK_PAIR_REMODE_CONTROL_STATE_SET_OK = 2; //设置船体ssid成功
        int PVSDK_PAIR_REMODE_CONTROL_STATE_SAVE_OK = 3; //保存船体ssid成功
        int PVSDK_PAIR_REMODE_CONTROL_STATE_SET_FAIL = 4; //设置ssid失败
        int PVSDK_PAIR_REMODE_CONTROL_STATE_CONNECT_BREAK = 5; //链接断开

        void pairRemode(int state);
    }
}
