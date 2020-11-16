package com.lcc.library.controller;

import com.lcc.library.dao.BooksDao;
import com.lcc.library.entity.Books;
import com.lcc.library.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksDao booksDao;

    @RequestMapping("/queryStudentBooks/{cnum}")
    @ResponseBody
    public Result queryStudentBooks(@PathVariable("cnum") Integer cnum) {
        List<Books> data = booksDao.queryByCard(cnum);
        if (!data.isEmpty()) {
            return Result.success().addData(data);
        }
        return Result.fail();
    }
}
