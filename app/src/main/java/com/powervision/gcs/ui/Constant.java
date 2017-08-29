package com.powervision.gcs.ui;

import android.os.Environment;

import java.io.File;

/**
 * 常量
 *
 * @author Sundy
 * @title Constant.java
 */
public class Constant {
    //	public static final double UI_BASE_WIDTH_LAND = 1920.0;
    public static final double UI_BASE_WIDTH_LAND = 1334.0;
    //	public static final double UI_BASE_HEIGHT_LAND = 1080.0;
    public static final double UI_BASE_HEIGHT_LAND = 750.0;
    /* SharedPreference 文件名 */
    public static final String GLOBAL_SETTING = "GLOBAL_SETTING";
    // 引导页显示状态Key
    public static final String GUIDE_PAGER_STATE = "GLOBAL_SETTING";
    // 用户登录状态key
    public static final String USER_LOGIN = "USER_LOGIN_STATE";
    // 用户实体
    public static final String USER_BEAN = "USER_NEAN";
    // 用户列表singleid
    public static final String AFTERSALES_SINGLEID = "SINGLEID";
    //飞机连接状态
    public static final String AIRCRAFT_CONNNECT_STATE = "AIRCRAFT_CONNNECT_STATE";
    public static final String APP_NAME = "GCSAPP";

    public static final class file {
        // 应用程序主目录
        public static final String DIR_ROOT = APP_NAME;
        // 应用程序图像资源目录
        public static final String DIR_IMAGE = DIR_ROOT + File.separator + "images";
        // 应用程序文件目录
        public static final String DIR_FILE = DIR_ROOT + File.separator + "file";
    }

    //飞机唯一标识码
    public static final String AIRCRAFT_UDID = "aircraft_psn";
    //飞机型号1-poweregg 2-powereye 3-ray
    public static final String AIRCRAFT_MODE = "aircraft_mode";
    // 飞机图标类型
    public static final String PLANE_TYPE = "plane_type";
    //飞机固件版本
    public static final String AIRCRAFT_ROM_VERSION = "aircraft_rom_version";
    // 遥控器型号
    public static final String REMOTE_CONTROLLER_MODE = "remote_controller_mode";
    //遥控器固件版本
    public static final String REMOTE_CONTROLLER_VERSION = "remote_controller_version";
    //云台型号
    public static final String MOUNT_MODEL = "mount_mode";
    //云台固件版本
    public static final String MOUNT_ROM_VERSION = "mount_rom_version";
    //相机型号
    public static final String CAMERA_MODE = "camera_mode";
    //相机固件版本
    public static final String CAMERA_ROM_VERSION = "camera_rom_version";
    //遥控器固件信息
    public static final String REMOTE_CONTROLLER_FIRMWARE_INFO = "remote_controller_firmware_info";
    // 飞控固件信息
    public static final String FLIGHT_CONTROL_FIRMWARE_INFO = "flight_cotrol_firmware_info";
    // pddl固件信息
    public static final String PDDL_FIRMWARE_INFO = "pddl_firmware_info";
    // 天空端pddl固件信息
    public static final String AIR_PDDL_FIRMWARE_INFO = "air_pddl_firmware_info";
    // 地面端pddl固件信息
    public static final String GROUND_PDDL_FIRMWARE_INFO = "ground_pddl_firmware_info";
    // pddl天空端固件版本号
    public static final String PDDL_AIR_LINK_VER = "pddl_air_link_ver";
    // pddl地面端固件版本号
    public static final String PDDL_GROUND_LINK_VER = "pddl_ground_link_ver";
    // 编码板版本
    public static final String AIR_LINK_VER = "air_link_ver";
    // 编码版固件信息
    public static final String AIR_LINK_FIRMWARE_INFO = "air_link_firmware_info";
    // 基站版本
    public static final String GROUND_LINK_VER = "ground_link_ver";
    // 基站固件信息
    public static final String BASE_STATION_FIRMWARE_INFO = "base_station_firmware_info";
    // 超声版本号
    public static final String AIR_SON_VER_CODE = "air_son_ver_code";
    // 光流版本号
    public static final String AIR_FLOW_VER_CODE = "air_flow_ver_code";
    //固件保存路径
    public static final String firmwarePath = "/GCS/firmware/";
    // 照片保存路径
    public static final String cameraPath = "/GCS/camera/";
    // 视频保存路径
    public static final String videoPath = "/GCS/video/";
    //蒙版显示
    public static final String MASK_GUIDE = "mask_guide";
    // 语音播报
    public static final String VOICE_PLAY = "VOICE_PLAY";
    // 地图类型
    public static final String MAP_TYPE = "MAP_TYPE";
    // 安全模式状态
    public static final String SAFE_MODE = "SAFE_MODE";
    // 自动壁障
    public static final String AUTO_BARRIER = "AUTO_BARRIER";
    // 主屏显示电压
    public static final String VOLTAGE_SHOW = "VOLTAGE_SHOW";
    // 公制和英制转换：0：auto 1：公制，2：英制
    public static final String METRIC_IMPERIAL = "metric_imperial";
    // 飞行日志保存路径
    public static final String FLIGHT_LOG_PATH = Environment.getExternalStorageDirectory().getPath() + "/GCS/Json/log/FlightRecord";
    // 飞行日志获取路径
    public static final String FLIGHT_LOG_PATH_GET = Environment.getExternalStorageDirectory().getPath() + "/GCS/Json/log/";
    //广告页面url
    public static final String SCREENADV_HEADIMAGE = "screenadv_headImage";
    //飞行器电量
    public static final String AIRPLANE_B = "air_plane_battary";
    //飞行器电压
    public static final String AIRPLANE_V = "air_plane_v";
    // 遥控器模式
    public static final String REMOTE_MODE = "REMOTE_MODE";
    // 显示航线
    public static final String SHOW_AIRLINE = "SHOW_AIRLINE";
    // 禁飞区限制
    public static final String NO_FLY_ZONE = "NO_FLY_ZONE";

