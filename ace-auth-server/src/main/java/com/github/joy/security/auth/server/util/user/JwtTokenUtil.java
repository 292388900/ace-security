/*
 * 文 件 名:  JwtTokenUtil.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月6日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.server.util.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.github.joy.security.auth.common.util.jwt.IJWTInfo;
import com.github.joy.security.auth.common.util.jwt.JWTHelper;
import com.github.joy.security.auth.server.config.KeyConfig;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Component
public class JwtTokenUtil
{
    @Value("${jwt.expire}")
    private int expire;
    
    @Autowired
    private KeyConfig keyConfig;
    
    public String generateToken(IJWTInfo jwtInfo) throws Exception{
        return JWTHelper.generateToken(jwtInfo, keyConfig.getUserPriKey(), expire);
    }
    
    public IJWTInfo getInfoFromToken(String token) throws Exception{
        return JWTHelper.getInfoFromToken(token, keyConfig.getUserPubKey());
    }
}
