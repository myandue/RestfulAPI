package com.example.RestfulAPI.controller;

import com.example.RestfulAPI.mapper.UserMapper;
import com.example.RestfulAPI.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class userController {

    private final UserMapper mapper;
//    private Map<String, User> userMap;
    //아 이게 repository를 따로 생성 안해주고 controller 안에 map을 생성해버려서
    //java 메모리 -> 외부 DB 변경하려니까 코드를 싹 변경해야하는구나,,
    //repository 분리해서 해보기

//    @PostConstruct
//    public void init(){
//        userMap = new HashMap<>();
//        userMap.put("1", new User("1", "홍길동", "111-1111", "서울시 강남구 대치1동"));
//        userMap.put("2", new User("2", "홍길자", "111-1112", "서울시 강남구 대치2동"));
//        userMap.put("3", new User("3", "홍길순", "111-1113", "서울시 강남구 대치3동"));
//    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String id){
//        return userMap.get(id);
         return mapper.getUser(id);
    }

    @GetMapping("/users")
    public List<User> getAllUser(){
//        return new ArrayList<User>(userMap.values());
        return mapper.getAllUser();
    }

    //새로운 사용자 생성
    @PostMapping("/user/{id}")
    public void postUser(@PathVariable("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("phone") String phone,
                         @RequestParam("address") String address){
//        User user = new User(id, name, phone, address);
//        userMap.put(id,user);
        mapper.insertUser(id,name,phone,address);
    }

    //사용자 아이디 조회 후 수정
    @PutMapping("/user/{id}")
    public void putUser(@PathVariable("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("phone") String phone,
                         @RequestParam("address") String address){
//        User user = userMap.get(id);
//
//        user.setName(name);
//        user.setPhone(phone);
//        user.setAddress(address);
        mapper.updateUser(id,name,phone,address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") String id){
//        userMap.remove(id);
        mapper.deleteUser(id);
    }
}
