package com.cssl.service;

import com.cssl.pojo.Smbms_provider;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Smbms_providerService {
    //查询所有供货商
    List<Smbms_provider> findAll();

    PageInfo getProviderListPage(String proName, String proContact, Integer n, Integer pageSize);

    Integer addProvider(Smbms_provider provider);
}
