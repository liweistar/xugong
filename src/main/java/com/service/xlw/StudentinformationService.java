package com.service.xlw;

import com.pojo.xlw.Card;
import com.pojo.xlw.Studentinformation;
import com.pojo.xlw.Users;

import java.util.List;

/**
 * @author level
 * @create 2019/5/6 - 22:10
 */
public interface StudentinformationService {
    void addStudentinformation(Studentinformation studentinformation);

    void deleteStudentinformationById(int id);

    void updateStudentinformation(Studentinformation studentinformation);

    Studentinformation queryById(int id);

    List<Studentinformation> queryAllStudentinformation();

    List<Studentinformation> queryByCodeid(int codeid);

    void addLoginUser(Users users);

    void addCard(Card card);

    void deleteUser(String username);

    Studentinformation queryByCodeidd(int codeid);
}
