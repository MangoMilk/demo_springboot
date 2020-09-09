package com.example.springboot.user.controller;

import com.example.springboot.common.config.ErrorConfig;
import com.example.springboot.common.util.CommonUtil;
import com.example.springboot.user.service.UserService;
import com.example.springboot.common.util.FOP;
import com.example.springboot.sms.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    SMSService SMSService;

    /**
     * register
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public Map<String,Object> register(@RequestParam("username") String username, @RequestParam("code") String code) {

        if (!CommonUtil.VerifyPhone(username)) {
            return FOP.fail(ErrorConfig.WRONG_PHONE_CODE, ErrorConfig.WRONG_PHONE_MEG);
        }

        if (!this.SMSService.checkRegisterVerifyCode(username, code)) {
            return FOP.fail(ErrorConfig.VERIFY_CODE_INVALID_CODE, ErrorConfig.VERIFY_CODE_INVALID_MSG);
        }

        if (this.userService.hasUser(username)) {
            return FOP.fail(ErrorConfig.USER_EXISTED_INVALID_CODE, ErrorConfig.USER_EXISTED_INVALID_MSG);
        }

        Map<String, Object> res = this.userService.register(username);

        return FOP.success(res);
    }
}
