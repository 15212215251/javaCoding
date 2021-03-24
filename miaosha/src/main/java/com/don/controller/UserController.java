package com.don.controller;/**
 * ClassName:    UserController
 * Package:    com.don.controller
 * Description:
 * Datetime:    2021/3/7   12:01 下午
 * Author:   tanglintao
 */

import com.alibaba.druid.util.StringUtils;
import com.don.controller.viewobject.UserVO;
import com.don.error.BusinessException;
import com.don.error.EmBusinessError;
import com.don.response.CommonResturnType;
import com.don.service.IUserService;
import com.don.service.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author: tanglintao
 * @ClassName: UserController
 * @Date: 2021/03/07 12:01
 */
@Slf4j
@Controller("user")
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:63342", allowCredentials = "true")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    //用户登录接口
    @RequestMapping(value = "/login", consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonResturnType login(@RequestParam(name = "telephone") String telephone, @RequestParam(name = "password") String password) throws BusinessException, NoSuchAlgorithmException {
        // 入参校验
        if (StringUtils.isEmpty(telephone) || StringUtils.isEmpty(password)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VAILDATION_ERROR);
        }
        // 用户登录服务
        UserModel userModel = userService.vaildLogin(telephone, this.encodeByMD5(password));

        // 加入到用户登录成功的session内
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN_IN", true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER", userModel);
        return CommonResturnType.create(null);
    }


    /**
     * 通过id获取学生对象信息
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    @RequestMapping(value = "/get", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonResturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        // 调用service服务获取对象并返回前端
        UserModel userModel = userService.getUserById(id);
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }
        // 将核心领域模型用户对象转换成可供UI使用的viewObject
        UserVO userVO = convertFromModel(userModel);
        return CommonResturnType.create(userVO);
    }

    private UserVO convertFromModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }

    /**
     * 获取Opt短信验证码
     *
     * @param telephone
     * @return
     */
    @RequestMapping(value = "/getopt", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonResturnType getOpt(@RequestParam(name = "telephone") String telephone) {
        // 获取opt验证码三个步骤

        // 1 按照一定的规则生产opt验证码 。使用随机数
        Random random = new Random();
        int randomInt = random.nextInt(99999);
        randomInt += 10000;
        String optCode = String.valueOf(randomInt);
        // 2 将opt验证码关联手机号
        httpServletRequest.getSession().setAttribute(telephone, optCode);
        // 3 将验证码发送到手机上 .直接打印到控制台模拟短信发送
        log.info("您手机号：" + telephone + "验证码为：" + optCode);
        return CommonResturnType.create(null);
    }

    /**
     * 用户注册接口
     *
     * @return
     */
    @RequestMapping(value = "/register", method = {RequestMethod.POST}, consumes = CONTENT_TYPE_FORMED)
    @ResponseBody
    public CommonResturnType register(@RequestParam(name = "telephone") String telephone,
                                      @RequestParam(name = "otpCode") String otpCode,
                                      @RequestParam(name = "name") String name,
                                      @RequestParam(name = "gender") Integer gender,
                                      @RequestParam(name = "age") Integer age,
                                      @RequestParam(name = "password") String password) throws BusinessException, NoSuchAlgorithmException {
        // 验证otpcode是否正确
        String inSessionotpCode = (String) this.httpServletRequest.getSession().getAttribute(telephone);
        if (!StringUtils.equals(inSessionotpCode, otpCode)) {
            throw new BusinessException(EmBusinessError.PARAMETER_VAILDATION_ERROR, "短信验证码不符合");
        }
        UserModel userModel = new UserModel();
        userModel.setTelephone(telephone);
        userModel.setName(name);
        userModel.setGender(Byte.parseByte(String.valueOf(gender.intValue())));
        userModel.setAge(age);
        userModel.setRegisterModel("byPhone");
        userModel.setEncrptPassword(this.encodeByMD5(password));
        userService.register(userModel);
        return CommonResturnType.create(null);
    }

    public String encodeByMD5(String string) throws NoSuchAlgorithmException {
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("md5");
        Base64 base64 = new Base64();
        // 加密字符串
        return base64.encodeAsString(md5.digest(string.getBytes()));

    }
}
