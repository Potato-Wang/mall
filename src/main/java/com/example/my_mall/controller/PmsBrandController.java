package com.example.my_mall.controller;

import com.example.my_mall.dto.PmsBrandParam;
import com.example.my_mall.mbg.model.PmsBrand;
import com.example.my_mall.service.PmsBrandService;
import com.example.my_mall.utils.result.CommonPage;
import com.example.my_mall.utils.result.CommonResults;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
 *商品品牌表的管理
 * 实现获取全部品牌列表，添加，删除，更新，分页，id查询，批量删除，批量更新，更新包括 是否为品牌制造商，是否显示
 */
@Api(tags = "PmsBrandController")
@Tag(name = "PmsBrandController", description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation(value = "获取全部品牌列表")
    @GetMapping(value = "/listAll")
    public CommonResults<List<PmsBrand>> listAll(){
        return CommonResults.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation(value = "添加品牌")
    @PostMapping(value = "/add")
    public CommonResults addBrand(@Validated @RequestBody PmsBrandParam pmsBrandParam){
        int count = pmsBrandService.addBrand(pmsBrandParam);
        if(count == 1){
            return CommonResults.success(count);
        }
        else{
            return CommonResults.failed();
        }
    }

    @ApiOperation(value = "更新品牌")
    @PostMapping(value = "/updata/{id}")
    public CommonResults updateBrand(@PathVariable("id") Long id, @Validated @RequestBody PmsBrandParam pmsBrandParam){
        int count = pmsBrandService.updateBrand(id, pmsBrandParam);
        if (count == 1){
            return CommonResults.success(count);
        }
        else{
            return CommonResults.failed();
        }
    }

    @ApiOperation(value = "删除品牌")
    @GetMapping(value = "/delete/{id}")
    public CommonResults deleteBrand(@PathVariable("id") Long id){
        int count = pmsBrandService.deleteBrand(id);
        if (count == 1){
            return CommonResults.success(null);
        }
        else{
            return CommonResults.failed();
        }
    }


    @ApiOperation(value = "根据品牌名称分页获取品牌列表")
    @GetMapping(value = "/list")
    public CommonResults<CommonPage<PmsBrand>> getList(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "showStatus", required = false) Integer showStatus,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pagesize
    ){
        List<PmsBrand> brandList = pmsBrandService.listBrand(keyword, showStatus, pageNum, pagesize);
        return CommonResults.success(CommonPage.restPage(brandList));
    }


    @ApiOperation(value = "根据编号查询品牌信息")
    @GetMapping(value = "/get/{id}")
    public CommonResults<PmsBrand> getItem(@PathVariable(value = "id") Long id){
        PmsBrand item = pmsBrandService.getBrand(id);
        return CommonResults.success(item);
    }


    @ApiOperation(value = "批量删除品牌")
    @PostMapping(value = "/delete_batch")
    public CommonResults deleteByBatch(@RequestParam("ids") List<Long> ids){
        int count = pmsBrandService.deleteBrand(ids);
        if (count > 0){
            return CommonResults.success(count);
        }
        else{
            return CommonResults.failed();
        }
    }

    @ApiOperation(value = "批量更新显示状态")
    @PostMapping(value = "/updata_showStatus")
    public CommonResults updateShowStatusByBatch(@RequestParam(value = "ids") List<Long> ids,
                                                 @RequestParam(value = "showStatus") Integer showStatus
    ){
        int count = pmsBrandService.updateShowStatus(ids, showStatus);
        if (count > 0){
            return CommonResults.success(count);
        }
        else {
            return CommonResults.failed();
        }
    }


    @ApiOperation(value = "批量更新厂家制造商状态")
    @PostMapping(value = "/updata_factoryStatus")
    public CommonResults updataFactoryStatusByBatch(@RequestParam(value = "ids") List<Long> ids,
                                                    @RequestParam(value = "factoryStatus") Integer factoryStatus
    ){
        int count = pmsBrandService.updateFactory(ids, factoryStatus);
        if(count > 0){
            return CommonResults.success(count);
        }
        else{
            return CommonResults.failed();
        }
    }




}
