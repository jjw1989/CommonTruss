package com.powervision.powersdk.param;

/**
 * 定义了遥控器位置的相关参数
 */
public class RemoteControlLocationNotifyParam {

    /**
     * Default constructor
     */
    public RemoteControlLocationNotifyParam() {
    }

    /**
     * 纬度
     */
    public float land_lat;

    /**
     * 经度
     */
    public float land_lon;

    /**
     * 高度
     */
    public float land_alt;

    /**
     * 状态
     */
    public int status;

}