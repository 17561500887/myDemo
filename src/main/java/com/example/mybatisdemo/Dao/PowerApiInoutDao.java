package com.example.mybatisdemo.Dao;

import com.example.mybatisdemo.domain.PoweronApiInout;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PowerApiInoutDao {

    @Select("select * from poweron_api_inout where key_value = #{keyValue}")
    PoweronApiInout selectAllByKeyValue(@Param("keyValue") String keyValue);


}
