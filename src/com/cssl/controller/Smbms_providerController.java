package com.cssl.controller;

import com.cssl.pojo.Smbms_provider;
import com.cssl.pojo.Smbms_user;
import com.cssl.service.Smbms_billService;
import com.cssl.service.Smbms_providerService;
import com.github.pagehelper.PageInfo;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.*;

@Controller
public class Smbms_providerController {
    @Autowired
    private Smbms_providerService SPS;

    public ModelAndView findAll(ModelAndView mv) {
        List<Smbms_provider> list = SPS.findAll();
        if (list.size() == 0) {
            mv.setViewName("index");
            mv.addObject("providerFail", "所有供货商查询失败!");
        } else {
            mv.setViewName("providerlist");
            mv.addObject("providerList", list);
        }
        return mv;
    }

    @GetMapping("/providerlist.do")
    public String getProviderList(
            @RequestParam(value = "proName", defaultValue = "") String proname,
            @RequestParam(value = "proContact", defaultValue = "") String procontact,
            @RequestParam(value = "n", defaultValue = "1") Integer n,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            Map<String, Object> map) {
        //获取用户列表信息
        PageInfo pageInfo = SPS.getProviderListPage(proname, procontact, n, pageSize);
        map.put("pageInfo", pageInfo);
        map.put("proName", proname);
        map.put("proContact", procontact);
        return "providerlist";
    }

    @RequestMapping(value = "/addProvider.do")
    public ModelAndView NewProvider(
            @RequestParam(defaultValue = "procode")String procode,
            @RequestParam(defaultValue = "proname")String proname,
            @RequestParam(defaultValue = "procontact")String procontact,
            @RequestParam(defaultValue = "prophone")String prophone,
            @RequestParam(defaultValue = "proaddress")String proaddress,
            @RequestParam(defaultValue = "profax")String profax,
            @RequestParam(defaultValue = "prodesc")String prodesc,
            HttpServletRequest res,
            ModelAndView mv
    ) {
        Smbms_provider sp = new Smbms_provider();
        long createdby = getSessionUSERId(res);
        Date date = new Date();
        sp.setProCode(procode);
        sp.setProName(proname);
        sp.setProContact(procontact);
        sp.setProPhone(prophone);
        sp.setProAddress(proaddress);
        sp.setProFax(profax);
        sp.setProDesc(prodesc);
        sp.setCreatedBy(createdby);
        sp.setCreationDate(date);
        return addProvider(mv, sp);
    }

    public ModelAndView addProvider(ModelAndView mv, @Validated Smbms_provider provider) {
        Integer i = SPS.addProvider(provider);
        Map<String, Object> map = new HashMap<>();
        if ("".equals(provider.getProCode()) || provider.getProCode() == null) {
            mv.addObject("Mess", "数据不能为空!");
            mv.setViewName("provideradd");
            return mv;
        } else {
            if (i > 0) {
                mv.addObject("Mess", "添加成功");
                mv.setViewName(getProviderList(null, null, 1, 5, map));
            } else {
                mv.addObject("Mess", "添加失败");
                mv.setViewName("provideradd");
            }
            return mv;
        }
    }

    public long getSessionUSERId(HttpServletRequest res) {
        Smbms_user user = (Smbms_user) res.getSession().getAttribute("USER");
        return user.getId();
    }

    @RequestMapping(value = "/providerdel.do")
    public String providerdel(Integer id) {
        Integer i = SPS.providerdel(id);
        if (i > 0) {
            return "providerlist";
        } else {
            return "删除失败!";
        }
    }

    @RequestMapping(value = "/providerview.do")
    public ModelAndView providerview(Integer id, ModelAndView mv) {
        Smbms_provider provider = SPS.findById(id);
        if(provider == null || "".equals(provider.getProCode())){
            mv.setViewName("providerlist");
            mv.addObject("vieMess","查询失败!");
        }else {
            mv.setViewName("providerview");
            mv.addObject("vieMess","查询成功!");
            mv.addObject("provider",provider);
        }
        return mv;
    }

    @RequestMapping(value = "/providermodifyS.do")
    public ModelAndView providermodifyS(Integer id, ModelAndView mv) {
        Smbms_provider provider = SPS.findById(id);
        if(provider == null || "".equals(provider.getProCode())){
            mv.setViewName("providerlist");
            mv.addObject("vieMess","查询失败!");
        }else {
            mv.setViewName("providermodify");
            mv.addObject("vieMess","查询成功!");
            mv.addObject("provider",provider);
        }
        return mv;
    }

    @RequestMapping(value = "/update.do")
    public ModelAndView updateP(ModelAndView mv,
                                @ModelAttribute("provider")Smbms_provider pro,
                                HttpServletRequest res
    ){
        long modifyBy = getSessionUSERId(res);
        Date date = new Date();
        pro.setModifyBy(modifyBy);
        pro.setModifyDate(date);
        Integer i = SPS.updateProvider(pro);
        if(i>0){
            mv.setViewName("providerlist");
        }else {
            mv.setViewName("providermodify");
            mv.addObject("UpMess","修改失败!");
        }
        return mv;
    }





}