    //注销登陆intent
    public static final String INTENT_ACT = "intentAct";
    public static final String INTENT_LOGOUT = "intent_logout";

    public static final class ware {
        // 遥控器固件
        public static final String RC_FIRMWARE = "firmware.bin";
        // 飞控固件
        public static final String FLY_CONTROL_FIRMWARE = "flightControlFirmware.bin";
        public static final String FLY_CONTROL_FIRMWARE_EGG = "flightControlFirmwareEgg.bin";
        public static final String FLY_CONTROL_FIRMWARE_EYE = "flightControlFirmwareEye.bin";
        // 天空pddl固件
        public static final String AIR_PDDL_FIRMWARE = "airPddlFirmware.bin";
        // 地面pddl固件
        public static final String GROUND_PDDL_FIRMWARE = "groundPddlFirmware.bin";
        // 编码板固件
        public static final String AIR_LINK_FIRMWARE = "airLinKFirmware.bin";
        // 基站固件
        public static final String GROUND_LINK_FIRMWARE = "groundLinkFirmware.bin";
        //ray 船控固件
        public static final String CONTROL_RAY_FIRMWARE = "raymain.bin";
        //ray 相机固件
        public static final String CAMARA_RAY_FIRMWARE = "firmware.bin";
        //遥控器
        public static final String REMOTE_RAY_FIRMWARE = "rayremote.bin";
        //遥控器
        public static final String STATION_RAY_FIRMWARE = "raystation.bin";
        //ray 新相机固件
        public static final String CAMERA_RAY_FIRMWARE = "raycamera.bin";
    }

    //ray 船控信息
    public static final String WATER_CONTROL_FIRMWARE = "raymain";
    //ray 相机信息
    public static final String WATER_CAMERAL_FIRMWARE = "raycamera";
    //ray 遥控器信息
    public static final String WATER_REMOTE_FIRMWARE = "rayremote";
    //ray 基站信息
    public static final String WATER_STATION_FIRMWARE = "raystation";
    //船控版本号
    public static final String WATER_CONTROL_FIRMWARE_VER = "flightControl_ray_ver";
    //ray 相机版本号
    public static final String WATER_CAMERAL_FIRMWARE_VER = "camera_ray_ver";
    //ray 相机已下载固件信息，md5，lastmodifytime，version
    public static final String WATER_CAMERAL_FIRMWARE_VER_DOWNLOAD_INFO = "camera_ray_ver_download_info";
    //ray 遥控器版本号
    public static final String WATER_REMOTE_FIRMWARE_VER = "remote_ray_ver";
    //ray 基站版本好
    public static final String WATER_STATION_FIRMWARE_VER = "station_ray_ver";

    public static final String FIRST_LOAD_MAP_TYPE = "load_map_tye";

    public static final String LET_GAO_DE_SHOW = "112";
    public static int SCREENWIDTH;
    public static int SCREENHEIGHT;
    public static boolean reConnected = false;


    public static String NOLONGER = "no_longer";
    public static String TITLE = "title";
    public static boolean CLEANED_IMAGE = false;
    public static boolean CLEAND_VIDEO = false;
    public static boolean COPY_COMPLETE = false;
    public static boolean RUNONSTOP = false;

    public static final class ray {
        public static final int RAY_CONTROL = 0x001;   //船控
        public static final int RAY_STATION = 0x002;   //船基站
        public static final int RAY_REMOTE = 0x003;    //船遥控器
    }

    /**
     * 1-连接 0-未连接
     */
    public static final String PV_FISH_FINDER_STATUS = "PV_FISH_FINDER_STATUS";     //寻鱼器状态
    public static final String SD_CARD_STATUS = "SD_CARD_STATUS";                   //sd卡容量
    /**
     * 0-异常 1-正常
     */
    public static final String PV_BATTERY_STATUS = "PV_BATTERY_STATUS";             //电池状态
    public static final String CHECK_BATTERY_REMAINED = "CHECK_BATTERY_REMAINED";   //电池电量
    public static final String CHECK_BATTERY_TEMP = "CHECK_BATTERY_TEMP";           //电池温度
    public static final String CHECK_RC_BATTERY = "CHECK_RC_BATTERY";               //遥控器电量

    public static int AP01_Grid = 0;
    public static int F1_Grid = 0;
    public static boolean NETSERVICESTARTED = false;
}

