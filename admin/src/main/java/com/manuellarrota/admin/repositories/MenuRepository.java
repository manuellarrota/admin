package com.manuellarrota.admin.repositories;

import com.manuellarrota.admin.entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT m FROM Menu m JOIN m.allowedRoles r WHERE r.nombre IN :roles")
    List<Menu> findMenusByRoles(@Param("roles") List<String> roles);

}