package com.test.register.registration1.controller;

import com.test.register.registration1.entity.Faculty;
import com.test.register.registration1.dao.FacultyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyDAO facultyDAO;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "faculty-register";
    }

    @PostMapping("/register")
    public String registerFaculty(@ModelAttribute Faculty faculty) {
        facultyDAO.save(faculty);
        return "redirect:/faculty/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "faculty-login";
    }
}
