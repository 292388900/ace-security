/*
 * 文 件 名:  EntityUtil.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2017年12月25日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.util;

import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 实体类相关工具
 * 解决问题：1、快速对实体的常驻字段，如：crtUser、crtHost、updUser等值快速注入
 * 
 * @author  Joy
 * @version  [1.0.0, 2017年12月25日]
 */
public class EntityUtil
{
    /**
     * 快速将bean的crtUser,crtHost,crtTime,updUser,updHost,updTime附上相关值
     * 
     * @param entity 实体bean
     * @see [类、类#方法、类#成员]
     */
    public static <T> void setCreateAndUpdateInfo(T entity){
        setCreateInfo(entity);
        setUpdatedInfo(entity);
    }
    
    /**
     * 快速将bean的crtUser,crtHost,crtTime附上相关值
     * 
     * @param entity 实体类
     * @see [类、类#方法、类#成员]
     */
    public static <T> void setCreateInfo(T entity){
        // 默认属性
        String[] fields = {"crtName", "crtUser", "crtHost", "crtTime"};
        Object[] value = getDafaultValues();
        
        // 填充默认属性值
        setDefaultValues(entity, fields, value);
    }
    
    /**
     * 快速将bean的updUser,updHost,updTime附上相关值
     * 
     * @param entity 实体bean
     * @see [类、类#方法、类#成员]
     */
    public static <T> void setUpdatedInfo(T entity){
        // 默认属性
        String[] fields = {"updName", "updUser", "updHost", "updTime"};
        Object[] value = getDafaultValues();
        
        // 填充默认属性值
        setDefaultValues(entity, fields, value);
    }
    
    private static <T> void setDefaultValues(T entity, String[] fields, Object[] value){
        for(int i = 0; i < fields.length; i++){
            String field = fields[i];
            if(ReflectionUtil.hasField(entity, field)){
                ReflectionUtil.invokeSetter(entity, field, value[i]);
            }
        }
    }
    
    @SuppressWarnings("deprecation")
    private static Object[] getDafaultValues(){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        
        String hostIp = "";
        String name = "";
        String id = "";
        
        if(request != null){
            hostIp = String.valueOf(request.getHeader("userHost"));
            name = URLDecoder.decode(String.valueOf(request.getHeader("userName")));
            id = String.valueOf(request.getHeader("userId"));
        }
        
        return new Object[]{name, id, hostIp, new Date()};
    }
    
    public static<T> boolean isPKNotNull(T entity, String field){
        if(!ReflectionUtil.hasField(entity, field)){
            return false;
        }
        
        Object value = ReflectionUtil.getFieldValue(entity, field);
        return value!=null&&!"".equals(value);
    }
}
