package com.example.bookshop;

import com.example.bookshop.controller.UserController;
import com.example.bookshop.entity.Role;
import com.example.bookshop.entity.User;
import com.example.bookshop.pojos.RoleObj;
import com.example.bookshop.pojos.enums.RoleType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest()
class UserControllerTests {

    @Autowired
    private UserController userController;


    @Test
    @BeforeTestMethod("givenAllUsers_Status200")
    public void addNewUserObj_Status200() {
        String actualUserName = "tata";
        String actualUserlogin = "kolyta";
        RoleObj roleType = new RoleObj(RoleType.CUSTOMER);

        User userResp = new User();
        userResp = userController.addNewUser(actualUserName, actualUserlogin, roleType);
        assertThat(userResp.getName().equals(actualUserName));
        assertThat(userResp.getLogin().equals(actualUserlogin));
        assertThatNoException();

    }

    @Test
	public void givenAllUsers_Status200() {
        ArrayList<User> users = new ArrayList<>();
        users = (ArrayList<User>) userController.getAllUsers();
        assertThat(users.size() > 0);

    }

}
