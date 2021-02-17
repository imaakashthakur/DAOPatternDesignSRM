/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18;

import com.f1softmanjitshakyatraining.day18.dao.impl.CourseDAODatabaseImpl;
import com.f1softmanjitshakyatraining.day18.dao.impl.StudentDAODatabaseImpl;
import com.f1softmanjitshakyatraining.day18.dao.impl.StudentDAOMemoryImpl;
import com.f1softmanjitshakyatraining.day18.service.StudentService;
import com.f1softmanjitshakyatraining.day18.service.impl.StudentServiceImpl;
import com.f1softmanjitshakyatraining.day18.dto.StudentDTO;
import com.f1softmanjitshakyatraining.day18.service.CourseService;
import com.f1softmanjitshakyatraining.day18.service.impl.CourseServiceImpl;
import java.util.Scanner;

/**
 *
 * @author aakashthakur-work
 */
public class Main {

    public static void main(String[] args) {
        StudentService studentServiceMemory;
        StudentService studentServiceDatabase;
        CourseService courseServiceDatabase;

        System.out.println("CRUD OPERATIONS: \n1. Memory \n2. Database");
        Scanner sc1 = new Scanner(System.in);
        int choice1 = sc1.nextInt();

        switch (choice1) {
            case 1: //MEMORY IMPLEMENTATAION
                studentServiceMemory = new StudentServiceImpl(new StudentDAOMemoryImpl());

                System.out.println("Which operation would you like to perform? \n1. Get All Students\n"
                        + "2. Get Student information using ID\n3. Update Student using ID\n4. Delete a"
                        + "student using ID\n5. Insert a new Student Record!");
                Scanner sc10 = new Scanner(System.in);
                int choice3 = sc10.nextInt();
                switch (choice3) {
                    case 1:
                        System.out.println(studentServiceMemory.getAllStudents());
                        break;
                    case 2:
                        System.out.println("\nEnter the ID of the student you want to update!: ");
                        Scanner sc7 = new Scanner(System.in);
                        int getStudentId = sc7.nextInt();
                        System.out.println(studentServiceMemory.getStudentById(getStudentId));
                        break;
                    case 3:
                        Scanner sc8 = new Scanner(System.in);
                        System.out.println("\nEnter the ID of the student you want to update!: ");
                        int id = sc8.nextInt();
                        System.out.println("Enter the updated Name of the student: ");
                        String name = sc8.next();
                        System.out.println("Enter the updated Address of the student: ");
                        String address = sc8.next();
                        System.out.println("Enter the updated contact Number of the student: ");
                        String contact = sc8.next();
                        System.out.println("Enter the updated CourseID of the student: ");
                        int courseId = sc8.nextInt();
                        studentServiceMemory.updateStudentById(id, name, address, contact, courseId);
                        break;
                    case 4:
                        System.out.println("\nEnter the ID of the student you want to permanently delete: ");
                        Scanner sc9 = new Scanner(System.in);
                        int idToDelete = sc9.nextInt();
                        studentServiceMemory.deleteStudentById(idToDelete);
                        break;
                    case 5:
                        System.out.println("\nEnter the details of the sudent: ");
                        Scanner sc11 = new Scanner(System.in);
                        System.out.println("Enter Name: ");
                        String newName = sc11.nextLine();
                        System.out.println("Enter Address: ");
                        String newAddress = sc11.nextLine();
                        System.out.println("Enter Contact Number: ");
                        String newContact = sc11.nextLine();
                        System.out.println("Enter the Course ID: ");
                        int newCourseId = sc11.nextInt();
                        studentServiceMemory.insertStudent(newName, newAddress, newContact, newCourseId);
                        break;
                    default:
                        System.out.println("Please Enter a valid option! Try Again!");
                        break;
                }
                break;
            case 2: //DATABASE IMPLEMENTATION

                studentServiceDatabase = new StudentServiceImpl(new StudentDAODatabaseImpl());

                System.out.println("Which Database would you like to select? \n1. Courses\n2."
                        + " Students");
                Scanner sc = new Scanner(System.in);
                int tableChoice = sc.nextInt();
                //<--COURSE TABLE IMPLEMENTATION-->>
                switch (tableChoice) {

                    case 1:
                        courseServiceDatabase = new CourseServiceImpl(new CourseDAODatabaseImpl());
                        System.out.println("Which operation would you like to perform? \n1. Get "
                                + "a Course Name by ID\n2. Insert a new Course name");
                        Scanner sc13 = new Scanner(System.in);
                        int courseChoice = sc13.nextInt();
                        switch (courseChoice) {
                            case 1:
                                System.out.println("\nEnter the Course ID: ");
                                Scanner sc16 = new Scanner(System.in);
                                int courseId = sc16.nextInt();
                                courseServiceDatabase.getCourseById(courseId);
                                break;

                            case 2:
                                courseServiceDatabase = new CourseServiceImpl(new CourseDAODatabaseImpl());
                                System.out.println("\nEnter the new Course Name: ");
                                Scanner sc17 = new Scanner(System.in);
                                String newCourseName = sc17.nextLine();
                                courseServiceDatabase.insertCourse(newCourseName);
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Which operation would you like to perform? \n1. Get All Students\n"
                                + "2. Get Student information using ID\n3. Update Student using ID\n4. Delete a"
                                + "student using ID\n5. Insert a new Student Record!\n6. DTO Usage!");
                        Scanner sc2 = new Scanner(System.in);
                        int choice2 = sc2.nextInt();
                        switch (choice2) {
                            case 1:
                                studentServiceDatabase.getAllStudents();
                                break;
                            case 2:
                                System.out.println("\nEnter the ID of the student you want to view!: ");
                                Scanner sc3 = new Scanner(System.in);
                                int idChoice = sc3.nextInt();
                                studentServiceDatabase.getStudentById(idChoice);
                                break;
                            case 3:
                                Scanner sc4 = new Scanner(System.in);
                                System.out.println("\nEnter the ID of the student you want to update!: ");
                                String s = sc4.nextLine();
                                int id = Integer.valueOf(s);
                                System.out.println("Enter the updated Name of the student: ");
                                String name = sc4.nextLine();
                                System.out.println("Enter the updated Address of the student: ");
                                String address = sc4.nextLine();
                                System.out.println("Enter the updated contact Number of the student: ");
                                String contact = sc4.nextLine();
                                System.out.println("Enter the updated CourseID of the student: ");
                                int courseId = sc4.nextInt();
                                studentServiceDatabase.updateStudentById(id, name, address, contact, courseId);
                                break;
                            case 4:
                                System.out.println("\nEnter the ID of the student you want to permanently delete: ");
                                Scanner sc5 = new Scanner(System.in);
                                int idToDelete = sc5.nextInt();
                                studentServiceDatabase.deleteStudentById(idToDelete);
                                break;
                            case 5:
                                System.out.println("\nEnter the details of the sudent: ");
                                Scanner sc6 = new Scanner(System.in);
                                System.out.println("Enter Name: ");
                                String newName = sc6.nextLine();
                                System.out.println("Enter Address: ");
                                String newAddress = sc6.nextLine();
                                System.out.println("Enter Contact Number: ");
                                String newContact = sc6.nextLine();
                                System.out.println("Enter the Course ID: ");
                                int newCourseId = sc6.nextInt();
                                studentServiceDatabase.insertStudent(newName, newAddress, newContact, newCourseId);
                                break;

                            case 6:
                                System.out.println("This is StudentDTO Builder using DTO: ");
                                StudentDTO studentDTO = StudentDTO.builder()
                                        .name("Harshad")
                                        .address("Gujrat")
                                        .contactNo("7358234987")
                                        .courseId(2)
                                        .build();
                                System.out.println(studentDTO);
                                studentServiceDatabase.addStudent(studentDTO);
                                break;
                            default:
                                System.out.println("Please enter a valid detail: ");
                                break;

                        }

                }

        }
    }
}
