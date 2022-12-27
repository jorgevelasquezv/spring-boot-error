package co.com.jorge.springboot.error.app.controllers;

import co.com.jorge.springboot.error.app.errors.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ArithmeticException.class)
    public String arithmeticError(ArithmeticException exp, Model model){
        model.addAttribute("error", "Error de aritmética");
        model.addAttribute("message", exp.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/genericError";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String numberFormatException(NumberFormatException exp, Model model){
        model.addAttribute("error", "Error: Formato de número invalido");
        model.addAttribute("message", exp.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/genericError";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundException(UserNotFoundException exp, Model model){
        model.addAttribute("error", "Error: Usuario no encontrado");
        model.addAttribute("message", exp.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/genericError";
    }
}
