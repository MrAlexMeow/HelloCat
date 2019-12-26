package com.example.springweb.controller;

import com.example.springweb.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class HelloController {
    @Autowired
    HelloService helloService;
    public final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    public int ID;
    public HelloController(){ID=1;}

    @RequestMapping("/hello")
    public String hello(){
        logger.info("hello logging" + helloService.getUserList());
        return "hello";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/loginPage")//login.html中的表单数据发送到此位置进行处理
    public String login(HttpServletRequest request,HttpSession session)
    {
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        System.out.println("您输入的用户名为："+ name);
        System.out.println("您输入的密码为："+ password);
        String rsp_name=helloService.login(name,password);
        session.setAttribute("name",rsp_name);
        if(rsp_name==null){
            return "fail";
        }else{
            String temp_name=helloService.get_name(1);
            System.out.println("您输入的用户名为："+ temp_name);
            String temp_type=helloService.type(1);
            String temp_convention=helloService.get_name(1);
            String temp_grade=helloService.grade(1);
            session.setAttribute("tid",1);
            session.setAttribute("temp_name",temp_name);
            session.setAttribute("temp_type",temp_type);
            session.setAttribute("temp_convention",temp_convention);
            session.setAttribute("temp_grade",temp_grade);
            return "MainPage";
        }
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/standard")
    public String standard(){
        return "standard";
    }

    @RequestMapping("/MainPage")
    public String MainPage(){
        return "MainPage";
    }

    @RequestMapping("/name_standard")
    public String name_standard(){
        return "name_standard";
    }

    @RequestMapping("/classify_standard")
    public String classify_standard(){
        return "classify_standard";
    }

    @RequestMapping("/safety_standard")
    public String safety_standard(){
        return "safety_standard";
    }

    @RequestMapping("/grade_standard")
    public String grade_standard(){
        return "grade_standard";
    }

    @RequestMapping("/checkApp?id=1")
    public String checkApp(){return "checkApp?id="+ID;
    }


    @RequestMapping("/modify")
    public String modify(HttpServletRequest request,HttpSession session){
        System.out.println("ID :"+ID);
        String type=request.getParameter("classify");
        String get_name=request.getParameter("name");
        String grade=request.getParameter("grade");
        String safety_level=request.getParameter("safety");

        String temp_name=helloService.get_name(ID);
        String temp_type=helloService.type(ID);
        String temp_convention=helloService.get_name(ID);
        String temp_grade=helloService.grade(ID);
        if(get_name!=null){
            System.out.println("你输入的命名为：" + get_name);
            helloService.update_name(ID,get_name);
        }
        if(type!=null){
            System.out.println("你输入的分类为：" + type);
            helloService.update_type(ID,type);
        }
        if(safety_level!=null){
            System.out.println("你输入的安全等级为：" +safety_level );
            helloService.update_safety_level(ID,safety_level);
        }
        if(grade!=null) {
            System.out.println("你输入的分级为：" + grade);
            helloService.update_grade(ID, grade);
        }
        temp_name=helloService.get_name(ID);
        temp_type=helloService.type(ID);
        temp_convention=helloService.get_name(ID);
        temp_grade=helloService.grade(ID);
        session.setAttribute("tid",ID);
        session.setAttribute("temp_name",temp_name);
        session.setAttribute("temp_type",temp_type);
        session.setAttribute("temp_convention",temp_convention);
        session.setAttribute("temp_grade",temp_grade);
        return "MainPage";
    }

    @GetMapping("/checkApp")
    public String checkApp(int id,HttpSession session){
        ID=id;
        String temp_name=helloService.get_name(id);
        String temp_type=helloService.type(id);
        String temp_convention=helloService.get_name(id);
        String temp_grade=helloService.grade(id);
        session.setAttribute("tid",id);
        session.setAttribute("temp_name",temp_name);
        session.setAttribute("temp_type",temp_type);
        session.setAttribute("temp_convention",temp_convention);
        session.setAttribute("temp_grade",temp_grade);
        return "MainPage";
    }

}
