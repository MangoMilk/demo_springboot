package com.example.springboot.controller;

import com.example.springboot.config.ErrorConfig;
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
public class VerifyCodeController {

    @Autowired
    VerifyCodeService service;

    /**
     * send verify code
     */
    @RequestMapping(value = "/api/verify_code", method = RequestMethod.POST)
    public Map<String,Object> verifyCode(@RequestParam("username") String username) {

        if (!VerifyUtil.Phone(username)) {
            return FOP.fail(ErrorConfig.WRONG_PHONE_CODE, ErrorConfig.WRONG_PHONE_MEG);
        }

        if (this.service.getRegisterVerifyCode(username) != "") {
            return FOP.fail(ErrorConfig.VERIFY_CODE_OFTEN_CODE, ErrorConfig.VERIFY_CODE_OFTEN_MSG);
        }

        Map<String, Object> res = this.service.sendRegisterVerifyCode(username);

        return FOP.success(res);
    }
}
