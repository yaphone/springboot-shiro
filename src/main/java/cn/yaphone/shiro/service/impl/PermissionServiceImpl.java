package cn.yaphone.shiro.service.impl;

import cn.yaphone.shiro.dao.PermissionMapper;
import cn.yaphone.shiro.model.Permission;
import cn.yaphone.shiro.model.PermissionExample;
import cn.yaphone.shiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 16:25
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissionByPermissionId(String permissionId) {
        PermissionExample example = new PermissionExample();
        example.createCriteria().andPermissionIdEqualTo(permissionId);
        List<Permission> permissions = permissionMapper.selectByExample(example);
        return permissions;
    }
}
