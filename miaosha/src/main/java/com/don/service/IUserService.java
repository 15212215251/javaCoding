package com.don.service;/**
 * ClassName:    IUserService
 * Package:    com.don.service
 * Description:
 * Datetime:    2021/3/7   12:04 下午
 * Author:   tanglintao
 */

import com.don.error.BusinessException;
import com.don.service.model.UserModel;

/**
 * @author: tanglintao
 * @ClassName: IUserService
 * @Descption:
 * @Date: 2021/03/07 12:04
 */
public interface IUserService {

    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BusinessException;

    UserModel vaildLogin(String telephone, String encrptpassword) throws BusinessException;
}
