package com.manuellarrota.admin.services;

import com.manuellarrota.admin.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> findAll();
    Optional<Rol> findById(Long id);
    Rol save(Rol dto);
    void delete(Long id);
}