/*
 * 文 件 名:  ServiceAuthFeign.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.joy.security.admin.common.msg.ObjectRestResponse;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@FeignClient(value = "${auth.serviceId}")
public interface ServiceAuthFeign
{
    @PostMapping(value="/client/userPubKey")
    public ObjectRestResponse<byte[]> getUserPublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);
    
    @PostMapping(value="/client/servicePubKey")
    public ObjectRestResponse<byte[]> getServicePublicKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);
}
