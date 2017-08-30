package com.powervision.powersdk.param;

/**
 * 模式信息
 */
public class ModeParam {

    /**
     * Default constructor
     */
    public ModeParam() {
    }

    /**
     * 
     */
    public final static int PVSDK_MODE_TYPE_NULL = -1;

    /**
     * 
     */
    public final static int PVSDK_MODE_TYPE_ARM = 0;

    /**
     * 
     */
    public final static int PVSDK_MODE_TYPE_DISARM = 1;

    /**
     * 起飞
     */
    public final static int PVSDK_MODE_TYPE_TAKEOFF = 2;

    /**
     * 跟随
     */
    public final static int PVSDK_MODE_TYPE_FOLLOWME = 3;

    /**
     * 航线飞行
     */
    public final static int PVSDK_MODE_TYPE_AUTOMISSION = 4;

    /**
     * 自动悬停
     */
    public final static int PVSDK_MODE_TYPE_AUTOLOITER = 5;

    /**
     * 降落
     */
    public final static int PVSDK_MODE_TYPE_LAND = 6;

    /**
     * 自动返航
     */
    public final static int PVSDK_MODE_TYPE_RTL = 7;

    /**
     * 自动环绕
     */
    public final static int PVSDK_MODE_TYPE_CIRCLE = 8;

    /**
     * 极简模式
     */
    public final static int PVSDK_MODE_TYPE_SUPERSIMPLE = 9;

    /**
     * 手动模式
     */
    public final static int PVSDK_MODE_TYPE_MANUAL = 10;

    /**
     * 定点模式
     */
    public final static int PVSDK_MODE_TYPE_POSCTL = 11;

}