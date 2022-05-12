package net.sytes.ucezz.mirea.java.carservice.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String login(WebRequest request, Model model) {
        if (!SecurityContextHolder.getContext().getAuthentication().getName().equalsIgnoreCase("anonymousUser"))
            return "redirect:/";
        Set<String> params = request.getParameterMap().keySet();
        model.addAttribute("errorCode", params.contains("error") ? 1 : 0);
        return "login";
    }
}
