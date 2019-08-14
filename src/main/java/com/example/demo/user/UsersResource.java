package com.example.demo.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
@Component

public class UsersResource {

    @Autowired
    private UsersMapper usersMapper;

    private final SqlSession sqlSession;

    public UsersResource(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @GetMapping
    public List<Users> getAllUsers(){
        return usersMapper.findAll();
    }

    @RequestMapping("/findUserById/{id}")
    public List<Users> findUserById(@PathVariable Integer id){
        return this.sqlSession.selectOne("findUserById", id);
    }


    @RequestMapping("/{id}")
    public Users getOneUsers(@PathVariable Integer id){
        return usersMapper.findOne(id);
    }
}
