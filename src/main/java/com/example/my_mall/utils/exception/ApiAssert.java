package com.example.my_mall.utils.exception;

import com.example.my_mall.utils.result.ResErrorCode;

public class ApiAssert {
    public static void fail(String msg){
        throw new ApiException(msg);
    }
    public static void fail(ResErrorCode errorCode){
        throw new ApiException(errorCode);
    }
}
