package com.example.bookshop.service;

import com.example.bookshop.controller.UserController;
import com.example.bookshop.pojosdto.RoleDto;
import com.example.bookshop.pojosdto.UserDto;
import com.example.bookshop.pojosdto.enums.RoleType;
import com.example.bookshop.serviceimpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest()
class UserServiceTests {

    @Autowired
    private UserServiceImpl userService;


    @Test
    @BeforeTestMethod("givenAllUsers")
    public void addNewUser() {
        String actualUserName = "tata";
        String actualUserlogin = "kolyta";
        String actualEmail = "user@gmail.com";

        UserDto userResp = new UserDto();
        userResp.setName(actualUserName);
        userResp.setLogin(actualUserlogin);
        userResp.setEmail(actualEmail);
        userResp.setRole(RoleType.CUSTOMER);

        userResp = userService.addNewUser(userResp);
        assertThat(userResp.getName().equals(actualUserName));
        assertThat(userResp.getLogin().equals(actualUserlogin));
        assertThat(userResp.getEmail().equals(actualEmail));
        assertThatNoException();

    }

    @Test
	public void givenAllUsers() {
        ArrayList<UserDto> users = new ArrayList<>();
        users = (ArrayList<UserDto>) userService.getAllUsers(0, 2);
        assertThat(users.size() > 0);
    }
}
