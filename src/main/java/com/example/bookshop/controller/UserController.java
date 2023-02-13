package com.example.bookshop.controller;


import com.example.bookshop.entity.Role;
import com.example.bookshop.entity.User;
import com.example.bookshop.pojos.RoleObj;
import com.example.bookshop.pojos.UserObj;
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
    public User addNewUser(@RequestParam String name,
                           @RequestParam String login,
                           @RequestParam RoleObj roleType){
        return userService.addNewUser(new UserObj(name, login, roleType));
    }

    /**
     * Add one new users in DB
     * @param userObj - User obj
     * @return a JSON with added user
     */
    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public User addNewUser(@RequestBody UserObj userObj) {
        return userService.addNewUser(userObj);
    }

    /**
     * Get user by Id
     * @param userId - int
     * @return a JSON of found user
     */
    @GetMapping("/get")
    @ResponseBody
    public User getUser(@RequestParam int userId){
        return userService.getUser(userId);
    }

    /**
     * Delete user by Id
     * @param userId - int
     * @return String message about successful removal of user
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public String deleteUser(@RequestParam int userId){
        User user = new User();
        user = userService.getUser(userId);
        userService.deleteUser(userId);
        return user.getName() + " was deleted!";
    }

    /**
     * Receiving all users in DB
     * @return a JSON with list of the users
     */
    @GetMapping("/all")
    @ResponseBody
    public List<User> getAllUsers(){
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
