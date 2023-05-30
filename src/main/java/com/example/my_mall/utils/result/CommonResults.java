package com.example.my_mall.utils.result;

/*
 *将服务返回的各种数据对象进行封装，以同一个类提供给下游服务
 * 同时提供一些判断上游服务结果状态的方法
 */


public class CommonResults<T> {

    //状态码
    private long status;

    private String msg;
    //数据对象
    private T data;

    protected CommonResults(){}

    protected CommonResults(long status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    //成功返回，成功返回附带信息，失败返回，失败返回附带信息
    //失败:参数失败，未登录，无权限

    public static <T> CommonResults<T> success(T data){
        return new CommonResults<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    public static <T> CommonResults<T> success(T data, String msg){
        return new CommonResults<T>(ResultCode.SUCCESS.getCode(), msg, data);
    }


    public static <T> CommonResults<T> failed(String msg){
        return new CommonResults<T>(ResultCode.FAILED.getCode(), msg, null);
    }

    public static <T> CommonResults<T> failed(ResErrorCode errorCode){
        return new CommonResults<T>(errorCode.getCode(), errorCode.getMsg(), null);
    }

    public static <T> CommonResults<T> failed(ResErrorCode errorCode, String msg){
        return new CommonResults<T>(errorCode.getCode(), msg, null);
    }

    public static <T> CommonResults<T> failed(){
        return failed(ResultCode.FAILED);
    }

    public static <T> CommonResults<T> invalid(){
        return failed(ResultCode.VALIDATE_FAILED);
    }

    public static <T> CommonResults<T> invalid(String msg){
        return failed(ResultCode.VALIDATE_FAILED, msg);
    }

    public static <T> CommonResults<T>  unauthorized(T data){
        return new CommonResults<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMsg(), data);
    }

    public static <T> CommonResults<T> unauthorized(String msg, T data){
        return new CommonResults<T>(ResultCode.UNAUTHORIZED.getCode(), msg, data);
    }

    public static <T> CommonResults<T> forbidden(T data){
        return new CommonResults<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMsg(), data);
    }

    public static <T> CommonResults<T> forbidden(String msg, T data){
        return new CommonResults<T>(ResultCode.FORBIDDEN.getCode(), msg, data);
    }


    public long getStatus(){
        return status;
    }

    public void setStatus(Long status){
        this.status = status;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }


}
