package com.tts.RuleZero.service;

import com.tts.RuleZero.model.User;

import java.util.List;

public interface UserService {

    User findByUsername(String username);

    List<User> findAll();

    void save(User user);

    User saveNewUser(User user);

    User getLoggedInUser();


}
