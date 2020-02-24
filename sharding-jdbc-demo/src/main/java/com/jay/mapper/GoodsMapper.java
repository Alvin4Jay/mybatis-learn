package com.jay.mapper;

import com.jay.bean.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 测试
 *
 * @author xuweijie
 */
@Mapper
public interface GoodsMapper {

    @Insert("insert into goods(goods_id, goods_name, goods_type) values(#{goodsId}, #{goodsName}, #{goodsType} )")
    void save(Goods goods);

    @Select("select goods_id, goods_name, goods_type from goods where goods_id=#{goodsId} and goods_type=#{goodsType} ")
    Goods select(@Param("goodsId") Long id, @Param("goodsType") Long type);

}
