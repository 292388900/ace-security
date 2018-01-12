package com.github.joy.security.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.joy.security.admin.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

public interface MenuMapper extends Mapper<Menu>{
    
    /**
     * 根据用户和组的权限关系查找用户可访问菜单
     * 
     * @param userId
     * @return
     * @see [类、类#方法、类#成员]
     */
    public List<Menu> selectAuthorityMenuByUserId(@Param("userId") int userId);
}