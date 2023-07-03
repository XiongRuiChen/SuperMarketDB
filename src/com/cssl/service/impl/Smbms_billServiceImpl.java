package com.cssl.service.impl;

import com.cssl.mapper.Smbms_billMapper;
import com.cssl.pojo.Smbms_bill;
import com.cssl.pojo.Smbms_provider;
import com.cssl.service.Smbms_billService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Smbms_billServiceImpl implements Smbms_billService {

    @Autowired
    private Smbms_billMapper SbM;

    @Override
    public List<Smbms_bill> FindAllBill() {
        return SbM.FindAllBill();
    }

    @Override
    public PageInfo getBillProListPage(String productName, String proName, String isPayment, Integer n, Integer pageSize) {
        PageHelper.startPage(n,pageSize);
        List<Smbms_provider> sp = SbM.selectByPageAll(productName,proName,isPayment);
        PageInfo<Smbms_provider> pageInfo = new PageInfo<>(sp, 3);
        return pageInfo;
    }

    @Override
    public List<String> getProNames() {
        return SbM.selectProNameByAll();
    }
}
