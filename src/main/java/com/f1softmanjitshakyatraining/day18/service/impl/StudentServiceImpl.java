/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18.service.impl;

import com.f1softmanjitshakyatraining.day18.model.Student;
import com.f1softmanjitshakyatraining.day18.model.Course;
import com.f1softmanjitshakyatraining.day18.dto.StudentDTO;
import com.f1softmanjitshakyatraining.day18.service.StudentService;
import com.f1softmanjitshakyatraining.day18.dao.StudentDAO;
import java.util.List;

/**
 *
 * @author aakashthakur-work
 */
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.fetchAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.fetchStudentById(id);
    }

    @Override
    public void deleteStudentById(int id) {
        studentDAO.removeStudentById(id);
    }

    @Override
    public void updateStudentById(int id, String name, String address, String contact, int courseId) {
        studentDAO.renovateStudentById(id, name, address, contact, courseId);
    }

    @Override
    public void insertStudent(String name, String address, String contact, int courseId) {
        studentDAO.addStudent(name, address, contact, courseId);
    }

    @Override
    public void addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        student.setContactNo(studentDTO.getContactNo());
        student.setCourse(new Course(studentDTO.getCourseId()));

        studentDAO.saveStudent(student);

    }
}
