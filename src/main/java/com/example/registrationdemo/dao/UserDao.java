package com.example.registrationdemo.dao;

import com.example.registrationdemo.entities.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserDao {

    private final static Map<Long, User> db = new HashMap<>();
    private static long ID = 1;

    public User save(User user){
        user.setId(ID);
        db.put(ID, user);
        ID++;
        return user;
    }

    public User update(User user){
        db.put(user.getId(), user);
        return user;
    }

    public User select(User user){
        return db.get(user.getId());
    }

    public Collection<User> getAll(){
        return db.values();
    }

    public void delete(User user){
        db.remove(user.getId());
    }

    public Optional<User> findUserByEmailAndPassword(User user){
        Collection<User> dbUsers = getAll();
        List<User> filteredUsers = dbUsers.stream().
                filter(u -> u.getEmail().equals(user.getEmail()) &&
                        u.getPassword().equals(user.getPassword())).
                collect(Collectors.toList());
        return filteredUsers.size() > 0 ? Optional.of(filteredUsers.get(0)) : Optional.empty();
    }


}
