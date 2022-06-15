package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUser(int id) {
        return userDao.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        userDao.save(user);
        return user;
    }

    @Override
    public User update(int id, User user) {
        User u = userDao.findById(id).get();
        u.setName(user.getName());
        u.setCity(user.getCity());
        userDao.save(u);
        return user;
    }

    @Override
    public User delete(int id) {
        User u = userDao.findById(id).get();
        userDao.delete(u);
        return u;
    }
}
