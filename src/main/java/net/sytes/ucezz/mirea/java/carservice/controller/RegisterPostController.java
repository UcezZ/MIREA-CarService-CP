package net.sytes.ucezz.mirea.java.carservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import net.sytes.ucezz.mirea.java.carservice.entity.Transport;
import net.sytes.ucezz.mirea.java.carservice.entity.User;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@RestController
public class RegisterPostController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TransportRepository transportRepository;

    /*
     * @RequestMapping("/transport")
     * public String transport(Model model) {
     * String username =
     * SecurityContextHolder.getContext().getAuthentication().getName();
     * User user = userRepository.get(username);
     * List<Transport> allTransport =
     * transportRepository.getAllByUserId(user.getId());
     * model.addAttribute("allTransport", allTransport);
     * model.addAttribute("headerDefined", true);
     * model.addAttribute("headerCaption", "Мой транспорт");
     * return "transport";
     * }
     */

    @PostMapping("/rggegister")
    public String registerPost(
            @RequestParam(value = "lastName", defaultValue = "null") String lastName,
            @RequestParam(value = "firstName", defaultValue = "null") String firstName,
            @RequestParam(value = "middleName", defaultValue = "null") String middleName,
            @RequestParam(value = "birthDate", defaultValue = "null") String birthDate,
            @RequestParam(value = "username", defaultValue = "null") String username,
            @RequestParam(value = "password", defaultValue = "null") String password,
            @RequestParam(value = "passwordConfirm", defaultValue = "null") String passwordConfirm) {
        if (username.equals("null") || password.equals("null")) {
            return null;
        }
        // userRepo.save(new User(username, bCryptPasswordEncoder.encode(password)));
        System.out.println(lastName);
        System.out.println(firstName);
        System.out.println(middleName);
        System.out.println(birthDate);
        System.out.println(username);
        System.out.println(password);
        System.out.println(passwordConfirm);
        return "/register#";
    }
}
