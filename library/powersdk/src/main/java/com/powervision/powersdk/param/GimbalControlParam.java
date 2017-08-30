package com.powervision.powersdk.param;

/**
 * 定义了云台控制的相关参数
 */

public class GimbalControlParam {
    /**
     * 控制云台速度
     */
    public static final int PVSDK_GIMBAL_SPEED = 2;

    /**
     * 控制云台回中
     */
    public static final int PVSDK_GIMBAL_MIDDLE = 4;

    /**
     * 控制云台向下
     */
    public static final int PVSDK_GIMBAL_DOWN = 5;

    public int mount_mode;
    public int stab_roll;
    public int stab_pitch;
    public int stab_yaw;
}
