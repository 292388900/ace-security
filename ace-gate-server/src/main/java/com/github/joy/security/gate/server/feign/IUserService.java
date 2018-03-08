/*
 * 文 件 名:  IUserService.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年2月2日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.gate.server.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.joy.security.api.vo.authority.PermissionInfo;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年2月2日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@FeignClient(value="ace-admin")
public interface IUserService
{
    @GetMapping(value="/api/user/{username}/permissions")
    public List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username);

    @GetMapping(value="/api/permissions")
    public List<PermissionInfo> getAllPermissionInfo();
}
