package com.xie.response;

import java.util.Date;

/**
 * Created by xie on 16/12/12.
 */
public class BaseResponse {
    private final static int SUCCESS_CODE = 0;
    private final static int FAIL_CODE = -1;
    private final static String SUCCESS_MESSAGE = "成功";
    private final static String FAIL_MESSAGE = "错误";

    private int errno;
    private String errmsg;
    private Object data;

    public BaseResponse(int errno, String errmsg, Object data) {
        this.errno = errno;
        this.errmsg = errmsg;
        this.data = data;
    }

    public static BaseResponse ok(Object data) {
        return new BaseResponse(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static BaseResponse ok() {
        return new BaseResponse(SUCCESS_CODE, SUCCESS_MESSAGE, null);
    }

    public static BaseResponse fail(String data) {
        return new BaseResponse(FAIL_CODE, data, null);
    }

    public static BaseResponse fail(int code, String data) {
        return new BaseResponse(code, data, null);
    }

    public static BaseResponse fail(Object data) {
        return new BaseResponse(FAIL_CODE, FAIL_MESSAGE, data);
    }

    public static BaseResponse fail() {
        return new BaseResponse(FAIL_CODE, FAIL_MESSAGE, null);
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
