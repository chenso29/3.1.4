package com.chenson2910.mycrudboot.service;

import com.chenson2910.mycrudboot.model.Role;
import com.chenson2910.mycrudboot.model.User;

import java.util.List;

public interface UserService {
    List<User> listAll();

    boolean save(User user);

    User get(Integer id) throws UserNotFoundException;

    void delete(Integer id) throws UserNotFoundException;

}
