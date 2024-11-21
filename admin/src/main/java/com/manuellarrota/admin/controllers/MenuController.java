package com.manuellarrota.admin.controllers;

import com.manuellarrota.admin.entities.Menu;
import com.manuellarrota.admin.services.MenuService;
import com.manuellarrota.admin.services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/menu")
public class MenuController {


    private final MenuService menuService;
    private final RoleService roleService;
    private static final String VIEW_MENU_REDIRECT="redirect:/menu";

    public MenuController(MenuService menuService, RoleService roleService) {
        this.menuService = menuService;
        this.roleService = roleService;
    }


    @GetMapping
    public String listMenus(Model model) {
        model.addAttribute("userMenu", menuService.findAll());
        model.addAttribute("menuList", menuService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "menu";
    }

    @PostMapping("/save")
    public String saveMenu(@ModelAttribute Menu menu) {
        menuService.save(menu);
        return VIEW_MENU_REDIRECT;
    }


    @PutMapping("/edit/{id}")
    public String editMenu(@PathVariable Long id, @ModelAttribute Menu menu) {
        return VIEW_MENU_REDIRECT;
    }


    @GetMapping("/delete/{id}")
    public String deleteMenu(@PathVariable Long id) {
        menuService.delete(id);
        return VIEW_MENU_REDIRECT;
    }
}
