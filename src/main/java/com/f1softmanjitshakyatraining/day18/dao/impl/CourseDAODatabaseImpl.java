/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18.dao.impl;

import com.f1softmanjitshakyatraining.day18.model.Course;
import com.f1softmanjitshakyatraining.day18.dao.CourseDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aakashthakur-work
 */
public class CourseDAODatabaseImpl implements CourseDAO {

    @Override
    public Course fetchCourseById(int courseId) {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/SRM";
            String username = "root";
            String password = "idrunkh2o";
            con = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt;
            String query = "SELECT * FROM Courses WHERE CourseId = ?";

            ResultSet rs;

            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, courseId);

            rs = pstmt.executeQuery();
            Course course = new Course();

            while (rs.next()) {

                String courseName = rs.getString("Name");
                course.setCourseName(courseName);
                course.setCourseId(courseId);
            }
            System.out.println("Course: " + course);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception Caught: " + ex);
        }
        return null;

    }

}
