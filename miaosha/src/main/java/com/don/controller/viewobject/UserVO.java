package com.don.controller.viewobject;/**
 * ClassName:    UserVO
 * Package:    com.don.controller.viewobject
 * Description:
 * Datetime:    2021/3/7   1:40 下午
 * Author:   tanglintao
 */

import lombok.Data;

/**
 * @author: tanglintao
 * @ClassName: UserVO
 * @Date: 2021/03/07 13:40
 */
@Data
public class UserVO {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户性别
     */
    private Byte gender;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 移动电话
     */
    private String telephone;


}
