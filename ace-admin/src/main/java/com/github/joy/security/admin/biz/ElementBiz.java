/*
 * 文 件 名:  ElementBiz.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2017年12月27日
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
import com.github.joy.security.admin.entity.Element;
import com.github.joy.security.admin.mapper.ElementMapper;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2017年12月27日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ElementBiz extends BaseBiz<ElementMapper, Element>
{   
    @Cache(key="permission:ele:u{1}")
    public List<Element> getAuthorityElementByUserId(String userId){
        return mapper.selectAuthorityElementByUserId(userId);
    }
    
    /**
     * 重载方法
     * @return
     */
    @Override
    @Cache(key="permission:ele")
    public List<Element> selectListAll()
    {
        return super.selectListAll();
    }
    
    /**
     * 重载方法
     * @param entity
     */
    @Override
    @CacheClear(keys={"permission:ele", "permission"})
    public void insertSelective(Element entity)
    {
        super.insertSelective(entity);
    }
    
    /**
     * 重载方法
     * @param entity
     */
    @Override
    @CacheClear(keys={"permission:ele", "permission"})
    public void updateSelectiveById(Element entity)
    {
        super.updateSelectiveById(entity);
    }
}
