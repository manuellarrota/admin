package com.manuellarrota.admin.services.impl;

import com.manuellarrota.admin.entities.Usuario;
import com.manuellarrota.admin.repositories.UsuarioRepository;
import com.manuellarrota.admin.services.UsuarioService;
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
public class UsuarioServiceImpl implements UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findLike(String keyword) {
        return usuarioRepository.findByEmailContaining(keyword);
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        return usuarioOpt.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuario save(Usuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            Usuario instancia = usuarioOptional.get();
            try {
                PropertyUtils.describe(usuario).entrySet().stream()
                        .filter(Objects::nonNull)
                        .filter(e -> !e.getKey().equals("class"))
                        .filter(e -> !e.getKey().equals("id"))
                        .filter(e -> !e.getKey().equals("fechaCreacion"))
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
            log.info(instancia.getRol().toString());
            log.info(instancia.toString());
            return usuarioRepository.save(instancia);

        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Usuario usuario = findById(id);
        usuarioRepository.delete(usuario);
    }
}