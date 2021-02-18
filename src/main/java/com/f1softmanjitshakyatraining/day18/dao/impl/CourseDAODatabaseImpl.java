/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18.dao.impl;

import com.f1softmanjitshakyatraining.day18.model.Course;
import com.f1softmanjitshakyatraining.day18.dao.CourseDAO;
import com.f1softmanjitshakyatraining.day18.jdbc.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aakashthakur-work
 */
public class CourseDAODatabaseImpl implements CourseDAO {

    static Connection con = JDBCConnection.getConnection();

    @Override
    public Course fetchCourseById(int courseId) {
        try {

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
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception Caught: " + ex);
        }
        return null;

    }
    @Override
    public List<Course> fetchAllCourses() {
        List<Course> coursesList = new ArrayList<>();

        try {
            Statement stmt;
            String query = "SELECT * FROM Courses";

            ResultSet rs;
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                Course course = new Course();
                String courseName = rs.getString("Name");
                int courseId = rs.getInt("CourseId");
                course.setCourseId(courseId);
                course.setCourseName(courseName);
                coursesList.add(course);
            }
        } catch (SQLException ex) {
            System.out.println("Exception is caught: " + ex);
        }
        return coursesList;
    }
    @Override
    public void saveCourse(String courseName) {
        try {

            PreparedStatement pstmt;
            String insertQuery = "INSERT INTO Courses (Name) VALUES (?)";
            pstmt = con.prepareStatement(insertQuery);
            pstmt.setString(1, courseName);
            int result = pstmt.executeUpdate();
            System.out.println(result + " row is inserted!!");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAODatabaseImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
