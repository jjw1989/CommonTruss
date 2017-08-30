package com.powervision.powersdk.interfaces;

/**
 * 外部回调接口
 * Created by Sundy on 2017/1/17.
 */

public interface ConnectionListener {
    /**
     * 链路连接中
     */
    public void onConnecting();

    /**
     * 链路连接成功
     */
    public void onConnectSuccess();

    /**
     * 链路已连接
     */
    public void onDisConnected();

    /**
     * 链路连接超时
     */
    public void onConnectTimeout();

    /**
     * 心跳超时
     */
    public void onHeartbeatTimeout();

    /**
     * 标准遥控器已连接
     */
    public void onConnectedStandardRemotecontrol();

    /**
     * 体感遥控器已连接
     */
    public void onConnectedMotionsensingRemotecontrol();

    /**
     * 链路连接失败
     */
    public void onConnectFailed();

    /**
     * 飞机连接中
     */
    public void onDroneConnecting();

    /**
     * 飞机已连接
     */
    public void onDroneConnected();

    /**
     * 飞机已断开
     */
    public void onDroneDisConnected();

    /**
     * 飞机连接超时
     */
    public void onDroneConnectTimeout();

    /**
     * 飞机连接失败
     */
    public void onDroneConnectFailed();

    /**
     * 水下机器人已连接
     */
    public void onRayConnected();

    /**
     * 心跳恢复
     */
    public void onDroneConnectedReplay();
}
