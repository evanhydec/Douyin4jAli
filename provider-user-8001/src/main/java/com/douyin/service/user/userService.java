package com.example.service.user;


import com.example.DTO.userDto;

import java.util.List;

public interface userService {
    userDto login(String name, String pwd);
    Integer register(String name,String pwd);
    userDto getUser(Integer id,Integer uid);
    List<userDto> getUsers(List<Integer> ids);
    boolean update(userDto user);
}
