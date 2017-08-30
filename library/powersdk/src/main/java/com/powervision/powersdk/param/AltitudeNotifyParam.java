package com.powervision.powersdk.param;

/**
 * 收到的关于高度的信息时产生回调的参数
 */

public class AltitudeNotifyParam {
    public long time_usec;//unsigned long
    public float altitude_monotonic;
    public float altitude_amsl; ///< 此时的深度
    public float altitude_local;
    public float altitude_relative;
    public float altitude_terrain;
    public float bottom_clearance;
}
