package net.sytes.ucezz.mirea.java.carservice.controller;

import java.security.MessageDigest;
import java.util.Set;

import javax.xml.bind.DatatypeConverter;

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
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String login(WebRequest request, Model model) {
        Set<String> params = request.getParameterMap().keySet();
        model.addAttribute("errorCode", params.contains("error") ? 1 : 0);
        return "login";
    }
}
