package com.powervision.gcs.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout

import com.powervision.gcs.R

/**
 * Created by David on 2017/8/31.
 */

class TestView  :  LinearLayout{

    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
     View.inflate(context,R.layout.pv_test,this)
 }


}
