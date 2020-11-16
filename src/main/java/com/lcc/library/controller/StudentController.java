package com.lcc.library.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcc.library.dao.StudentDao;
import com.lcc.library.entity.Result;
import com.lcc.library.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentDao studentDao;

    // 分页查询整表
    @RequestMapping("/queryAllStudent")
    @ResponseBody
    public Result queryAllStudent(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        List list = studentDao.queryAll((page - 1) * limit, limit);
        Result rusult = Result.success().addData(list);
        rusult.setCount(studentDao.queryRowCount());
        return rusult;
    }

    // 添加用户
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    @ResponseBody
    public Result addStudent(@RequestBody Student student) {
        try {
            if (studentDao.addStudent(student) > 0) {
                return Result.success();
            }
        } catch (Exception e) {
            Result result = Result.fail();
            result.setMsg("操作失败，cid已存在");
            return result;
        }
        return Result.fail();
    }

    // 修改用户
    @RequestMapping(value = "/modfiyStudent/{uid}", method = RequestMethod.POST)
    @ResponseBody
    public Result modfiyStudent(@PathVariable("uid") Integer uid, @RequestBody Student student) {
        student.setUid(uid);
        try {
            if (studentDao.updateStudent(student) > 0) {
                return Result.success();
            }
        } catch (Exception e) {
            Result result = Result.fail();
            result.setMsg("修改失败");
            return result;
        }
        return Result.fail();
    }

    // 删除用户
    @RequestMapping(value = "/removeStudent", method = RequestMethod.POST)
    @ResponseBody
    // 前端传JSON数组，包含待删除的用户对象
    public Result removeStudent(@RequestBody String students) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Student.class);
        List<Student> list = objectMapper.readValue(students, javaType);

        try {
            if (studentDao.deleteStudent(list) > 0) {
                return Result.success();
            }
        } catch (Exception e) {
            Result result = Result.fail();
            result.setMsg("删除失败");
            return result;
        }
        return Result.fail();
    }
}