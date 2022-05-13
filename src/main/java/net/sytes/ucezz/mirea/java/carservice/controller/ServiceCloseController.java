package net.sytes.ucezz.mirea.java.carservice.controller;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import net.sytes.ucezz.mirea.java.carservice.entity.ServiceEntity;
import net.sytes.ucezz.mirea.java.carservice.entity.UserEntity;
import net.sytes.ucezz.mirea.java.carservice.repository.ServiceCategoryRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.ServiceRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@Controller
@RequestMapping("/service/close")
public class ServiceCloseController {
    @Autowired
    TransportRepository transportRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ServiceCategoryRepository serviceCategoryRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @RequestMapping(method = RequestMethod.POST)
    public String registerPost(WebRequest request, Model model,
            @RequestParam(value = "idService", defaultValue = "0") int idService) {
        int errorCode = 0;

        ServiceEntity serviceEntity = serviceRepository.get(idService);

        UserEntity userEntity = userRepository.get(SecurityContextHolder.getContext().getAuthentication().getName());

        if (serviceEntity == null || userEntity == null) {
            errorCode = 1;
        }

        if (errorCode == 0 && !userEntity.getIsManager()) {
            errorCode = 1;
        }

        if (errorCode == 0 && userEntity.getId() != serviceEntity.getIdManager()) {
            errorCode = 1;
        }

        if (errorCode == 0) {
            serviceRepository.setCompleted(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()), idService);
            return "redirect:/service";
        } else {
            model.addAttribute("errorCode", errorCode);
            model.addAttribute("transportRepository", transportRepository);
            model.addAttribute("serviceCategoryRepository", serviceCategoryRepository);
            model.addAttribute("userRepository", userRepository);
            model.addAttribute("userNewServices", serviceRepository.getUserNewServices(userEntity.getId()));
            model.addAttribute("userActiveServices", serviceRepository.getUserActiveServices(userEntity.getId()));
            model.addAttribute("userClosedServices", serviceRepository.getUserClosedServices(userEntity.getId()));
            if (userEntity.getIsManager()) {
                model.addAttribute("managerNewServices", serviceRepository.getManagerNewServices());
                model.addAttribute("managerActiveServices",
                        serviceRepository.getManagerActiveServices(userEntity.getId()));
                model.addAttribute("managerClosedServices",
                        serviceRepository.getManagerClosedServices(userEntity.getId()));
            }
            model.addAttribute("user", userEntity);
            model.addAttribute("pageName", "service");
            return "service";
        }
    }
}
