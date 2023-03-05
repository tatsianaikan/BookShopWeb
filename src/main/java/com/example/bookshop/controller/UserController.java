package com.example.bookshop.controller;


import com.example.bookshop.entity.User;
import com.example.bookshop.pojosdto.RoleDto;
import com.example.bookshop.pojosdto.UserDto;
import com.example.bookshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
@Configurable
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * Receiving all users in DB
     * @return String - path to usersPage
     */
    @GetMapping("")
    public String getAllUsers(Model model,
                              @RequestParam(defaultValue = "0") Integer pageNo,
                              @RequestParam(defaultValue = "5") Integer pageSize){
        model.addAttribute("title", "Users");

        Iterable<UserDto> users = userService.getAllUsers(pageNo, pageSize);
        model.addAttribute("usersList", users);
        return "view/pages/usersPage";
    }

    /**
     * Get user by Id
     * @return String - userProfilePage page
     */
    @GetMapping("/createUser")
    public String openCreateUserForm(Model model){
        model.addAttribute("title", "Created User Page");
        return "view/pages/userCreatePage";
    }

    /**
     * Delete user by Id
     * @param userId - int
     * @return String message about successful removal of user
     */
    @PostMapping("/delete/{userId}")
    public String deleteUser(@PathVariable(value="userId") long userId, Model model){
        model.addAttribute("title", "Delete User");

        userService.deleteUser(userId);
        return "redirect:/user";
    }
}


/**
 * customers can:
 *      - login/logout
 *      - view own profile
 *      - edit own profile
 *      - delete own profile
 *
 * managers can:
 *      - login/logout
 *
 * administrators can:
 *    - login/logout
 *    - create accounts;
 *    - view accounts;
 *    - edit accounts;
 *    - delete accounts;
 *
 */
