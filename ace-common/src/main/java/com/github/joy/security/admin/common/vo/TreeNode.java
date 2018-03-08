/*
 * 文 件 名:  TreeNode.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月22日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.vo;

import java.util.List;
import java.util.ArrayList;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月22日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class TreeNode
{
    protected int id;
    protected int parentId;
    List<TreeNode> children = new ArrayList<TreeNode>();
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getParentId()
    {
        return parentId;
    }
    public void setParentId(int parentId)
    {
        this.parentId = parentId;
    }
    public List<TreeNode> getChildren()
    {
        return children;
    }
    public void setChildren(List<TreeNode> children)
    {
        this.children = children;
    }
    
    public void add(TreeNode node){
        children.add(node);
    }
}
