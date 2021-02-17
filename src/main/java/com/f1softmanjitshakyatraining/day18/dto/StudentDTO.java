/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.f1softmanjitshakyatraining.day18.dto;

import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author aakashthakur-work
 */
@Builder
@Getter

public class StudentDTO {

    private String name;
    static String collegeName = "SRM";
    private String address;
    private String contactNo;
    private int courseId;

}
