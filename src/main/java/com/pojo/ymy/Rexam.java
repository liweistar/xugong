package com.pojo.ymy;

import java.util.Date;

public class Rexam {
    private Integer id;

    private Integer code;

    private String name;

    private String rkemu;

    private String status;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRkemu() {
        return rkemu;
    }

    public void setRkemu(String rkemu) {
        this.rkemu = rkemu == null ? null : rkemu.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}