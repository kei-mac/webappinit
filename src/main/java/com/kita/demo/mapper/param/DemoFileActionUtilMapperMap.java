package com.kita.demo.mapper.param;
import java.util.Map;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DemoFileActionUtilMapperMap {

    public Map<String, String> setMap() {
        Map<String, String> columMapping = new HashMap<>();

        columMapping.put("観測所番号", "observation_station_number");
        columMapping.put("都道府県", "prefecture");
        columMapping.put("地点", "location");
        columMapping.put("国際地点番号", "international_station_number");
        columMapping.put("現在時刻(年)", "current_year");
        columMapping.put("現在時刻(月)", "current_month");
        columMapping.put("現在時刻(日)", "current_day");
        columMapping.put("現在時刻(時)", "current_hour");
        columMapping.put("現在時刻(分)", "current_minute");
        columMapping.put("現在値(mm)", "current_value_mm");
        columMapping.put("現在値の品質情報", "current_value_quality_info");
        columMapping.put("8日の最大値(mm)", "max_value_8_days_mm");
        columMapping.put("8日の最大値の品質情報", "max_value_8_days_quality_info");
        columMapping.put("8日の最大値起時（時）(まで)", "max_value_8_days_hour");
        columMapping.put("8日の最大値起時（分）(まで)", "max_value_8_days_minute");
        columMapping.put("8日の最大値起時(まで)の品質情報", "max_value_8_days_quality_info_2");
        columMapping.put("極値更新", "extreme_value_update");
        columMapping.put("10年未満での極値更新", "extreme_value_update_within_10_years");
        columMapping.put("7日までの観測史上1位の値(mm)", "record_value_until_7_days_mm");
        columMapping.put("7日までの観測史上1位の値の品質情報", "record_value_until_7_days_quality_info");
        columMapping.put("7日までの観測史上1位の値の年", "record_value_until_7_days_year");
        columMapping.put("7日までの観測史上1位の値の月", "record_value_until_7_days_month");
        columMapping.put("7日までの観測史上1位の値の日", "record_value_until_7_days_day");
        columMapping.put("7日までの9月の1位の値(mm)", "record_value_until_september_7_days_mm");
        columMapping.put("7日までの9月の1位の値の品質情報", "record_value_until_september_7_days_quality_info");
        columMapping.put("7日までの9月の1位の値の年", "record_value_until_september_7_days_year");
        columMapping.put("7日までの9月の1位の値の月", "record_value_until_september_7_days_month");
        columMapping.put("7日までの9月の1位の値の日", "record_value_until_september_7_days_day");
        columMapping.put("統計開始年", "statistics_start_year");

        return columMapping;
    }
}
