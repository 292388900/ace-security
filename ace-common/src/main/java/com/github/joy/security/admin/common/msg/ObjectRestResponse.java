/*
 * 文 件 名:  ObjectRestResponse.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2017年12月26日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.msg;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2017年12月26日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ObjectRestResponse<T> extends BaseResponse
{
    private T data;
    boolean rel;
    
    public T getData()
    {
        return data;
    }
    
    public void setData(T data)
    {
        this.data = data;
    }
    
    public boolean isRel()
    {
        return rel;
    }
    
    public void setRel(boolean rel)
    {
        this.rel = rel;
    }
    
    public ObjectRestResponse<T> rel(boolean rel){
        this.setRel(rel);
        return this;
    }

    public ObjectRestResponse<T> data(T data){
        this.setData(data);
        return this;
    }
}
