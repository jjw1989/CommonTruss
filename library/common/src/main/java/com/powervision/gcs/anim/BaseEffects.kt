package com.powervision.gcs.anim

import android.view.animation.*

/**
 * 动画插播器
 * Created by David on 2017/8/1.
 */
object BaseEffects {
    var acceInter: Interpolator = AccelerateInterpolator()
    var deceInter:Interpolator=DecelerateInterpolator()
    var acceToDeceInter=AccelerateDecelerateInterpolator()
    var anticInter=AnticipateInterpolator()
    var overInter=OvershootInterpolator()
    var anticOverInter=AnticipateOvershootInterpolator()
    var bounInter=BounceInterpolator()
    var linearInter=LinearInterpolator()

}