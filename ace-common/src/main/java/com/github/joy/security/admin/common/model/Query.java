/*
 * 文 件 名:  Query.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2017年12月27日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2017年12月27日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Query extends LinkedHashMap<String, Object>
{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;  
    
    // 当前页码
    private int page = 1;
    
    // 每页条数
    private int limit = 10;
    
    public Query(Map<String, Object> params){
        this.putAll(params);
        
        if(params.get("page")!=null){
            this.page = Integer.parseInt(params.get("page").toString());
        }
        
        if(params.get("limit") != null){
            this.limit = Integer.parseInt(params.get("limit").toString());
        }
        
        this.remove("page");
        this.remove("limit");
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getLimit()
    {
        return limit;
    }

    public void setLimit(int limit)
    {
        this.limit = limit;
    }
}
