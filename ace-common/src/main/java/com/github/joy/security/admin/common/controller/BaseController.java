/*
 * 文 件 名:  BaseController.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2017年12月27日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.joy.security.admin.common.biz.BaseBiz;
import com.github.joy.security.admin.common.model.Query;
import com.github.joy.security.admin.common.msg.ObjectRestResponse;
import com.github.joy.security.admin.common.msg.TableResultResponse;
import com.github.joy.security.admin.common.util.ContextUtil;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2017年12月27日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@SuppressWarnings({"rawtypes", "hiding"})
public class BaseController<Biz extends BaseBiz, Entity>
{
    @Autowired
    protected HttpServletRequest request;
    
    @Autowired
    protected Biz baseBiz;
    
    @PostMapping
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ObjectRestResponse<Entity> add(@RequestBody Entity entity){
        baseBiz.insertSelective(entity);
        return new ObjectRestResponse<Entity>();
    }
    
    @GetMapping(value="/{id}")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ObjectRestResponse<Entity> get(@PathVariable int id){
        ObjectRestResponse<Entity> response = new ObjectRestResponse<>();
        Object object = baseBiz.selectById(id);
        return response.data((Entity)object);
    }
    
    @PutMapping(value="/{id}")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ObjectRestResponse<Entity> update(@RequestBody Entity entity){
        baseBiz.updateSelectiveById(entity);
        return new ObjectRestResponse<Entity>();
    }
    
    @DeleteMapping(value="/{id}")
    @ResponseBody
    public ObjectRestResponse<Entity> remove(@PathVariable int id){
        baseBiz.deleteById(id);
        return new ObjectRestResponse<Entity>();
    }
    
    @SuppressWarnings("unchecked")
    @GetMapping(value="/all")
    @ResponseBody
    public List<Entity> all(){
        return baseBiz.selectListAll();
    }
    
    @GetMapping(value="/page")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params){
        Query query = new Query(params);
        return baseBiz.selectByQuery(query);
    }
    
    public String getCurrentUser(){
        return ContextUtil.getUser();
    }
}
