/*
 * 文 件 名:  CommonConstant.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2017年12月27日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.common.constant;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2017年12月27日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class CommonConstant
{
    public static interface CONTEXT_KEY{
        String USER = "currentUser";
        String USER_ID = "currentUserId";
        String USER_NAME = "currentUserName";
        String USER_TOKEN = "currentUserToken";
    }
    
    public static int PW_ENCORDER_SALT = 12;
    
    //异常码
    public static interface EX_CODE{
        Integer TOKEN_ERROR = 40101;
        Integer USER_INVALID = 40102;
        Integer CLIENT_INVALID = 40131;
        Integer CLIENT_FORBIDDEN = 40331;
        Integer OTHER = 500;
    }
}
