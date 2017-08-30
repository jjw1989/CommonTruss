package com.powervision.powersdk.callback;

/**
 * 
 */
public class MissionCallback {

    /**
     * Default constructor
     */
    public MissionCallback() {
    }





    /**
     * 定义了任务回调时的状态
     */
    public interface MissionListener {

        /**
         * 
         */
        public static final int PVSDK_MISSION_SEND_TIMEOUT = -1;

        /**
         * 
         */
        public static final int PVSDK_MISSION_CURRENT = 0;

        /**
         * 
         */
        public static final int PVSDK_MISSION_CLEAR_SUCCESS = 1;

        /**
         * 
         */
        public static final int PVSDK_MISSION_SEND_SUCCESS = 2;

        /**
         * 
         */
        public static final int PVSDK_MISSION_RECEIVE_SUCCESS = 3;

        /**
         * 
         */
        public static final int PVSDK_MISSION_SEND_ERROR = 4;



        /**
         * 发送超时
         *
         */
        public void onMissionSendTimeout();

        /**
         * 当前航点
         *
         */
        public void onMissionCurrent();

        /**
         * 清除成功
         *
         */
        public void onMissionClearSuccess();

        /**
         * 发送成功
         *
         */
        public void onMissionSendSuccess();

        /**
         * 接收成功
         *
         */
        public void onMissionReceiveSuccess();

        /**
         * 发送错误
         *
         */
        public void onMissionSendFailed();

    }

    /**
     * 任务执行回调的状态
     */
    public interface MissionActionListener {

        /**
         * 
         */
        public static final int PVSDK_MISSION_ACTION_UNKNOWN = -2;

        /**
         * 
         */
        public static final int PVSDK_MISSION_ACTION_TIMEOUT = -1;

        /**
         * 
         */
        public static final int PVSDK_MISSION_ACTION_ARM = 0;

        /**
         * 
         */
        public static final int PVSDK_MISSION_ACTION_DISARM = 1;



        /**
         * 任务执行回调的状态未知
         *
         */
        public void onMissionActionUnknown();

        /**
         * 任务执行回调的状态超时
         *
         */
        public void onMissionActionTimeout();

        /**
         * 任务执行回调的状态ARM
         */
        public void onMissionActionArm();

        /**
         * 任务执行回调的状态DISARM
         */
        public void onMissionActionDisarm();

    }

    /**
     *  定义了开始航线飞行的状态
     */
    public interface StartWaypointListener {

        /**
         * 
         */
        public static final int PVSDK_START_WAYPOINT_TIMEOUT = -1;

        /**
         * 
         */
        public static final int PVSDK_START_WAYPOINT_START = 0;

        /**
         * 
         */
        public static final int PVSDK_START_WAYPOINT_STOP = 1;




        /**
         * 开始航线飞行
         */
        public void onWaypointStart();

        /**
         * 航线飞行结束
         */
        public void onWaypointStop();

        /**
         * 航线飞行超时
         */
        public void onWaypointTimeout();

    }

    /**
     * 定义了航线飞行过程中的当前位置状态
     */
    public interface MissionRunListener {

        /**
         * 
         */
        public static final int PVSDK_MISSIONRUN_INFO_CURRENT = 0;

        /**
         * 
         */
        public static final int PVSDK_MISSIONRUN_INFO_REACHED = 1;

        /**
         * 当前航点
         *
         * @param seq
         */
        public void onMissionRunCurrent(int seq);

        /**
         * 到达航点
         *
         * @param seq
         */
        public void onMissionRunReached(int seq);

    }

}