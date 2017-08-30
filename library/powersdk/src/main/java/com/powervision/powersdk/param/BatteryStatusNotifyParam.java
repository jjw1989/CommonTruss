package com.powervision.powersdk.param;

import java.util.Arrays;

/**
 * 电池状态
 */
public class BatteryStatusNotifyParam {

    /**
     * Default constructor
     */
    public BatteryStatusNotifyParam() {
    }

    /**
     * 
     */
    public int [] voltages = new int [10];

    /**
     * Temperature of the battery in centi-degrees celsius. INT16_MAX for unknown temperature
     */
    public int temperature;

    /**
     * Remaining battery energy: (0%: 0, 100%: 100), -1: autopilot does not estimate the remaining battery
     */
    public int battery_remaining;

    @Override
    public String toString() {
        return "BatteryStatusNotifyParam{" +
                "voltages=" + Arrays.toString(voltages) +
                ", temperature=" + temperature +
                ", battery_remaining=" + battery_remaining +
                '}';
    }
}