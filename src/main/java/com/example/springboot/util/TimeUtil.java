package com.example.springboot.util;

public class TimeUtil {

    public static Integer GetSecond() {
        return Integer.valueOf(String.valueOf(System.currentTimeMillis()/1000));
    }
}
