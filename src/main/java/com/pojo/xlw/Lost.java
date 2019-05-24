package com.pojo.xlw;

import com.annotation.ExportConfig;

public class Lost {
    private Integer id;
    @ExportConfig("学号")
    private Integer code;
    @ExportConfig("姓名")
    private String name;
    @ExportConfig("手机号")
    private Integer number;

    private String img;

    private String handle;

    private String reviewe;

    private String recive;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle == null ? null : handle.trim();
    }

    public String getReviewe() {
        return reviewe;
    }

    public void setReviewe(String reviewe) {
        this.reviewe = reviewe == null ? null : reviewe.trim();
    }

    public String getRecive() {
        return recive;
    }

    public void setRecive(String recive) {
        this.recive = recive == null ? null : recive.trim();
    }
}