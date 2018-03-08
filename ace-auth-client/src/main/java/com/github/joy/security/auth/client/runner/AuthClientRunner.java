/*
 * 文 件 名:  AuthClientRunner.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.client.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.github.joy.security.admin.common.msg.BaseResponse;
import com.github.joy.security.admin.common.msg.ObjectRestResponse;
import com.github.joy.security.auth.client.config.ServiceAuthConfig;
import com.github.joy.security.auth.client.config.UserAuthConfig;
import com.github.joy.security.auth.client.feign.ServiceAuthFeign;

import lombok.extern.slf4j.Slf4j;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Configuration
@Slf4j
public class AuthClientRunner implements CommandLineRunner
{
    @Autowired
    private ServiceAuthFeign serviceAuthFeign;
    
    @Autowired
    private ServiceAuthConfig serviceAutoConfig;
    
    @Autowired
    private UserAuthConfig userAuthConfig;
    
    /**
     * 重载方法
     * @param arg0
     * @throws Exception
     */
    @Override
    public void run(String... arg0)
        throws Exception
    {
        log.info("初始化加载用户pubKey");
        BaseResponse response = serviceAuthFeign.getUserPublicKey(serviceAutoConfig.getClientId(), serviceAutoConfig.getClientSecret());
        if(response.getStatus() == 200){
            @SuppressWarnings("unchecked")
            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>)response;
            this.userAuthConfig.setPubKeyByte(userResponse.getData());
        }
        log.info("初始化加载客户pubKey");
        response = serviceAuthFeign.getServicePublicKey(serviceAutoConfig.getClientId(), serviceAutoConfig.getClientSecret());
        if(response.getStatus() == 200){
            @SuppressWarnings("unchecked")
            ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>)response;
            this.serviceAutoConfig.setPubKeyByte(userResponse.getData());
        }
    }
    
}
