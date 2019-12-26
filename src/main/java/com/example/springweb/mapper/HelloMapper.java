package com.example.springweb.mapper;

import com.example.springweb.dao.HelloUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HelloMapper {
    @Select("select * from user ")
    @Results({
            @Result(property = "id", column = "stringId"),
            @Result(property = "name", column = "user_name")
    })
    List<HelloUser> findAll();

    @Insert("insert into user(stringId,user_name,password) values(#{id},#{name},#{password})")
    void insert(HelloUser helloUser);


    @Select("select * from user where stringId = #{id}")
    @Results({
            @Result(property = "id",column = "stringId"),
            @Result(property = "name",column = "user_name")
    })
    HelloUser getOne(String id);

    @Select("select name from user where name=#{name} and password=#{password}")
    public String login(@Param("name")String name,@Param("password") String password);

    @Update("update user set user_name = #{name}, password = #{password} where StringId = #{id}")
    void updateByID(HelloUser helloUser);//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值

    @Delete("delete from user where StringId = #{id}")
    void deleteByID(String id);//DELETE FROM 表名称 WHERE 列名称 = 值

    @Update("update appinfo set name=#{name} where id=#{id}")
    void update_name(@Param("name")String name,@Param("id")int id);

    @Update("update appinfo set classify=#{classify} where id=#{id}")
    void update_type(@Param("classify") String classify,@Param("id")int id);

    @Update("update appinfo set safety=#{safety} where id=#{id}")
    void update_safety_level(@Param("safety") String safety,@Param("id")int id);

    @Update("update appinfo set grade=#{grade} where id=#{id}")
    void update_grade(@Param("grade") String grade,@Param("id")int id);

    // 下方无问题
    @Select("select safety from appinfo where id=#{id}")
    public String safety(int id);

    @Select("select classify from appinfo where id=#{id}")
    public String type(int id);

    @Select("select name from appinfo where id=#{id}")
    public String get_name(int id);

    @Select("select grade from appinfo where id=#{id}")
    public String grade(int id);
}
