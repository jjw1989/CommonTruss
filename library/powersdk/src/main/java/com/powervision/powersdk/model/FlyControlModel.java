package com.powervision.powersdk.model;

/**
 * Created by nemo on 2017/4/21.
 */

public class FlyControlModel {
    public static final int GET_SUCCESS = 0x001;         //遥控器参数获取成功
    public static final int SET_TIMEOUT = 0x002;         //遥控器参数设置超时
    public static final int UPGRADE_SUCCESS = 0x003;     //飞控升级成功
    public static final int UPGRADE_ERROR = 0x004;       //飞控器升级失败
    public static final int UPGRADE_PROGRESS = 0x005;    //飞控器升级进度
}
