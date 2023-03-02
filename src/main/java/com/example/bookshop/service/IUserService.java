package com.example.bookshop.service;

import com.example.bookshop.entity.User;
import com.example.bookshop.pojosdto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserService {

    public UserDto addNewUser(UserDto user);
    public UserDto getUser (int idUser);
    public String deleteUser (int idUser);
    public List<UserDto> getAllUsers();
}
