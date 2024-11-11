package com.manuellarrota.admin.services;

import com.manuellarrota.admin.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> findAll();
    List<Rol> findLike(String keyword);
    Optional<Rol> findById(Long id);
    Rol save(Rol rol);
    Rol update(Long id, Rol rol);
    void delete(Long id);
}