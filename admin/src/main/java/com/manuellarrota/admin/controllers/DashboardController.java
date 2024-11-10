package com.manuellarrota.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping({"/", "/dashboard"})
    public String showDashboard() {
        return "dashboard"; // Nombre de la plantilla Thymeleaf (dashboard.html)
    }

}
