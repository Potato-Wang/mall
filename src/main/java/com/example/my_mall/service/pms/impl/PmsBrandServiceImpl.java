package com.example.my_mall.service.pms.impl;

import com.example.my_mall.dto.PmsBrandParam;
import com.example.my_mall.mbg.mapper.PmsBrandMapper;
import com.example.my_mall.mbg.model.PmsBrand;
import com.example.my_mall.mbg.model.PmsBrandExample;
import com.example.my_mall.service.pms.PmsBrandService;
import com.github.pagehelper.PageHelper;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;


    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int addBrand(PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        //若添加商品时，首字母没有参数，则使用名字
        if (pmsBrand.getFirstLetter() == null || pmsBrand.getFirstLetter() == ""){
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0,1));
        }
        return pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteBrand(List<Long> ids) {
        PmsBrandExample pmsBrandExample = new PmsBrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        return pmsBrandMapper.deleteByExample(pmsBrandExample);
    }

    @Override
    public int updateBrand(Long id, PmsBrandParam pmsBrandParam) {
        PmsBrand pmsBrand = new PmsBrand();
        BeanUtils.copyProperties(pmsBrandParam, pmsBrand);
        pmsBrand.setId(id);
        if (pmsBrand.getFirstLetter() == null || pmsBrand.getFirstLetter() == ""){
            pmsBrand.setFirstLetter(pmsBrand.getName().substring(0,1));
        }
        //todo
        //更新品牌对其他造成的影响


        return pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public List<PmsBrand> listBrand(String keyword, Integer showStatus, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsBrandExample pmsBrandExample = new PmsBrandExample();
        PmsBrandExample.Criteria criteria = pmsBrandExample.createCriteria();
        pmsBrandExample.setOrderByClause("sort desc");
        if (!StringUtils.isNullOrEmpty(keyword)){
            criteria.andNameLike(keyword);
        }
        if(showStatus!=null){
            criteria.andShowStatusEqualTo(showStatus);
        }

        return pmsBrandMapper.selectByExample(pmsBrandExample);
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateFactory(List<Long> ids, Integer factoryStatus) {
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setFactoryStatus(factoryStatus);
        PmsBrandExample pmsBrandExample = new PmsBrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        return pmsBrandMapper.updateByExampleSelective(pmsBrand, pmsBrandExample);
    }

    @Override
    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        PmsBrand pmsBrand = new PmsBrand();
        pmsBrand.setShowStatus(showStatus);
        PmsBrandExample pmsBrandExample = new PmsBrandExample();
        pmsBrandExample.createCriteria().andIdIn(ids);
        return pmsBrandMapper.updateByExampleSelective(pmsBrand, pmsBrandExample);
    }
}
