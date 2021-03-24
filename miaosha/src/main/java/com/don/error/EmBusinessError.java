package com.don.error;

/**
 * ClassName:    EmBusinessError
 * Package:    com.don.error
 * Description:
 * Datetime:    2021/3/7   2:09 下午
 * Author:   tanglintao
 */
public enum EmBusinessError implements CommonError {
    // 通用错误类型
    PARAMETER_VAILDATION_ERROR(00001, "参数不合法"),

    // 1000开头为用户相关错误信息
    USER_NOT_EXIST(10001, "用户不存在"),

    UNKNOWN_ERROR(10002, "未知错误"),

    USER_LOGIN_FAIL(20003, "用户手机号或者密码不存在");

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
