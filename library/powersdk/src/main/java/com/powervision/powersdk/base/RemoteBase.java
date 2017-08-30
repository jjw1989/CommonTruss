package com.powervision.powersdk.base;

import com.powervision.powersdk.callback.RemoteControlCallback;
import com.powervision.powersdk.model.RemoteModel;

/**
 * Created by lewis on 2017/3/16.
 * 遥控器基类
 */

public class RemoteBase implements RemoteControlCallback.RemoteControlParamListener {

    private RemoteListener remoteListener;

    protected void setRemoteListener(RemoteListener remoteListener) {
        this.remoteListener = remoteListener;
    }

    @Override
    public void onRemoteControlSetSuccess(String paramID) {
        if (remoteListener != null) {
            remoteListener.remoteCallBack(RemoteModel.RC_SET_SUCCESS, paramID);
        }
    }

    @Override
    public void onRemoteControlSetTimeout(String paramID) {
        if (remoteListener != null) {
            remoteListener.remoteCallBack(RemoteModel.RC_SET_TIMEOUT, paramID);
        }
    }

    @Override
    public void onRemoteControlGetSuccess(String paramID) {
        if (remoteListener != null) {
            remoteListener.remoteCallBack(RemoteModel.RC_GET_SUCCESS, paramID);
        }
    }

    @Override
    public void onRemoteControlGetTimeout(String paramID) {
        if (remoteListener != null) {
            remoteListener.remoteCallBack(RemoteModel.RC_GET_TIMEOUT, paramID);
        }
    }

    public interface RemoteListener {
        void remoteCallBack(int status, String paramID);
    }
}

