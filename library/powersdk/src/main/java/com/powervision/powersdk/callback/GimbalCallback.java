package com.powervision.powersdk.callback;

/**
 * 云台相关回调
 */
public class GimbalCallback {

    /**
     * Default constructor
     */
    public GimbalCallback() {
    }



    /**
     * 云台设置，获取参数回调
     */
    public interface GimbalParamListener {



        /**
         * @param paramID 
         * @return
         */
        public void onGimbalParamsSetSuccess(String paramID);

        /**
         * @param paramID 
         * @return
         */
        public void onGimbalParamsSetTimeout(String paramID);

        /**
         * @param paramID 
         * @return
         */
        public void onGimbalParamsGetSuccess(String paramID);

        /**
         * @param paramID 
         * @return
         */
        public void onGimbalParamsGetTimeout(String paramID);

    }

    /**
     * 感度类型回调
     */
    public interface RequestOperationalSensitivityListener {

        /**
         * 
         */
        public static final int PVSDK_OPERATIONALSENSITIVITYCONFIG_INFO_PITCH = 0;

        /**
         * 
         */
        public static final int PVSDK_OPERATIONALSENSITIVITYCONFIG_INFO_ROLL = 1;



        /**
         * 俯仰
         *
         * @param param 
         * @return
         */
        public void onOperationalsenSitivityConfigPitch(float param);

        /**
         * 横滚
         *
         * @param param 
         * @return
         */
        public void onOperationalsenSitivityConfigRoll(float param);

    }

}