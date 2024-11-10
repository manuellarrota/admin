package com.manuellarrota.admin.controllers;

import com.manuellarrota.admin.entities.Rol;
import com.manuellarrota.admin.entities.Usuario;
import com.manuellarrota.admin.services.MenuService;
import com.manuellarrota.admin.services.RolService;
import com.manuellarrota.admin.services.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rol")
public class RolController {

    private final RolService rolService;
    private final UsuarioService usuarioService;
    private final MenuService menuService;

    public RolController(MenuService menuService, UsuarioService usuarioService, RolService rolService) {
        this.menuService = menuService;
        this.usuarioService = usuarioService;
        this.rolService = rolService;
    }

    @GetMapping("/usuarios")
    public String listaUsuarios(Model model) {
        model.addAttribute("userMenu", menuService.findAll());
        List<Rol> roles = rolService.findAll();
        model.addAttribute("usuarios", roles);
        return "rol/roles";
    }


    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario, Model model) {
        log.info("Guardando " + usuario.toString());
        usuarioService.save(usuario);
        model.addAttribute("userMenu", menuService.findAll());
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios/usuarios";
    }
}
