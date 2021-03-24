package com.don.error;/**
 * ClassName:    CommonError
 * Package:    com.don.error
 * Description:
 * Datetime:    2021/3/7   2:07 下午
 * Author:   tanglintao
 */

/**
 * @author: tanglintao
 * @ClassName: CommonError
 * @Descption:
 * @Date: 2021/03/07 14:07
 */
public interface CommonError {

    public int getErrCode();

    public String getErrMsg();

    public CommonError setErrMsg(String errMsg);
}
