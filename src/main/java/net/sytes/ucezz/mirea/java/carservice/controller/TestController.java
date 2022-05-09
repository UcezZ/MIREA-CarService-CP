package net.sytes.ucezz.mirea.java.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sytes.ucezz.mirea.java.carservice.entity.TransportType;
import net.sytes.ucezz.mirea.java.carservice.entity.Transport;
import net.sytes.ucezz.mirea.java.carservice.entity.User;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportTypeRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.TransportRepository;
import net.sytes.ucezz.mirea.java.carservice.repository.UserRepository;

@RestController
public class TestController {

    /*
     * @Autowired
     * private JdbcTemplate jdbcTemplate;
     */

    @Autowired
    UserRepository userRepository;

    @Autowired
    TransportTypeRepository serviceCategoryRepository;

    @Autowired
    TransportRepository transportRepository;

    @GetMapping("/test")
    @ResponseBody
    String test() throws Exception {
        String res = new String();

        for (User o : userRepository.getAll())
            res += "<p>" + o + "</p>";

        for (TransportType o : serviceCategoryRepository.getAll())
            res += "<p>" + o + "</p>";

        for (Transport o : transportRepository.getAll())
            res += "<p>" + o + "</p>";
        return res;
    }
}
