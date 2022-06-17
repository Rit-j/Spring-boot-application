package com.example.demo.Service;

import com.example.demo.Dao.UserRepository;
import com.example.demo.Entity.User;
import com.example.demo.Exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFound("User with id : " + id +" does not exists"));
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User update(int id, User user) {
        User u = userRepository.findById(id).orElseThrow(()->new ResourceNotFound("User with id : " + id +" does not exists"));;
        u.setName(user.getName());
        u.setCity(user.getCity());
        userRepository.save(u);
        return user;
    }

    @Override
    public User delete(int id) {
        User u = userRepository.findById(id).orElseThrow(()->new ResourceNotFound("User with id : " + id +" does not exists"));;
        userRepository.delete(u);
        return u;
    }
}
