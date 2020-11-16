package com.lcc.library.entity;

/**
 * isbn 图书编号 主键
 * cnum 卡号 外键
 * bname 书名 默认值 BookName
 * beginTime 借书时间戳
 * endTime 还书时间戳
 */
public class Books {
    private String isbn;
    private Integer cnum;
    private String bname;
    private Integer beginTime;
    private Integer endTime;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}
