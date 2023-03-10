package com.example.demo.Service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Entity.User;
import com.example.demo.Exception.ResourceNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        User user = null;
        try {
            user = userRepository.findById(id).get();
            if (user == null) {
                throw new ResourceNotFound("User with id : " + id + " does not exists");
            }
        }
        catch (NoSuchElementException e){
            log.error(e.getMessage());
            throw new ResourceNotFound("User with id : " + id + " does not exists");
        }
        return user;
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
        u.setEmail(user.getEmail());
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
