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
import net.sytes.ucezz.mirea.java.carservice.repository.TransportRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportTypeRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@Controller
@RequestMapping("/service/add")
public class ServiceAddController {
    @Autowired
    TransportTypeRepository transportTypeRepository;

    @Autowired
    TransportRepository transportRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ServiceCategoryRepository serviceCategoryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String registerGet(WebRequest request, Model model) {

        model.addAttribute("errorCode", -1);
        model.addAttribute("allServiceCategory", serviceCategoryRepository.getAll());
        model.addAttribute("service",
                new ServiceEntity()
                        .setCompletion("")
                        .setCreation("")
                        .setDescription(""));
        model.addAttribute("allUserTransport",
                transportRepository.getAllByUserId(
                        userRepository.get(
                                SecurityContextHolder.getContext().getAuthentication().getName())
                                .getId()));
        return "service-add";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerPost(WebRequest request, Model model,
            @RequestParam(value = "idTransport", defaultValue = "0") int idTransport,
            @RequestParam(value = "idServiceCategory", defaultValue = "0") int idServiceCategory,
            @RequestParam(value = "description", defaultValue = "") String description) {
        int errorCode = 0;

        TransportEntity transportEntity = transportRepository.get(idTransport);

        ServiceCategoryEntity serviceCategoryEntity = null;

        UserEntity userEntity = userRepository.get(SecurityContextHolder.getContext().getAuthentication().getName());

        if (transportEntity == null) {
            errorCode = 1;
        }
        if (errorCode == 0) {
            serviceCategoryEntity = serviceCategoryRepository.get(idServiceCategory);
            if (serviceCategoryEntity == null) {
                errorCode = 2;
            }
        }

        if (errorCode == 0 && userEntity == null) {
            errorCode = 3;
        }

        if (errorCode == 0 && userEntity.getId() != transportEntity.getIdUser()) {
            errorCode = 4;
        }

        if (errorCode == 0) {
            // TODO: service adding to db
            return "redirect:/service";
        } else {
            model.addAttribute("errorCode", errorCode);
            model.addAttribute("allServiceCategory", serviceCategoryRepository.getAll());
            model.addAttribute("service",
                    new ServiceEntity()
                            .setIdServiceCategory(idServiceCategory)
                            .setIdTransport(idTransport)
                            .setDescription(description)
                            .setCompletion("")
                            .setCreation(""));
            model.addAttribute("allUserTransport",
                    transportRepository.getAllByUserId(userEntity.getId()));
            return "service-add";
        }
    }
}
