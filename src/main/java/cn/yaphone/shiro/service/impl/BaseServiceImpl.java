package cn.yaphone.shiro.service.impl;

import cn.yaphone.shiro.dao.UserMapper;
import cn.yaphone.shiro.model.User;
import cn.yaphone.shiro.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/5 18:23
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
