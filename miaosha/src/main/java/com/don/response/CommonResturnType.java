package com.don.response;/**
 * ClassName:    CommonResturnType
 * Package:    com.don.response
 * Description:
 * Datetime:    2021/3/7   1:56 下午
 * Author:   tanglintao
 */

import lombok.Data;

/**
 * @author: tanglintao
 * @ClassName: CommonResturnType
 * @Date: 2021/03/07 13:56
 */
@Data
public class CommonResturnType {
    // 对呀的请求返回结果 success 或者fail
    private String status;
    // 若status 是success则返回正确的数据格式。若为fail，则返回错误信息
    private Object data;

    public static CommonResturnType create(Object result) {
        return CommonResturnType.create(result, "success");
    }

    public static CommonResturnType create(Object result, String status) {
        CommonResturnType type = new CommonResturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }
}
