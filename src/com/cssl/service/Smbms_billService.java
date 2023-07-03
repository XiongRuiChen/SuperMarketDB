package com.cssl.service;

import com.cssl.pojo.Smbms_bill;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Smbms_billService {
    List<Smbms_bill> FindAllBill();

    //两表联查订单 供货商
    PageInfo getBillProListPage(String productName, String proName, String isPayment, Integer n, Integer pageSize);

    List<String> getProNames();

}
