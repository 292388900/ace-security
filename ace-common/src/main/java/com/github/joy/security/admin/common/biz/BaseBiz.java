/*
 * 文 件 名:  BaseBiz.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2017年12月25日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.biz;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.joy.security.admin.common.model.Query;
import com.github.joy.security.admin.common.msg.TableResultResponse;
import com.github.joy.security.admin.common.util.EntityUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2017年12月25日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public abstract class BaseBiz<M extends Mapper<T>, T>
{
    @Autowired
    protected M mapper;
    
    public void setMapper(M mapper){
        this.mapper = mapper;
    }
    
    public T selectOne(T entity){
        return mapper.selectOne(entity);
    }
    
    public T selectById(Object id){
        return mapper.selectByPrimaryKey(id);
    }
    
    public List<T> selectList(T entity){
        return mapper.select(entity);
    }
    
    public List<T> selectListAll(){
        return mapper.selectAll();
    }
    
    public Long selectCount(T entity){
        return new Long(mapper.selectCount(entity));
    }
    
    public void insert(T entity){
        EntityUtil.setCreateAndUpdateInfo(entity);
        mapper.insert(entity);
    }
    
    public void insertSelective(T entity){
        EntityUtil.setCreateAndUpdateInfo(entity);
        mapper.insertSelective(entity);
    }
    
    public void delete(T entity){
        mapper.delete(entity);
    }
    
    public void deleteById(Object id){
        mapper.deleteByPrimaryKey(id);
    }
    
    public void updateById(T entity){
        EntityUtil.setUpdatedInfo(entity);
        mapper.updateByPrimaryKey(entity);
    }
    
    public void updateSelectiveById(T entity){
        EntityUtil.setUpdatedInfo(entity);
        mapper.updateByPrimaryKeySelective(entity);
    }
    
    public List<T> selectByExample(Object example){
        return mapper.selectByExample(example);
    }
    
    public int selectCountByExample(Object example){
        return mapper.selectCountByExample(example);
    }
    
    @SuppressWarnings("unchecked")
    public TableResultResponse<T> selectByQuery(Query query){
        Class<T> clazz = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = new Example(clazz);
        Example.Criteria criteria = example.createCriteria();
        
        for(Map.Entry<String, Object> entry : query.entrySet()){
            criteria.andLike(entry.getKey(), "%" + entry.getValue() + "%");
        }
        
        Page<Object> result = PageHelper.startPage(query.getPage(), query.getLimit());
        List<T> list = mapper.selectByExample(example);
        return new TableResultResponse<>(result.getTotal(), list);
    }
}
