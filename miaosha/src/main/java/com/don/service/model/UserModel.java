package com.don.service.model;/**
 * ClassName:    UserModel
 * Package:    com.don.service.model
 * Description:
 * Datetime:    2021/3/7   12:08 下午
 * Author:   tanglintao
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: tanglintao
 *
 * @ClassName: UserModel
 *
 * @Date: 2021/03/07 12:08
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserModel {
    private Integer id;
    private String name;
    private Byte gender;
    private Integer age;
    private String telephone;
    private String registerModel;
    private String thirdPartId;
    private String encrptPassword;
}
