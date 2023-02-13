package com.example.bookshop.serviceimpl;


import com.example.bookshop.entity.User;
import com.example.bookshop.mapper.Converter;
import com.example.bookshop.pojos.UserObj;
import com.example.bookshop.repository.IUserRepository;
import com.example.bookshop.service.IUserService;
import jakarta.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bookshop.mapper.Converter.converter;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Autowired(required = true)
    private IUserRepository userRepository;

    @Transactional
    public User addNewUser(UserObj userObj) {
       User userEnity = converter.userToEntity(userObj);
       return userRepository.save(userEnity);
    }

    @Transactional
    public List<User> getAllUsers() {
        List<User> usersResponse =(List<User>) userRepository.findAll();
        return usersResponse;
    }

    @Transactional
    public User getUser(int idUser) {
        return userRepository.findById(idUser).get();
    }

    @Transactional
    public void deleteUser(int idUser) {
       userRepository.deleteById(idUser);
    }
}
