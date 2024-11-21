package com.manuellarrota.admin.services;

import com.manuellarrota.admin.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    List<User> findLike(String keyword);
    User findById(Long id);
    User save(User user);
    User update(Long id, User user);
    void delete(Long id);
}
