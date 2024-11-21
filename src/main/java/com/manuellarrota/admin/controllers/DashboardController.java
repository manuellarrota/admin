package com.manuellarrota.admin.controllers;

import com.manuellarrota.admin.services.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
    public class DashboardController {

        private final MenuService menuService;

        @Autowired
        public DashboardController(MenuService menuService) {
            this.menuService = menuService;
        }

        @GetMapping({"/", "/dashboard"})
        public String showDashboard(Model model) {
            model.addAttribute("userMenu", menuService.findAll());
            return "dashboard";
        }


    }
