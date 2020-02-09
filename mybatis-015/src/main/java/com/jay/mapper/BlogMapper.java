package com.jay.mapper;

import com.jay.bean.Blog;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 分页查询
 *
 * @author xuweijie
 */
public interface BlogMapper {

    /**
     * 物理查询
     *
     * @param ownerId
     * @param limit
     * @param offset
     * @return
     */
    List<Blog> findByUserId(Long ownerId, Integer limit, Integer offset);

    /**
     * 逻辑查询(+PageHelper，物理查询，修改SQL)
     *
     * @param ownerId
     * @param rowBounds
     * @return
     */
    List<Blog> findByUserIdWithRowBounds(Long ownerId, RowBounds rowBounds);

}
