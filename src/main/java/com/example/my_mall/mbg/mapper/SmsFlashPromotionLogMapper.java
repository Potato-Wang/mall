package com.example.my_mall.mbg.mapper;

import com.example.my_mall.mbg.model.SmsFlashPromotionLog;
import com.example.my_mall.mbg.model.SmsFlashPromotionLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsFlashPromotionLogMapper {
    long countByExample(SmsFlashPromotionLogExample example);

    int deleteByExample(SmsFlashPromotionLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsFlashPromotionLog row);

    int insertSelective(SmsFlashPromotionLog row);

    List<SmsFlashPromotionLog> selectByExample(SmsFlashPromotionLogExample example);

    SmsFlashPromotionLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") SmsFlashPromotionLog row, @Param("example") SmsFlashPromotionLogExample example);

    int updateByExample(@Param("row") SmsFlashPromotionLog row, @Param("example") SmsFlashPromotionLogExample example);

    int updateByPrimaryKeySelective(SmsFlashPromotionLog row);

    int updateByPrimaryKey(SmsFlashPromotionLog row);
}