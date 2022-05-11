package net.sytes.ucezz.mirea.java.carservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sytes.ucezz.mirea.java.carservice.entity.Transport;
import net.sytes.ucezz.mirea.java.carservice.entity.User;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportTypeRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@Controller
public class TransportController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TransportRepository transportRepository;

    @Autowired
    TransportTypeRepository transportTypeRepository;

    @RequestMapping("/transport")
    public String transport(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.get(username);
        List<Transport> allTransport = transportRepository.getAllByUserId(user.getId());
        model.addAttribute("allTransport", allTransport);
        model.addAttribute("headerDefined", true);
        model.addAttribute("headerCaption", "Мой транспорт");
        model.addAttribute("transportTypeRepository", transportTypeRepository);
        return "transport";
    }
}
