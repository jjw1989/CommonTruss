package com.powervision.powersdk.base;

import android.util.Log;

import com.powervision.powersdk.callback.CameraCallback;
import com.powervision.powersdk.callback.FlyTimeInterface;
import com.powervision.powersdk.model.CameraType;

/**
 * 相机基类
 * Created by Sundy on 2017/3/13.
 */

public abstract class CameraBase implements CameraCallback.CameraParamListener, CameraCallback.CameraListener {
    private InterCameraListener interCameraListener;
    private InterCameraParamsListener interCameraParamsListener;
    private EyePListener eyePListener;
    public  void setEyePListener(EyePListener eyePListener){
        this.eyePListener = eyePListener;
    }

    public void setInterCameraListener(InterCameraListener interCameraListener) {
        this.interCameraListener = interCameraListener;
    }

    public void setInterCameraParamsListener(InterCameraParamsListener interCameraParamsListener) {
        this.interCameraParamsListener = interCameraParamsListener;
    }

    /**
     * 判断相机是否存在
     */
    @Override
    public void onCameraExists() {

    }

    @Override
    public void onCameraRecStopEnd() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraRecStopEnd);
        }
    }

    @Override
    public void onCameraRecRecing() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraRecRecing);
        }
    }

    @Override
    public void onCameraRecStartError() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraRecStartError);
        }
    }

    @Override
    public void onCameraRecStopError() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraRecStopError);
        }
    }

    /**
     * 切换录像模式成功
     */
    @Override
    public void onCameraRecMode() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraRecMode);
        }
    }

    @Override
    public void onCameraRecModeError() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraRecModeError);
        }
    }

    @Override
    public void onCameraStillCaptureEnd() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraStillCaptureEnd);
        }
    }

    @Override
    public void onCameraStillCaptureing() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraStillCaptureing);
        }
    }

    @Override
    public void onCameraStillCaptureError() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraStillCaptureing);
        }
    }

    /**
     * 切换拍照模式成功
     */
    @Override
    public void onCameraStillCaptureMode() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraStillCaptureMode);
        }
    }

    @Override
    public void onCameraStillCaptureModeError() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraStillCaptureModeError);
        }
    }

    @Override
    public void onCameraFormatSDSuccess() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraFormatSDSuccess);
        }
    }

    @Override
    public void onCameraFormatSDFailed() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraFormatSDFailed);
        }
    }

    @Override
    public void onCameraResetToCameraFactorySuccess() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraResetToCameraFactorySuccess);
        }
    }

    @Override
    public void onCameraResetToCameraFactoryFailed() {
        if (interCameraListener != null) {
            interCameraListener.onCameraCallBack(CameraType.onCameraResetToCameraFactoryFailed);
        }
    }

    @Override
    public void onCameraRecSettingSuccess() {

    }

    @Override
    public void onCameraRecSettingFailed() {

    }

    @Override
    public void onCameraCaptureSettingSuccess() {

    }

    @Override
    public void onCameraCaptureSettingFailed() {

    }

    @Override
    public void onCameraPictureSettingSuccess() {

    }

    @Override
    public void onCameraPictureSettingFailed() {

    }

    @Override
    public void onCameraCameraFeedBackTimeout() {

    }

    @Override
    public void onCameraParamSetSuccess(String paramId) {
        Log.w("lzqca","set");
        if (interCameraParamsListener != null) {
            interCameraParamsListener.onCameraCallBack(CameraType.onCameraParamSetSuccess, paramId);
        }
        if (eyePListener != null){
            eyePListener.setSuccess(paramId);
        }
    }

    @Override
    public void onCameraParamSetTimeout(String paramId) {
        if (interCameraParamsListener != null) {
            interCameraParamsListener.onCameraCallBack(CameraType.onCameraParamSetTimeout, paramId);
        }
    }

    @Override
    public void onCameraParamGetSuccess(String paramId) {
        Log.w("lzqca","      get");
        if (interCameraParamsListener != null) {
            interCameraParamsListener.onCameraCallBack(CameraType.onCameraParamGetSuccess, paramId);
        }
        if (eyePListener != null){
            eyePListener.getSuccess(paramId);
        }

    }

    @Override
    public void onCameraParamGetTimeout(String paramId) {
        if (interCameraParamsListener != null) {
            interCameraParamsListener.onCameraCallBack(CameraType.onCameraParamGetTimeout, paramId);
        }
    }

    public interface InterCameraListener {
        public void onCameraCallBack(CameraType model);
    }

    public interface InterCameraParamsListener {
        public void onCameraCallBack(CameraType model, String paramId);
    }
}

