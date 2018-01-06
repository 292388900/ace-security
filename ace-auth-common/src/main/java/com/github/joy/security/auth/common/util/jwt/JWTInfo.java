/*
 * 文 件 名:  JWTInfo.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月3日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.common.util.jwt;

import java.io.Serializable;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月3日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class JWTInfo implements Serializable, IJWTInfo
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -4949995321398871639L;
    
    private String username;
    private String userId;
    private String name;
    
    public JWTInfo(String username, String userId, String name)
    {
        this.username = username;
        this.userId = userId;
        this.name = name;
    }
    
    /**
     * 重载方法
     * @return
     */
    @Override
    public String getUniqueName()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * 重载方法
     * @return
     */
    @Override
    public String getId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    /**
     * 重载方法
     * @return
     */
    @Override
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * 重载方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass()!=obj.getClass()){
            return false;
        }
        
        JWTInfo jwtInfo = (JWTInfo)obj;
        if(username != null ? !username.equals(jwtInfo.username) : jwtInfo.username != null){
            return false;
        }
        return userId!=null?userId.equals(jwtInfo.userId) : jwtInfo.userId == null;
    }
    
    /**
     * 重载方法
     * @return
     */
    @Override
    public int hashCode()
    {
        int result = username!=null?username.hashCode():0;
        result = 31 * result + (userId != null? userId.hashCode():0);
        return result;
    }
}
