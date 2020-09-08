package com.example.springboot.util;

import java.util.HashMap;
import java.util.Map;

public class FOP {

    public static Map<String, Object> success(Map<String, Object> content) {
        return FOP.response(0,"success",content);
    }

    public static Map<String, Object> fail(int code, String message) {
        return FOP.response(code, message,null);
    }

    private static Map<String, Object> response(int code, String message, Map<String, Object> content) {
        Map<String,Object> res = new HashMap<>();
        res.put("code",code);
        res.put("message",message);
        res.put("content",content);

        return res;
    }
}
