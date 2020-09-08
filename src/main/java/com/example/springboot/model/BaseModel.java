package com.example.springboot.model;

import com.example.springboot.config.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class BaseModel {

    @Autowired
    private DataSourceConfig config;

    public String table;

//    public String sql;

    static public Connection conn;

//    public PreparedStatement pstmt;

    public BaseModel() {
        try {
            if (!(BaseModel.conn instanceof Connection)) {
                BaseModel.conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
            }
        }catch (SQLException exception) {
            // TODO: Need to log err msg.
            System.out.println(exception.getMessage());
        }
    }

    public int add(Map<String, Object> insertData){
        String sql, insertKeyStr, insertValuePlaceHolderStr;

        sql = "INSERT INTO " + table;
        insertKeyStr = "(";
        insertValuePlaceHolderStr = "(";

        for (String key : insertData.keySet()) {
            insertKeyStr += (key + ",");
            insertValuePlaceHolderStr += "?,";
        }

        // preprocessing
        insertKeyStr = insertKeyStr.substring(0,-1) + ")";
        insertValuePlaceHolderStr = insertValuePlaceHolderStr.substring(0,-1) + ")";
        sql += (insertKeyStr + " VALUES " + insertValuePlaceHolderStr);
        System.out.println(sql);
        return 1;
//        pstmt = conn.prepareStatement(sql);
//
//        // params binding
//        int i = 1;
//        for (Object value : insertData.values()) {
//
//            if (value instanceof Integer) {
//                pstmt.setInt(i, (Integer) value);
//            }else if(value instanceof String) {
//                pstmt.setString(i, (String) value);
//            }else{
//                // TODO: wrong data type, add log and throws error.
//            }
//
//            i++;
//        }
//
//        int res = pstmt.executeUpdate();
//        pstmt.close();
//
//        return res;
    }
}
