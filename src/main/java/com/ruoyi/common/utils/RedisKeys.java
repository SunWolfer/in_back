/**
 * Copyright (c) 2016-2019 思达特开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.ruoyi.common.utils;

/**
 * Redis所有Keys
 *
 * @author Mark sunlightcs@gmail.com
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    public static String getTagkey(String key) {
		return "api:tag:"+key;

    }

    public static String getDeviceTagkey(String key) {
        return "api:deviceTag:"+key;

    }

    public static String getDevicekey(String key) {
		return "api:device:"+key;

    }

    public static String getDictKey(String key) {
        return "api:dict:"+key;

    }
    public static String getSensorKey(String key) {
        return "api:sensor:"+key;

    }

    public static String getVideoKey(String key){
        return "api:video:"+key;
    }

    public static String getWindowNowTagkey(String key) {
        return "api:windowNowTag:"+key;

    }
}
