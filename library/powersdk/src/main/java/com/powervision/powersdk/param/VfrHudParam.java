package com.powervision.powersdk.param;

/**
 * 速度,高度,油门等参数
 */

public class VfrHudParam {
    public float airspeed; /*< Current airspeed in m/s*/
    public float groundspeed; /*< Current ground speed in m/s*/
    public float alt; /*< Current altitude (MSL), in meters*/
    public float climb; /*< Current climb rate in meters/second*/
    public int heading; /*< Current heading in degrees, in compass units (0..360, 0=north)*/
    public int throttle; /*< Current throttle setting in integer percent, 0 to 100*/

}
