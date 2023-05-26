package com.example.my_mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 *商品品牌表的管理
 * 实现获取全部品牌列表，添加，删除，更新，分页，id查询，批量删除，批量更新，更新包括 是否为品牌制造商，是否显示
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController {

    private PmsBrandService Service;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    //todo
    //创建通用查询返回对象
    //实现方法



}
