package com.jay.bean;

import lombok.Data;

import java.util.List;

/**
 * @author xuweijie
 */
@Data
public class Student {

    private Long id;
    private String name;
    private List<Teacher> teacherList; // 一对多

}
