package com.powervision.powersdk.param;

/**
 * 飞行日志开始参数
 */
public class FlightRecordStartParam {

    /**
     * Default constructor
     */
    public FlightRecordStartParam() {
    }

    /**
     * 飞行记录类型 0为json
     */
    public int type;

    /**
     * 全路径文件名，SDK会在后面插入当前时间作为文件唯一标识
     */
    public String fileNameWithPath;

}