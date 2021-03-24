package com.don.service.impl;/**
 * ClassName:    UserServiceImpl
 * Package:    com.don.service.impl
 * Description:
 * Datetime:    2021/3/7   12:05 下午
 * Author:   tanglintao
 */

import com.don.dao.UserDOMapper;
import com.don.dao.UserPasswordDOMapper;
import com.don.dataobject.UserDO;
import com.don.dataobject.UserPasswordDO;
import com.don.error.BusinessException;
import com.don.error.EmBusinessError;
import com.don.service.IUserService;
import com.don.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: tanglintao
 * @ClassName: UserServiceImpl
 * @Date: 2021/03/07 12:05
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired(required = false)
    private UserDOMapper userDOMapper;

    @Autowired(required = false)
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if (userDO == null) {
            return null;
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        // 通过用户id获取用户加密密码
        return convertFromDataObject(userDO, userPasswordDO);
    }

    @Override
    @Transactional
    public void register(UserModel userModel) throws BusinessException {
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VAILDATION_ERROR);
        }
        if (StringUtils.isEmpty(userModel.getName())
            || userModel.getAge() == null
            || userModel.getGender() == null
            || StringUtils.isEmpty(userModel.getTelephone())) {
            throw new BusinessException(EmBusinessError.PARAMETER_VAILDATION_ERROR);
        }
        // userModel 转 userDo
        UserDO userDO = convertFromDataObject(userModel);
        userDOMapper.insertSelective(userDO);
        UserPasswordDO userPasswordDO = convertPasswordFromModel(userModel);
        userPasswordDO.setUserId(userDO.getId());
        userPasswordDOMapper.insertSelective(userPasswordDO);
        return;
    }

    @Override
    public UserModel vaildLogin(String telephone, String encrpypassword) throws BusinessException {
        // 通过手机获取密码
        UserDO userDO = userDOMapper.selectByTelephone(telephone);
        if (userDO == null) {
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }

        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        UserModel userModel = convertFromDataObject(userDO, userPasswordDO);

        if (!StringUtils.equals(encrpypassword, userModel.getEncrptPassword())) {
            throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
        }
        return userModel;

        // 比对密码是否相匹配
    }

    private UserPasswordDO convertPasswordFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setEncrptPassword(userModel.getEncrptPassword());
        userPasswordDO.setId(userModel.getId());
        return userPasswordDO;
    }

    private UserDO convertFromDataObject(UserModel userModel) {
        UserDO userDO = new UserDO();
        if (userModel == null) {
            return null;
        }
        BeanUtils.copyProperties(userModel, userDO);
        return userDO;
    }

    private UserModel convertFromDataObject(UserDO userDO, UserPasswordDO userPassword) {
        if (userDO == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO, userModel);
        if (userPassword.getEncrptPassword() != null) {
            userModel.setEncrptPassword(userPassword.getEncrptPassword());
        }
        return userModel;
    }
}
