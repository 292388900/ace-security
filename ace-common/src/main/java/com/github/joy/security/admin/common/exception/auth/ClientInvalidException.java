/*
 * 文 件 名:  ClientInvalidException.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月9日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.exception.auth;

import com.github.joy.security.admin.common.constant.CommonConstant;
import com.github.joy.security.admin.common.exception.BaseException;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月9日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ClientInvalidException extends BaseException
{

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4727803142908819638L;
    
    /** 
     * <默认构造函数>
     */
    public ClientInvalidException(String message)
    {
        super(message, CommonConstant.EX_CODE.CLIENT_INVALID);
    }
}
