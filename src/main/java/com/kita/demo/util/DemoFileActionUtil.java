package com.kita.demo.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

/**
 * ファイル操作クラス
 * 
 * @author 来田 圭汰朗
 * 
 */
@Component
@RequiredArgsConstructor
public class DemoFileActionUtil {

    // フィールド
    private final String ENCODING = "SJIS";

    /**
     * ファイル読み込み処理
     * 
     * @param filePath      （ファイルパス）
     * @param columnMapping （カラムマップ）
     * @param clazz         （対象クラス）
     * @return List 読み込みデータ
     */
    public List<Map<String, Object>> processDatFile(String filePath, Map<String, String> columnMapping,
            Class<?> clazz) {

        List<Map<String, Object>> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), ENCODING))) {

            // TODO ファイル存在確認

            // datファイルの1行目を読み込み（カラム名）
            String headerLine = br.readLine();
            if (headerLine == null) {
                throw new IOException("datファイルが空です。");
            }

            // datファイルのカラム名を取得
            String[] fileColumns = headerLine.split("\t");

            // カラム数のチェック
            if (fileColumns.length != columnMapping.size()) {
                throw new IllegalArgumentException("カラム数とマッピング数が一致しません");
            }

            // datファイルのデータを読み込み
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split("\t");

                // データベースのカラム名に対応するMapを作成
                Map<String, Object> dataMap = new HashMap<>();
                for (int i = 0; i < fileColumns.length; i++) {
                    String dbColumn = columnMapping.get(fileColumns[i]);

                    // 値を格納
                    if (dbColumn != null) {
                        String value = values[i];

                        // データ型に応じて値を変換して格納
                        Field field = clazz.getDeclaredField(dbColumn);
                        field.setAccessible(true);
                        Class<?> fieldType = field.getType();
                        
                        if (value == null || value.trim().isEmpty()) {
                            dataMap.put(dbColumn, null);
                        } else if (fieldType.equals(Integer.class) || fieldType.equals(int.class)) {
                            dataMap.put(dbColumn, Integer.parseInt(value));
                        } else if (fieldType.equals(Double.class) || fieldType.equals(double.class)) {
                            dataMap.put(dbColumn, Double.parseDouble(value));
                        } else if (fieldType.equals(Timestamp.class)) {
                            dataMap.put(dbColumn, Timestamp.valueOf(value));
                        } else {
                            dataMap.put(dbColumn, value);
                        }
                        
                    } else {
                        throw new IOException("カラム名:" + fileColumns[i] + "が存在していません。");
                    }
                }

                // Mapをリストに追加
                dataList.add(dataMap);
            }
        } catch (IOException | NoSuchFieldException e) {
            // エラーハンドリング
            e.printStackTrace();
        }

        // Mapのリストを戻り値として返却
        return dataList;
    }
}
