package com.example.bookshop.serviceimpl;


import com.example.bookshop.entity.User;
import com.example.bookshop.pojosdto.UserDto;
import com.example.bookshop.repository.IUserRepository;
import com.example.bookshop.service.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public UserDto editUser(UserDto userDto) {
        if(isUserExists(userDto.getUserId())) {
            User userEnity = userRepository.save(converter.userToEntity(userDto));
            return converter.userToDto(userEnity);
        }
        return null;
    }

    @Transactional
    public List<UserDto> getAllUsers(Integer pageNo, Integer pageSize) {
        PageRequest paging = PageRequest.of(pageNo, pageSize);

        Page<User> usersResponse = userRepository.findAll(paging);

        if(usersResponse.hasContent()) {
        return usersResponse.stream()
                            .map(userEntry -> converter.userToDto(userEntry))
                            .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Transactional
    public UserDto getUser(long idUser) {
        User userEnity =  userRepository.findById(idUser).get();
        return converter.userToDto(userEnity);
    }

    @Transactional
    public String deleteUser(long idUser) {
        UserDto user = new UserDto();
        user = getUser(idUser);

       userRepository.deleteById(idUser);
       return user.getName() + " was deleted!";
    }

    @Transactional
    public boolean isUserExists(long idUser) {
        if(!userRepository.existsById(idUser)){
            return false;
        }
        return true;
    }
}
