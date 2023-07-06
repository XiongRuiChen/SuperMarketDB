package com.cssl.service;

import com.cssl.mapper.Smbms_userMapper;
import com.cssl.pojo.Smbms_user;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Smbms_userService {
    //登录方法
    Smbms_user login(Smbms_user user);

    //查询所有用户
    List<Smbms_user> FindAllUser();

    //更改密码
    Integer UpdatePwd(Smbms_user user);

    //分页查询所有User
    PageInfo getUserListPage(String userName,String roleName,Integer n,Integer pageSize);

    //查询岗位名称
    List<String> getRoleNames();

    Integer addNewUser(Smbms_user user);

    Smbms_user findOneById(Integer id);

    Integer delById(Integer id);

    Integer updateUser(Smbms_user user);

}
