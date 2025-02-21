package com.test.register.registration1.controller;

import com.test.register.registration1.dao.CourseDAO;
import com.test.register.registration1.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseDAO courseDAO;

    @GetMapping("/list")
    public String listCourses(Model model) {
        List<Course> courses = courseDAO.getAll();
        model.addAttribute("courses", courses);
        return "course-list";
    }
}
