/*
 * 文 件 名:  ServiceAuthUtil.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年2月2日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.client.jwt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.github.joy.security.auth.client.config.ServiceAuthConfig;
import com.github.joy.security.auth.client.exception.JwtIllegalArgumentException;
import com.github.joy.security.auth.client.exception.JwtSignatureException;
import com.github.joy.security.auth.client.exception.JwtTokenExpiredException;
import com.github.joy.security.auth.client.feign.ServiceAuthFeign;
import com.github.joy.security.auth.common.event.AuthRemoteEvent;
import com.github.joy.security.auth.common.util.jwt.IJWTInfo;
import com.github.joy.security.auth.common.util.jwt.JWTHelper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
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
@Configuration
@Slf4j
@EnableScheduling
public class ServiceAuthUtil implements ApplicationListener<AuthRemoteEvent>
{
    @Autowired
    private ServiceAuthConfig serviceAuthConfig;
    
    @Autowired
    private ServiceAuthFeign serviceAuthFeign;
    
    private List<String> allowedClient;
    
    private String clientToken;
    
    public IJWTInfo getInfoFromToken(String token) throws Exception{
        try
        {
            return JWTHelper.getInfoFromToken(token, serviceAuthConfig.getPubKeyByte());
        }
        catch (ExpiredJwtException e)
        {
            throw new JwtTokenExpiredException("Client token expired!");
        }catch (SignatureException e) {
            throw new JwtSignatureException("Client token signature error!");
        }catch (IllegalArgumentException e) {
            throw new JwtIllegalArgumentException("Client token is null or empty!");
        }
    }
    
    /**
     * 重载方法
     * @param arg0
     */
    @Override
    public void onApplicationEvent(AuthRemoteEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }
    
}
