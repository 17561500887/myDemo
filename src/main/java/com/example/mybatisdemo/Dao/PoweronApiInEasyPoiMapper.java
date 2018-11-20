package com.example.mybatisdemo.Dao;


import com.example.mybatisdemo.domain.PoweronApiInEasyPoi;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoweronApiInEasyPoiMapper {


    int insert(PoweronApiInEasyPoi  record);

    int insertSelective(PoweronApiInEasyPoi  record);

    List<PoweronApiInEasyPoi > selectAllPoweron();

    int updateByPrimaryKeySelective(PoweronApiInEasyPoi  record);

    int updateByPrimaryKey(PoweronApiInEasyPoi  record);
}
