package com.example.springweb;

import com.example.springweb.dao.HelloUser;
import com.example.springweb.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloServiceTest {
    @Autowired
    HelloService helloService;
    @Test
    public void testupdate_type() throws Exception{
        helloService.update_type(1,"高科技");
        assertEquals(helloService.type(1),"高科技");
    }
    @Test
    public void testupdate_name() throws Exception{
        helloService.update_name(1,"小王科技App");
        assertEquals(helloService.get_name(1), "小王科技App");
    }
    @Test
    public void testupdate_grade() throws Exception{
        helloService.update_grade(1,"比较高级");
        assertEquals(helloService.grade(1),"比较高级");
    }
    @Test
    public void testupdate_safety() throws Exception{
        helloService.update_safety_level(1,"非常安全");
        assertEquals(helloService.safety(1),"非常安全");
    }
    @Test
    public void testupdate_null() throws Exception{
        helloService.update_safety_level(666,"非常安全");
        assertEquals(helloService.safety(666),null);
    }
}
