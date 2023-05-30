package com.example.my_mall.dto;


import com.example.my_mall.utils.validator.FlagValidator;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;


//关于品牌相关服务，用于传输的参数对象
@Data
@EqualsAndHashCode
public class PmsBrandParam {

    @NotEmpty
    @Schema(name = "品牌名称", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(name = "首字母")
    private String firstLetter;

    @Min(value = 0)
    @Schema(name = "分类字段")
    private Integer sort;

    @FlagValidator(value = {"0","1"}, message = "只允许两种状态码")
    @Schema(name = "是否为品牌制造商")
    private Integer factoryStatus;

    @FlagValidator(value = {"0","1"}, message = "只允许两种状态码")
    @Schema(name = "是否显示")
    private Integer showStatus;

    @FlagValidator(value = {"0","1"}, message = "有货-1无货-0两种状态")
    @Schema(name = "产品数量是否不为0")
    private Integer productCount;

    @NotEmpty
    @Schema(name = "品牌logo")
    private String logo;

    @Schema(name = "品牌大图")
    private String bigPic;

    @Schema(name = "品牌故事")
    private String brandStory;




}
