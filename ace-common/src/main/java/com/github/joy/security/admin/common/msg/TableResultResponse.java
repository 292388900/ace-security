/*
 * 文 件 名:  TableResultResponse.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2017年12月26日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.msg;

import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2017年12月26日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class TableResultResponse<T> extends BaseResponse
{
    private TableData<T> data;
    
    public TableResultResponse(long total, List<T> rows){
        this.data = new TableData<>(total, rows);
    }
    
    public TableResultResponse(){
        this.data = new TableData<T>();
    }
    
    public TableData<T> getData()
    {
        return data;
    }

    public void setData(TableData<T> data)
    {
        this.data = data;
    }
    
    TableResultResponse<T> total(int total){
        this.data.setTotal(total);
        return this;
    }
    
    TableResultResponse<T> total(List<T> rows){
        this.data.setRows(rows);
        return this;
    }

    @SuppressWarnings("hiding")
    class TableData<T> {
        
        private long total;
        
        private List<T> rows;
        
        public TableData(long total, List<T> rows){
            this.total = total;
            this.rows = rows;
        }
        
        public TableData(){
        }

        public long getTotal()
        {
            return total;
        }

        public void setTotal(long total)
        {
            this.total = total;
        }

        public List<T> getRows()
        {
            return rows;
        }

        public void setRows(List<T> rows)
        {
            this.rows = rows;
        }
        
    }
}
