package co.com.jorge.springboot.error.app.controllers;

import co.com.jorge.springboot.error.app.errors.UserNotFoundException;
import co.com.jorge.springboot.error.app.models.domain.User;
import co.com.jorge.springboot.error.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(){
        Integer valor = 100/0;
//        Integer valor = Integer.parseInt("10X");
        return "index";
    }

    @GetMapping("/see/{id}")
    public String see(@PathVariable Integer id, Model model){

//        User user = userService.getById(id);
//
//        if (user == null){
//            throw new UserNotFoundException(id.toString());
//        }

        User user = userService.getByIdOptional(id).orElseThrow(() -> new UserNotFoundException(id.toString()));
        model.addAttribute("user", user);
        model.addAttribute("titulo", "Detalle Usuario: ".concat(user.getName()));
        return "see";
    }
}
