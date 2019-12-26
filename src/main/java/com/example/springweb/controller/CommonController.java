package com.example.springweb.controller;

import com.example.springweb.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.springweb.service.CommonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class CommonController {
    @Autowired
    public CommonService commonservice;

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public String login() {
        return "/index";
    }

    @RequestMapping(value = "/loginRedirect", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(HttpServletRequest request, HttpSession session, Model model) {
        String user_name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("你输入的用户名为：" + user_name);
        System.out.println("你输入的密码为：" + password);
        String tname = commonservice.login(user_name, password);
        session.setAttribute("name", tname);
        if (tname == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("session", "test");
            return "redirect:/MainPage";
        }
    }

    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginindex() {
        return "/index";
    }
}
