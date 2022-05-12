package net.sytes.ucezz.mirea.java.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sytes.ucezz.mirea.java.carservice.entity.UserEntity;
import net.sytes.ucezz.mirea.java.carservice.repository.ServiceRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@Controller
public class ProfileController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TransportRepository transportRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @RequestMapping("/profile")
    public String profile(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepository.get(username);
        int transportCount = transportRepository.getCountByUserId(user.getId());
        model.addAttribute("pageName", "profile");
        model.addAttribute("user", user);
        model.addAttribute("transportCount", transportCount);
        model.addAttribute("serviceRepository", serviceRepository);
        return "profile";
    }
}
