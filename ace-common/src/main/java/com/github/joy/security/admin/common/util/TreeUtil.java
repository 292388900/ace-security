/*
 * 文 件 名:  TreeUtil.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月22日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.util;

import java.util.ArrayList;
import java.util.List;

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
public class TreeUtil
{
    /**
     * 两层循环实现建树
     * 
     * @param treeNodes 传入的树节点列表
     * @param root
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static <T extends TreeNode> List<T> build(List<T> treeNodes, Object root){
        List<T> trees = new ArrayList<>();
        for(T treeNode : treeNodes){
            if(root.equals(treeNode.getParentId())){
                trees.add(treeNode);
            }
            
            for(T it : treeNodes){
                if(it.getParentId() == treeNode.getId()){
                    if(treeNode.getChildren() == null){
                        treeNode.setChildren(new ArrayList<TreeNode>());
                    }
                    treeNode.add(it);
                }
            }
        }
        return trees;
    }
    
    /**
     * 使用递归方法建树
     * 
     * @param treeNodes
     * @param root
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root){
        List<T> trees = new ArrayList<>();
        for(T treeNode : treeNodes){
            if(root.equals(treeNode.getParentId())){
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }
    
    /**
     * 递归查找子节点
     * 
     * @param treeNode
     * @param treeNodes
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes){
        for(T it : treeNodes){
            if(treeNode.getId() == it.getParentId()){
                if(treeNode.getChildren() == null){
                    treeNode.setChildren(new ArrayList<TreeNode>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
