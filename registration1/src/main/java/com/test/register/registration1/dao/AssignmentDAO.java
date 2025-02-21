package com.test.register.registration1.dao;

import com.test.register.registration1.entity.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssignmentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Assign faculty to a course
    public void assignFacultyToCourse(Long facultyId, Long courseId) {
        String sql = "INSERT INTO faculty_course (faculty_id, course_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, facultyId, courseId);
    }

    // Get courses assigned to a specific faculty
    public List<Long> getCoursesByFaculty(Long facultyId) {
        String sql = "SELECT course_id FROM faculty_course WHERE faculty_id = ?";
        return jdbcTemplate.queryForList(sql, Long.class, facultyId);
    }

    // Remove faculty from a course
    public void removeFacultyFromCourse(Long facultyId, Long courseId) {
        String sql = "DELETE FROM faculty_course WHERE faculty_id = ? AND course_id = ?";
        jdbcTemplate.update(sql, facultyId, courseId);
    }
}
