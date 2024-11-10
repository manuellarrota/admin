package com.manuellarrota.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    // Página de login personalizada
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Devuelve el archivo login.html
    }

    // Página de logout (muestra un mensaje de éxito)
    @GetMapping("/logout")
    public String logoutPage() {
        return "redirect:/login?logout=true";  // Redirige a login con mensaje de logout
    }
}
