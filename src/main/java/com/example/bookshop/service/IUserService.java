package com.example.bookshop.service;

import com.example.bookshop.entity.User;
import com.example.bookshop.pojosdto.ProductDto;
import com.example.bookshop.pojosdto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserService {

    public UserDto addNewUser(UserDto user);
    public UserDto getUser (long idUser);
    public UserDto editUser(UserDto user);
    public String deleteUser (long idUser);
    public Iterable<UserDto> getAllUsers(Integer pageNo, Integer pageSize);

    public boolean isUserExists (long idUser);
}
