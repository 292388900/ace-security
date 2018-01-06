/*
 * 文 件 名:  UserBiz.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月3日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.biz;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ace.cache.annotation.Cache;
import com.ace.cache.annotation.CacheClear;
import com.github.joy.security.admin.common.biz.BaseBiz;
import com.github.joy.security.admin.common.constant.CommonConstant;
import com.github.joy.security.admin.entity.User;
import com.github.joy.security.admin.mapper.UserMapper;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserBiz extends BaseBiz<UserMapper, User>
{   
    @Override
    public void insertSelective(User entity){
        String password = new BCryptPasswordEncoder(CommonConstant.PW_ENCORDER_SALT).encode(entity.getPassword());
        entity.setPassword(password);
        super.insertSelective(entity);
    }
    
    @Override
    @CacheClear(pre="user{1.username}")
    public void updateSelectiveById(User entity){
        super.updateSelectiveById(entity);
    }
    
    /**
     * 根据用户名获取用户信息
     * 
     * @param username
     * @return
     * @see [类、类#方法、类#成员]
     */
    @Cache(key="user{1}")
    public User getUserByUsername(String username){
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }
}
