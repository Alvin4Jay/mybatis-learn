package com.jay.bean;

import lombok.Data;

import java.util.List;

/**
 * @author xuweijie
 */
@Data
public class Teacher {

    private Long id;
    private String name;
    private List<Student> studentList; // 一对多

}
