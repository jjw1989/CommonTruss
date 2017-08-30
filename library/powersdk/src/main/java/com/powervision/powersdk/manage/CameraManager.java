package com.powervision.powersdk.manage;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.powervision.powersdk.PVSdk;
import com.powervision.powersdk.base.CameraBase;
import com.powervision.powersdk.model.CameraParams;
import com.powervision.powersdk.sdk.PowerSDK;

/**
 * 和相机相关回调简单封装
 * Created by Sundy on 2017/3/13.
 */

public class CameraManager extends CameraBase {
    private static CameraManager cameraManager = null;
    private PowerSDK powerSDK;
    private Handler mHandler;
    private int Type;
    private CameraManager() {
        mHandler = new Handler(Looper.getMainLooper());
        powerSDK = PowerSDK.getInstance();
      //  powerSDK.setCameraParamListener(this);
    }

//    public void setCameraListener() {
//        powerSDK.setCameraListener(this);
//    }

    /**
     * 相机回调注册
     *
     * @param listener
     */
    public void cameraCallback(final InterCameraListener listener) {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                setInterCameraListener(listener);
            }
        });
        powerSDK.setCameraListener(this);
    }
    /**
     * 相机参数回调注册
     *
     * @param listener
     */
    public void cameraParamsCallback(final InterCameraParamsListener listener) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                setInterCameraParamsListener(listener);
            }
        });
//        if (Type == 0) {
            powerSDK.setCameraParamListener(this);
//        }
    }

    public PowerSDK getPowerSDK() {
        return powerSDK;
    }

    public static CameraManager getInstance() {
        if (cameraManager == null) {
            cameraManager = new CameraManager();
        }
        return cameraManager;
    }

    /**
     * 请求相机所有参数
     */
    public void requestCameraAllParams() {
            if (PVSdk.instance().isDroneConnectStatus()) {
                powerSDK.requestParameter(CameraParams.PV_CAM_REQ_ALL);
        }
    }
    public void setAirTye(int airType){
        Type = airType;
        if (airType==1){
            powerSDK.setCameraParamListener(this);
        }
    }

    /**
     * 请求相机当前状态
     */
    public void requestCameraCurrentStatus() {
        if (PVSdk.instance().isDroneConnectStatus()) {
            powerSDK.requestParameter(CameraParams.PV_CAM_STAT);
        }
    }

    /**
     * 获取sd卡的剩余容量
     */
    public void requestCameraSdCard(){
        powerSDK.requestParameter(CameraParams.PV_CAM_SD_LEFT);
    }
}

