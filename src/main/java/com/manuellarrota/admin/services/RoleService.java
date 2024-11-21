package com.manuellarrota.admin.services;

import com.manuellarrota.admin.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> findAll();
    List<Role> findLike(String keyword);
    Optional<Role> findById(Long id);
    Role save(Role role);
    Role update(Long id, Role role);
    void delete(Long id);
}