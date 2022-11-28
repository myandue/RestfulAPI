package com.example.RestfulAPI.controller;

import com.example.RestfulAPI.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class userController {

    private Map<String, User> userMap;

    @PostConstruct
    public void init(){
        userMap = new HashMap<>();
        userMap.put("1", new User("1", "홍길동", "111-1111", "서울시 강남구 대치1동"));
        userMap.put("2", new User("2", "홍길자", "111-1112", "서울시 강남구 대치2동"));
        userMap.put("3", new User("3", "홍길순", "111-1113", "서울시 강남구 대치3동"));
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return new ArrayList<User>(userMap.values());
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String id){
         return userMap.get(id);
    }

    //새로운 사용자 생성
    @PostMapping("/user/{id}")
    public void postUser(@PathVariable("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("phone") String phone,
                         @RequestParam("address") String address){
        User user = new User(id, name, phone, address);
        userMap.put(id,user);
    }

    //사용자 아이디 조회 후 수정
    @PutMapping("/user/{id}")
    public void putUser(@PathVariable("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("phone") String phone,
                         @RequestParam("address") String address){
        User user = userMap.get(id);

        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") String id){
        userMap.remove(id);
    }
}
