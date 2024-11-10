package com.manuellarrota.admin.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler({RuntimeException.class, Exception.class})
    public String handleException(Exception ex, Model model) {
        String errorMessage = "Cause: " + ex.getClass();
        errorMessage += ", Localize Message " + ex.getLocalizedMessage();
        errorMessage += ", Detail: " + ex.getMessage();
        model.addAttribute("errorMessage", errorMessage);
        return "error";  // Esto redirige a la página error.html
    }


    @ExceptionHandler({NoResourceFoundException.class})
    public String noResourceFound(Exception ex, Model model) {
        return "error/404";  // Esto redirige a la página 404.html
    }
}
