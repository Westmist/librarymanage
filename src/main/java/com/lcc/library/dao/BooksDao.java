package com.lcc.library.dao;

import com.lcc.library.entity.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BooksDao {
    // 根据卡号查询书单表
    List<Books> queryByCard(@Param("cnum") Integer cnum);

}
