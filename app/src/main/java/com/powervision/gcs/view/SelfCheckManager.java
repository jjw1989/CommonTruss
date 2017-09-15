package com.powervision.gcs.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.powervision.gcs.R;

/**
 * 自检管理
 * Created by David on 2017/9/16.
 */

public class SelfCheckManager {

    public static final String ANIM_DIALOG_TAG = "SelfcheckTag";
    private Activity context;
    private ViewGroup androidContentView;
    private View rootView;

    public SelfCheckManager(Activity context){
        this.context=context;
    }
    /**
     * 显示自检View
     */
    public void showView(){
        androidContentView = (ViewGroup) context.getWindow().getDecorView();
        rootView= LayoutInflater.from(context).inflate(R.layout.pv_selfcheck_layout,null);
        rootView.setTag(ANIM_DIALOG_TAG);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        androidContentView.addView(rootView, params);
    }

    /**
     * 销毁自检view
     */
    public void dismissView(){

    }
}
