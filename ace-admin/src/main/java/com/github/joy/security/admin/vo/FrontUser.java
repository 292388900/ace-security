/*
 * 文 件 名:  FrontUser.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月6日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.vo;

import java.util.List;

import com.github.joy.security.api.vo.authority.PermissionInfo;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author 姓名 工号
 * @version [版本号, 2018年1月6日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class FrontUser
{
    private String id;
    
    private String username;
    
    private String name;
    
    private String description;
    
    private String image;
    
    private List<PermissionInfo> menus;
    
    private List<PermissionInfo> elements;
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getImage()
    {
        return image;
    }
    
    public void setImage(String image)
    {
        this.image = image;
    }
    
    public List<PermissionInfo> getMenus()
    {
        return menus;
    }
    
    public void setMenus(List<PermissionInfo> menus)
    {
        this.menus = menus;
    }
    
    public List<PermissionInfo> getElements()
    {
        return elements;
    }
    
    public void setElements(List<PermissionInfo> elements)
    {
        this.elements = elements;
    }
}
