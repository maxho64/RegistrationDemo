package com.example.registrationdemo.service;

import com.example.registrationdemo.dao.UserDao;
import com.example.registrationdemo.entities.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    private final UserDao dao;

    public UserService(){
        dao = new UserDao();
    }

    public User save(User user){
        return dao.save(user);
    }

    public User update(User user){
        return dao.update(user);
    }

    public User select(User user){
        return dao.select(user);
    }

    public Collection<User> getAll(){
        return dao.getAll();
    }

    public void delete(User user){
        dao.delete(user);
    }

    public boolean isRegistered(User user){
        return dao.findUserByEmailAndPassword(user).isPresent();
    }
}
