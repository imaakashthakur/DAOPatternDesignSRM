/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18.service.impl;

import com.f1softmanjitshakyatraining.day18.dao.CourseDAO;
import com.f1softmanjitshakyatraining.day18.model.Course;
import com.f1softmanjitshakyatraining.day18.service.CourseService;

/**
 *
 * @author aakashthakur-work
 */
public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO;

    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public Course getCourseById(int courseId) {
        return courseDAO.fetchCourseById(courseId);
    }

    @Override
    public void insertCourse(String courseName) {
        courseDAO.saveCourse(courseName);
    }

}
