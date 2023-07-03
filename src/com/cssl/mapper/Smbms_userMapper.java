package com.cssl.mapper;

import com.cssl.pojo.Smbms_role;
import com.cssl.pojo.Smbms_user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Smbms_userMapper {
    //登录方法
    Smbms_user login(Smbms_user user);

    //查询所有用户
    List<Smbms_user> FindAllUser();

    Integer UpdatePwd(Smbms_user user);

    List<Smbms_role> selectByPageAll(@Param("userName")String userName, @Param("roleName")String roleName);

}
