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

public class Course {

    private int courseId;
    private String courseName;

    public Course(int courseId) {
        this.courseId = courseId;
    }

}
