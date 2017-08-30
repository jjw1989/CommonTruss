package com.powervision.powersdk.callback;

/**
 * 传感器回调
 */
public class SensorCallback {

    /**
     * Default constructor
     */
    public SensorCallback() {
    }


    /**
     * 磁力计校准回调
     */
    public interface MagnetometerCalibrateListener {

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_INVALID = 0;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_LEFT_ORIENTATION_DETECTED = 1;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_LEFT_SIDE_DONE = 2;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_RIGHT_ORIENTATION_DETECTED = 3;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_RIGHT_SIDE_DONE = 4;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_UP_ORIENTATION_DETECTED = 5;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_UP_SIDE_DONE = 6;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_DOWN_ORIENTATION_DETECTED = 7;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_DOWN_SIDE_DONE = 8;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_FRONT_ORIENTATION_DETECTED = 9;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_FRONT_SIDE_DONE = 10;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_BACK_ORIENTATION_DETECTED = 11;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_BACK_SIDE_DONE = 12;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_DONE = 13;

        /**
         * 
         */
        public static final int PVSDK_MAGNETOMETERCALIBRATE_INFO_FAILED = 14;



        /**
         *无效
         */
        public void onMagnetometerCalibrateInvalid();

        /**
         * 检测到左侧方向
         */
        public void onMagnetometerCalibrateLeftOrientationDetected();

        /**
         * 左侧方向完成
         */
        public void onMagnetometerCalibrateLeftSideDone();

        /**
         * 检测到右侧方向
         */
        public void onMagnetometerCalibrateRightOrientationDetected();

        /**
         * 右侧方向完成
         */
        public void onMagnetometerCalibrateRightSideDone();

        /**
         * 检测到上侧方向
         */
        public void onMagnetometerCalibrateUpOrientationDetected();

        /**
         * 上侧方向完成
         */
        public void onMagnetometerCalibrateUpSideDone();

        /**
         * 检测到下侧方向
         */
        public void onMagnetometerCalibrateDownOrientationDetected();

        /**
         * 下侧方向完成
         */
        public void onMagnetometerCalibrateDownSideDone();

        /**
         * 检测到前侧方向
         */
        public void onMagnetometerCalibrateFrontOrientationDetected();

        /**
         * 前侧方向完成
         */
        public void onMagnetometerCalibrateFrontSideDone();

        /**
         * 检测到后侧方向
         */
        public void onMagnetometerCalibrateBackOrientationDetected();

        /**
         * 后侧方向完成
         */
        public void onMagnetometerCalibrateBackSideDone();

        /**
         * 校准完成
         */
        public void onMagnetometerCalibrateDone();

        /**
         * 校准失败
         */
        public void onMagnetometerCalibrateFailed();

    }

}