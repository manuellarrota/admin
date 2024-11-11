package com.manuellarrota.admin.controllers;

import com.manuellarrota.admin.services.MenuService;
import com.manuellarrota.admin.util.MenuOption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
    public class DashboardController {

        MenuService menuService;

        public DashboardController(MenuService menuService) {
            this.menuService = menuService;
        }

        @GetMapping({"/", "/dashboard"})
        public String showDashboard(Model model) {
            List<MenuOption> menus =  menuService.findAll();
            log.info(String.valueOf(menus.size()));
            model.addAttribute("userMenu", menus);
            return "dashboard"; // Nombre de la plantilla Thymeleaf (dashboard.html)
        }


    }
