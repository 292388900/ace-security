/*
 * 文 件 名:  PermissionInfo.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月6日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.api.vo.authority;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class PermissionInfo implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 938282988958969360L;
    
    private String code;
    private String type;
    private String uri;
    private String method;
    private String name;
    private String menu;
    
    public String getCode()
    {
        return code;
    }
    public void setCode(String code)
    {
        this.code = code;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getUri()
    {
        return uri;
    }
    public void setUri(String uri)
    {
        this.uri = uri;
    }
    public String getMethod()
    {
        return method;
    }
    public void setMethod(String method)
    {
        this.method = method;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getMenu()
    {
        return menu;
    }
    public void setMenu(String menu)
    {
        this.menu = menu;
    }
}
