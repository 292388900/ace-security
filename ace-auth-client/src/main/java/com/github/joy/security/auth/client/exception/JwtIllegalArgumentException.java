/*
 * 文 件 名:  JwtIllegalArgumentException.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月3日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.client.exception;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class JwtIllegalArgumentException extends Exception
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 2011089963349066197L;

    public JwtIllegalArgumentException(String s){
        super(s);
    }
}
