/*
 * 文 件 名:  AuthRemoteEvent.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月11日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.common.event;

import java.util.List;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月11日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class AuthRemoteEvent extends RemoteApplicationEvent
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2861889402982547574L;
    
    private List<String> allowedClient;
    
    /** 
     * <默认构造函数>
     */
    public AuthRemoteEvent()
    {
        // TODO Auto-generated constructor stub
    }
    
    public AuthRemoteEvent(Object source, String originService, String destinationService, List<String> allowedClient){
        super(source, originService, destinationService);
        this.allowedClient = allowedClient;
    }
}
