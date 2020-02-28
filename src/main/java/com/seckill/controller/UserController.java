package com.seckill.controller;

import com.seckill.controller.viewObject.UserVO;
import com.seckill.error.BusinessException;
import com.seckill.error.EmBusinessError;
import com.seckill.response.CommonReturnType;
import com.seckill.service.UserService;
import com.seckill.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by admin on 2020/2/19.
 */
@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    //用户获取otp短信接口
    @RequestMapping("/getOtp")
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name = "telephone") String telephone){
        //需要按照一定的规则生产OTP验证码
        Random random = new Random();
        int randomInt = random.nextInt(99999);//此时随机数取值[0,99999)
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);

        //将OTP验证码同对应用户的手机号关联，企业级应用会做到redis中。
        // 此处使用httpSession的方式绑定用户的手机号与OTPCODE


        //将otp验证码通过短信通道发送给用户，此项目省略

        return CommonReturnType.create(null);
    }




    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name="id")Integer id) throws BusinessException {
        //调用service服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);

        if(userModel == null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"手机号码不匹配");
        }

        //将核心领域模型用户对象转化为可供UI使用的viewoject
        UserVO userVO = convertFromUserModel(userModel);
        //返回通用格式
        return CommonReturnType.create(userVO);
    }

    private UserVO convertFromUserModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;

    }

}
