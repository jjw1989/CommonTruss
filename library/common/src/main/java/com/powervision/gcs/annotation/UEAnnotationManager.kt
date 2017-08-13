//package com.powervision.gcs.annotation
//
//import android.app.Activity
//import android.content.Context
//import android.graphics.Color
//import android.graphics.Typeface
//import android.support.v4.app.Fragment
//import android.util.Log
//import android.util.TypedValue
//import android.view.View
//import android.view.View.OnClickListener
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//
//
//
//import java.lang.reflect.Field
//import java.util.Locale
//
///**
//
// * UEAnnotationManager
// * 注释管理类 · 提供自定义注释解析以及控件初始化
// * Created by David on 2017/8/10.
// */
//class UEAnnotationManager{
//
//    private object UEAnnotationManager { val INSTANCE = UEAnnotationManager() }
///**
// * 私有化构造方法
// */
////private constructor() {
//
//    /**
//     * 初始化Activity字体
//     */
//    fun initializeFont(context: Activity, typeface: Typeface) {
//        val fields = context.javaClass.declaredFields
//        for (field in fields) {
//            //判断是否含有UEID注释
//            if (field.isAnnotationPresent(UEAnnotation.UEID::class.java)) {
//                setFont(context, field, typeface)
//            }
//        }
//    }
//
//    /**
//     * 初始化Fragment字体
//     */
//    fun initializeFont(fragment: Fragment, typeface: Typeface) {
//        val fields = fragment.javaClass.declaredFields
//        for (field in fields) {
//            if (field.isAnnotationPresent(UEAnnotation.UEID::class.java)) {
//                setFont(fragment, field, typeface)
//            }
//        }
//    }
//
//    /**
//     * 初始化Fragment字体
//     */
//    private fun setFont(fragment: Fragment, field: Field, typeface: Typeface) {
//        field.isAccessible = true
//        try {
//            val `object` = field.get(fragment)
//            if (`object` is TextView || `object` is EditText || `object` is Button) {
//                //反射机制调用方法设置参数
//                field.type.getMethod("setTypeface", Typeface::class.java).invoke(`object`, typeface)
//            }
//        } catch (e: Exception) {
//            Log.e("Deliration", e.toString())
//            Log.e("Deliration", "资源错误 - 字体设置失败")
//        }
//
//    }
//
//    /**
//     * 初始化Activity字体
//     */
//    private fun setFont(context: Context, field: Field, typeface: Typeface) {
//        field.isAccessible = true
//        try {
//            val `object` = field.get(context)
//            if (`object` is TextView || `object` is EditText || `object` is Button) {
//                field.type.getMethod("setTypeface", Typeface::class.java).invoke(`object`, typeface)
//            }
//        } catch (e: Exception) {
//            Log.e("Deliration", e.toString())
//            Log.e("Deliration", "资源错误 - 字体设置失败")
//        }
//
//    }
//
//    /**
//     * 初始化方法
//     * @param context 上下文
//     */
//    fun initialize(context: Activity, layout: Boolean) {
//        if (layout && context.javaClass.isAnnotationPresent(UEAnnotation.UELayout::class.java)) {
//            initializeLayout(context)
//        }
//        val fields = context.javaClass.declaredFields
//        for (field in fields) {
//            if (field.isAnnotationPresent(UEAnnotation.UEID::class.java)) {
//                initializeWidgets(field, context)
//            } else if (field.isAnnotationPresent(UEAnnotation.UENew::class.java)) {
//                initializeObjects(field, context)
//            }
//        }
//    }
//
//    /**
//     * 初始化方法
//     * @param fragment
//     * *
//     * @param view
//     */
//    fun initialize(fragment: Fragment, view: View) {
//        val fields = fragment.javaClass.declaredFields
//        for (field in fields) {
//            if (field.isAnnotationPresent(UEAnnotation.UEID::class.java)) {
//                initializeWidgets(field, fragment, view)
//            } else if (field.isAnnotationPresent(UEAnnotation.UENew::class.java)) {
//                initializeObjects(field, fragment, view)
//            }
//        }
//    }
//
//    /**
//     * 初始化Activity布局
//     * @param context
//     */
//    private fun initializeLayout(context: Activity) {
//        val initialization = context.javaClass.getAnnotation(UEAnnotation.UELayout::class.java)
//        if (initialization.value !== -1) {
//            context.setContentView(initialization.value)
//        } else {
//            try {
//                val layout = context.resources.getIdentifier(context.javaClass.simpleName.toLowerCase(Locale.getDefault()), "layout", context.packageName)
//                if (layout != 0) {
//                    context.setContentView(layout)
//                } else {
//                    Log.e("Deliration", "资源错误 - 未找到名为" + context.javaClass.simpleName.toLowerCase(Locale.getDefault()) + ".xml的布局文件")
//                }
//            } catch (e: Exception) {
//                Log.d("Deliration", e.message)
//            }
//
//        }
//    }
//
//    /**
//     * 初始化UI控件
//     * @param field
//     * *
//     * @param context
//     */
//    private fun initializeWidgets(field: Field, context: Activity) {
//        if (!field.isAnnotationPresent(UEAnnotation.UEID::class.java)) {
//            return
//        }
//        val initialization = field.getAnnotation(UEAnnotation.UEID::class.java)
//        var ID = initialization.value
//        try {
//            field.isAccessible = true
//            if (ID == -1) {
//                ID = context.resources.getIdentifier(field.name, "id", context.packageName)
//                if (ID == 0) {
//                    Log.e("Deliration", "资源错误 - 未找到ID为R.id." + field.name + "的控件")
//                    return
//                }
//            }
//            val view = context.findViewById<View>(ID)
//            val clazz = field.type
//            field.set(context, view)
//            if (field.isAnnotationPresent(UEAnnotation.UEVisibility::class.java)) {
//                clazz.getMethod("setVisibility", Int::class.javaPrimitiveType).invoke(view, context)
//            }
//            if (field.isAnnotationPresent(UEAnnotation.UEBackgroundColor::class.java)) {
//                clazz.getMethod("setBackgroundColor", Int::class.javaPrimitiveType).invoke(view, Color.parseColor(field.getAnnotation(UEAnnotation.UEBackgroundColor::class.java).value))
//            }
//            if (field.isAnnotationPresent(UEAnnotation.UEAlpha::class.java)) {
//                clazz.getMethod("setAlpha", Float::class.javaPrimitiveType).invoke(view, field.getAnnotation(UEAnnotation.UEAlpha::class.java).value)
//            }
//            if (field.isAnnotationPresent(UEAnnotation.UEOnClick::class.java)) {
//                clazz.getMethod("setOnClickListener", OnClickListener::class.java).invoke(view, context)
//            }
//            if (field.isAnnotationPresent(UEAnnotation.UEClickable::class.java)) {
//                clazz.getMethod("setClickable", Boolean::class.javaPrimitiveType).invoke(view, field.getAnnotation(UEAnnotation.UEClickable::class.java).value)
//            }
//            if (field.isAnnotationPresent(UEAnnotation.UEEnabled::class.java)) {
//                clazz.getMethod("setEnabled", Boolean::class.javaPrimitiveType).invoke(view, field.getAnnotation(UEAnnotation.UEEnabled::class.java).value)
//            }
//            if (field.isAnnotationPresent(UEAnnotation.UEBackgroundResource::class.java)) {
//                var resId = field.getAnnotation(UEAnnotation.UEBackgroundResource::class.java).value
//                if (resId == -1) {
//                    resId = context.resources.getIdentifier(field.name, "drawable", context.packageName)
//                }
//                if (resId < 1) {
//                    Log.e("Deliration", "资源错误 - 未找到ID为R.drawable." + field.name + "的图片")
//                } else {
//                    clazz.getMethod("setBackgroundResource", OnClickListener::class.java).invoke(view, resId)
//                }
//            }
//            if (!isExpress(field.type)) {
//                return
//            }
//            if (field.isAnnotationPresent(UEAnnotation.UEText::class.java)) {
//                clazz.getMethod("setText", CharSequence::class.java).invoke(view, field.getAnnotation(UEAnnotation.UEText::class.java).value)
//            }
//            if (field.isAnnotationPresent(UEAnnotation.UETextSize::class.java)) {
//                clazz.getMethod("setTextSize", *arrayOf<Class<*>>(Int::class.javaPrimitiveType!!, Float::class.javaPrimitiveType!!)).invoke(view, *arrayOf<Any>(TypedValue.COMPLEX_UNIT_SP, field.getAnnotation(UEAnnotation.UETextSize::class.java).value))
//            }
//            if (field.isAnnotationPresent(UEAnnotation.UETextColor::class.java)) {
//                clazz.getMethod("setTextColor", Int::class.javaPrimitiveType).invoke(view, Color.parseColor(field.getAnnotation(UEAnnotation.UETextColor::class.java).value))
//            }
//        } catch (e: Exception) {
//            Log.d("initializeWidgets", e.toString())
//        }
//
//    }
//
//    /**
//     * 初始化Object对象
//     * @param field
//     * *
//     * @param context
//     */
//    private fun initializeObjects(field: Field, context: Activity) {
//        if (field.isAnnotationPresent(UEAnnotation.UENew::class.java)) {
//            try {
//                field.isAccessible = true
//                field.set(context, field.type.newInstance())
//            } catch (e: Exception) {
//                Log.d("initializeObjects", e.message)
//            }
//
//        }
//    }
//
//    /**
//     * 初始化UI控件
//     * @param field
//     * *
//     * @param context
//     */
//    private fun initializeWidgets(field: Field, fragment: Fragment, view: View) {
//        if (field.isAnnotationPresent(UEAnnotation.UEID::class.java)) {
//            val initialization = field.getAnnotation(UEAnnotation.UEID::class.java)
//            var ID = initialization.value
//            try {
//                field.isAccessible = true
//                if (ID == -1) {
//                    ID = fragment.resources.getIdentifier(field.name, "id", fragment.activity.packageName)
//                    if (ID == 0) {
//                        Log.e("Deliration", "资源错误 - 未找到ID为R.id." + field.name + "的控件")
//                    }
//                }
//                field.set(fragment, view.findViewById<View>(ID))
//                if (field.isAnnotationPresent(UEAnnotation.UEOnClick::class.java)) {
//                    field.type.getMethod("setOnClickListener", OnClickListener::class.java)
//                            .invoke(view.findViewById<View>(ID), fragment)
//                }
//                if (field.isAnnotationPresent(UEAnnotation.UETextColor::class.java)) {
//                    field.type.getMethod("setTextColor", Int::class.javaPrimitiveType)
//                            .invoke(view.findViewById<View>(ID), Color.parseColor(field.getAnnotation(UEAnnotation.UETextColor::class.java).value))
//                }
//                if (field.isAnnotationPresent(UEAnnotation.UETextSize::class.java)) {
//                    field.type.getMethod("setTextSize", Float::class.javaPrimitiveType)
//                            .invoke(view.findViewById<View>(ID), field.getAnnotation(UEAnnotation.UETextSize::class.java).value)
//                }
//                if (field.isAnnotationPresent(UEAnnotation.UEBackgroundColor::class.java)) {
//                    field.type.getMethod("setBackgroundColor", Int::class.javaPrimitiveType)
//                            .invoke(view.findViewById<View>(ID), Color.parseColor(field.getAnnotation(UEAnnotation.UEBackgroundColor::class.java).value))
//                }
//            } catch (e: Exception) {
//                Log.d("initializeWidgets", e.message)
//            }
//
//        }
//    }
//
//    /**
//     * 初始化Object对象
//     * @param field
//     * *
//     * @param context
//     */
//    private fun initializeObjects(field: Field, fragment: Fragment, view: View) {
//        if (field.isAnnotationPresent(UEAnnotation.UENew::class.java)) {
//            try {
//                field.isAccessible = true
//                field.set(fragment, field.type.newInstance())
//            } catch (e: Exception) {
//                Log.d("initializeObjects", e.message)
//            }
//
//        }
//    }
//
////    private fun isExpress(clazz: Class<*>): Boolean {
////        for (express in EXPRESS_CLASSES) {
////            if (clazz == express) {
////                return true
////            }
////        }
////        return false
////    }flight_guide_eye_0_zh.jpg
//
//
//    companion object {
//
//        //单一实例
//        private var instance: UEAnnotationManager by lazy {
//            UEAnnotationManager.INSTANCE
//        }
//
//
//        private val EXPRESS_CLASSES = arrayOf<Class<*>>(TextView::class.java, EditText::class.java, Button::class.java, UIButton::class.java, UIEditText::class.java)
//    }
//}
