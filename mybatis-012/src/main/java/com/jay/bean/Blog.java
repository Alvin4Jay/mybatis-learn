package com.jay.bean;

import lombok.Data;

/**
 * @author xuweijie
 */
@Data
public class Blog {

    private Long id;
    private String title;
    private String content;
    private User user; // 一对一
    private Long ownerId;

}
