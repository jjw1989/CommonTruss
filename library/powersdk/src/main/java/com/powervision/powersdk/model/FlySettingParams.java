package com.powervision.powersdk.model;

/**
 * Created by nemo on 2017/2/23.
 * <p>
 * 飞行参数设置指令列表
 */

public class FlySettingParams {

    /**
     * 电量阀值
     */
    public static final String PV_BAT_CRITICAL = "PV_BAT_CRITICAL";
    /**
     * 禁飞区限制
     */
    public static final String RC_TRAN_USED = "RC_TRAN_USED";
    /**
     * 限制飞行高度
     */
    public static final String GF_MAX_VER_DIST = "GF_MAX_VER_DIST";
    /**
     * 新手模式
     */
    public static final String NEW_USER = "NEW_USER";
    /**
     * EXP相关
     */
    public static final String PV_RC_HTR_EXP = "PV_RC_HTR_EXP";
    public static final String PV_RC_YAW_EXP = "PV_RC_YAW_EXP";
    public static final String PV_RC_PITCH_EXP = "PV_RC_PITCH_EXP";
    public static final String PV_RC_ROLL_EXP = "PV_RC_ROLL_EXP";
    public static final String PV_RC_TG_EXP = "PV_RC_TG_EXP";

    /**
     * 激活相关
     */
    public static final String PV_V_KEY_FLAG = "PV_V_KEY_FLAG";//激活状态
    public static final String PV_RO_KEY_ = "PV_RO_KEY_"; // 激活码指令
    public static final String PV_RO_PSN_ = "PV_RO_PSN_"; // 飞机唯一标示码
    public static final String PV_V_SON_VER = "PV_V_SON_VER"; //飞机超声版本号
    public static final String PV_V_FLOW_VER = "PV_V_FLOW_VER";// 飞机光流版本号
}
