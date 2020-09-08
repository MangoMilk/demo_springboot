package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoomController {

//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @RequestMapping("/createRoom")
//    public Map<String, Object> createRoom() throws SQLException {
//
//        int ownerId = 1;
//        String roomName = "test";
//        int timeStamp = Integer.valueOf(String.valueOf(System.currentTimeMillis()/1000));
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String dateStr = dateFormat.format(new Date());
//
//
////        String sql = "INSERT INTO `t_room` (room_owner,room_name,created_date,created_at,last_updated_at) VALUES (1,'test',"+dateStr+","+timeStamp+","+timeStamp+")";
//        String sql = "INSERT INTO `t_room` (room_owner,room_name,created_date,created_at,last_updated_at) VALUES (?,?,?,?,?)";
//
//        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_test?characterEncoding=utf-8","root","root");
//        PreparedStatement pstmt = connection.prepareStatement(sql);
//        pstmt.setInt(1,ownerId);
//        pstmt.setString(2,roomName);
//        pstmt.setString(3,dateStr);
//        pstmt.setInt(4,timeStamp);
//        pstmt.setInt(5,timeStamp);
//
////        jdbcTemplate.execute(sql);
////        jdbcTemplate.execute(sql,);
//        Map<String,Object> res = new HashMap<>();
//        res.put("code", 0);
//        res.put("message", "success");
//        res.put("content", pstmt.executeUpdate());
//        pstmt.close();
//        connection.close();
//
//        return res;
//    }
//
//    @RequestMapping("/getRooms")
//    public Map<String,Object> getRooms() {
//
//        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_room");
//
//        Map<String,Object> res = new HashMap<>();
//        res.put("code", 0);
//        res.put("message", "success");
//        res.put("content",list);
//        return res;
//    }
//
//    @RequestMapping(value = "/room/{room_id}",method = RequestMethod.GET)
//    public Map<String,Object> getRoom(@PathVariable("room_id") int roomId) {
//        Map<String,Object> res = new HashMap<>();
//        return res;
//    }
//
//    @RequestMapping("/editRoom")
//    public String editRoom() {
//        return "";
//    }
//
//    @RequestMapping("/deleteRoom")
//    public String deleteRoom() {
//        return "";
//    }
}
