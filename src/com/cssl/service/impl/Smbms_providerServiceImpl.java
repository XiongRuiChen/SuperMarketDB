package com.cssl.service.impl;

import com.cssl.mapper.Smbms_providerMapper;
import com.cssl.pojo.Smbms_provider;
import com.cssl.service.Smbms_providerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class Smbms_providerServiceImpl implements Smbms_providerService {

    @Autowired
    private Smbms_providerMapper SPM;
    @Override
    public List<Smbms_provider> findAll() {
        return SPM.findAll();
    }

    @Override
    public PageInfo getProviderListPage(String proName, String proContact, Integer n, Integer pageSize) {
        PageHelper.startPage(n,pageSize);
        List<Smbms_provider> pros =SPM.selectByPageAll(proName, proContact);
        PageInfo<Smbms_provider> pageInfo = new PageInfo<>(pros);
        return pageInfo;
    }

    @Override
    public Integer addProvider(Smbms_provider provider) {
        return SPM.addProvider(provider);
    }

    @Override
    public Integer providerdel(Integer id) {
        return SPM.providerdel(id);
    }

    @Override
    public Smbms_provider findById(Integer id) {
        return SPM.findById(id);
    }

    @Override
    public Integer updateProvider(Smbms_provider provider) {
        return SPM.updateProvider(provider);
    }


}
