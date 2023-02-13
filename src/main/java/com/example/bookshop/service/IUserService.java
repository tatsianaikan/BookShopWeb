package com.example.bookshop.service;

import com.example.bookshop.entity.User;
import com.example.bookshop.pojos.UserObj;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserService {

    public User addNewUser(UserObj user);
    public User getUser (int idUser);
    public void deleteUser (int idUser);
    public List<User> getAllUsers();
}
