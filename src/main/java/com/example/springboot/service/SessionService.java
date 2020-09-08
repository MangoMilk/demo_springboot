package com.example.springboot.service;

import com.example.springboot.config.CacheKeyConfig;
import com.example.springboot.domain.UserDomain;
import com.example.springboot.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SessionService {

    @Autowired
    RedisUtil redis;

    @Autowired
    UserService userService;

    public final int IS_SUCCESS_YES = 1;
    public final int IS_SUCCESS_NO = 0;

    /**
     * getVerifyCode
     * @param username
     * @return
     */
    public String getVerifyCode(String username) {
        String code = "";
        if (redis.get(this.getVerifyCodeCacheKey(username)) != null) {
            code = (String)redis.get(this.getVerifyCodeCacheKey(username));
        }

        return code;
    }

    /**
     * sendVerifyCode
     * @param username
     * @return
     */
    public Map<String, Object> sendVerifyCode(String username) {
        Map<String, Object> res = new HashMap<>();
        String code = BornUtil.VerifyCode();
        int isSuccess = IS_SUCCESS_NO;

        if (SMSUtil.sendVerificationCode(username, code)) {
            redis.set(this.getVerifyCodeCacheKey(username), code);
            redis.expire(this.getVerifyCodeCacheKey(username),CacheKeyConfig.VERIFY_CODE_CACHE_DURATION);
            isSuccess = IS_SUCCESS_YES;
        }

        res.put("is_success", isSuccess);

        return res;
    }

    /**
     * checkVerifyCode
     * @param username
     * @param code
     * @return
     */
    public Boolean checkVerifyCode(String username, String code) {
        boolean res = false;
        String cacheCode = (String)redis.get(this.getVerifyCodeCacheKey(username));

        if(cacheCode != null &&cacheCode != "" && cacheCode.equals(code)) {
            res = true;
        }

        return res;
    }

    /**
     * getVerifyCodeCacheKey
     * @param username
     * @return
     */
    private String getVerifyCodeCacheKey(String username) {
        return CacheKeyConfig.VERIFY_CODE_CACHE_KEY + username;
    }
}
