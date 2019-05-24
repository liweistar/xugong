package com.service.impl.xlw;


import com.dao.xlw.StudentMapper;
import com.pojo.xlw.Student;
import com.service.xlw.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author level
 * @create 2019/5/7 - 11:33
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public Student login(Student student) {
        return studentMapper.selectByAdmin(student);
    }
}
