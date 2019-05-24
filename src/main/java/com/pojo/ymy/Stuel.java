package com.pojo.ymy;

import java.util.Date;

public class Stuel {
    private Integer id;

    private Integer code;

    private String stuname;

    private String elname;

    private String elnr;

    private String publisher;

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

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getElname() {
        return elname;
    }

    public void setElname(String elname) {
        this.elname = elname == null ? null : elname.trim();
    }

    public String getElnr() {
        return elnr;
    }

    public void setElnr(String elnr) {
        this.elnr = elnr == null ? null : elnr.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}