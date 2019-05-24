package com.service.impl.ymy;


import com.dao.ymy.ExamMapper;
import com.pojo.ymy.Exam;
import com.pojo.ymy.ExamExample;
import com.service.ymy.ExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Resource
    private ExamMapper examMapper;

    /**
     * 增加
     * @param exam
     */
    @Override
    public void addExam(Exam exam) {
        examMapper.insert(exam);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteExamById(Integer id) {
        examMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param exam
     */
    @Override
    public void updateExam(Exam exam) {
        examMapper.updateByPrimaryKey(exam);
    }

    /**
     * 根据学号查询
     * @param id
     * @return
     */
    @Override
    public Exam queryById(Integer id) {
        return examMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Exam> queryAllExam() {
        return examMapper.queryAllExam();
    }

    /**
     * 根据学号查询
     * @param code
     * @return
     */
    @Override
    public List<Exam> examList(Integer code) {
        ExamExample example = new ExamExample();
        ExamExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(code);
        List<Exam> exams = examMapper.selectByExample(example);
        return exams;
    }
}
