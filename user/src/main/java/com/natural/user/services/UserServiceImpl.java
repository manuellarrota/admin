package com.natural.user.services;

import com.natural.user.domain.User;
import com.natural.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User saveAndUpdateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
