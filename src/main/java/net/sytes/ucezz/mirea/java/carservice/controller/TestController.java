package net.sytes.ucezz.mirea.java.carservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.sytes.ucezz.mirea.java.carservice.entity.ServiceCategory;
import net.sytes.ucezz.mirea.java.carservice.entity.User;
import net.sytes.ucezz.mirea.java.carservice.repository.ServiceCategoryRepository;
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
    ServiceCategoryRepository serviceCategoryRepository;

    @GetMapping("/test")
    @ResponseBody
    String test() throws Exception {
        String res = new String();

        for (User o : userRepository.getAllUsers())
            res += "<p>" + o + "</p>";

        for (ServiceCategory o : serviceCategoryRepository.getAllServiceCategories())
            res += "<p>" + o + "</p>";
        return res;
    }
}
