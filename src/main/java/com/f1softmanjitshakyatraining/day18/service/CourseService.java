/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18.service;

import com.f1softmanjitshakyatraining.day18.model.Course;

import java.util.List;

/**
 *
 * @author aakashthakur-work
 */
public interface CourseService {

    Course getCourseById(int courseId);

    void insertCourse(String courseName);

    List<Course> getAllCourses();
}
