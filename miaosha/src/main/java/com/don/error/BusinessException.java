package com.don.error;/**
 * ClassName:    BusinessException
 * Package:    com.don.error
 * Description:
 * Datetime:    2021/3/7   2:21 下午
 * Author:   tanglintao
 */

/**
 * @author: tanglintao
 *
 * @ClassName: BusinessException
 *
 * @Date: 2021/03/07 14:21
 *
 */
public class BusinessException extends Exception implements CommonError {
    private CommonError commonError;
    // 直接接受EmBusiness用于传参构造业务异常
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    // 接受自定义errMsg的方式构造业务异常
    public BusinessException(CommonError commonError, String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
