package com.test.register.registration1.dao;

import com.test.register.registration1.entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FacultyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Faculty faculty) {
        String sql = "INSERT INTO faculty (facultyName, facultyEmail, password, facultyMobileNumber) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, faculty.getFacultyName(), faculty.getFacultyEmail(), faculty.getPassword(), faculty.getFacultyMobileNumber());
    }

    public Faculty findByEmail(String email) {
        String sql = "SELECT * FROM faculty WHERE facultyEmail = ?";
        return jdbcTemplate.queryForObject(sql, new FacultyRowMapper(), email);
    }

    public List<Faculty> getAll() {
        String sql = "SELECT * FROM faculty";
        return jdbcTemplate.query(sql, new FacultyRowMapper());
    }

    static class FacultyRowMapper implements RowMapper<Faculty> {
        @Override
        public Faculty mapRow(ResultSet rs, int rowNum) throws SQLException {
            Faculty faculty = new Faculty();
            faculty.setFacultyId(rs.getLong("facultyId"));
            faculty.setFacultyName(rs.getString("facultyName"));
            faculty.setFacultyEmail(rs.getString("facultyEmail"));
            faculty.setPassword(rs.getString("password"));
            faculty.setFacultyMobileNumber(rs.getString("facultyMobileNumber"));
            return faculty;
        }
    }
}
