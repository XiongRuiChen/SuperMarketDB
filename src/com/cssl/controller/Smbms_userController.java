package com.cssl.controller;


import com.cssl.pojo.Smbms_user;
import com.cssl.service.Smbms_userService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;


@Controller
//@RequestMapping("/user")
public class Smbms_userController {

    @Autowired
    private Smbms_userService SS;
    private final String ContextPath = "http://localhost:8080/SuperMarketDB";


    //用户登录
    @RequestMapping(value = "/login.do", produces = "application/json")
    private ModelAndView login(String userCode, String userPassword, ModelAndView mv, HttpServletRequest req) {
        //新对象 用于向MyBatis传递值
        Smbms_user user = new Smbms_user();
        //传值 用户输入的账户密码
        user.setUserCode(userCode);
        user.setUserPassword(userPassword);
        //调用登录查询方法 数据库没有该用户传递null值
        user = SS.login(user);
        //不为空 登陆成功
        if (user != null) {
            mv.setViewName("index");
            mv.addObject("MESS", "登陆成功!");
            mv.addObject("LoginUser", user);
            //Session中存储用户登录数据
            req.getSession().setAttribute("USER", user);
        } else {
            //登陆失败返回登录页面
            mv.setViewName("login");
            mv.addObject("MESS", "登陆失败!");
        }
        return mv;
    }

    //退出登录 清除Session中的用户数据
    @RequestMapping(value = "/logout.do")
    public String logout(HttpServletRequest req) {
        //清除数据
        req.getSession().removeAttribute("USER");
        //重定向登录界面
        return "redirect:" + ContextPath + "/login.jsp";
    }

    //添加新用户
    @RequestMapping(value = "")
    public String AddNewUser() {
        return "redirect:" + ContextPath + "/index.jsp";
    }

    //查询全部用户
    @ResponseBody()
    @RequestMapping(value = "/FindAllUser.do")
    public ModelAndView FindAllUser(ModelAndView mv) {
        List<Smbms_user> UserList = SS.FindAllUser();
        mv.addObject("UserList", UserList);
        mv.setViewName("useredit");
        return mv;
    }


    @Transactional
    @RequestMapping(value = "/UpdatePwd.do")
    public ModelAndView UpdatePwd(ModelAndView mv,
                                  HttpServletRequest req,
                                  @NotNull
                                  String oldpassword,
                                  @NotNull
                                  String newpassword,
                                  @NotNull
                                  String rnewpassword) {
        Smbms_user u1;
        u1 = (Smbms_user) req.getSession().getAttribute("USER");
        //System.out.println("oldpassword"+oldpassword+"newpassword"+newpassword+"rnewpassword"+rnewpassword);
        //System.out.println(u1.toString());
        //与原密码一致
        if (oldpassword.equals(u1.getUserPassword()) && newpassword.equals(rnewpassword)) {
            u1.setUserPassword(newpassword);
            Integer res = SS.UpdatePwd(u1);
            if (res > 0) {
                mv.addObject("UpdateMESS", "修改成功!返回登录页重新登陆!");
                mv.setViewName("login");
            }
        } else {
            mv.addObject("UpdateMESS", "修改失败!请检查密码是否一致,原密码是否正确!");
            mv.setViewName("pwdmodify");
        }
        return mv;
    }

    //查询全部用户 分页
    @GetMapping("/userlist.do")
    public String getUserList(
            @RequestParam(value="userName",defaultValue="")String userName,
            @RequestParam(value="roleName",defaultValue="")String roleName,
            @RequestParam(value="n",defaultValue="1")Integer n,
            @RequestParam(value="pageSize",defaultValue="5")Integer pageSize,
            Map<String,Object> map){
        //获取用户列表信息
        PageInfo pageInfo = SS.getUserListPage(userName,roleName,n, pageSize);
        //获取角色名称列表信息
        List<String> roleNames = SS.getRoleNames();
        map.put("pageInfo", pageInfo);
        map.put("roleNames",roleNames);
        map.put("username",userName);
        map.put("rolename",roleName);
        return "useredit";
    }





}
