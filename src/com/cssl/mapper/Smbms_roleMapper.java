package com.cssl.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Smbms_roleMapper {

    @Select("select roleName from smbms_role")
    List<String> selectRoleNameByAll();

}
