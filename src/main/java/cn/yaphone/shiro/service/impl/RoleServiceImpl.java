package cn.yaphone.shiro.service.impl;

import cn.yaphone.shiro.dao.RoleMapper;
import cn.yaphone.shiro.model.Role;
import cn.yaphone.shiro.model.RoleExample;
import cn.yaphone.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 15:46
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Role getRoleByRoleId(String roleId) {
        RoleExample example = new RoleExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<Role> roles = roleMapper.selectByExample(example);
        return roles.size() == 1 ? roles.get(0) : null;
    }
}
