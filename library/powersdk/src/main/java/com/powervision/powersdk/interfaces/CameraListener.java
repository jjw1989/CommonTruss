package com.powervision.powersdk.interfaces;

/**
 * Created by Sundy on 2017/3/13.
 */

public interface CameraListener {
    /**
     * 判断相机是否存在1
     */
    public void onCameraExists() ;

    /**
     * 录像结束2
     */
    public void onCameraRecStopEnd();

    /**
     * 录像中3
     */
    public void onCameraRecRecing();
    /**
     * 开始录像错误4
     */
    public void onCameraRecStartError() ;

    /**
     * 结束录像错误5
     */
    public void onCameraRecStopError() ;

    /**
     * 切换录像模式成功6
     */
    public void onCameraRecMode() ;

    /**
     * 换录像模式失败7
     */
    public void onCameraRecModeError() ;
    /**
     * 拍照成功8
     */
    public void onCameraStillCaptureEnd() ;

    /**
     * 拍照中9
     */
    public void onCameraStillCaptureing() ;

    /**
     * 拍照错误10
     */
    public void onCameraStillCaptureError() ;
    /**
     * 切换拍照模式成功11
     */
    public void onCameraStillCaptureMode() ;

    /**
     * 切换拍照模式失败12
     */
    public void onCameraStillCaptureModeError();

    /**
     * 格式化sd卡成功13
     */
    public void onCameraFormatSDSuccess() ;

    /**
     * 格式化sd卡失败14
     */
    public void onCameraFormatSDFailed() ;

    /**
     * 相机恢复出厂化设置成功15
     */
    public void onCameraResetToCameraFactorySuccess();

    /**
     * 相机恢复出厂化设置失败16
     */
    public void onCameraResetToCameraFactoryFailed() ;

    /**
     * 视频参数设置成功17
     */
    public void onCameraRecSettingSuccess();

    /**
     * 视频参数设置失败18
     */
    public void onCameraRecSettingFailed() ;

    /**
     * 拍照参数设置成功19
     */
    public void onCameraCaptureSettingSuccess();
    /**
     * 拍照参数设置失败20
     */
    public void onCameraCaptureSettingFailed();


    /**
     * 相机照片参数设置成功21
     */
    public void onCameraPictureSettingSuccess();

    /**
     * 相机照片参数设置失败22
     */
    public void onCameraPictureSettingFailed();

    /**
     * 相机操作超时23
     */
    public void onCameraCameraFeedBackTimeout();
    /**
     * 设置相机参数成功
     *
     * @param paramId 相机参数ID
     *
     */
    public void onCameraParamSetSuccess(String paramId) ;

    /**
     * 设置相机参数超时
     *
     * @param paramId 相机参数ID
     */
    public void onCameraParamSetTimeout(String paramId) ;

    /**
     * 获取相机参数成功
     *
     * @param paramId 相机参数ID
     */
    public void onCameraParamGetSuccess(String paramId);

    /**
     * 获取相机参数超时
     *
     * @param paramId 相机参数ID
     */
    public void onCameraParamGetTimeout(String paramId);
}
