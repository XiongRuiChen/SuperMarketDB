package com.cssl.mapper;

import com.cssl.pojo.Smbms_bill;
import com.cssl.pojo.Smbms_provider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface Smbms_billMapper {

    List<Smbms_bill> FindAllBill();

    @Select("select proName from smbms_provider")
    List<String> selectProNameByAll();

    List<Smbms_provider> selectByPageAll(@Param("productName") String productName, @Param("proName") String proName, @Param("isPayment") String isPayment);


}
