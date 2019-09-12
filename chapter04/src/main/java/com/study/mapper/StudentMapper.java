package com.study.mapper;

import com.study.pojo.Student;

import java.util.List;

public interface StudentMapper {
    public Student findStudentById(int id);
    public List<Student> findAllStudents();
}
