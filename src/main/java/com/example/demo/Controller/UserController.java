package com.example.demo.Controller;


import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(){
        return "Welcome";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        return this.userService.getUser(id);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable int id, @RequestBody User user){
        return this.userService.update(id,user);
    }

    @DeleteMapping("/user/{id}")
    public User delete(@PathVariable int id){
        return this.userService.delete(id);
    }
}
