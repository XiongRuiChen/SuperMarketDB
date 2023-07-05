package com.cssl.mapper;

import com.cssl.pojo.Smbms_provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Smbms_providerMapper {
    //查询所有供货商
    List<Smbms_provider> findAll();

    /**
     * 供应商信息查询
     * @param proContact
     * @param proName
     * @return
     */
    List<Smbms_provider> selectByPageAll(@Param("proName")String proName, @Param("proContact")String proContact);

    Integer addProvider(Smbms_provider provider);

    Integer providerdel(Integer id);

    Smbms_provider findById(Integer id);

    Integer updateProvider(Smbms_provider provider);
}
