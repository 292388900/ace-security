/*
 * 文 件 名:  UserAuthUtil.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月3日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.client.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.github.joy.security.auth.client.config.UserAuthConfig;
import com.github.joy.security.auth.client.exception.JwtIllegalArgumentException;
import com.github.joy.security.auth.client.exception.JwtSignatureException;
import com.github.joy.security.auth.client.exception.JwtTokenExpiredException;
import com.github.joy.security.auth.common.util.jwt.IJWTInfo;
import com.github.joy.security.auth.common.util.jwt.JWTHelper;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年1月3日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Configuration
public class UserAuthUtil
{
    @Autowired
    private UserAuthConfig userAuthConfig;
    
    public IJWTInfo getInfoFromToken(String token)
        throws Exception
    {
        try
        {
            return JWTHelper.getInfoFromToken(token, userAuthConfig.getPubKeyByte());
        }
        catch (ExpiredJwtException e)
        {
            throw new JwtTokenExpiredException("User token expried!");
        }
        catch (SignatureException e)
        {
            throw new JwtSignatureException("User token signature error!");
        }
        catch (IllegalArgumentException e)
        {
            throw new JwtIllegalArgumentException("User token is null or empty");
        }
    }
}
