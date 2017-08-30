package com.powervision.powersdk.interfaces;

/**
 * 添加自检回调接口
 * Created by Sundy on 2017/3/9.
 */

public interface SelfChackListener {

    public void onSelfCheckSetSuccess(String paramID);

    public void onSelfCheckSetTimeout(String paramID);

    public void onSelfCheckGetSuccess(String paramID);

    public void onSelfCheckGetTimeout(String paramID);
}
