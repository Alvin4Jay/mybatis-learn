package com.jay.mapper;

import com.jay.bean.Teacher;

/**
 * @author xuweijie
 */
public interface TeacherMapper {

    /**
     * 根据id查找老师信息
     *
     * @param id
     * @return
     */
    Teacher findById(Long id);

}
