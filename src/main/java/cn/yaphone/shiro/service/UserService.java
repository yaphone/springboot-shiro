package cn.yaphone.shiro.service;

import cn.yaphone.shiro.model.User;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 15:04
 */
public interface UserService {
    User getUserByUsername(String username);
}
