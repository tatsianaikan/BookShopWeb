package com.example.bookshop.controller;


import com.example.bookshop.pojosdto.RoleDto;
import com.example.bookshop.pojosdto.UserDto;
import com.example.bookshop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Configurable
@RequestMapping("/userProfile")
public class UserProfileController {

    @Autowired
    private IUserService userService;

    /**
     * Get user with Id=1 then click on 'User Profile' menu
     * @return String - userProfilePage page
     */
    @GetMapping("")
    public String getCurrentUser(Model model){
        model.addAttribute("title", "User Profile Page");
        model.addAttribute("user",  userService.getUser(1l));
        return "view/pages/userProfilePage";
    }

    /**
     * Add one new user in DB
     * @param userName - String
     * @param email - String
     * @param login - String
     * @param address - String
     * @return a JSON with added user
     */
    @PostMapping("/add")
    public String addNewUser(@RequestParam String userName,
                             @RequestParam String email,
                             @RequestParam String login,
                             @RequestParam String address,
                             Model model){
        userService.addNewUser(new UserDto(userName, email, login, address));
        return "redirect:/user";
    }

    /**
     * Add one new user as Object in DB(it is used for tests now)
     * @param userDto - User obj
     * @return a JSON with added user
     */
    @PostMapping("/addFullUser")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addNewUser(@RequestBody UserDto userDto) {
        return userService.addNewUser(userDto);
    }


    /**
     * Get user by Id
     * @param userId - int
     * @return String - userProfilePage page
     */
    @GetMapping("/{userId}")
    public String getUserById(@PathVariable(value="userId") long userId, Model model){
        model.addAttribute("title", "User Profile");

        if(!userService.isUserExists(userId))
            return "redirect:/user";
        model.addAttribute("user",  userService.getUser(userId));
        return "view/pages/userProfilePage";
    }

     /**
     * Edit user by Id
     * @param userId - int
     * @return String - userProfilePage page
     */
    @PostMapping("/{userId}")
    public String editUser(@RequestParam String userName,
                           @RequestParam String email,
                           @RequestParam String login,
                           @RequestParam String address,
                           @PathVariable(value="userId") long userId,
                           Model model){

        model.addAttribute("title", "Edit User");

        UserDto user = userService.getUser(userId);
        user.setName(userName);
        user.setEmail(email);
        user.setLogin(login);
        user.setAddress(address);

        userService.editUser(user);
        model.addAttribute("user",  userService.getUser(userId));
        return "view/pages/userProfilePage";
    }
}