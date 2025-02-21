package com.test.register.registration1.controller;

import com.test.register.registration1.dao.AssignmentDAO;
import com.test.register.registration1.dao.CourseDAO;
import com.test.register.registration1.dao.FacultyDAO;
import com.test.register.registration1.entity.Faculty;
import com.test.register.registration1.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/assignments")
public class AssignmentController {
    @Autowired
    private AssignmentDAO assignmentDAO;

    @Autowired
    private FacultyDAO facultyDAO;

    @Autowired
    private CourseDAO courseDAO;

    // Show assignment form
    @GetMapping("/assign")
    public String showAssignmentForm(Model model) {
        List<Faculty> faculties = facultyDAO.getAll();
        List<Course> courses = courseDAO.getAll();
        model.addAttribute("faculties", faculties);
        model.addAttribute("courses", courses);
        return "assign-faculty-course";
    }

    // Assign faculty to a course
    @PostMapping("/assign")
    public String assignFacultyToCourse(@RequestParam Long facultyId, @RequestParam Long courseId) {
        assignmentDAO.assignFacultyToCourse(facultyId, courseId);
        return "redirect:/assignments/assign";
    }

    // Remove faculty from a course
    @PostMapping("/remove")
    public String removeFacultyFromCourse(@RequestParam Long facultyId, @RequestParam Long courseId) {
        assignmentDAO.removeFacultyFromCourse(facultyId, courseId);
        return "redirect:/assignments/assign";
    }
}
