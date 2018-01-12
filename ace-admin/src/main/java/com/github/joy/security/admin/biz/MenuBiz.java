/*
 * 文 件 名:  MenuBiz.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月11日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.cache.annotation.Cache;
import com.ace.cache.annotation.CacheClear;
import com.github.joy.security.admin.common.biz.BaseBiz;
import com.github.joy.security.admin.constant.AdminCommonConstant;
import com.github.joy.security.admin.entity.Menu;
import com.github.joy.security.admin.mapper.MenuMapper;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月11日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuBiz extends BaseBiz<MenuMapper, Menu>
{
    /**
     * 重载方法
     * @return
     */
    @Override
    @Cache(key="permission:menu")
    public List<Menu> selectListAll()
    {
        return super.selectListAll();
    }
    
    /**
     * 重载方法
     * @param entity
     */
    @Override
    @CacheClear(keys={"permission:menu", "permission"})
    public void insertSelective(Menu entity)
    {
        if(AdminCommonConstant.ROOT == entity.getParentId()){
            entity.setPath("/" + entity.getCode());
        }else {
            Menu parent = this.selectById(entity.getParentId());
            entity.setPath(parent.getPath() + "/" + entity.getCode());
        }
        super.insertSelective(entity);
    }
    
    /**
     * 重载方法
     * @param entity
     */
    @Override
    @CacheClear(keys={"permission:menu", "permission"})
    public void updateById(Menu entity)
    {
        if(AdminCommonConstant.ROOT == entity.getParentId()){
            entity.setPath("/" + entity.getCode());
        }else {
            Menu parent = this.selectById(entity.getParentId());
            entity.setPath(parent.getPath() + "/" + entity.getCode());
        }
        super.updateById(entity);
    }
    
    /**
     * 重载方法
     * @param entity
     */
    @Override
    @CacheClear(keys={"permission:menu", "permission"})
    public void updateSelectiveById(Menu entity)
    {
        super.updateSelectiveById(entity);
    }
    
    /**
     * 获取用户可以访问的菜单
     * 
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<Menu> getUserAuthorityMenuByUserId(int id){
        return mapper.selectAuthorityMenuByUserId(id);
    }
}
