package com.cssl.service;

import com.cssl.pojo.Smbms_provider;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Smbms_providerService {
    //查询所有供货商
    List<Smbms_provider> findAll();

    public PageInfo getProviderListPage(String proName, String proContact, Integer n, Integer pageSize);

}
