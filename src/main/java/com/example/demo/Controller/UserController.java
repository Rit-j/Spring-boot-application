package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = this.userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public ResponseEntity<User> getUser(@PathVariable int id){
        User u = this.userService.getUser(id);
        return new ResponseEntity<>(u, HttpStatus.FOUND);
    }

    @PostMapping("/addUser")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User u = this.userService.addUser(user);
        return new ResponseEntity<>(u, HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user){
        User u = this.userService.update(id,user);
        return new ResponseEntity<>(u, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<User> delete(@PathVariable int id){
        User u = this.userService.delete(id);
        return new ResponseEntity<>(u, HttpStatus.ACCEPTED);
    }
}
