package com.powervision.powersdk.model;

/**
 * Created by lewis on 2017/3/20.
 * 遥控器相关
 */

public class RemoteModel {
    public static final int RC_TYPE_STD = 0x01;            //标准遥控器
    public static final int RC_TYPE_TG = 0x02;             //体感遥控器
    public static final int CONNECT_TIMEOUT = 0x03;        //链路连接成功
    public static final int CONNECT_FAILED = 0x04;         //链路连接失败
    public static final int RC_SET_SUCCESS = 0x05;         //遥控器参数设置成功
    public static final int RC_SET_TIMEOUT = 0x06;         //遥控器参数设置超时
    public static final int RC_GET_SUCCESS = 0x07;         //遥控器参数获取成功
    public static final int RC_GET_TIMEOUT = 0x08;         //遥控器参数获取超时
    public static final int RC_UPGRADE_SUCCESS = 0x09;     //遥控器升级成功
    public static final int RC_UPGRADE_ERROR = 0x10;       //遥控器升级失败
    public static final int RC_UPGRADE_PROGRESS = 0x11;    //遥控器升级进度
}
