package com.example.demo.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from users")
    List<Users> findAll();

    List<Users> findAllUsers();

    @Select("select * from users where id=#{id}")
    Users findOne(Integer id);
}
