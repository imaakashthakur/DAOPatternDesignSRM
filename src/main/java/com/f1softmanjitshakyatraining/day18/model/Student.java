/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author aakashthakur-work
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student {
    
    private String name;
    private int id;
    static String collegeName = "SRM";
    private String address;
    private String contactNo;
    private Course course;
    

}
