package cn.yaphone.shiro.service;

import cn.yaphone.shiro.model.User;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/5 18:23
 */
public interface BaseService {
    User getUserById(long id);
}
