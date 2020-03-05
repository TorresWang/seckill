package com.seckill.service;

import com.seckill.error.BusinessException;
import com.seckill.service.model.UserModel;

/**
 * Created by admin on 2020/2/19.
 */
public interface UserService {
    UserModel getUserById(Integer id);
    void register(UserModel userModel)  throws BusinessException;
}
