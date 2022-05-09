package net.sytes.ucezz.mirea.java.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sytes.ucezz.mirea.java.carservice.entity.User;
import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@Controller
public class TransportController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/transport")
    public String transport(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.get(username);
        model.addAttribute("user", user);
        return "transport";
    }
}
