package com.example.mybatisdemo.Dao;

import com.example.mybatisdemo.domain.PoweronApiIn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoweronApiInMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PoweronApiIn record);

    int insertSelective(PoweronApiIn record);

    PoweronApiIn selectByPrimaryKey(Long id);

    List<PoweronApiIn> selectAllPoweron();

    int updateByPrimaryKeySelective(PoweronApiIn record);

    int updateByPrimaryKey(PoweronApiIn record);
}