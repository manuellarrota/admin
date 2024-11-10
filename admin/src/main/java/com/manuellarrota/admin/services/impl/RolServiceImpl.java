package com.manuellarrota.admin.services.impl;

import com.manuellarrota.admin.entities.Rol;
import com.manuellarrota.admin.repositories.RolRepository;
import com.manuellarrota.admin.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void delete(Long id) {
        Optional<Rol> rol = findById(id);
        rol.ifPresent(rolRepository::delete);
    }
}