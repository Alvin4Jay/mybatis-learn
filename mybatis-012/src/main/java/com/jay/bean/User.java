package com.jay.bean;

import lombok.Data;

import java.util.List;

/**
 * @author xuweijie
 */
@Data
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Blog> blogList;

}
