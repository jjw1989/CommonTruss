package com.powervision.powersdk.model;

/**
 * Created by Sundy on 2017/3/13.
 */

public enum CameraType {
    onCameraExists(1),
    onCameraRecStopEnd(2),
    onCameraRecRecing(3),
    onCameraRecStartError(4),
    onCameraRecStopError(5),
    onCameraRecMode(6),
    onCameraRecModeError(7),
    onCameraStillCaptureEnd(8),
    onCameraStillCaptureing(9),
    onCameraStillCaptureError(10),
    onCameraStillCaptureMode(11),
    onCameraStillCaptureModeError(12),
    onCameraFormatSDSuccess(13),
    onCameraFormatSDFailed(14),
    onCameraResetToCameraFactorySuccess(15),
    onCameraResetToCameraFactoryFailed(16),
    onCameraRecSettingSuccess(17),
    onCameraRecSettingFailed(18),
    onCameraCaptureSettingSuccess(19),
    onCameraCaptureSettingFailed(20),
    onCameraPictureSettingSuccess(21),
    onCameraPictureSettingFailed(22),
    onCameraCameraFeedBackTimeout(23),
    /////////////////////////////////
    onCameraParamSetSuccess(24),
    onCameraParamSetTimeout(25),
    onCameraParamGetSuccess(26),
    onCameraParamGetTimeout(27);
    private int cmdType;

    CameraType(int cmdType) {
        this.cmdType = cmdType;
    }
}
