/*
 * 文 件 名:  AdminAccessFilter.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年2月2日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.gate.server.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.joy.security.auth.client.config.ServiceAuthConfig;
import com.github.joy.security.auth.client.config.UserAuthConfig;
import com.github.joy.security.auth.client.jwt.UserAuthUtil;
import com.github.joy.security.gate.server.feign.IUserService;
import com.netflix.zuul.ZuulFilter;

import lombok.extern.slf4j.Slf4j;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年2月2日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Component
@Slf4j
public class AdminAccessFilter extends ZuulFilter
{
    @Autowired
    private IUserService userService;
    
    @Value("${gate.ignore.startWith}")
    private String startWith;
    
    @Value("${zuul.prefix}")
    private String zuulPrefix;
    
    @Autowired
    private UserAuthUtil userAuthUtil;
    
    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    
    @Autowired
    private UserAuthConfig userAuthConfig;
    
    /**
     * 重载方法
     * @return
     */
    @Override
    public Object run()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 重载方法
     * @return
     */
    @Override
    public boolean shouldFilter()
    {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * 重载方法
     * @return
     */
    @Override
    public int filterOrder()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * 重载方法
     * @return
     */
    @Override
    public String filterType()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
}
