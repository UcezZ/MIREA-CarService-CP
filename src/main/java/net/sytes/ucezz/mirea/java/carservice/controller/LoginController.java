package net.sytes.ucezz.mirea.java.carservice.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import net.sytes.ucezz.mirea.java.carservice.entity.User;
import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String registerGet(WebRequest request, Model model) {
        model.addAttribute("errorCode", -1);
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerPost(WebRequest request, Model model,
            @RequestParam(value = "username", defaultValue = "") String username,
            @RequestParam(value = "password", defaultValue = "") String password) {

        model.addAttribute("errorCode", 1);
        return "login";
    }
}
