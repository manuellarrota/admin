package com.manuellarrota.admin.controllers;

import com.manuellarrota.admin.entities.Usuario;
import com.manuellarrota.admin.services.MenuService;
import com.manuellarrota.admin.services.RolService;
import com.manuellarrota.admin.services.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    private final UsuarioService usuarioService;
    private final MenuService menuService;
    private final RolService rolService;
    private static final String USER_VIEW = "users";

    @Autowired
    public UserController(UsuarioService usuarioService, MenuService menuService, RolService rolService) {
        this.usuarioService = usuarioService;
        this.menuService = menuService;
        this.rolService = rolService;
    }

    @GetMapping
    public String listaUsuarios(Model model) {
        cargarDatosPagina(model);
        return USER_VIEW;
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        model.addAttribute("roles", rolService.findAll());
        model.addAttribute("userMenu", menuService.findAll());
        model.addAttribute("userList", usuarioService.findLike(keyword));
        return USER_VIEW;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        usuarioService.delete(id);
        cargarDatosPagina(model);
        return "redirect:/user";
    }

    @PostMapping("/save")
    public String guardarUsuario(@ModelAttribute Usuario usuario, Model model) {
        log.info("Guardando USARIOO");
        log.info(usuario.toString());
        usuarioService.save(usuario);
        cargarDatosPagina(model);
        return "redirect:/user";

    }

    @PutMapping("/edit/{id}")
    public String editarUsuario(@PathVariable Long id, @ModelAttribute Usuario usuario, Model model) {
        log.info("EDITAR USARIOO");
        log.info(usuario.toString());
        usuarioService.update(id, usuario);
        cargarDatosPagina(model);
        return "redirect:/user";
    }

    void cargarDatosPagina(Model model){
        model.addAttribute("roles", rolService.findAll());
        model.addAttribute("userMenu", menuService.findAll());
        model.addAttribute("userList", usuarioService.findAll());
    }
}
