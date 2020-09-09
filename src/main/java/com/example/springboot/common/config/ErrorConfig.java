package com.example.springboot.common.config;

public class ErrorConfig {
    public static final int WRONG_PHONE_CODE = 1001;
    public static final String WRONG_PHONE_MEG = "Phone number is wrong.";

    public static final int VERIFY_CODE_OFTEN_CODE = 1002;
    public static final String VERIFY_CODE_OFTEN_MSG = "Get code too often.";

    public static final int VERIFY_CODE_INVALID_CODE = 1003;
    public static final String VERIFY_CODE_INVALID_MSG = "Code is invalid.";

    public static final int USER_EXISTED_INVALID_CODE = 1004;
    public static final String USER_EXISTED_INVALID_MSG = "User is existed.";
}
