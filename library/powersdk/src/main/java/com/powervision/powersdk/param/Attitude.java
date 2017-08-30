package com.powervision.powersdk.param;

/**
 * 姿态参数
 */
public class Attitude {

    /**
     * Default constructor
     */
    public Attitude() {
    }

    /**
     * Timestamp (milliseconds since system boot)
     */
    public long timeBootMs;

    /**
     * Pitch angle (rad, -pi..+pi)
     */
    public float pitch;

    /**
     * Roll angle (rad, -pi..+pi)
     */
    public float roll;

    /**
     * Yaw angle (rad, -pi..+pi)
     */
    public float yaw;

    /**
     * Pitch angular speed (rad/s)
     */
    public float pitchSpeed;

    /**
     * Roll angular speed (rad/s)
     */
    public float rollSpeed;

    /**
     * Yaw angular speed (rad/s)
     */
    public float yawSpeed;

}