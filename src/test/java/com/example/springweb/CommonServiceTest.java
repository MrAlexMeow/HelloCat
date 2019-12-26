package com.example.springweb;

import com.example.springweb.dao.HelloUser;
import com.example.springweb.service.CommonService;
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
public class CommonServiceTest {
    @Autowired
    CommonService common;
    @Test
    public void testLogin_ID1() throws Exception{
        assertEquals(common.login("John","123456"),"John");
    }
    @Test
     public void testLogin_ID2() throws Exception {
        assertEquals(common.login("Chick", "026"), null);
    }
    @Test
    public void testLogin_null() throws Exception{
        assertEquals(common.login("MrFake","null"),null);
    }
}
