package com.example.springProject.service;

import com.example.springProject.repo.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springProject.model.Student;
import java.util.List;

@Service
public class StudentService {

  private StudentRepo repo;

  public StudentRepo getRepo() {
    return repo;
  }

  @Autowired
  public void setRepo(StudentRepo stRepo) {
    this.repo = stRepo;
  }

  public void addaStudent(Student st) {
    repo.save(st);
  }

  public List<Student> getStudents(){
    return repo.findAll();
  }



}
