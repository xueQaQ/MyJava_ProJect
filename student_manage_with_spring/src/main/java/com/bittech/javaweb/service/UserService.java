package com.bittech.javaweb.service;

import com.bittech.javaweb.entity.User;

/**
 * Author: secondriver
 * Created: 2018/7/29
 */
public interface UserService {
    
    boolean login(User user);
    
    boolean register(User user);
    
}
