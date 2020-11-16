package com.lcc.library.dao;

import com.lcc.library.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("/studentDao")
@Mapper
public interface StudentDao {
    // 查询整个学生表
    List<Student> queryAll(@Param("hIndex") Integer hIndex, @Param("limit") Integer limit);

    // 查询数据表总行数
    Integer queryRowCount();

    // 添加用户
    Integer addStudent(Student student);

    // 修改用户
    Integer updateStudent(Student student);

    // 删除用户
    Integer deleteStudent(List<Student> list);
}
