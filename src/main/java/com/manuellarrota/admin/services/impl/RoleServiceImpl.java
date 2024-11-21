package com.manuellarrota.admin.services.impl;

import com.manuellarrota.admin.entities.Role;
import com.manuellarrota.admin.repositories.RoleRepository;
import com.manuellarrota.admin.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> findLike(String keyword) {
        return roleRepository.findByNameContaining(keyword);
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Long id, Role role) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if(roleOptional.isPresent()){
            roleOptional.get().setName(role.getName());
            return roleRepository.save(roleOptional.get());
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Role> role = findById(id);
        role.ifPresent(roleRepository::delete);
    }
}