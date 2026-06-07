package com.kita.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Map;

/**
 * 天気予報のデータ読み込み
 * 
 */
@Mapper
public interface DemoFileActionUtilMapper {

    public void addDataMapper(@Param("tableName") String tableName, @Param("map") Map<String, Object> map);
}
