package com.powervision.powersdk.base;

import com.powervision.powersdk.callback.SystemStatusCallback;
import com.powervision.powersdk.model.ModeModel;

/**
 * Created by lewis on 2017/3/20.
 */

public class ModeChangeBase implements SystemStatusCallback.ModeChangedListener{

    private RCModeChangeListener rcModeChangeListener;

    protected void setRcModeChangeListener(RCModeChangeListener rcModeChangeListener) {
        this.rcModeChangeListener = rcModeChangeListener;
    }

    @Override
    public void onModeChanged() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.ModeChange);
        }
    }

    @Override
    public void onModeChangedManual() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.Manual);
        }
    }

    @Override
    public void onModeChangedAltctl() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.Altctl);
        }
    }

    @Override
    public void onModeChangedPosctl() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.Posctl);
        }
    }

    @Override
    public void onModeChangedAutomission() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.Automission);
        }
    }

    @Override
    public void onModeChangedAutoTakeoff() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.AutoTakeoff);
        }
    }

    @Override
    public void onModeChangedAutoLand() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.AutoLand);
        }
    }

    @Override
    public void onModeChangedAutoRtl() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.AutoRtl);
        }
    }

    @Override
    public void onModeChangedSuperSimple() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.SuperSimple);
        }
    }

    @Override
    public void onModeChangedAutoCircle() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.AutoCircle);
        }
    }

    @Override
    public void onModeChangedFollowme() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.Followme);
        }
    }

    @Override
    public void onModeChangedAutoLoiter() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.AutoLoiter);
        }
    }

    @Override
    public void onModeChangedTimeout() {
        if (rcModeChangeListener != null) {
            rcModeChangeListener.onModeChangeCallback(ModeModel.Timeout);
        }
    }

    public interface RCModeChangeListener{
        public void onModeChangeCallback(int mode);
    }
}
