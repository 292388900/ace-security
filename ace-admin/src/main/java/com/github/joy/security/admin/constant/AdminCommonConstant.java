/*
 * 文 件 名:  AdminCommonConstant.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月11日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.admin.constant;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月11日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class AdminCommonConstant
{
    public final static int ROOT = -1;
    
    public static interface RESOURCE_TYPE{
        String MENU = "menu";
        String BTN = "button";
    }
    
    public static interface RESOURCE_REQUEST_METHOD{
        String GET = "GET";
        String PUT = "PUT";
        String DELETE = "DELETE";
        String POST = "POST";
    }
    
    public final static String RESOURCE_ACTION_VISIT = "访问";
}
