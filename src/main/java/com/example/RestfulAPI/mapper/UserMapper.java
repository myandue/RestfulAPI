package com.example.RestfulAPI.mapper;

import com.example.RestfulAPI.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM User WHERE id=#{id}")
    User getUser(@Param("id") String id);

    @Select("SELECT * FROM User")
    List<User> getAllUser();

    //Insert, Update, Delete는 sql문에 의해 영향 받은 record의 개수가 반환된다.
    @Insert("INSERT INTO User VALUES(#{id}, #{name}, #{phone}, #{address})")
    int insertUser(@Param("id") String id,
                  @Param("name") String name,
                  @Param("phone") String phone,
                  @Param("address") String address);

    @Update("UPDATE User SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
    int updateUser(@Param("id") String id,
                  @Param("name") String name,
                  @Param("phone") String phone,
                  @Param("address") String address);

    @Delete("DELETE FROM USER WHERE id=#{id}")
    int deleteUser(@Param("id") String id);
}
