package com.manuellarrota.admin.controllers;

import com.manuellarrota.admin.entities.Usuario;
import com.manuellarrota.admin.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    UsuarioService usuarioService;

    @Autowired
    public UserController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public String listaUsuarios(Model model) {

        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/listaUsuarios";
    }

    @GetMapping("/usuarios/crear")
    public String crearUsuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/crearUsuario";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }
}
