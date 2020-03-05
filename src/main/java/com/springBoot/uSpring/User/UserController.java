package com.springBoot.uSpring.User;

import com.springBoot.uSpring.Comments.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    private List<User> users;
    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> getUsers(){
        return userService.getUsers() ;
    }

    @PostMapping("/saveUser")
    public User addUser(@RequestBody  User user){
        return userService.addUser(user) ;
    }
    @PostMapping("/saveUsers")
    public List<User> addUsers(@RequestBody List<User> users){
        return userService.addUsers(users) ;
    }
    @GetMapping("/user/{id}")
    public User getComment(@PathVariable int id){
        return userService.getUser(id) ;
    }


    @PutMapping("/updateUser")
    public User updateComment(@RequestBody User user){
        return userService.updateUser(user) ;
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        return userService.deleteUser(id) ;
    }
}
