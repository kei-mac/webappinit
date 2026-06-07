package com.kita.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import com.kita.demo.mapper.DemoFileActionUtilMapper;
import com.kita.demo.mapper.param.DemoFileActionUtilMapperMap;
import com.kita.demo.mapper.param.DemoFileActionUtilMapperResult;
import com.kita.demo.util.DemoFileActionUtil;

@Component
@RequiredArgsConstructor
public class DemoFileActionService {

    private final DemoFileActionUtilMapper mapper;
    private final DemoFileActionUtil demoFileActionUtil;
    private final DemoFileActionUtilMapperMap demoFileActionUtilMapperMap;

    public void addData(){
        String filePath = "C:\\project\\Webapp\\testdata\\pre72h00_rct.dat";
        String tableName = "weather_data";

        List<Map<String, Object>> dataList = demoFileActionUtil.processDatFile(filePath, demoFileActionUtilMapperMap.setMap(), DemoFileActionUtilMapperResult.class);
        for(Map<String, Object> map:dataList){
            mapper.addDataMapper(tableName, map);
        }
    }
}
