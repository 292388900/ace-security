/*
 * 文 件 名:  Client.java
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
import javax.persistence.Table;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Table(name="auth_client")
public class Client
{
    @Id
    private Integer id;
    
    private String code;
    
    private String secret;
    
    private String name;
    
    private String locked = "0";
    
    private String description;
    
    private Date crtTime;
    
    private String crtUser;
    
    private String crtName;
    
    private String crtHost;
    
    private Date updTime;
    
    private String updUser;
    
    private String updName;
    
    private String updHost;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getSecret()
    {
        return secret;
    }

    public void setSecret(String secret)
    {
        this.secret = secret;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLocked()
    {
        return locked;
    }

    public void setLocked(String locked)
    {
        this.locked = locked;
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

    public Date getUpdTime()
    {
        return updTime;
    }

    public void setUpdTime(Date updTime)
    {
        this.updTime = updTime;
    }

    public String getUpdUser()
    {
        return updUser;
    }

    public void setUpdUser(String updUser)
    {
        this.updUser = updUser;
    }

    public String getUpdName()
    {
        return updName;
    }

    public void setUpdName(String updName)
    {
        this.updName = updName;
    }

    public String getUpdHost()
    {
        return updHost;
    }

    public void setUpdHost(String updHost)
    {
        this.updHost = updHost;
    }
     
}
