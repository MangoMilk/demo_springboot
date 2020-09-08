package com.example.springboot.controller;

import com.example.springboot.config.ErrorConfig;
import com.example.springboot.service.UserService;
import com.example.springboot.service.VerifyCodeService;
import com.example.springboot.util.FOP;
import com.example.springboot.util.VerifyUtil;
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
    VerifyCodeService verifyCodeService;

    /**
     * register
     */
    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public Map<String,Object> register(@RequestParam("username") String username, @RequestParam("code") String code) {

        // P0: Phone register, send a code to user's phone to confirm.
        if (!VerifyUtil.Phone(username)) {
            return FOP.fail(ErrorConfig.WRONG_PHONE_CODE, ErrorConfig.WRONG_PHONE_MEG);
        }

        if (!this.verifyCodeService.checkRegisterVerifyCode(username, code)) {
            return FOP.fail(ErrorConfig.VERIFY_CODE_INVALID_CODE, ErrorConfig.VERIFY_CODE_INVALID_MSG);
        }

        if (this.userService.hasUser(username)) {
            return FOP.fail(ErrorConfig.USER_EXISTED_INVALID_CODE, ErrorConfig.USER_EXISTED_INVALID_MSG);
        }

        Map<String, Object> res = this.userService.register(username);

        return FOP.success(res);
    }
}
