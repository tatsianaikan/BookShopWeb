package com.example.bookshop.controller;


import com.example.bookshop.entity.User;
import com.example.bookshop.pojosdto.RoleDto;
import com.example.bookshop.pojosdto.UserDto;
import com.example.bookshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Configurable
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;


    /**
     * Add one new users in DB
     * @param name - String
     * @param login - String
     * @param roleType - Role obj
     * @return a JSON with added user
     */
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addNewUser(@RequestParam String name,
                           @RequestParam String login,
                           @RequestParam RoleDto roleType){
        return userService.addNewUser(new UserDto(name, login, roleType));
    }

    /**
     * Add one new users in DB
     * @param userDto - User obj
     * @return a JSON with added user
     */
    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addNewUser(@RequestBody UserDto userDto) {
        return userService.addNewUser(userDto);
    }

    /**
     * Get user by Id
     * @param userId - int
     * @return a JSON of found user
     */
    @GetMapping("/get")
    @ResponseBody
    public UserDto getUser(@RequestParam int userId){
        return userService.getUser(userId);
    }

    /**
     * Delete user by Id
     * @param userId - int
     * @return String message about successful removal of user
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public void deleteUser(@RequestParam int userId){
        userService.deleteUser(userId);
    }

    /**
     * Receiving all users in DB
     * @return a JSON with list of the users
     */
    @GetMapping("/all")
    @ResponseBody
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
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
