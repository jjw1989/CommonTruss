package com.powervision.powersdk.callback;

import com.powervision.powersdk.param.DistanceSensorNotifyParam;
import com.powervision.powersdk.param.HomePositionNotifyParam;

/**
 * 返航点相关
 */
public class PositionCallback {

    /**
     * Default constructor
     */
    public PositionCallback() {
    }








    /**
     * 返航点状态
     */
    public interface TakeoffLandListener {

        /**
         * 
         */
        public static final int PVSDK_TAKEOFFLAND_SET_SUCCESS = 0;

        /**
         * 
         */
        public static final int PVSDK_TAKEOFFLAND_RECEIVE_SUCCESS = 1;

        /**
         * 
         */
        public static final int PVSDK_TAKEOFFLAND_SEND_TIMEOUT = 2;

        /**
         * 
         */
        public static final int PVSDK_TAKEOFFLAND_SEND_FAILED = 3;



        /**
         * 设置成功
         */
        public void onTakeoffLandSetSuccess();

        /**
         * 接收成功
         */
        public void onTakeoffLandRecieveSuccess();

        /**
         * 发送超时
         */
        public void onTakeoffLandSendTimeout();

        /**
         * 发送失败
         */
        public void onTakeoffLandSendFailed();

    }

    /**
     * GPSRAWINT信息
     */
    public interface GpsRawIntListener {

        /**
         * 
         */
        public static final int PVSDK_GPSRAWINT_CHANGED = 0;



        /**
         * GpsRawInt参数改变
         */
        public void onGPSRawIntChanged();

    }

    /**
     * 位置状态
     */
    public interface PositionChangedListener {

        /**
         * 
         */
        public static final int PVSDK_POSITION_CHANGED = 0;




        /**
         * 位置状态改变
         */
        public void onPositionChanged();

    }

    /**
     * HOME点通知
     */
    public interface HomePositionListener {



        /**
         * HOME点通知
         *
         * @param position
         */
        public void onHomePosition(HomePositionNotifyParam position);

    }

    /**
     * 姿态和速度改变通知
     */
    public interface AttitudeAndGroundspeedChangedListener {

        /**
         * 
         */
        public static final int PVSDK_ATTITUDEANDGROUNDSPEED_CHANGED = 0;



        /**
         * 收到改变
         */
        public void onAttitudeAndGroundSpeedChanged(int status);

    }

    /**
     * 距离传感器回调
     */
    public interface DistanceSensorListener {



        /**
         * 避障的距离传感器信息时回调
         *
         * @param param
         */
        public void onDistanceSensorDataReceived(DistanceSensorNotifyParam param);

    }

}