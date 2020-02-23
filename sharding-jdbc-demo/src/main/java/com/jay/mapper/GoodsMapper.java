package com.jay.mapper;

import com.jay.bean.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 测试
 *
 * @author xuweijie
 */
@Mapper
public interface GoodsMapper {

    @Insert("insert into goods(goods_Id, goods_name, goods_type) values(#{goodsId}, #{goodsName}, #{goodsType} )")
    void save(Goods goods);

}
