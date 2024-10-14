package com.example.springProject.repo;

import org.springframework.stereotype.Repository;

import com.example.springProject.model.Student;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class StudentRepo {

  JdbcTemplate jdbcTemplate;

  @Autowired
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public void save(Student st) {
    String sql = "INSERT INTO student VALUES (?, ?, ?)";
    int rows = jdbcTemplate.update(sql, st.getRollNo(), st.getName(), st.getMarks());
    System.out.println(rows + " affected");
  }

  public List<Student> findAll() {

    String sql = "select * from student";

    RowMapper<Student> mapper = new RowMapper<Student>() {

      @Override
      public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student s = new Student();
        s.setRollNo(rs.getInt("rollNo"));

        s.setName(rs.getString("name"));
        s.setMarks(rs.getInt("marks"));
        return s;
      }
    };

    return jdbcTemplate.query(sql, mapper);
  }

}
