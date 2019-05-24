package com.pojo.ymy;

import com.annotation.ExportConfig;

public class Achievement {
    private Integer id;

    @ExportConfig(value = "学号")
    private Integer code;
    @ExportConfig(value = "姓名")
    private String name;
    @ExportConfig(value = "计算机导论")
    private Double keone;
    @ExportConfig(value = "c++")
    private Double ketwo;
    @ExportConfig(value = "java框架")
    private Double kethree;
    @ExportConfig(value = "英语")
    private Double kefour;
    @ExportConfig(value = "高数")
    private Double kefive;
    @ExportConfig(value = "绩点")
    private Double point;

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

    public Double getKeone() {
        return keone;
    }

    public void setKeone(Double keone) {
        this.keone = keone;
    }

    public Double getKetwo() {
        return ketwo;
    }

    public void setKetwo(Double ketwo) {
        this.ketwo = ketwo;
    }

    public Double getKethree() {
        return kethree;
    }

    public void setKethree(Double kethree) {
        this.kethree = kethree;
    }

    public Double getKefour() {
        return kefour;
    }

    public void setKefour(Double kefour) {
        this.kefour = kefour;
    }

    public Double getKefive() {
        return kefive;
    }

    public void setKefive(Double kefive) {
        this.kefive = kefive;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }
}