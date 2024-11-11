package com.manuellarrota.admin.controllers;

import com.manuellarrota.admin.entities.Rol;
import com.manuellarrota.admin.services.MenuService;
import com.manuellarrota.admin.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/role")
public class RolController {

    private final RolService rolService;
    private final MenuService menuService;


    @Autowired
    public RolController(RolService rolService, MenuService menuService) {
        this.rolService = rolService;
        this.menuService = menuService;
    }

    // Mostrar la página de roles con la lista de roles
    @GetMapping
    public String listRoles(Model model) {
        model.addAttribute("userMenu", menuService.findAll());
        model.addAttribute("roleList", rolService.findAll());
        return "roles";
    }

    // Guardar un nuevo rol
    @PostMapping("/save")
    public String saveRole(@ModelAttribute Rol rol) {
        rolService.save(rol);
        return "redirect:/role";
    }

    // Buscar roles
    @GetMapping("/search")
    public String searchRoles(@RequestParam String keyword, Model model) {
        model.addAttribute("userMenu", menuService.findAll());
        model.addAttribute("roleList", rolService.findLike(keyword));
        return "roles";
    }

    // Editar un rol
    @PutMapping("/edit/{id}")
    public String editRole(@PathVariable Long id, @ModelAttribute Rol rol) {
        rolService.update(id, rol);
        return "redirect:/role";
    }

    // Eliminar un rol
    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        rolService.delete(id);
        return "redirect:/role";
    }

    void cargarDatosPagina(Model model){
        model.addAttribute("roles", rolService.findAll());
        model.addAttribute("userMenu", menuService.findAll());
    }
}
