package cn.yaphone.shiro.service.impl;

import cn.yaphone.shiro.dao.UserMapper;
import cn.yaphone.shiro.model.User;
import cn.yaphone.shiro.model.UserExample;
import cn.yaphone.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 15:04
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        return users.size() == 1 ? users.get(0) : null;
    }
}
