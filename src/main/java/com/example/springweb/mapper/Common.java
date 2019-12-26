package com.example.springweb.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface Common {
    @Select("select name from user where name=#{name} and password=#{password}")
    @Results({
            @Result(property = "name", column = "name")
    })
    public String login(@Param("name") String sno,@Param("password") String password);
}
