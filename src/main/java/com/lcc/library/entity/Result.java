package com.lcc.library.entity;


import java.util.List;

// 返回前端的数据，带返回信息的JSON
public class Result {
    // 返回状态码，layui状态码为0表示返回成功
    private Integer code;
    private String msg;
    // 返回的记录数
    private Integer count;
    private List data;

    public static Result success() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("操作成功");
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.setCode(100);
        result.setMsg("服务器错误");
        return result;
    }

    public Result addData(List listSrc) {
        this.setData(listSrc);
        return this;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
