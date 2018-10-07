package cn.yaphone.shiro.service.impl;

import cn.yaphone.shiro.dao.RolePermissionMapper;
import cn.yaphone.shiro.dao.UserRoleMapper;
import cn.yaphone.shiro.model.Permission;
import cn.yaphone.shiro.model.Role;
import cn.yaphone.shiro.model.RolePermission;
import cn.yaphone.shiro.model.RolePermissionExample;
import cn.yaphone.shiro.service.PermissionService;
import cn.yaphone.shiro.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 16:29
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Permission> getPermissionsByRole(Role role) {
        List<Permission> permissions = new ArrayList<>();
        RolePermissionExample example = new RolePermissionExample();
        example.createCriteria().andRoleIdEqualTo(role.getRoleId());
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(example);
        for (RolePermission rolePermission: rolePermissions) {
            permissions.add(permissionService.getPermissionByPermissionId(rolePermission.getPermissionId()));
        }
        return permissions;
    }
}
