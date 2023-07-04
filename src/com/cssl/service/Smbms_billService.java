package com.cssl.service;

import com.cssl.pojo.Smbms_bill;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Smbms_billService {
    List<Smbms_bill> FindAllBill();

    //两表联查订单 供货商
    PageInfo getBillProListPage(String productName, String proName, String isPayment, Integer n, Integer pageSize);

    List<String> getProNames();

    //添加新账单
    @Transactional
    Integer addBill(Smbms_bill bill);

    //根据id查询
    Smbms_bill findById(Integer id);

    //根据id修改账单信息
    @Transactional
    Integer updateBill(Smbms_bill bill);

    @Transactional
    //id 删除订单
    Integer deleteBill(Integer id);
}
