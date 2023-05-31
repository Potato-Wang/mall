package com.example.my_mall.service.pms;

import com.example.my_mall.dto.PmsBrandParam;
import com.example.my_mall.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {

    //获取品牌列表
    List<PmsBrand> listAllBrand();
    //添加品牌
    int addBrand(PmsBrandParam pmsBrandParam);
    //删除品牌
    int deleteBrand(Long id);
    //批量删除
    int deleteBrand(List<Long> ids);
    //更新品牌
    int updateBrand(Long id, PmsBrandParam pmsBrandParam);
    //分页查询
    List<PmsBrand> listBrand(String keyword, Integer showStatus, int pageNum, int pageSize);
    //品牌名查询
    PmsBrand getBrand(Long id);
    //批量更新 是否为制造商
    int updateFactory(List<Long> ids, Integer factoryStatus);
    //批量更新 是否显示
    int updateShowStatus(List<Long> ids, Integer showStatus);

}
