package com.pojo.xlw;

import com.pojo.zj.Teacher;

public class Course {
    private Integer courseid;

    private Integer coursecode;

    private String coursename;

    private String courseteacher;

    private String courselocaltion;

    private String coursetime;

    private String coursepower;

    private String coursetype;

    private Integer selcount;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getCoursecode() {
        return coursecode;
    }

    public void setCoursecode(Integer coursecode) {
        this.coursecode = coursecode;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getCourseteacher() {
        return courseteacher;
    }

    public void setCourseteacher(String courseteacher) {
        this.courseteacher = courseteacher == null ? null : courseteacher.trim();
    }

    public String getCourselocaltion() {
        return courselocaltion;
    }

    public void setCourselocaltion(String courselocaltion) {
        this.courselocaltion = courselocaltion == null ? null : courselocaltion.trim();
    }

    public String getCoursetime() {
        return coursetime;
    }

    public void setCoursetime(String coursetime) {
        this.coursetime = coursetime == null ? null : coursetime.trim();
    }

    public String getCoursepower() {
        return coursepower;
    }

    public void setCoursepower(String coursepower) {
        this.coursepower = coursepower == null ? null : coursepower.trim();
    }

    public String getCoursetype() {
        return coursetype;
    }

    public void setCoursetype(String coursetype) {
        this.coursetype = coursetype == null ? null : coursetype.trim();
    }

    public Integer getSelcount() {
        return selcount;
    }

    public void setSelcount(Integer selcount) {
        this.selcount = selcount;
    }
}