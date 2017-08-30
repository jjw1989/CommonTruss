package com.powervision.powersdk.manage;
import android.util.Log;

import com.powervision.powersdk.callback.PositionCallback;
import com.powervision.powersdk.interfaces.SettleChageListener;
import com.powervision.powersdk.param.GpsRawIntParam;
import com.powervision.powersdk.sdk.PowerSDK;

/**
 * Created by ZDY on 2017/5/19.
 */

public class GpsRawIntManager {
    private static  GpsRawIntManager gpsRawIntManager = null;
    private PowerSDK mPowerSdk;
    private GpsRawIntManager(){
        mPowerSdk = PowerSDK.getInstance();
        mPowerSdk.setGpsRawIntListener(listener);


    }
    private SettleChageListener settleChageListener;
    public void setListener(SettleChageListener settleChageListener){
        this.settleChageListener = settleChageListener;
    }

    public static  GpsRawIntManager getInstance(){
        if (gpsRawIntManager == null){
            gpsRawIntManager = new GpsRawIntManager();
        }
        return gpsRawIntManager;
    }
    public int num = -1;
    private PositionCallback.GpsRawIntListener listener = new PositionCallback.GpsRawIntListener() {
        @Override
        public void onGPSRawIntChanged() {
            if (mPowerSdk.getGpsRawIntParam()!= null){
                GpsRawIntParam gp = mPowerSdk.getGpsRawIntParam();
                num = gp.satellites_visible;
            }
            if (settleChageListener!=null&&num!=-1){
                settleChageListener.settleChanged(num);
            }

        }
    };
    public void onDestroy(){
        mPowerSdk.setGpsRawIntListener(null);
        listener = null;
    }

}
