package com.natural.user.controllers;

import com.natural.user.domain.User;
import com.natural.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @GetMapping
    ResponseEntity<UserDto> getUser(Long id){
        log.info("getuser");
        return null;
    }

    @PostMapping
    ResponseEntity<UserDto> saveAndUpdateUser(User user){
        log.info("saveUser");
        return null;
    }

    @DeleteMapping
    void deleteUser(Long id){
        log.info("Delete user");
    }
}
