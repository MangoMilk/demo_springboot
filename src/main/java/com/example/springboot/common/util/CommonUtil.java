package com.example.springboot.common.util;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.regex.Pattern;

public class CommonUtil {
    // ========== Born ==========
    public static String Born4Code() {
        return "1234";
    }

//    public static String OpenId() {
//
//    }

    // ========== Cipher ==========
    public static String HS256Encode(String text, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(),"HmacSHA256");
            sha256_HMAC.init(secretKey);
            byte[] bytes = sha256_HMAC.doFinal(text.getBytes());
            hash = byteArrayToHexString(bytes);
        }catch (Exception e) {
            // TODO: Need to write log.
            System.out.println("Error CipherUtil.HS256Encode: " + e.getMessage());
        }

        return hash;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

    // ========== Time ==========
    public static Integer GetSecond() {
        return Integer.valueOf(String.valueOf(System.currentTimeMillis()/1000));
    }

    // ========== Verify ==========
    public static boolean VerifyPhone(String phone) {
        Pattern pattern = Pattern.compile("^[1]\\d{10}$");
        return pattern.matcher(phone).matches();
    }

    public static boolean Mail(String mail) {
        Pattern pattern = Pattern.compile("^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$");
        return pattern.matcher(mail).matches();
    }
}
