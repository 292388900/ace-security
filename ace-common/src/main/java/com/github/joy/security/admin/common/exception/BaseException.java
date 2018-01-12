/*
 * 文 件 名:  BaseException.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月9日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.exception;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月9日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class BaseException extends RuntimeException
{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 575954308867190663L;
    
    private int status = 200;

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
    
    /** 
     * <默认构造函数>
     */
    public BaseException()
    {
    }
    
    public BaseException(String message, int status){
        super(message);
        this.status = status;
    }
    
    public BaseException(String message){
        super(message);
    }
    
    public BaseException(String message, Throwable cause){
        super(message, cause);
    }
    
    public BaseException(Throwable cause){
        super(cause);
    }
    
    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
