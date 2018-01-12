/*
 * 文 件 名:  ClientController.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.joy.security.admin.common.msg.ObjectRestResponse;
import com.github.joy.security.auth.server.config.KeyConfig;
import com.github.joy.security.auth.server.service.AuthClientService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@RestController
@RequestMapping("client")
public class ClientController
{
    @Autowired
    private AuthClientService authClientService;
    
    @Autowired
    private KeyConfig keyConfig;
    
    @PostMapping("/userPubKey")
    public ObjectRestResponse<byte[]> getUserPublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret) throws Exception{
        authClientService.volidate(clientId, secret);
        return new ObjectRestResponse<byte[]>().data(keyConfig.getUserPubKey());
    }
    
    @PostMapping("/servicePubKey")
    public ObjectRestResponse<byte[]> getServicePublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret) throws Exception{
        authClientService.volidate(clientId, secret);
        return new ObjectRestResponse<byte[]>().data(keyConfig.getServicePubKey());
    }
}
