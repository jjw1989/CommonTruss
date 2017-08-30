package com.powervision.powersdk.param;

/**
 * 水下电机相关参数
 */

public class SpeedControlNotifyParam {
    public float voltage; ///< 电机电压
    public float current; ///< 电机电流
    public float phasecurrent; ///< ESC phase current
    public long revocount; ///< 电机旋转总圈数
    public long data1; ///< reserved1
    public long data2; ///< reserved2
    public long data3; ///< reserved3
    public int rxthr; ///< 输入油门
    public int realthr; ///< 输出油门
    public int rpm; ///< 转速
    public int mostemp; ///< 温度
    public int statuscode; ///< 状态码
    public int port; ///< 电机编号
    public int direction; ///< 转向
}
