package com.test.register.registration1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")  // Mapping the root URL
    public String showHomePage() {
        return "index";  // This will resolve to /WEB-INF/Views/index.jsp
    }
}
