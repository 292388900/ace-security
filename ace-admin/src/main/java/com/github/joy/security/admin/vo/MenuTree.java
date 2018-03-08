/*
 * 文 件 名:  MenuTree.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月22日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.vo;

import com.github.joy.security.admin.common.vo.TreeNode;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月22日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class MenuTree extends TreeNode
{
    String icon;
    
    String title;
    
    String href;
    
    boolean spread = false;
    
    String path;
    
    String component;
    
    String authority;
    
    String redirect;
    
    String code;
    
    String label;

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getHref()
    {
        return href;
    }

    public void setHref(String href)
    {
        this.href = href;
    }

    public boolean isSpread()
    {
        return spread;
    }

    public void setSpread(boolean spread)
    {
        this.spread = spread;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getComponent()
    {
        return component;
    }

    public void setComponent(String component)
    {
        this.component = component;
    }

    public String getAuthority()
    {
        return authority;
    }

    public void setAuthority(String authority)
    {
        this.authority = authority;
    }

    public String getRedirect()
    {
        return redirect;
    }

    public void setRedirect(String redirect)
    {
        this.redirect = redirect;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }
    
    /** 
     * <默认构造函数>
     */
    public MenuTree()
    {
        // TODO Auto-generated constructor stub
    }
    
    public MenuTree(int id, String name, int parentId){
        this.id = id;
        this.parentId = parentId;
        this.title = name;
        this.label = name;
    }
    
    public MenuTree(int id, String name, MenuTree parent){
        this.id = id;
        this.parentId = parent.getId();
        this.title = name;
        this.label = name;
    }
}
