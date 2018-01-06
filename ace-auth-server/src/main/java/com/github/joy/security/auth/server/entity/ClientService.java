/*
 * 文 件 名:  ClientService.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月6日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.server.entity;

import java.util.Date;

import javax.persistence.Id;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ClientService
{
    @Id
    private Integer id;
    
    private String serviceId;
    
    private String clientId;
    
    private String description;
    
    private Date crtTime;
    
    private String crtUser;
    
    private String crtName;
    
    private String crtHost;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getServiceId()
    {
        return serviceId;
    }

    public void setServiceId(String serviceId)
    {
        this.serviceId = serviceId;
    }

    public String getClientId()
    {
        return clientId;
    }

    public void setClientId(String clientId)
    {
        this.clientId = clientId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getCrtTime()
    {
        return crtTime;
    }

    public void setCrtTime(Date crtTime)
    {
        this.crtTime = crtTime;
    }

    public String getCrtUser()
    {
        return crtUser;
    }

    public void setCrtUser(String crtUser)
    {
        this.crtUser = crtUser;
    }

    public String getCrtName()
    {
        return crtName;
    }

    public void setCrtName(String crtName)
    {
        this.crtName = crtName;
    }

    public String getCrtHost()
    {
        return crtHost;
    }

    public void setCrtHost(String crtHost)
    {
        this.crtHost = crtHost;
    }
}
