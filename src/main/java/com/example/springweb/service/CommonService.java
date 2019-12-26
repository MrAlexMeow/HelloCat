package com.example.springweb.service;

import com.example.springweb.dao.HelloUser;
import com.example.springweb.mapper.HelloMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springweb.mapper.Common;

@Service
public class CommonService {
    @Resource
    public Common commonmapper;
    public String login(String sno, String password){
        return commonmapper.login(sno, password);
    }
}
