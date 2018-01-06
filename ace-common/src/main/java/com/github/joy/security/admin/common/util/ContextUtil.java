/*
 * 文 件 名:  ContextUtil.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2017年12月27日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.util;

import java.util.HashMap;
import java.util.Map;

import com.github.joy.security.admin.common.constant.CommonConstant;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2017年12月27日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ContextUtil
{
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();
    
    public static void set(String key, Object value){
        Map<String, Object> map = threadLocal.get();
        if(map == null){
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }
    
    public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if(map == null){
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }
    
    public static String getUser(){
        Object value = get(CommonConstant.CONTEXT_KEY.USER);
        return returnObjectValue(value);
    }
    
    public static String getUserID(){
        Object value = get(CommonConstant.CONTEXT_KEY.USER_ID);
        return returnObjectValue(value);
    }
    
    public static String getUserName(){
        Object value = get(CommonConstant.CONTEXT_KEY.USER_NAME);
        return returnObjectValue(value);
    }
    
    public static String getUserToken(){
        Object value = get(CommonConstant.CONTEXT_KEY.USER_TOKEN);
        return returnObjectValue(value);
    }
    
    public static void setUser(String user){
        set(CommonConstant.CONTEXT_KEY.USER, user);
    }
    
    public static void setUserID(String id){
        set(CommonConstant.CONTEXT_KEY.USER_ID, id);
    }
    
    public static void setUserName(String name){
        set(CommonConstant.CONTEXT_KEY.USER_NAME, name);
    }
    
    public static void setUserToken(String token){
        set(CommonConstant.CONTEXT_KEY.USER_TOKEN, token);
    }
    
    public static String returnObjectValue(Object value){
        return value == null?null:value.toString();
    }
    
    public static void remove(){
        threadLocal.remove();
    }
}
