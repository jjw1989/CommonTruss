package com.powervision.gcs.utils

import android.content.Context

/**
 * 获取语言工具类
 * Created by David on 2017/8/12.
 */
object LanguageUtils {
    private const val ZH = 10000
    private const val EN = 10001
    /**
     * 获取本机语言
     * zh-中文 en-英文 ar-阿拉伯语 cs-捷克语 da-丹麦语 de-德语 es-西班牙语 fi-芬兰语
    fr-法语 hu-匈牙利语 id-印尼语 it-意大利语 ja-日语 ka-乔治亚 ko-韩语 mn-蒙语 nl-荷兰语
    pl-波兰语 pt-葡萄牙语 bx-巴西语 ro-罗马尼亚语 ru-俄罗斯语 sk-斯洛伐克语
    sq-阿尔巴尼亚语 sv-瑞典语 te-泰国语 tr-土耳其语 vi-越南语
     * @return
     */
    fun getLanguage(context: Context): String {
        val locale = context.resources.configuration.locale
        val language = locale.language
        if (language.endsWith("zh")) {
            return "zh";//中文
        } else if (language.endsWith("en")) {
            return "en";//英文
        } else if (language.endsWith("ar")) {
            return "ar";//阿拉伯语
        } else if (language.endsWith("cs")) {
            return "cs";//cs-捷克语
        } else if (language.endsWith("da")) {
            return "da";//da-丹麦语
        } else if (language.endsWith("de")) {
            return "de";//de-德语
        } else if (language.endsWith("es")) {
            return "es";//es-西班牙语
        } else if (language.endsWith("fi")) {
            return "fi";//fi-芬兰语
        } else if (language.endsWith("fr")) {
            return "fr";//fr-法语
        } else if (language.endsWith("hu")) {
            return "hu";//hu-匈牙利语
        } else if (language.endsWith("id")) {
            return "id";//id-印尼语
        } else if (language.endsWith("it")) {
            return "it";//it-意大利语
        } else if (language.endsWith("ja")) {
            return "ja";//ja-日语
        } else if (language.endsWith("ka")) {
            return "ka";//ka-乔治亚
        } else if (language.endsWith("ko")) {
            return "ko";//ko-韩语
        } else if (language.endsWith("mn")) {
            return "mn";//mn-蒙语
        } else if (language.endsWith("nl")) {
            return "nl";//nl-荷兰语
        } else if (language.endsWith("pl")) {
            return "pl";//pl-波兰语
        } else if (language.endsWith("pt")) {
            return "pt";//pt-葡萄牙语
        } else if (language.endsWith("bx")) {
            return "bx";//bx-巴西语
        } else if (language.endsWith("ro")) {
            return "ro";//ro-罗马尼亚语
        } else if (language.endsWith("pt")) {
            return "pt";//pt-葡萄牙语
        } else if (language.endsWith("ru")) {
            return "ru";//ru-俄罗斯语
        } else if (language.endsWith("sk")) {
            return "sk";//sk-斯洛伐克语
        } else if (language.endsWith("sq")) {
            return "sq";//sq-阿尔巴尼亚语
        } else if (language.endsWith("sv")) {
            return "sv";//sv-瑞典语
        } else if (language.endsWith("te")) {
            return "te";// te-泰国语
        } else if (language.endsWith("tr")) {
            return "tr";// tr-土耳其语
        } else if (language.endsWith("vi")) {
            return "vi";//vi-越南语
        }
        return ""
    }

    /**
     * 获取本机语言代号
     * @return
     */
    fun getIntLanguage(language: String): Int {
        if (language.endsWith("zh")) {
            return ZH
        } else if (language.endsWith("en")) {
            return EN
        }
        return 0
    }

    /**如果本机语言是中文返回true否则返回flase */
    fun getNatLanguage(context: Context): Boolean {
        val locale = context.resources.configuration.locale
        val language = locale.language
        if (language.endsWith("zh")) {
            return true
        }
        return false
    }
}