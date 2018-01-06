/*
 * 文 件 名:  ServiceAutoConfig.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月5日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.client.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月5日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ServiceAutoConfig
{
    private byte[] pubKeyByte;
    
    @Value("${auth.client.id:null}")
    private String clientId;
    
    @Value("${auth.client.secret}")
    private String clientSecret;
   
    @Value("${auth.client.token-header}")
    private String tokenHeader;
    
    @Value("${spring.application.name}")
    private String applicationName;

    public byte[] getPubKeyByte()
    {
        return pubKeyByte;
    }

    public void setPubKeyByte(byte[] pubKeyByte)
    {
        this.pubKeyByte = pubKeyByte;
    }

    public String getClientId()
    {
        return "null".equals(clientId)?applicationName:clientId;
    }

    public void setClientId(String clientId)
    {
        this.clientId = clientId;
    }

    public String getClientSecret()
    {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret)
    {
        this.clientSecret = clientSecret;
    }

    public String getTokenHeader()
    {
        return tokenHeader;
    }
    
    public void setTokenHeader(String tokenHeader)
    {
        this.tokenHeader = tokenHeader;
    }

    public String getToken(HttpServletRequest request){
        return request.getHeader(this.getTokenHeader());
    }
}
