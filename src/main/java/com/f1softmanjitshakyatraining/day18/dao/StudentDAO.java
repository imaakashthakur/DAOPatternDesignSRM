/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18.dao;

import java.util.List;
import com.f1softmanjitshakyatraining.day18.model.Student;

/**
 *
 * @author aakashthakur-work
 */
public interface StudentDAO {

    List<Student> fetchAllStudents();

    Student fetchStudentById(int id);

    void removeStudentById(int id);

    void renovateStudentById(int id, String name, String address, String contact, int courseId);

    void addStudent(String name, String address, String contact, int courseId);
    
    Boolean saveStudent(Student student);
    
    

}
