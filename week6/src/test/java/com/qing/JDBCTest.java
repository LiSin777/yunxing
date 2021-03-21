package com.qing;

import com.qing.pojo.Student;
import com.qing.utils.JDBCUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JDBCTest {
    @Autowired
    private JDBCUtils jdbcUtils;
    @Test
    public void testInsert(){
        jdbcUtils.insert(new Student("s001","老大",20,"计算机学院"));
        jdbcUtils.insert(new Student("s002","老二",19,"计算机学院"));
        jdbcUtils.insert(new Student("s003","老三",18,"计算机学院"));
        jdbcUtils.insert(new Student("s004","老四",17,"计算机学院"));
    }

    @Test
    public void testQueryAll(){
        System.out.println(jdbcUtils.queryAll());
    }

    @Test
    public void testDeleteByID(){
        jdbcUtils.deleteByID("s004");
    }

    @Test
    public void testQueryByID(){
        System.out.println(jdbcUtils.queryByID("s003"));
    }

    @Test
    public void testUpdateByID(){
        jdbcUtils.updateByID(new Student("s001" , "老大" , 20 , "通信学院"));
    }
}
