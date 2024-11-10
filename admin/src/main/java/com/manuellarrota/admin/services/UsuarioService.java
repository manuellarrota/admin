package com.manuellarrota.admin.services;

import com.manuellarrota.admin.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    void delete(Long id);
}
