package com.powervision.gcs.sdk;

import android.util.Log;

import com.powervision.powersdk.callback.SystemStatusCallback;
import com.powervision.powersdk.sdk.PowerSDK;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * 连接管理
 * Created by Sundy on 2017/8/31.
 */

public class PVConnManager implements SystemStatusCallback.ConnectionListener{
    /**
     * 飞控主类成员变量
     */
    private PowerSDK mPowerSDK;
    /**
     * 飞控重连
     */
    private Disposable mLoopConnect;
    public PVConnManager(){
        mPowerSDK=PowerSDK.getInstance();
    }

    public void initSDK(final PVConnConfig connConfig){

          mLoopConnect= Observable.interval(0,3000, TimeUnit.MILLISECONDS)
                        .subscribe(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                Log.i("powersdk", "accept: ="+aLong+"ip="+connConfig.getIp());
                                if (mPowerSDK.initSDK(connConfig.getIp(),connConfig.getPort())==0){

                                }
                                if (aLong==3){
                                   // Log.i("powersdk", "accept: ="+aLong);
                                    mLoopConnect.dispose();
                                }
                            }
                        });

    }


    @Override
    public void onConnecting() {

    }

    @Override
    public void onConnectSuccess() {

    }

    @Override
    public void onDisConnected() {

    }

    @Override
    public void onConnectTimeout() {

    }

    @Override
    public void onHeartbeatTimeout() {

    }

    @Override
    public void onConnectedStandardRemotecontrol() {

    }

    @Override
    public void onConnectedMotionsensingRemotecontrol() {

    }

    @Override
    public void onConnectFailed() {

    }

    @Override
    public void onDroneConnecting() {

    }

    @Override
    public void onDroneConnected() {

    }

    @Override
    public void onDroneDisConnected() {

    }

    @Override
    public void onDroneConnectTimeout() {

    }

    @Override
    public void onDroneConnectFailed() {

    }

    @Override
    public void onRayConnected() {

    }

    @Override
    public void onDroneConnectedReplay() {

    }

    @Override
    public void onBaseStationConnFailed() {

    }
}
