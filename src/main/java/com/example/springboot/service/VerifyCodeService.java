package com.example.springboot.service;

import com.example.springboot.config.CacheKeyConfig;
import com.example.springboot.util.BornUtil;
import com.example.springboot.util.RedisUtil;
import com.example.springboot.util.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerifyCodeService {

    @Autowired
    RedisUtil redis;

    public final int IS_SUCCESS_YES = 1;
    public final int IS_SUCCESS_NO = 0;

    /**
     * getRegisterVerifyCode
     * @param username
     * @return
     */
    public String getRegisterVerifyCode(String username) {
        String code = "";
        String key =this.getRegisterVerifyCodeCacheKey(username);
        if (redis.get(key) != null) {
            code = (String)redis.get(key);
        }

        return code;
    }

    /**
     * sendRegisterVerifyCode
     * @param username
     * @return
     */
    public Map<String, Object> sendRegisterVerifyCode(String username) {
        Map<String, Object> res = new HashMap<>();
        int isSuccess = IS_SUCCESS_NO;
        String code = BornUtil.VerifyCode();
        String key = this.getRegisterVerifyCodeCacheKey(username);

        if (SMSUtil.sendVerificationCode(username, code)) {
            redis.set(key, code);
            redis.expire(key, CacheKeyConfig.VERIFY_CODE_CACHE_DURATION);
            isSuccess = IS_SUCCESS_YES;
        }

        res.put("is_success", isSuccess);
        res.put("code", code);

        return res;
    }

    /**
     * checkRegisterVerifyCode
     * @param username
     * @param code
     * @return
     */
    public Boolean checkRegisterVerifyCode(String username, String code) {
        boolean res = false;
        String cacheCode = (String)redis.get(this.getRegisterVerifyCodeCacheKey(username));

        if(cacheCode != null &&cacheCode != "" && cacheCode.equals(code)) {
            res = true;
        }

        return res;
    }

    /**
     * getRegisterVerifyCodeCacheKey
     * @param username
     * @return
     */
    private String getRegisterVerifyCodeCacheKey(String username) {
        return CacheKeyConfig.VERIFY_CODE_CACHE_KEY + username;
    }

    /**
     * deleteRegisterVerifyCode
     * @param username
     */
    public void deleteRegisterVerifyCode(String username) {
        redis.delete(this.getRegisterVerifyCodeCacheKey(username));
    }
}
