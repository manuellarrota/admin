package com.manuellarrota.admin.repositories;

import com.manuellarrota.admin.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    List<Rol> findByNombreContaining(String keyWord);
}