package com.service.ymy;


import com.pojo.ymy.Exam;

import java.util.List;

public interface ExamService {
    //增加
    void addExam(Exam exam);
    //删
    void deleteExamById(Integer id);
    //改
    void updateExam(Exam exam);
    //根据id查
    Exam queryById(Integer id);
    //查所有
    List<Exam> queryAllExam();
    //根据学号查询
    List<Exam> examList(Integer code);
}
