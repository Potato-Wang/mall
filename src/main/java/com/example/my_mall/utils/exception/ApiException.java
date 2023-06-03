package com.example.my_mall.utils.exception;

import com.example.my_mall.utils.result.ResErrorCode;

public class ApiException extends RuntimeException{
    private ResErrorCode errorCode;

    public  ApiException(ResErrorCode errorCode){
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public ApiException(String msg){
        super(msg);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ResErrorCode getErrorCode() {
        return errorCode;
    }
}
