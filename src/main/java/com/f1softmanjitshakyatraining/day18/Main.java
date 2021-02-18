/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18;

import com.f1softmanjitshakyatraining.day18.dao.impl.StudentDAODatabaseImpl;
import com.f1softmanjitshakyatraining.day18.dao.impl.StudentDAOMemoryImpl;
import com.f1softmanjitshakyatraining.day18.service.StudentService;
import com.f1softmanjitshakyatraining.day18.service.impl.StudentServiceImpl;
import java.util.Scanner;

/**
 *
 * @author aakashthakur-work
 */
public class Main {

    public static void main(String[] args) {
        StudentService studentServiceMemory;
        StudentService studentServiceDatabase;

        System.out.println("CRUD OPERATIONS: \n1. Memory \n2. Database");
        Scanner sc1 = new Scanner(System.in);
        int choice1 = sc1.nextInt();

        switch (choice1) {
            case 1:
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
            case 2:
                studentServiceDatabase = new StudentServiceImpl(new StudentDAODatabaseImpl());

                System.out.println("Which operation would you like to perform? \n1. Get All Students\n"
                        + "2. Get Student information using ID\n3. Update Student using ID\n4. Delete a"
                        + "student using ID\n5. Insert a new Student Record!");
                Scanner sc2 = new Scanner(System.in);
                int choice2 = sc2.nextInt();
                switch (choice2) {
                    case 1:
                        studentServiceDatabase.getAllStudents();
                    case 2:
                        System.out.println("\nEnter the ID of the student you want to view!: ");
                        Scanner sc3 = new Scanner(System.in);
                        int idChoice = sc3.nextInt();
                        studentServiceDatabase.getStudentById(idChoice);
                        break;
                    case 3:
                        Scanner sc4 = new Scanner(System.in);
                        System.out.println("\nEnter the ID of the student you want to update!: ");
                        int id = sc4.nextInt();
                        System.out.println("Enter the updated Name of the student: ");
                        String name = sc4.next();
                        System.out.println("Enter the updated Address of the student: ");
                        String address = sc4.next();
                        System.out.println("Enter the updated contact Number of the student: ");
                        String contact = sc4.next();
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
                    default:
                        System.out.println("Please enter a valid detail: ");
                        break;

                }

        }
    }
}
