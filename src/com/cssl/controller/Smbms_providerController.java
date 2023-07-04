package com.cssl.controller;

import com.cssl.pojo.Smbms_provider;
import com.cssl.service.Smbms_billService;
import com.cssl.service.Smbms_providerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class Smbms_providerController {
    @Autowired
    private Smbms_providerService SPS;

    public ModelAndView findAll(ModelAndView mv) {
        List<Smbms_provider> list = SPS.findAll();
        if(list.size() == 0){
            mv.setViewName("index");
            mv.addObject("providerFail","所有供货商查询失败!");
        }else {
            mv.setViewName("providerlist");
            mv.addObject("providerList",list);
        }
        return mv;
    }

    @GetMapping("/providerlist.do")
    public String getProviderList(
            @RequestParam(value="proName",defaultValue="")String proname,
            @RequestParam(value="proContact",defaultValue="")String procontact,
            @RequestParam(value="n",defaultValue="1")Integer n,
            @RequestParam(value="pageSize",defaultValue="5")Integer pageSize,
            Map<String,Object> map){
        //获取用户列表信息
        PageInfo pageInfo = SPS.getProviderListPage(proname, procontact, n, pageSize);
        map.put("pageInfo", pageInfo);
        map.put("proName",proname);
        map.put("proContact",procontact);
        return "providerlist";
    }


}
