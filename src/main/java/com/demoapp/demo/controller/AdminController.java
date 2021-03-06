package com.demoapp.demo.controller;

import com.demoapp.demo.ApplicationConstants;
import com.demoapp.demo.model.User;
import com.demoapp.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {

    @Autowired
    UserService userService;

    /**
     * this method returns the json of all the users on the root screen
     * i.e.: localhost:port
     */
    @GetMapping(ApplicationConstants.GET_ALL_USERS)
    public List<User> displayAllUsers(){
        return userService.displayAllUsers();
    }

    /**
     * @param id: id Of the user to be retrieved
     */
    @GetMapping(ApplicationConstants.GET_USER_BY_ID)
    public Optional<User> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping(ApplicationConstants.ADD_ONE_USER)
    public void addUser(User user){
        userService.addUser(user);
    }

    @PutMapping(ApplicationConstants.UPDATE_ONE_USER)
    public void updateUser(@PathVariable Integer id, User userToUpdate){
        userService.updateUser(id, userToUpdate);
    }

    @DeleteMapping(ApplicationConstants.DELETE_ONE_USER)
    public void deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
    }

}
