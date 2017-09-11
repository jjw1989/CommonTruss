package com.powervision.gcs.utils;

import android.content.Context;
import android.os.Build;


import com.powervision.gcs.config.Params;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 生成json参数
 * Created by sundy on 2016/8/11.
 */

public class JsonParams {

    /**********************************************服务参数************************************************************/
    /**
     * 飞行周边列表
     */
//    public static String getFlyAroundParams(String pageNumber, String pageCount) {
//        JSONObject json = new JSONObject();
//        try {
//            json.put(Params.KEY_PAGENUMBER, pageNumber);
//            json.put(Params.KEY_PAGECOUNT, pageCount);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return json.toString();
//    }

    /******************************************
     * 个人中心
     **************************/
    /**
     * 手机登录
     *
     * @param userphone
     * @param code
     * @return
     */
    public static String getLoginJson(String userphone, String code) {
        JSONObject json = new JSONObject();
        try {
            json.put("userphone", userphone);
            json.put("password", code);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    /**
     * 邮箱登录
     *
     * @param useremail
     * @param password
     * @return
     */
    public static String getEmailLoginJson(String useremail, String password) {
        JSONObject emailLogin = new JSONObject();
        try {
            emailLogin.put("useremail", useremail);
            emailLogin.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return emailLogin.toString();
    }

    /**
     * 上传飞行日志
     */
    public static String getFlighRecords(String userId, String deviceid, String createtime, String fileSize) {
        JSONObject json = new JSONObject();
        try {
            json.accumulate("userid", userId); // 用户id
            json.accumulate("deviceid", deviceid); // 设备id
            json.accumulate("createtime", createtime); // 创建时间
            json.accumulate("latitude", 40.1273781 + ""); // 纬度
            json.accumulate("longitude", 116.7487723 + ""); // 经度
            json.accumulate("logbytesize", fileSize); // 字节大小
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    /**
     * 获取手机号是否已经存在请求json
     *
     * @param account
     * @return
     */
    public static String getPhoneCheckJson(String account) {
        JSONObject phoneJson = new JSONObject();
        try {
            phoneJson.put("userphone", account);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return phoneJson.toString();
    }

    /**
     * 获取邮箱是否已经存在请求map
     *
     * @param account
     * @return
     */
    public static String getEmailExistJson(String account) {
        JSONObject emailJson = new JSONObject();
        try {
            emailJson.put("useremail", account);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return emailJson.toString();
    }

    /**
     * 获取验证码json
     *
     * @param phone
     * @return
     */
    public static String getVerificationCodeJson(String phone) {
        JSONObject codeJson = new JSONObject();
        try {
            codeJson.put("userphone", phone);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return codeJson.toString();
    }

    /**
     * 获取发送验证码请求json
     *
     * @param email
     * @return
     */
    public static String getVerificationCodeJson(String email, int type) {
        JSONObject codeJson = new JSONObject();
        try {
            codeJson.put("useremail", email);
            codeJson.put("actionType", String.valueOf(type));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return codeJson.toString();
    }

    /**
     * 获取手机注册请求json
     *
     * @param account
     * @param code
     * @param password
     * @param nickname
     * @return
     */
    public static String getPhoneRegisterJson(String account, String code, String password, String nickname, String country_code) {
        JSONObject phoneJson = new JSONObject();
        try {
            phoneJson.put("userphone", account);
            phoneJson.put("phonecode", code);
            phoneJson.put("password", password);
            phoneJson.put("nickname", nickname);
            phoneJson.put("country", country_code);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return phoneJson.toString();
    }

    /**
     * 获取邮箱注册请求json
     *
     * @param useremail
     * @param mailcode
     * @param password
     * @return
     */
    public static String getEmailRegisterJson(String useremail, String mailcode, String password, String nickname, String country_code) {
        JSONObject emailJson = new JSONObject();
        try {
            emailJson.put("useremail", useremail);
            emailJson.put("mailcode", mailcode);
            emailJson.put("password", password);
            emailJson.put("nickname", nickname);
            emailJson.put("country", country_code);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return emailJson.toString();
    }

    /**
     * 手机密码重置请求json
     *
     * @param account
     * @param code
     * @param password
     * @return
     */
    public static String getPhoneResetJson(String account, String code, String password) {
        JSONObject emailReset = new JSONObject();
        try {
            emailReset.put("userphone", account);
            emailReset.put("phonecode", code);
            emailReset.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return emailReset.toString();
    }

    /**
     * 获取邮箱重置密码请求json
     *
     * @param account
     * @param code
     * @param password
     * @return
     */
    public static String getEmailResetJson(String account, String code, String password) {
        JSONObject emailReset = new JSONObject();
        try {
            emailReset.put("useremail", account);
            emailReset.put("mailcode", code);
            emailReset.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return emailReset.toString();
    }

    /**
     * 获取修改昵称json
     *
     * @param userid
     * @param nickname
     * @return
     */
    public static String getNickNameJson(String userid, String nickname) {
        JSONObject nickJson = new JSONObject();
        try {
            nickJson.put("userid", userid);
            nickJson.put("nickname", nickname);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return nickJson.toString();
    }

    /**
     * 修改保存用户信息json串
     *
     * @param userid
     * @return
     */
    public static String getUserInfo(String userid) {
        JSONObject userJson = new JSONObject();
        try {
            userJson.put("userid", userid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return userJson.toString();
    }

    /**
     * 获取修改密码请求json
     *
     * @param userId
     * @param password
     * @param newpassword
     * @return
     */
    public static String getChangePasswordJson(String userId, String password, String newpassword) {
        JSONObject changeJson = new JSONObject();
        try {
            changeJson.put("userid", userId);
            changeJson.put("password", password);
            changeJson.put("newpassword", newpassword);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return changeJson.toString();
    }

    /**
     * 获取飞行学院请求json
     *
     * @param pageNumber
     * @param pageCount
     * @return
     */
    public static String getFlySchoolQueryJson(String productId, String pageNumber, String pageCount) {
        JSONObject schoolJson = new JSONObject();
        try {
            schoolJson.put("productId", productId);
            schoolJson.put("pagenumber", pageNumber);
            schoolJson.put("pagecount", pageCount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return schoolJson.toString();
    }

    public static String transFromString(String s) {
//        char[] chars = s.toCharArray();
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < chars.length ; i++) {
//            if (chars[i] == '"'){
//                sb.append("\"");
//            }else{
//                sb.append(chars[i]);
//            }
//        }
//        String whole = sb.toString();
//        Log.w("lzqWhole","whle "+whole);
        return s;

    }


    /**
     * 技术支持请求json
     *
     * @param ts_types
     * @return
     */
    public static String getTechnicalSupportJson(String ts_types) {
        JSONObject supportJson = new JSONObject();
        try {
            supportJson.put("ids", ts_types);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return supportJson.toString();
    }

    /**
     * 获取问题列表params
     *
     * @param id
     * @return
     */
    public static String getTechnicalListJson(String id) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("typeid", id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    /**
     * 获取提交维修申请请求json
     *
     * @param device_number
     * @param name
     * @param phone
     * @param question
     * @param userid
     * @return
     */
    public static String getAfterSaleApplyJson(String device_number, String name, String phone, String question, String userid) {
        JSONObject params = new JSONObject();
        try {
            params.put("deviceCode", device_number);
            params.put("userName", name);
            params.put("userPhone", phone);
            params.put("questionDescription", question);
            params.put("userId", userid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return params.toString();
    }

    /**
     * 获取维修列表请求json
     *
     * @param userId
     * @return
     */
    public static String getOrderListJson(String userId) {
        JSONObject listJson = new JSONObject();
        try {
            listJson.put("userId", userId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listJson.toString();
    }

    /**
     * 激活请求json
     */
    public static String getActivationJson(String activeCode, String address, String userid, String lonlat) {
        JSONObject activationJson = new JSONObject();
        try {
            activationJson.put("encrypt_str", activeCode);
            activationJson.put("activation_address", address);
            activationJson.put("userid", userid);
            activationJson.put("lonlat", lonlat);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return activationJson.toString();
    }

    /**
     * 保险证书json
     */
    public static String getCertificateJsson(String userid, String psn) {
        JSONObject certificateJson = new JSONObject();
        try {
            certificateJson.put("userid", userid);
            certificateJson.put("psn", psn);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return certificateJson.toString();
    }

    /**
     * 获取维修流程请求json
     *
     * @param singleId
     * @return
     */
    public static String getOrderProcessJson(String singleId) {
        JSONObject processJson = new JSONObject();
        try {
            processJson.put("singleId", singleId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return processJson.toString();
    }

    /**
     * 快递单号提交json
     *
     * @param orderSingleId
     * @param userId
     * @param expressNumber
     * @param name
     * @param phone
     * @param address
     * @return
     */
    public static String getExpressJson(String orderSingleId, String userId, String expressNumber, String name, String phone, String address) {
        JSONObject expressJson = new JSONObject();
        try {
            expressJson.put("orderSingleId", orderSingleId);//订单唯一id
            expressJson.put("userId", userId);
            expressJson.put("orderLogisticsCode", expressNumber);
            expressJson.put("userName", name);
            expressJson.put("userPhone", phone);
            expressJson.put("userDetailAddress", address);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return expressJson.toString();
    }

//    /**
//     * 创建固件升级json串
//     *
//     * @param context
//     * @param maplist
//     * @return
//     */
//    public static String getFirmwareInfo(Context context, ArrayList<HashMap<String, String>> maplist) {
//        JSONObject firmwareJson = new JSONObject();
//        SPHelperUtils mSPHelper = SPHelperUtils.getInstance(context);
//        try {
//            firmwareJson.put("equipment_model", String.valueOf(mSPHelper.getInt(Constant.AIRCRAFT_MODE) + 1)); //设备型号
//            firmwareJson.put("equipment_id", mSPHelper.getString(Constant.AIRCRAFT_UDID)); // 设备id
//            firmwareJson.put("user_id", mSPHelper.getUserInfo().getUserid()); // 用户id
//            firmwareJson.put("mobile_system", "android");
//            firmwareJson.put("mobile_brand", Build.BRAND);
//            firmwareJson.put("mobile_model", Build.MODEL);
//            firmwareJson.put("mobile_unique_sign", StringUtil.getDeviceId(context));
//            JSONArray jsonArr = new JSONArray();//json格式的数组
//            for (HashMap<String, String> map : maplist) {
//                JSONObject jsonObjArr = new JSONObject();
//                jsonObjArr.put("hardware_type", map.get("hardware_type"));//硬件类型
//                jsonObjArr.put("hardware_model", map.get("hardware_model"));
//                jsonObjArr.put("firmware_version_code", map.get("firmware_version_code"));
//                jsonArr.put(jsonObjArr);
//            }
//            firmwareJson.put("firware_group", jsonArr);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return firmwareJson.toString();
//    }

    /**
     * 开屏广告页json
     *
     * @param deviceType 用于区分普通手机和ipad，0为手机、1为ipad
     * @return
     */
    public static String getScreenAdvertising(String deviceType) {
        JSONObject expressJson = new JSONObject();
        try {
            expressJson.put("deviceType", deviceType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return expressJson.toString();
    }

    /**
     * 获取飞行日志历史请求json
     *
     * @param userid
     * @return
     */
    public static String getRecordHistoryJson(String userid) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.accumulate("userid", userid); // 用户id
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    /**
     * 获取飞行记录详情请求json
     *
     * @param flightid
     * @return
     */
    public static String getFlyRecordLogJson(String flightid) {
        JSONObject recordLogJson = new JSONObject();
        try {
            recordLogJson.put("flightid", flightid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return recordLogJson.toString();
    }

    /**
     * 获取绑定手机json
     *
     * @return
     */
    public static String getBindPhoneJson(String userid, String userphone, String phonecode) {
        JSONObject bindPhoneJson = new JSONObject();
        try {
            bindPhoneJson.put("userid", userid);
            bindPhoneJson.put("userphone", userphone);
            bindPhoneJson.put("phonecode", phonecode);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bindPhoneJson.toString();
    }

    /**
     * 获取绑定邮箱json
     *
     * @return
     */
    public static String getBindEmailJson(String userid, String useremail, String emailcode) {
        JSONObject bindEmailJson = new JSONObject();
        try {
            bindEmailJson.put("userid", userid);
            bindEmailJson.put("useremail", useremail);
            bindEmailJson.put("emailcode", emailcode);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bindEmailJson.toString();
    }

    /**
     * 获取保存个人资料json
     *
     * @param userid
     * @param nickname
     * @param birthday
     * @param country_code
     * @param city
     * @param phone
     * @param email
     * @return
     */
    public static String getSaveProfileJson(String userid, String nickname, String birthday, String country_code, String city, String phone, String email) {
        JSONObject profileJson = new JSONObject();
        try {
            profileJson.put("userId", userid);
            profileJson.put("nickName", nickname);
            profileJson.put("brithday", birthday);
            profileJson.put("country", country_code);
            profileJson.put("city", city);
            profileJson.put("userPhone", phone);
            profileJson.put("userEmail", email);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return profileJson.toString();
    }

    /**
     * 获取用户激活设备json
     *
     * @param userId
     * @return
     */
    public static String getActiveDevice(String userId) {
        JSONObject activeJson = new JSONObject();
        try {
            activeJson.put("userId", userId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return activeJson.toString();
    }
}
