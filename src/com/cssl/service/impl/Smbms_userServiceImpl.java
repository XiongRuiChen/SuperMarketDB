package com.cssl.service.impl;

import com.cssl.mapper.Smbms_roleMapper;
import com.cssl.mapper.Smbms_userMapper;
import com.cssl.pojo.Smbms_role;
import com.cssl.pojo.Smbms_user;
import com.cssl.service.Smbms_userService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Smbms_userServiceImpl implements Smbms_userService {

    @Autowired
    private Smbms_userMapper SUM;
    @Autowired
    private Smbms_roleMapper SRM;
    @Override
    public Smbms_user login(Smbms_user user) {
        return SUM.login(user);
    }

    @Override
    public List<Smbms_user> FindAllUser() {
        return SUM.FindAllUser();
    }

    @Override
    @Transactional
    public Integer UpdatePwd(Smbms_user user) {
        return SUM.UpdatePwd(user);
    }

    @Override
    public PageInfo getUserListPage(String userName, String roleName, Integer n, Integer pageSize) {
        PageHelper.startPage(n,pageSize);
        List<Smbms_role> userRoles = SUM.selectByPageAll(userName,roleName);
        PageInfo<Smbms_role> pageInfo = new PageInfo<>(userRoles,3);
        return pageInfo;
    }

    @Override
    public List<String> getRoleNames() {
        return SRM.selectRoleNameByAll();
    }

    @Override
    public Integer addNewUser(Smbms_user user) {
        return SUM.addNewUser(user);
    }

    @Override
    public Smbms_user findOneById(Integer id) {
        return SUM.findOneById(id);
    }

    @Override
    public Integer delById(Integer id) {
        return SUM.delById(id);
    }

    @Override
    public Integer updateUser(Smbms_user user) {
        return SUM.updateUser(user);
    }

}
