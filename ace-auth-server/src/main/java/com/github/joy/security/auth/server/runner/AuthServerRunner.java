/*
 * 文 件 名:  AuthServerRunner.java
 * 版    权:  SSSCC Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  
 * 修改时间:  2018年1月6日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.github.joy.security.auth.server.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import com.github.joy.security.auth.common.util.jwt.RsaKeyHelper;
import com.github.joy.security.auth.server.config.KeyConfig;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2018年1月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Configuration
public class AuthServerRunner implements CommandLineRunner
{
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    
    @Autowired
    private KeyConfig keyConfig;
    
    private static final String REDIS_USER_PRI_KEY = "AG:AUTH:JWT:PRI";
    private static final String REDIS_USER_PUB_KEY = "AG:AUTH:JWT:PUB";
    private static final String REDIS_SERVICE_PRI_KEY = "AG:AUTH:CLIENT:PRI";
    private static final String REDIS_SERVICE_PUB_KEY = "AG:AUTH:CLIENT:PUB";
    
    
    /**
     * 重载方法
     * @param arg0
     * @throws Exception
     */
    @Override
    public void run(String... arg0)
        throws Exception
    {
        if(redisTemplate.hasKey(REDIS_USER_PRI_KEY)){
            keyConfig.setUserPriKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PRI_KEY).toString()));
            keyConfig.setUserPubKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PUB_KEY).toString()));
            keyConfig.setServicePriKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PRI_KEY).toString()));
            keyConfig.setServicePubKey(RsaKeyHelper.toBytes(redisTemplate.opsForValue().get(REDIS_SERVICE_PUB_KEY).toString()));
        }else {
            Map<String, byte[]> keyMap = RsaKeyHelper.generateKey(keyConfig.getUserSecret());
            keyConfig.setUserPriKey(keyMap.get("pri"));
            keyConfig.setUserPubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(REDIS_USER_PRI_KEY, RsaKeyHelper.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_USER_PUB_KEY, RsaKeyHelper.toHexString(keyMap.get("pub")));
            keyMap = RsaKeyHelper.generateKey(keyConfig.getServiceSecret());
            keyConfig.setServicePriKey(keyMap.get("pri"));
            keyConfig.setServicePubKey(keyMap.get("pub"));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PRI_KEY, RsaKeyHelper.toHexString(keyMap.get("pri")));
            redisTemplate.opsForValue().set(REDIS_SERVICE_PUB_KEY, RsaKeyHelper.toHexString(keyMap.get("pub")));
        }
    }
    
}
