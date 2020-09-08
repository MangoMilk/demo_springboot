package com.example.springboot.util;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class CipherUtil {

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

}
