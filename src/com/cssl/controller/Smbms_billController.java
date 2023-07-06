package com.cssl.controller;

import com.cssl.pojo.Smbms_bill;
import com.cssl.pojo.Smbms_user;
import com.cssl.service.Smbms_billService;
import com.cssl.service.Smbms_providerService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class Smbms_billController {

    @Autowired
    private Smbms_billService SbS;

    @Autowired
    private Smbms_providerService SPS;

    @RequestMapping(value = "/bill.do")
    public ModelAndView FindAllBill(ModelAndView mv) {
        List<Smbms_bill> list = SbS.FindAllBill();
        mv.addObject("AllBills", list);
        mv.setViewName("bilist");
        return mv;
    }

    @RequestMapping("/exportExcel.do")
    public ModelAndView exportExcel() {
        // 获取要导出的数据，假设是一个订单列表
        List<Smbms_bill> billList = SbS.FindAllBill();
        // 创建模型视图
        ModelAndView modelAndView = new ModelAndView("excelView");
        // 将要导出的数据存储在模型中
        modelAndView.addObject("data", billList);
        return modelAndView;
    }

    @RequestMapping("/billlist.do")
    public String getBillProList(
            @RequestParam(value = "productName", defaultValue = "") String productName,
            @RequestParam(value = "proName", defaultValue = "") String proName,
            @RequestParam(value = "isPayment", defaultValue = "") String isPayment,
            @RequestParam(value = "n", defaultValue = "1") Integer n,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            Map<String, Object> map) {
        //获取订单列表信息
        PageInfo pageInfo = SbS.getBillProListPage(productName, proName, isPayment, n, pageSize);
        //获取供应商列表信息
        List<String> proNames = SbS.getProNames();
        map.put("pageInfo", pageInfo);
        map.put("proNames", proNames);
        map.put("productName", productName);
        map.put("proName", proName);
        map.put("isPayment", isPayment);
        return "bilist";
    }

    @RequestMapping(value = "/addBill.do")
    public ModelAndView addBill(ModelAndView mv,
                                @RequestParam String billCode,
                                @RequestParam String productName,
                                @RequestParam String productDesc,
                                @RequestParam String productUnit,
                                @RequestParam String productCount,
                                @RequestParam String totalPrice,
                                @RequestParam("providerId") String providerId,
                                @RequestParam String isPayment,
                                HttpServletRequest res
    ) {
        Smbms_user OnlineUser = (Smbms_user) res.getSession().getAttribute("USER");
        long createdBy = OnlineUser.getId();
        Smbms_bill NewBill = new Smbms_bill();
        Date date = new Date();
        BigDecimal productCount1 = new BigDecimal(productCount);
        BigDecimal totalPrice1 = new BigDecimal(totalPrice);
        NewBill.setBillCode(billCode);
        NewBill.setProductName(productName);
        NewBill.setProductDesc(productDesc);
        NewBill.setProductUnit(productUnit);
        NewBill.setProductCount(productCount1);
        NewBill.setTotalPrice(totalPrice1);
        NewBill.setProviderId(Long.parseLong(providerId));
        NewBill.setIsPayment(Integer.valueOf(isPayment));
        NewBill.setCreatedBy(createdBy);
        NewBill.setCreationDate(date);
        Integer i = SbS.addBill(NewBill);
        if (i > 0) {
            mv.setViewName("bilist");
            mv.addObject("AddMess", "添加成功!");
            return mv;
        } else {
            mv.setViewName("addbill");
            mv.addObject("Mess", "添加失败!");
            return mv;
        }
    }

    @RequestMapping(value = "/getProNamesC.do")
    public ModelAndView getProNamesC(ModelAndView mv) {
        List<String> proNames = SbS.getProNames();
        mv.setViewName("addbill");
        mv.addObject("ProNames", proNames);
        return mv;
    }

    @RequestMapping(value = "/view.do")
    public ModelAndView view(Integer id, ModelAndView mv) {
        Smbms_bill bill = SbS.findById(id);
        mv.addObject("bill", bill);
        mv.setViewName("billview");
        return mv;
    }

    @RequestMapping(value = "/modify.do")
    public ModelAndView modify(Integer id, ModelAndView mv) {
        List<String> proNames = SbS.getProNames();
        mv.setViewName("billmodify");
        Smbms_bill bill = SbS.findById(id);
        mv.addObject("bill", bill);
        mv.addObject("ProNames", proNames);
        return mv;
    }

    @Transactional
    @RequestMapping(value = "/updateBill.do")
    public ModelAndView updateBill(
            String billCode,
            String productName,
            String productDesc,
            String productUnit,
            String productCount,
            String totalPrice,
            @RequestParam("providerId") String providerId,
            String isPayment,
            HttpServletRequest res,
            Integer id,
            ModelAndView mv
    ) {
        long modifyBy = getSessionUSERId(res);
        Smbms_bill updateBill = new Smbms_bill();
        Date date = new Date();
        BigDecimal productCount1 = new BigDecimal(productCount);
        BigDecimal totalPrice1 = new BigDecimal(totalPrice);
        updateBill.setBillCode(billCode);
        updateBill.setProductName(productName);
        updateBill.setProductDesc(productDesc);
        updateBill.setProductUnit(productUnit);
        updateBill.setProductCount(productCount1);
        updateBill.setTotalPrice(totalPrice1);
        updateBill.setProviderId(Long.parseLong(providerId));
        updateBill.setIsPayment(Integer.valueOf(isPayment));
        updateBill.setModifyBy(modifyBy);  // 使用 OnlineUser 对象中的 id 属性值
        updateBill.setModifyDate(date);
        updateBill.setId(id);
        System.out.println(updateBill);
        Integer i = SbS.updateBill(updateBill);  // 修改为传入 updateBill 对象
        if (i > 0) {
            mv.addObject("UpdateMess", "修改成功!");
            mv.setViewName("bilist");
        } else {
            mv.addObject("UpdateMess", "修改失败!");
            mv.setViewName("billmodify");
        }
        return mv;
    }

    public static long getSessionUSERId(HttpServletRequest res) {
        Smbms_user user = (Smbms_user) res.getSession().getAttribute("USER");
        return user.getId();
    }

    @RequestMapping(value = "/del.do")
    public ModelAndView deleteBill(Integer id,ModelAndView mv){
        Integer i = SbS.deleteBill(id);
        if (i > 0){
            mv.setViewName("bilist");
            mv.addObject("DMess","删除成功");
        }else {
            mv.setViewName("bilist");
            mv.addObject("DMess","删除失败");
        }
        return mv;
    }


}
