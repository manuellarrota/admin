package com.manuellarrota.admin.services.impl;

import com.manuellarrota.admin.entities.User;
import com.manuellarrota.admin.repositories.UserRepository;
import com.manuellarrota.admin.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findLike(String keyword) {
        return userRepository.findByMailContaining(keyword);
    }

    @Override
    public User findById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        return userOpt.orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        Optional<User> usuarioOptional = userRepository.findById(id);
        if(usuarioOptional.isPresent()){
            User instancia = usuarioOptional.get();
            try {
                PropertyUtils.describe(user).entrySet().stream()
                        .filter(Objects::nonNull)
                        .filter(e -> !e.getKey().equals("class"))
                        .filter(e -> !e.getKey().equals("id"))
                        .filter(e -> !e.getKey().equals("dateCreated"))
                        .filter(e -> !e.getKey().equals("handler"))
                        .filter(e -> !e.getKey().equals("hibernateLazyInitializer"))
                        .forEach(
                                e -> {
                                    try {
                                        if (e.getValue() != null) {
                                            PropertyUtils.setProperty(instancia, e.getKey(), e.getValue());
                                        }
                                    } catch (Exception ex) {
                                        log.error(ex.getMessage());
                                    }
                                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info(instancia.getRole().toString());
            log.info(instancia.toString());
            return userRepository.save(instancia);

        }
        return null;
    }

    @Override
    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
}