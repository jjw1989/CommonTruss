package com.powervision.gcs.annotation

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**

 * UEAnnotation
 * 注释汇总 · 提供初始化注释标签
 * Created by David on 2017/8/10.
 */
class UEAnnotation {

    /**
     * 布局 · 解析R.layout.xxx布局索引
     */
    @Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UELayout(val value: Int = -1)

    @Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UEConfig(val value: Int = -1)

    /**
     * 类 · 初始化对象
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UENew(val value: Boolean = true)

    /**
     * View及子类通用 · 解析R.id.xxx控件索引
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UEID(val value: Int = -1)

    /**
     * View及子类通用 · 绑定控件点击事件
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UEOnClick(val value: Boolean = true)

    /**
     * View及子类通用 · 解析16进制字串符背景颜色
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UEBackgroundColor(val value: String = "#00000000")

    /**
     * View及子类通用 · 控制控件是否可视
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UEVisibility(val value: Int = 0x00000000)

    /**
     * View及子类通用 · 设置控件透明度(0 - 1f)
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UEAlpha(val value: Float = 0.5f)

    /**
     * View及子类通用 · 解析R.drawable.xxx背景图片索引
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UEBackgroundResource(val value: Int = -1)

    /**
     * View及子类通用 · 控制控件是否允许响应点击
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UEClickable(val value: Boolean = false)

    /**
     * View及子类通用 · 控制控件是否可用
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UEEnabled(val value: Boolean = false)

    /**
     * 特殊View类 · 解析16进制字符串字体颜色
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UETextColor(val value: String = "#444444")

    /**
     * 特殊View类 · 设置字体大小SP
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UETextSize(val value: Int = 14)

    /**
     * 特殊View类 · 设置文本内容
     */
    @Target(AnnotationTarget.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    annotation class UEText(val value: String = "")
}
