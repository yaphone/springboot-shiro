package cn.yaphone.shiro.service;

import cn.yaphone.shiro.model.Role;
import cn.yaphone.shiro.model.User;

import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 16:02
 */
public interface UserRoleService {
    List<Role> getRolesByUser(User user);
}
