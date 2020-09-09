package com.example.springboot.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    public static final String ISS = "Sheepherder JWT"; // 签发人
    public static final int EXPIRE = 7200; // 过期时间
    public static final String AUD = "";    // audience 收众，接收jwt的一方
    public static final String SUB = "";    // subject: 主题，该jwt面向的用户
    public static final String NBF = "";    // not before: 生效时间
    public static final String JTI = "";    // jwt id: 编号

    public static String GenJwt(Map<String, Object> payload){
        String jwt = "";

        try {
            int issueAt = CommonUtil.GetSecond();

            // payload
            payload.put("iss", JwtUtil.ISS);
            payload.put("iat", issueAt);
            payload.put("exp", 0);  // TODO: issueAt + JwtUtil.EXPIRE
            payload.put("aud", JwtUtil.AUD);
            payload.put("sub", JwtUtil.SUB);
//        payload.put("jti", JwtUtil.SUB);
//        payload.put("nbf", JwtUtil.SUB);

            String payloadStr = JSON.toJSONString(payload);
            byte[] payloadByteArr = payloadStr.getBytes("UTF-8");
            payloadStr = (Base64.getEncoder()).encodeToString(payloadByteArr);
            payload.remove("iss");
            payload.remove("iat");
            payload.remove("exp");
            payload.remove("aud");
            payload.remove("sub");

            // header
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");

            String headerStr = (new JSONObject(header)).toString();
            byte[] headerByteArr = headerStr.getBytes("UTF-8");
            headerStr = (Base64.getEncoder()).encodeToString(headerByteArr);

            // package
            jwt = headerStr + "." + payloadStr;
            String secret = "Sheepherder"; // TODO: encrypt secret.
            String sign = CommonUtil.HS256Encode(jwt, secret);
            jwt += "." + sign;

        }catch (Exception e){
            //TODO: Need to write log.
            System.out.println("Error JwtUtil.GenJwt: " + e.getMessage());
        }

        return jwt;
    }

    // TODO: return reason.
    public static boolean CheckJwt(String jwt) {
        if (jwt == "") {
            return false;
        }

        String[] jwtArr = jwt.split(".");
        if (jwtArr.length <  3) {
            return false;
        }

        String header = jwtArr[0];
        String payload = jwtArr[1];
        String sign = jwtArr[2];
        String secret = "Sheepherder"; // TODO: encrypt secret.

        if (sign != CommonUtil.HS256Encode(header+"."+payload, secret)) {
            return false;
        }

        String payloadStr = (Base64.getDecoder()).decode(payload).toString();

        Map<String, Object> payloadData = JSONObject.parseObject(payloadStr);

        if ((int)payloadData.get("uid") == 0) {
            return false;
        }

        // TODO: Check expire.

        return true;
    }
}
