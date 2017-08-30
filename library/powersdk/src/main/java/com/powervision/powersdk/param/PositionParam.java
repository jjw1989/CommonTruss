package com.powervision.powersdk.param;

/**
 * 定义了设置水下机器人Ray位置的参数
 */

public class PositionParam {
    /**
     * 右：上下 范围+-1000
     * */
    public int x;
    /**
     * 左：左右 范围+-1000
     * */
    public int y;
    /**
     * 左：上下 范围+-1000
     * */
    public int z;
    /**
     * 右：左右 范围+-1000
     * */
    public int r;

    public int buttons;
}
