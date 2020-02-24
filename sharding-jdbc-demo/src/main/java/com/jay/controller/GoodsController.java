package com.jay.controller;

import com.jay.bean.Goods;
import com.jay.mapper.GoodsMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * 控制器
 *
 * @author xuweijie
 */
@RestController
public class GoodsController {

    @Resource
    private GoodsMapper goodsMapper;

    @GetMapping("save")
    public String save() {
        for (int i = 1; i <= 40; i++) {
            Goods goods = new Goods();
            goods.setGoodsId((long) i);
            goods.setGoodsName("shangpin" + i);
            goods.setGoodsType((long) (new Random().nextInt(5) + 1));
            goodsMapper.save(goods);
        }
        return "success";
    }

    @GetMapping("select")
    public Goods select(@RequestParam Long id, @RequestParam Long type) {
        Goods goods = goodsMapper.select(id, type);
        return goods;
    }

}
