package com.test.register.registration1.dao;

import com.test.register.registration1.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CourseDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Course course) {
        String sql = "INSERT INTO course (courseName, courseDuration) VALUES (?, ?)";
        jdbcTemplate.update(sql, course.getCourseName(), course.getCourseDuration());
    }

    public List<Course> getAll() {
        String sql = "SELECT * FROM course";
        return jdbcTemplate.query(sql, new CourseRowMapper());
    }

    static class CourseRowMapper implements RowMapper<Course> {
        @Override
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            Course course = new Course();
            course.setCourseId(rs.getLong("courseId"));
            course.setCourseName(rs.getString("courseName"));
            course.setCourseDuration(rs.getInt("courseDuration"));
            return course;
        }
    }
}
