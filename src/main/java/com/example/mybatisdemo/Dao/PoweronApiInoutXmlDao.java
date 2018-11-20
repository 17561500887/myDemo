package com.example.mybatisdemo.Dao;

import com.example.mybatisdemo.domain.PoweronApiInout;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PoweronApiInoutXmlDao {

    PoweronApiInout selectAllXmlByKeyValue(String keyValue);

    List<PoweronApiInout> selectList();
}
