package cn.yaphone.shiro.service.impl;

import cn.yaphone.shiro.dao.RoleMapper;
import cn.yaphone.shiro.dao.UserRoleMapper;
import cn.yaphone.shiro.model.Role;
import cn.yaphone.shiro.model.User;
import cn.yaphone.shiro.model.UserRole;
import cn.yaphone.shiro.model.UserRoleExample;
import cn.yaphone.shiro.service.RoleService;
import cn.yaphone.shiro.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 16:03
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleService roleService;

    @Override
    public List<Role> getRolesByUser(User user) {
        List<Role> roles = new ArrayList<>();
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(user.getId());
        List<UserRole> userRoles = userRoleMapper.selectByExample(example);
        for (UserRole userRole: userRoles) {
            roles.add(roleService.getRoleByRoleId(userRole.getRoleId()));
        }
        return roles;
    }
}
