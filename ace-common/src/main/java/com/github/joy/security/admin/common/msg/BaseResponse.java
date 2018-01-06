/*
 * 文 件 名:  BaseResponse.java
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
public class BaseResponse
{
    private int status = 200;
    private String message;
    
    public BaseResponse(int status, String message){
        this.status = status;
        this.message = message;
    }
    
    public BaseResponse()
    {
        
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
