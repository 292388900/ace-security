/*
 * 文 件 名:  AutoConfiguration.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月5日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.client.configuration;

import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.github.joy.security.auth.client.config.ServiceAutoConfig;
import com.github.joy.security.auth.client.config.UserAuthConfig;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月5日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Configuration
@ComponentScan({"com.github.joy.security.auth.client", "com.github.joy.security.auth.common.event"})
@RemoteApplicationEventScan(basePackages = "com.github.joy.security.auth.common.event")
public class AutoConfiguration
{
    @Bean
    ServiceAutoConfig getServiceAuthConfig(){
        return new ServiceAutoConfig();
    }
    
    @Bean
    UserAuthConfig getUserAutoConfig(){
        return new UserAuthConfig();
    }
}
