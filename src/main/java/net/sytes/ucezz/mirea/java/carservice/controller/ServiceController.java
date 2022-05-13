package net.sytes.ucezz.mirea.java.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import net.sytes.ucezz.mirea.java.carservice.entity.ServiceCategoryEntity;
import net.sytes.ucezz.mirea.java.carservice.entity.ServiceEntity;
import net.sytes.ucezz.mirea.java.carservice.entity.TransportEntity;
import net.sytes.ucezz.mirea.java.carservice.entity.UserEntity;
import net.sytes.ucezz.mirea.java.carservice.repository.ServiceCategoryRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.ServiceRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportTypeRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    TransportTypeRepository transportTypeRepository;

    @Autowired
    TransportRepository transportRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ServiceCategoryRepository serviceCategoryRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String registerGet(WebRequest request, Model model) {
        UserEntity user = userRepository.get(
                SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("transportRepository", transportRepository);
        model.addAttribute("serviceCategoryRepository", serviceCategoryRepository);
        model.addAttribute("userNewServices", serviceRepository.getUserNewServices(user.getId()));
        model.addAttribute("userActiveServices", serviceRepository.getUserActiveServices(user.getId()));
        model.addAttribute("userClosedServices", serviceRepository.getUserClosedServices(user.getId()));
        model.addAttribute("pageName", "service");
        return "service";
    }
}
