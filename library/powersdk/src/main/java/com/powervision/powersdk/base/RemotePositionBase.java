package com.powervision.powersdk.base;

import com.powervision.powersdk.callback.RemoteControlCallback;
import com.powervision.powersdk.param.RemoteControlLocationNotifyParam;

/**
 *
 * Created by Sundy on 2017/6/1.
 */

public class RemotePositionBase implements RemoteControlCallback.RemoteControlLocationListener {
    private RemotePositionListener listener;

    public void setListener(RemotePositionListener listener) {
        this.listener = listener;
    }

    @Override
    public void onRemoteControlLocation(RemoteControlLocationNotifyParam param) {
       if(listener!=null){
           listener.onRemotePosition();
       }
    }

    public interface RemotePositionListener{
        public void onRemotePosition();
    }
}
