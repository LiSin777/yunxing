package com.qing.utils;

import com.qing.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class JDBCUtils {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Student student){
        String sql = "insert into student values(? , ? , ? , ?)";
        return jdbcTemplate.update(sql , student.getSno() , student.getName()
                , student.getAge() , student.getCollege());
    }

    public List<Map<String, Object>> queryAll(){
        String sql = "select * from student";
        return jdbcTemplate.queryForList(sql);
    }

    public int deleteByID(String sno){
        String sql = "delete from student where sno = ?";
        return jdbcTemplate.update(sql , sno);
    }

    public Student queryByID(String sno){
        String sql = "select * from student where sno = ?";
        return jdbcTemplate.queryForObject(sql , new BeanPropertyRowMapper<>(Student.class) , sno);
    }

    public int updateByID(Student student){
        String sql = "update student set name = ? , age = ? , college = ? where sno = ?";
        return jdbcTemplate.update(sql , student.getName() , student.getAge() ,
                student.getCollege() , student.getSno());
    }
}
