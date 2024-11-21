package com.manuellarrota.admin.controllers;

import com.manuellarrota.admin.entities.User;
import com.manuellarrota.admin.services.MenuService;
import com.manuellarrota.admin.services.RoleService;
import com.manuellarrota.admin.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final MenuService menuService;
    private final RoleService roleService;
    private static final String USER_VIEW = "users";
    private static final String USER_VIEW_REDIRECT = "redirect:/user";

    @Autowired
    public UserController(UserService userService, MenuService menuService, RoleService roleService) {
        this.userService = userService;
        this.menuService = menuService;
        this.roleService = roleService;
    }

    @GetMapping
    public String listaUsuarios(Model model) {
        loadDataPage(model);
        return USER_VIEW;
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("userMenu", menuService.findAll());
        model.addAttribute("userList", userService.findLike(keyword));
        return USER_VIEW;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        userService.delete(id);
        loadDataPage(model);
        return USER_VIEW_REDIRECT;
    }

    @PostMapping("/save")
    public String guardarUsuario(@ModelAttribute User user, Model model) {
        userService.save(user);
        loadDataPage(model);
        return USER_VIEW_REDIRECT;

    }

    @PutMapping("/edit/{id}")
    public String editarUsuario(@PathVariable Long id, @ModelAttribute User user, Model model) {
        log.info("EDITAR USARIOO");
        log.info(user.toString());
        userService.update(id, user);
        loadDataPage(model);
        return USER_VIEW_REDIRECT;
    }

    void loadDataPage(Model model){
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("userMenu", menuService.findAll());
        model.addAttribute("userList", userService.findAll());
    }
}
