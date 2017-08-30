package com.powervision.powersdk.manage;

import com.powervision.powersdk.callback.SystemStatusCallback;
import com.powervision.powersdk.interfaces.SelfChackListener;

/**
 * 自检管理类
 * Created by Sundy on 2017/3/9.
 */

public class SelfCheckManager implements SystemStatusCallback.SelfCheckListener {
    private SelfChackListener listener;

    public void setListener(SelfChackListener listener) {
        this.listener = listener;
    }

    @Override
    public void onSelfCheckSetSuccess(String paramID) {
        listener.onSelfCheckSetSuccess(paramID);
    }

    @Override
    public void onSelfCheckSetTimeout(String paramID) {
        listener.onSelfCheckSetTimeout(paramID);
    }

    @Override
    public void onSelfCheckGetSuccess(String paramID) {
        listener.onSelfCheckGetSuccess(paramID);
    }

    @Override
    public void onSelfCheckGetTimeout(String paramID) {
        listener.onSelfCheckSetTimeout(paramID);
    }
}
