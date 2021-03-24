package com.don.controller;/**
 * ClassName:    BaseController
 * Package:    com.don.controller
 * Description:
 * Datetime:    2021/3/8   9:50 下午
 * Author:   tanglintao
 */

import com.don.error.BusinessException;
import com.don.error.EmBusinessError;
import com.don.response.CommonResturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tanglintao
 * @ClassName: BaseController
 * @Date: 2021/03/08 21:50
 */
public class BaseController {
    /**
     *
     */
    public static final String CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";
    /**
     * 吸收未被controller类吸收的exception
     *
     * @param exception
     * @return
     * @throws UnsupportedEncodingException
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(Exception exception) throws UnsupportedEncodingException {
        // 定义map对象接收错误信息
        Map<String, Object> responseData = new HashMap<>(16);
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            responseData.put("errCode", businessException.getErrCode());
            responseData.put("errMsg", businessException.getErrMsg());
        } else {
            responseData.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
            responseData.put("errMsg", EmBusinessError.UNKNOWN_ERROR.getErrMsg());
        }
        return CommonResturnType.create(responseData, "fail");
    }
}
