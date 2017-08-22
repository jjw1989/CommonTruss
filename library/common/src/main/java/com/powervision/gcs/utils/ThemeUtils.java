package com.powervision.gcs.utils;

import android.content.Context;
import android.content.res.TypedArray;

/**
 * author Sundy
 * version 4.0
 * title com.sundy.mainnavigatetabbar
 * description
 * company 北京飞兽科技有限公司
 * created 2016/3/15 18:17
 */
public class ThemeUtils {
    private static final int[] APPCOMPAT_CHECK_ATTRS = {android.R.attr.colorPrimary};
    public static void checkAppCompatTheme(Context context){
        TypedArray a=context.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        final boolean failed=!a.hasValue(0);
        if(a!=null){
            a.recycle();
        }
        if(failed){
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme "
                    + "(or descendant) with the design library.");
        }
    }

}
