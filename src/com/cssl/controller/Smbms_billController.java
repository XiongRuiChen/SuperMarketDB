package com.cssl.controller;

import com.cssl.pojo.Smbms_bill;
import com.cssl.service.Smbms_billService;
import com.cssl.service.Smbms_providerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class Smbms_billController {

    @Autowired
    private Smbms_billService SbS;

    @Autowired
    private Smbms_providerService SPS;

    @RequestMapping(value = "/bill.do")
    public ModelAndView FindAllBill(ModelAndView mv){
        List<Smbms_bill> list = SbS.FindAllBill();
        mv.addObject("AllBills",list);
        mv.setViewName("bilist");
        return mv;
    }

    @RequestMapping("/billlist.do")
    public String getBillProList(
            @RequestParam(value="productName",defaultValue="")String productName,
            @RequestParam(value="proName",defaultValue="")String proName,
            @RequestParam(value="isPayment",defaultValue="")String isPayment,
            @RequestParam(value="n",defaultValue="1")Integer n,
            @RequestParam(value="pageSize",defaultValue="5")Integer pageSize,
            Map<String,Object> map){
        //获取订单列表信息
        PageInfo pageInfo = SbS.getBillProListPage(productName, proName, isPayment, n, pageSize);
        //获取供应商列表信息
        List<String> proNames = SbS.getProNames();
        map.put("pageInfo", pageInfo);
        map.put("proNames",proNames);
        map.put("productName",productName);
        map.put("proName",proName);
        map.put("isPayment",isPayment);
        return "bilist";
    }


}
