package com.example.bookshop.serviceimpl;


import com.example.bookshop.entity.User;
import com.example.bookshop.pojosdto.UserDto;
import com.example.bookshop.repository.IUserRepository;
import com.example.bookshop.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.bookshop.mapper.Converter.converter;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Autowired(required = true)
    private IUserRepository userRepository;

    @Transactional
    public UserDto addNewUser(UserDto userDto) {
       User userEnity =  userRepository.save(converter.userToEntity(userDto));
       return converter.userToDto(userEnity);
    }

    @Transactional
    public List<UserDto> getAllUsers() {
        List<User> usersResponse =(List<User>) userRepository.findAll();
        return usersResponse.stream()
                            .map(userEntry -> converter.userToDto(userEntry))
                            .collect(Collectors.toList());
    }

    @Transactional
    public UserDto getUser(int idUser) {
        User userEnity =  userRepository.findById(idUser).get();
        return converter.userToDto(userEnity);
    }

    @Transactional
    public String deleteUser(int idUser) {
        UserDto user = new UserDto();
        user = getUser(idUser);

       userRepository.deleteById(idUser);
       return user.getName() + " was deleted!";
    }
}
