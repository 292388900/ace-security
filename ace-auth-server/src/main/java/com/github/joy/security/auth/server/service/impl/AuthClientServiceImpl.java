/*
 * 文 件 名:  AuthClientServiceImpl.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月6日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.joy.security.admin.common.exception.auth.ClientInvalidException;
import com.github.joy.security.auth.server.entity.Client;
import com.github.joy.security.auth.server.mapper.ClientMapper;
import com.github.joy.security.auth.server.service.AuthClientService;

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
public class AuthClientServiceImpl implements AuthClientService
{
    @Autowired
    private ClientMapper clientMapper;
    
    /**
     * 重载方法
     * @param clientId
     * @param secret
     * @return
     * @throws Exception
     */
    @Override
    public String apply(String clientId, String secret)
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 重载方法
     * @param clientId
     * @param secret
     * @throws Exception
     */
    @Override
    public void volidate(String clientId, String secret)
        throws Exception
    {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if(client == null || !client.getSecret().equals(secret)){
            throw new ClientInvalidException("Client not found or Client secret is error!");
        }
    }
    
}
