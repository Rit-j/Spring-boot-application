package com.example.demo.Service;

import com.example.demo.Entity.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User getUser(int id);

    public User addUser(User user);

    public User update(int id, User user);

    public User delete(int id);
}
