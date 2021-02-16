/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18.dao.impl;

import com.f1softmanjitshakyatraining.day18.model.Student;
import com.f1softmanjitshakyatraining.day18.model.Course;
import com.f1softmanjitshakyatraining.day18.dao.StudentDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aakashthakur-work
 */
public class StudentDAODatabaseImpl implements StudentDAO {

    Connection con = null;

    @Override
    public List<Student> fetchAllStudents() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/SRM";
            String username = "root";
            String password = "idrunkh2o";
            con = DriverManager.getConnection(url, username, password);

            System.out.println("\nMySQL Database connection established!!");

            Statement stmt = con.createStatement();

            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM Students");

            List<Student> students = new ArrayList<>();

            while (rs.next()) {

                Student student = new Student();
                Integer studentId = rs.getInt("ID");
                String studentName = rs.getString("Name");
                String studentAddress = rs.getString("Address");
                String studentContact = rs.getString("Contact");
                Integer studentCourseId = rs.getInt("CourseId");
                student.setId(studentId);
                student.setName(studentName);
                student.setAddress(studentAddress);
                student.setContactNo(studentContact);
                student.setCourse(new Course(studentCourseId, "CourseName"));

                students.add(student);

            }
            System.out.println("Result Set: " + students);
            con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception Occured: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Student fetchStudentById(int id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/SRM";
            String username = "root";
            String password = "idrunkh2o";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is established successfully!");

            PreparedStatement pstmt;

            ResultSet rs;

            String query = "SELECT * FROM Students WHERE id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            List<Student> students = new ArrayList<>();

            while (rs.next()) {

                Student student = new Student();
                Integer studentId = rs.getInt("ID");
                String studentName = rs.getString("Name");
                String studentAddress = rs.getString("Address");
                String studentContact = rs.getString("Contact");
                Integer studentCourseId = rs.getInt("CourseId");
                student.setId(studentId);
                student.setName(studentName);
                student.setAddress(studentAddress);
                student.setContactNo(studentContact);
                student.setCourse(new Course(studentCourseId, "CourseName"));

                students.add(student);

            }
            System.out.println("Record where ID = 1: " + students);
            con.close();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentDAODatabaseImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void removeStudentById(int id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/SRM";
            String username = "root";
            String password = "idrunkh2o";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("MySQL database conneciton established!");

            PreparedStatement pstmt;

            String query = "DELETE FROM Students WHERE id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            int rowDeleted = pstmt.executeUpdate();
            System.out.println("\nThe row is deleted successfully!!!: " + rowDeleted);
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception Catched: " + ex);
        }
    }

    @Override
    public void renovateStudentById(int id, String name, String address, String contact, int courseId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/SRM";
            String username = "root";
            String password = "idrunkh2o";
            con = DriverManager.getConnection(url, username, password);

            PreparedStatement pstmt;

            String query = "UPDATE Students SET Name = ?, Address =?, Contact = ?, CourseId = ? WHERE id = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, contact);
            pstmt.setInt(4, courseId);
            pstmt.setInt(5, id);
            int rowUpdated = pstmt.executeUpdate();
            System.out.println("Row " + id + " is updated: " + rowUpdated);
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception Catched: " + ex);
        }
    }

    @Override
    public void addStudent(String name, String address, String contact, int courseId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/SRM";
            String username = "root";
            String password = "idrunkh2o";

            con = DriverManager.getConnection(url, username, password);

            PreparedStatement pstmt;

            String query = "INSERT INTO Students(Name, Address, Contact, CourseId) VALUES(?, ?, ?, ?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, contact);
            pstmt.setInt(4, courseId);

            int rowCreated = pstmt.executeUpdate();
            System.out.println("Row is created! " + rowCreated);
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }
    }

}
