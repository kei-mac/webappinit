package com.kita.demo.mapper.param;

import lombok.Data;

/**
 * 天気予報のデータ読み込み
 */
@Data
public class DemoFileActionUtilMapperResult {
    private int observation_station_number;
    private String prefecture;
    private String location;
    private String international_station_number;
    private int current_year;
    private int current_month;
    private int current_day;
    private int current_hour;
    private int current_minute;
    private double current_value_mm;
    private int current_value_quality_info;
    private double max_value_8_days_mm;
    private int max_value_8_days_quality_info;
    private int max_value_8_days_hour;
    private int max_value_8_days_minute;
    private int max_value_8_days_quality_info_2;
    private boolean extreme_value_update;
    private boolean extreme_value_update_within_10_years;
    private double record_value_until_7_days_mm;
    private int record_value_until_7_days_quality_info;
    private int record_value_until_7_days_year;
    private int record_value_until_7_days_month;
    private int record_value_until_7_days_day;
    private double record_value_until_september_7_days_mm;
    private int record_value_until_september_7_days_quality_info;
    private int record_value_until_september_7_days_year;
    private int record_value_until_september_7_days_month;
    private int record_value_until_september_7_days_day;
    private int statistics_start_year;
}
