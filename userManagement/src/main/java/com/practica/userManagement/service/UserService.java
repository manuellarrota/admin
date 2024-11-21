package com.practica.userManagement.service;


import com.practica.userManagement.domain.User;
import com.practica.userManagement.domain.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto saveUser(UserDto userDto);
    boolean deleteUser(Long id);
    UserDto converToDto(User user);
    User converToEntity(UserDto userDto);
}
