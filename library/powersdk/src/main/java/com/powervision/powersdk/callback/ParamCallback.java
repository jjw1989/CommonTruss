package com.powervision.powersdk.callback;

/**
 * 设置、获取参数回调状态
 */
public class ParamCallback {

    /**
     * Default constructor
     */
    public ParamCallback() {
    }


    /**
     * 设置、获取参数回调状态
     */
    public interface ParamSetGetListener {

        /**
         * 
         */
        public static final int PVSDK_PARAMSETGET_INFO_SET_SUCCESS = 0;

        /**
         * 
         */
        public static final int PVSDK_PARAMSETGET_INFO_SET_TIMEOUT = 1;

        /**
         * 
         */
        public static final int PVSDK_PARAMSETGET_INFO_GET_SUCCESS = 2;

        /**
         * 
         */
        public static final int PVSDK_PARAMSETGET_INFO_GET_TIMEOUT = 3;



        /**
         * @param paramID 
         * @return
         */
        public void onParamSetSuccess(String paramID);

        /**
         * @param paramID 
         * @return
         */
        public void onParamSetTimeout(String paramID);

        /**
         * @param paramID 
         * @return
         */
        public void onParamGetSuccess(String paramID);

        /**
         * @param paramID 
         * @return
         */
        public void onParamGetTimeout(String paramID);

    }

}