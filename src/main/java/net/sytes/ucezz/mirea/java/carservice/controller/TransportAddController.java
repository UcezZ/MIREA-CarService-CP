package net.sytes.ucezz.mirea.java.carservice.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import net.sytes.ucezz.mirea.java.carservice.entity.TransportEntity;
import net.sytes.ucezz.mirea.java.carservice.entity.TransportTypeEntity;
import net.sytes.ucezz.mirea.java.carservice.entity.UserEntity;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportTypeRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@Controller
@RequestMapping("/transport/add")
public class TransportAddController {
    @Autowired
    TransportTypeRepository transportTypeRepository;

    @Autowired
    TransportRepository transportRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String registerGet(WebRequest request, Model model) {
        model.addAttribute("errorCode", -1);
        model.addAttribute("currentYear", LocalDate.now().getYear());
        model.addAttribute("allTransportType", transportTypeRepository.getAll());
        model.addAttribute("transport",
                new TransportEntity()
                        .setBrand("")
                        .setModel("")
                        .setRegNumber(""));
        return "transport-add";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerPost(WebRequest request, Model model,
            @RequestParam(value = "transportType", defaultValue = "0") int idTransportType,
            @RequestParam(value = "brand", defaultValue = "") String brand,
            @RequestParam(value = "model", defaultValue = "") String tModel,
            @RequestParam(value = "regNumber", defaultValue = "") String regNumber,
            @RequestParam(value = "releaseYear", defaultValue = "0") int releaseYear) {
        int errorCode = 0;

        TransportTypeEntity transportTypeEntity = transportTypeRepository.get(idTransportType);

        UserEntity userEntity = null;

        TransportEntity transportEntity = null;

        if (transportTypeEntity == null) {
            errorCode = 1;
        }

        if (errorCode == 0 && (brand.length() == 0 || tModel.length() == 0)) {
            errorCode = 2;
        }

        if (errorCode == 0 && (regNumber.length() < 8 || regNumber.length() > 9)) {
            errorCode = 3;
        }

        if (errorCode == 0 && (releaseYear < 1900 || releaseYear > LocalDate.now().getYear())) {
            errorCode = 4;
        }

        if (errorCode == 0) {
            regNumber = regNumber.toUpperCase();
            transportEntity = transportRepository.get(regNumber);
            if (transportEntity != null) {
                errorCode = 5;
            }
        }

        if (errorCode == 0) {
            userEntity = userRepository.get(SecurityContextHolder.getContext().getAuthentication().getName());
            if (userEntity == null) {
                errorCode = 6;
            }
        }
        if (errorCode == 0) {
            transportRepository.add(idTransportType, userEntity.getId(), brand, tModel, regNumber, releaseYear);
            return "redirect:/transport";
        } else {
            model.addAttribute("transport",
                    new TransportEntity()
                            .setBrand(brand)
                            .setIdTransportType(idTransportType)
                            .setModel(tModel)
                            .setRegNumber(regNumber)
                            .setReleaseYear(releaseYear));
            model.addAttribute("errorCode", errorCode);
            model.addAttribute("currentYear", LocalDate.now().getYear());
            model.addAttribute("allTransportType", transportTypeRepository.getAll());
            return "transport-add";
        }
    }
}
