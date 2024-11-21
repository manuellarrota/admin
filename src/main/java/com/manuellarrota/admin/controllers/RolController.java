package com.manuellarrota.admin.controllers;

import com.manuellarrota.admin.entities.Role;
import com.manuellarrota.admin.services.MenuService;
import com.manuellarrota.admin.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/role")
public class RolController {

    private final RoleService roleService;
    private final MenuService menuService;
    private static final  String ROLE_VIEW_REDIRECT = "redirect:/role";

    @Autowired
    public RolController(RoleService roleService, MenuService menuService) {
        this.roleService = roleService;
        this.menuService = menuService;
    }

    @GetMapping
    public String listRoles(Model model) {
        model.addAttribute("userMenu", menuService.findAll());
        model.addAttribute("roleList", roleService.findAll());
        return "roles";
    }

    @PostMapping("/save")
    public String saveRole(@ModelAttribute Role role) {
        roleService.save(role);
        return ROLE_VIEW_REDIRECT;
    }

    @GetMapping("/search")
    public String searchRoles(@RequestParam String keyword, Model model) {
        model.addAttribute("userMenu", menuService.findAll());
        model.addAttribute("roleList", roleService.findLike(keyword));
        return "roles";
    }

    @PutMapping("/edit/{id}")
    public String editRole(@PathVariable Long id, @ModelAttribute Role role) {
        roleService.update(id, role);
        return ROLE_VIEW_REDIRECT;
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleService.delete(id);
        return ROLE_VIEW_REDIRECT;
    }

}
