package com.example.springboot.user.service;

import com.example.springboot.common.util.CommonUtil;
import com.example.springboot.user.dao.UserDomainMapper;
import com.example.springboot.user.domain.UserDomain;
import com.example.springboot.common.util.JwtUtil;
import com.example.springboot.sms.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDomainMapper userDomainMapper;

    @Autowired
    SMSService SMSService;

    public static final byte GENDER_MALE = 1;
    public static final byte GENDER_FEMALE = 2;

    public static final byte STATUS_YES = 1;
    public static final byte STATUS_NO = 0;

    /**
     * register
     * @param username
     * @return
     */
    public Map<String, Object> register(String username) {

        Map<String, Object> res = new HashMap<>();
        UserDomain user = this.addUser(username);

        if (user != null) {
            Map<String,Object> userInfo = new HashMap<>();
            userInfo.put("phone", user.getPhone());
            userInfo.put("username", user.getUsername());
            userInfo.put("avatar_url", user.getAvatarUrl());
            userInfo.put("gender", user.getGender());
            userInfo.put("province", user.getProvince());
            userInfo.put("city", user.getCity());

            res.put("user_info", userInfo);
            res.put("jwt_token", JwtUtil.GenJwt(res));
            this.SMSService.deleteRegisterVerifyCode(username);
        }

        return res;
    }

    /**
     * hasUser
     * @param username
     * @return
     */
    public boolean hasUser(String username) {
        UserDomain user = this.userDomainMapper.selectByPhone(username);

        return user != null ? true : false;
    }

    /**
     * addUser
     * @param username
     * @return
     */
    public UserDomain addUser(String username) {
        Integer now = CommonUtil.GetSecond();
        UserDomain user = new UserDomain();

        user.setPhone(username);
        user.setUsername("u_"+now);
        user.setAvatarUrl("default_avatar.png");
        user.setGender(GENDER_MALE);
        user.setProvince("GD");
        user.setCity("GZ");
        user.setLastLoginedAt(now);
        user.setLastLoginedIp(now);
        user.setCreatedAt(now);
        user.setUpdatedAt(now);
        user.setStatus(STATUS_YES);

        int isSuccess = this.userDomainMapper.insert(user);

        if (isSuccess <= 0) {
            return null;
        }

        return user;
    }
}
