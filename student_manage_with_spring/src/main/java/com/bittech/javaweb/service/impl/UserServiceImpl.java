package com.bittech.javaweb.service.impl;

import com.bittech.javaweb.dao.UserDao;
import com.bittech.javaweb.entity.User;
import com.bittech.javaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * Author: secondriver
 * Created: 2018/7/29
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public boolean login(User user) {
        if (user == null) {
            return false;
        }
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            return false;
        }
        return userDao.login(user) != null;
    }
    
    @Override
    public boolean register(User user) {
        if (user == null) {
            return false;
        }
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            return false;
        }
        //1.用户名是否存在
        if (userDao.exist(user.getUserName())) {
            return false;
        }
        return userDao.insert(user) == 1;
    }
    
}
