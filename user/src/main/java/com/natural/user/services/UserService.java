package com.natural.user.services;

import com.natural.user.domain.User;

public interface UserService {
    User getUser(Long id);
    User saveAndUpdateUser(User user);
    void deleteUser(Long id);
}
