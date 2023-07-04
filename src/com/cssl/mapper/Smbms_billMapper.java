package com.cssl.mapper;

import com.cssl.pojo.Smbms_bill;
import com.cssl.pojo.Smbms_provider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Smbms_billMapper {

    List<Smbms_bill> FindAllBill();

    @Select("select proName from smbms_provider")
    List<String> selectProNameByAll();

    List<Smbms_provider> selectByPageAll(@Param("productName") String productName, @Param("proName") String proName, @Param("isPayment") String isPayment);

    //添加新账单
    Integer addBill(Smbms_bill bill);

    //根据ID查询账单
    Smbms_bill findById(Integer id);

    //根据id修改账单信息
    @Update("UPDATE `smbms_bill` SET `modifyBy` = #{modifyBy},`modifyDate` = #{modifyDate},`billCode` = #{billCode},`productName`= #{productName},`productDesc` = #{productDesc},`productUnit` = #{productUnit},`productCount` = #{productCount},`totalPrice` = #{totalPrice},`providerId` = #{providerId},`isPayment` = #{isPayment} WHERE id = #{id}")
    Integer updateBill(Smbms_bill bill);

    //id 删除订单
    Integer deleteBill(Integer id);

}
