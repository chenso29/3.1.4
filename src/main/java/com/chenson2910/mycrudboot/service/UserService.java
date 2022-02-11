package com.chenson2910.mycrudboot.service;

import com.chenson2910.mycrudboot.model.User;
import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User getOneUser(Long id);

    User insertUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);
}
