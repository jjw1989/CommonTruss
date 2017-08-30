package com.powervision.powersdk.param;

/**
 * GPS相关参数
 */

public class GpsRawIntParam {
    public long time_usec; /*< Timestamp (microseconds since UNIX epoch or microseconds since system boot)*/
    public int lat; /*< Latitude (WGS84), in degrees * 1E7*/
    public int lon; /*< Longitude (WGS84), in degrees * 1E7*/
    public int alt; /*< Altitude (AMSL, NOT WGS84), in meters * 1000 (positive for up). Note that virtually all GPS modules provide the AMSL altitude in addition to the WGS84 altitude.*/
    public int eph; /*< GPS HDOP horizontal dilution of position (unitless). If unknown, set to: UINT16_MAX*/
    public int epv; /*< GPS VDOP vertical dilution of position (unitless). If unknown, set to: UINT16_MAX*/
    public int vel; /*< GPS ground speed (m/s * 100). If unknown, set to: UINT16_MAX*/
    public int cog; /*< Course over ground (NOT heading, but direction of movement) in degrees * 100, 0.0..359.99 degrees. If unknown, set to: UINT16_MAX*/
    public int fix_type; /*< 0-1: no fix, 2: 2D fix, 3: 3D fix, 4: DGPS, 5: RTK. Some applications will not use the value of this field unless it is at least two, so always correctly fill in the fix.*/
    public int satellites_visible;
}
