/*
 * 文 件 名:  JWTHelper.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月3日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.common.util.jwt;

import org.joda.time.DateTime;

import com.github.joy.security.auth.common.constant.CommonConstants;
import com.github.joy.security.auth.common.util.StringHelper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年1月3日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class JWTHelper
{
    private static RsaKeyHelper rsaKeyHelper = new RsaKeyHelper();
    
    /**
     * 密钥加密token
     * 
     * @param jwtInfo
     * @param priKeyPath
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(IJWTInfo jwtInfo, String priKeyPath, int expire)
        throws Exception
    {
        String compactJws = Jwts.builder()
            .setSubject(jwtInfo.getUniqueName())
            .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getId())
            .claim(CommonConstants.JWT_KEY_NAME, jwtInfo.getName())
            .setExpiration(DateTime.now().plusSeconds(expire).toDate())
            .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKeyPath))
            .compact();
        return compactJws;
    }
    
    /**
     * 密钥加密token
     * 
     * @param jwtInfo
     * @param priKey
     * @param expire
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static String generateToken(IJWTInfo jwtInfo, byte[] priKey, int expire)
        throws Exception
    {
        String compactJws = Jwts.builder()
            .setSubject(jwtInfo.getUniqueName())
            .claim(CommonConstants.JWT_KEY_USER_ID, jwtInfo.getId())
            .claim(CommonConstants.JWT_KEY_NAME, jwtInfo.getName())
            .setExpiration(DateTime.now().plusSeconds(expire).toDate())
            .signWith(SignatureAlgorithm.RS256, rsaKeyHelper.getPrivateKey(priKey))
            .compact();
        return compactJws;
    }
    
    /**
     * 公钥解析token
     * 
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, String pubKeyPath)
        throws Exception
    {
        Jws<Claims> claimJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKeyPath)).parseClaimsJws(token);
        return claimJws;
    }
    
    /**
     * 公钥解析token
     * 
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token, byte[] pubKey)
        throws Exception
    {
        Jws<Claims> claimJws = Jwts.parser().setSigningKey(rsaKeyHelper.getPublicKey(pubKey)).parseClaimsJws(token);
        return claimJws;
    }
    
    /**
     * 获取token中的用户信息
     * 
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static IJWTInfo getInfoFromToken(String token, String pubKeyPath)
        throws Exception
    {
        Jws<Claims> clainsJws = parserToken(token, pubKeyPath);
        Claims body = clainsJws.getBody();
        return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_ID)),
            StringHelper.getObjectValue(CommonConstants.JWT_KEY_NAME));
    }
    
    /**
     * 获取token中的用户信息
     * 
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static IJWTInfo getInfoFromToken(String token, byte[] pubKey)
        throws Exception
    {
        Jws<Claims> clainsJws = parserToken(token, pubKey);
        Claims body = clainsJws.getBody();
        return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_ID)),
            StringHelper.getObjectValue(CommonConstants.JWT_KEY_NAME));
    }
}
