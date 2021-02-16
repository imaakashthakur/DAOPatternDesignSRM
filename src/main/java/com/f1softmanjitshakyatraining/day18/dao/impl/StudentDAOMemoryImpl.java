/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18.dao.impl;

import com.f1softmanjitshakyatraining.day18.model.Course;
import com.f1softmanjitshakyatraining.day18.model.Student;
import com.f1softmanjitshakyatraining.day18.dao.StudentDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aakashthakur-work
 */
public class StudentDAOMemoryImpl implements StudentDAO {

    List<Student> students = new ArrayList<>();
    Course civilCourse = new Course(3, "Civil");
    Course computerCourse = new Course(1, "CSE");
    Course updatedCourse = new Course(4, "Updated Course");
    String updatedName = "Santosh Pun";
    String updatedAddress = "Pokhara";
    String updatedContactNo = "9812345678";

    public StudentDAOMemoryImpl() {
        Student student1 = new Student("Amrendra Thakur", 1, "Ramechhap", "9845771505", civilCourse);
        Student student2 = new Student("Suresh Khatri", 2, "Jhapa", "9874638746", civilCourse);
        Student student3 = new Student("Aakash Thakur", 3, "Lalitpur", "9848652890", computerCourse);
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    @Override
    public List<Student> fetchAllStudents() {
        return students;
    }

    @Override
    public Student fetchStudentById(int id) {
        return students.get(id - 1);
    }

    @Override
    public void removeStudentById(int id) {
        System.out.println(students.get(id - 1) + "is being removed..");
        students.remove(id - 1);
        System.out.println("Student with ID: " + (id) + " is removed successfully!");
    }

    @Override
    public void renovateStudentById(int id, String name, String address, String contact, int courseId) {
        System.out.println(students.get(id - 1) + " is being updated..");
        students.get(id - 1).setName(updatedName);
        students.get(id - 1).setAddress(updatedAddress);
        students.get(id - 1).setContactNo(updatedContactNo);
        students.get(id - 1).setCourse(updatedCourse);

    }

    @Override
    public void addStudent(String name, String address, String contact, int courseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
