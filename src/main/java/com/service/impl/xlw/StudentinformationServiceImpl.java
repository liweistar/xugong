package com.service.impl.xlw;


import com.dao.xlw.CardMapper;
import com.dao.xlw.StudentinformationMapper;
import com.dao.xlw.UsersMapper;
import com.pojo.xlw.*;
import com.service.xlw.StudentinformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author level
 * @create 2019/5/6 - 22:14
 */
@Service
public class StudentinformationServiceImpl implements StudentinformationService {
    @Resource
    public StudentinformationMapper studentinformationMapper;
    @Resource
    public UsersMapper usersMapper;
    @Resource
    public CardMapper cardMapper;
    @Override
    public void addStudentinformation(Studentinformation studentinformation) {
        studentinformationMapper.insert(studentinformation);
    }

    @Override
    public void deleteStudentinformationById(int id) {
        StudentinformationExample example=new StudentinformationExample();
        StudentinformationExample.Criteria criteria = example.createCriteria();
        criteria.andCodeidEqualTo(id);
        studentinformationMapper.deleteByExample(example);
    }

    @Override
    public void updateStudentinformation(Studentinformation studentinformation) {
          studentinformationMapper.updateByPrimaryKey(studentinformation);
    }

    @Override
    public Studentinformation queryById(int id) {
        Studentinformation s = studentinformationMapper.selectByPrimaryKey(id);
        return s;
    }

    @Override
    public List<Studentinformation> queryAllStudentinformation() {
        return studentinformationMapper.selectAll();
    }

    @Override
    public List<Studentinformation> queryByCodeid(int codeid) {
        StudentinformationExample example=new StudentinformationExample();
        StudentinformationExample.Criteria c = example.createCriteria();
        c.andCodeidEqualTo(codeid);
        List<Studentinformation> l = studentinformationMapper.selectByExample(example);

        return l;
    }

    @Override
    public void addLoginUser(Users users) {
        usersMapper.insert(users);
    }

    @Override
    public void addCard(Card card) {
        cardMapper.insert(card);
    }

    @Override
    public void deleteUser(String username) {
        UsersExample example=new UsersExample();
        UsersExample.Criteria c = example.createCriteria();
        c.andUsernameEqualTo(username);
        usersMapper.deleteByExample(example);
    }

    @Override
    public Studentinformation queryByCodeidd(int codeid) {
        StudentinformationExample example=new StudentinformationExample();
        StudentinformationExample.Criteria c = example.createCriteria();
        c.andCodeidEqualTo(codeid);
        List<Studentinformation> l = studentinformationMapper.selectByExample(example);
        Studentinformation a = l.get(0);
        return a;
    }
}
