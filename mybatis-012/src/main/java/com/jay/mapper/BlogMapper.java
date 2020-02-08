package com.jay.mapper;

import com.jay.bean.Blog;

/**
 * @author xuweijie
 */
public interface BlogMapper {

    Blog findById(Long id);

    Blog findByIdTwo(Long id);

}
