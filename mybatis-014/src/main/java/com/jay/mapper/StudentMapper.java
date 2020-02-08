package com.jay.mapper;

import com.jay.bean.Student;

/**
 * @author xuweijie
 */
public interface StudentMapper {

    /**
     * 根据id查找学生信息
     *
     * @param id
     * @return
     */
    Student findById(Long id);

}
