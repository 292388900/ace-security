/*
 * 文 件 名:  AuthServiceImpl.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月6日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.server.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.joy.security.api.vo.user.UserInfo;
import com.github.joy.security.auth.common.util.jwt.JWTInfo;
import com.github.joy.security.auth.server.feign.IUserService;
import com.github.joy.security.auth.server.service.AuthService;
import com.github.joy.security.auth.server.util.user.JwtTokenUtil;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class AuthServiceImpl implements AuthService
{
    private JwtTokenUtil jwtTokenUtil;
    private IUserService userService;
    
    /** 
     * <默认构造函数>
     */
    @Autowired
    public AuthServiceImpl(JwtTokenUtil jwtTokenUtil, IUserService userService)
    {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }
    
    /**
     * 重载方法
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public String login(String username, String password)
        throws Exception
    {
        UserInfo userInfo = userService.validate(username, password);
        String token = "";
        if(!StringUtils.isEmpty(userInfo.getId())){
            token = jwtTokenUtil.generateToken(new JWTInfo(userInfo.getUsername(), userInfo.getId()+"", userInfo.getName()));
        }
        return token;
    }
    
}
