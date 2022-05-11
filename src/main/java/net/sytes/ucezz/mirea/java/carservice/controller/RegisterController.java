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
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String registerGet(WebRequest request, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("errorCode", -1);
        model.addAttribute("maxDate", LocalDate.now().minusYears(16).toString());
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerPost(WebRequest request, Model model,
            @RequestParam(value = "lastName", defaultValue = "") String lastName,
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "middleName", defaultValue = "") String middleName,
            @RequestParam(value = "birthDate", defaultValue = "") String birthDate,
            @RequestParam(value = "username", defaultValue = "") String username,
            @RequestParam(value = "password", defaultValue = "") String password,
            @RequestParam(value = "passwordConfirm", defaultValue = "") String passwordConfirm) {
        int errorCode = 0;

        if (lastName.length() == 0 || firstName.length() == 0) {
            errorCode = 1;
        }
        if (errorCode == 0) {
            try {
                birthDate = new SimpleDateFormat("yyyy-MM-dd")
                        .format(new SimpleDateFormat("yyyy-MM-dd").parse(birthDate));
            } catch (Exception e) {
                errorCode = 2;
            }
        }
        if (errorCode == 0 && username.length() == 0) {
            errorCode = 3;
        }
        User u = userRepository.get(username);
        if (errorCode == 0 && u != null) {
            errorCode = 4;
        }
        if (errorCode == 0 && password.length() == 0) {
            errorCode = 5;
        }
        if (errorCode == 0 && !password.equals(passwordConfirm)) {
            errorCode = 6;
        }
        if (errorCode == 0 && !password.equalsIgnoreCase(username)) {
            errorCode = 7;
        }
        u = new User()
                .setBirthDate(birthDate)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setMiddleName(middleName)
                .setUsername(username)
                .setPassword(password);
        if (errorCode == 0) {
            userRepository.register(lastName, firstName, middleName, username, u.getPasswordHashString(), birthDate);
        }
        model.addAttribute("errorCode", errorCode);
        model.addAttribute("user", u);
        model.addAttribute("maxDate", LocalDate.now().minusYears(16).toString());
        return "register";
    }
}
