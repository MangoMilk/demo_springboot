package com.example.springboot.util;

import java.util.regex.Pattern;

public class VerifyUtil {

    public static boolean Phone(String phone) {
        Pattern pattern = Pattern.compile("^[1]\\d{10}$");
        return pattern.matcher(phone).matches();
    }

    public static boolean Mail(String mail) {
        Pattern pattern = Pattern.compile("^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$");
        return pattern.matcher(mail).matches();
    }
}
