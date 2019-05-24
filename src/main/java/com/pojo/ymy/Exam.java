package com.pojo.ymy;

import com.annotation.ExportConfig;

public class Exam {
    private Integer id;
    @ExportConfig("学号")
    private Integer code;
    @ExportConfig("姓名")
    private String name;
    @ExportConfig("考试科目")
    private String kemu;
    @ExportConfig("考试时间")
    private String time;
    @ExportConfig("考试状态")
    private String status;

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

    public String getKemu() {
        return kemu;
    }

    public void setKemu(String kemu) {
        this.kemu = kemu == null ? null : kemu.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}