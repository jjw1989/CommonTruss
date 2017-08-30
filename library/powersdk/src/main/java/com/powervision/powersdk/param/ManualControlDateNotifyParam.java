package com.powervision.powersdk.param;

/**
 * 遥控器信息数据
 */
public class ManualControlDateNotifyParam {

    /**
     * Default constructor
     */
    public ManualControlDateNotifyParam() {
    }

    /**
     * pitch 前后
     */
    public int x;

    /**
     * roll 左右
     */
    public int y;

    /**
     * 上下
     */
    public int z;

    /**
     * 偏航
     */
    public int r;

    /**
     * 
     */
    public long buttons;

    /**
     * 1 在校准状态
     */
    public int target;

}