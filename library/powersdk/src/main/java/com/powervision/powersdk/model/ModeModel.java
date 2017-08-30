package com.powervision.powersdk.model;

/**
 * Created by lewis on 2017/3/20.
 */

public class ModeModel {

    public static final int Manual = 0x001;            //手动模式
    public static final int Altctl = 0x002;            //定高模式
    public static final int Posctl = 0x003;            //定点模式
    public static final int Automission = 0x004;       //航线飞行
    public static final int AutoTakeoff = 0x005;       //自动起飞
    public static final int AutoLand = 0x006;          //自动降落
    public static final int AutoRtl = 0x007;           //自动返航
    public static final int SuperSimple = 0x008;       //极简模式
    public static final int AutoCircle = 0x009;        //环绕模式
    public static final int Followme = 0x010;          //跟随模式
    public static final int AutoLoiter = 0x011;        //悬停模式
    public static final int Timeout = 0x012;           //超时
    public static final int ModeChange = 0x013;        //模式改变
}
