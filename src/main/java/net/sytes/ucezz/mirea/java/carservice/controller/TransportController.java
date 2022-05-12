package net.sytes.ucezz.mirea.java.carservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sytes.ucezz.mirea.java.carservice.entity.TransportEntity;
import net.sytes.ucezz.mirea.java.carservice.entity.UserEntity;
import net.sytes.ucezz.mirea.java.carservice.repository.ServiceRepository;
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

    @Autowired
    ServiceRepository serviceRepository;

    @RequestMapping("/transport")
    public String transport(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepository.get(username);
        List<TransportEntity> allTransport = transportRepository.getAllByUserId(user.getId());

        model.addAttribute("pageName", "transport");
        model.addAttribute("allTransport", allTransport);
        model.addAttribute("transportTypeRepository", transportTypeRepository);
        model.addAttribute("serviceRepository", serviceRepository);
        return "transport";
    }
}
