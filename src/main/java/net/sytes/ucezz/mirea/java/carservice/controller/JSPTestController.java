package net.sytes.ucezz.mirea.java.carservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPTestController {
    @RequestMapping("/jsptest")
    public String jsptest(Model model) {
        model.addAttribute("greeting", "zalupa");
        return "jsptest";
    }
}
