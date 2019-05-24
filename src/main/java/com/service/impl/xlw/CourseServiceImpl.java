package com.service.impl.xlw;


import com.dao.xlw.CourseMapper;
import com.pojo.xlw.Course;
import com.pojo.xlw.CourseExample;
import com.service.xlw.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author level
 * @create 2019/4/25 - 21:18
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Override
    public void addCourse(Course course) {
        courseMapper.insert(course);
    }

    @Override
    public void deleteCourseById(Integer id) {
        courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseMapper.updateByPrimaryKey(course);
    }

    @Override
    public Course queryById(Integer id) {

        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Course> queryAllCourse() {
        CourseExample example = new CourseExample();
        return courseMapper.selectByExample(example);
    }

    @Override
    public List<Course> queryByType(Course course) {
        CourseExample example = new CourseExample();
        CourseExample.Criteria c = example.createCriteria();
        c.andCoursetypeEqualTo(course.getCoursetype());
        List<Course> a = courseMapper.selectByExample(example);
        return a;
    }

    /**
     * 根据课程名称查询
     *
     * @param coursename
     * @return
     */
    @Override
    public Course quaryReByName(String coursename) {
        CourseExample example = new CourseExample();
        CourseExample.Criteria criteria = example.createCriteria();
        criteria.andCoursenameEqualTo(coursename);
        List<Course> courses = courseMapper.selectByExample(example);
        return courses.get(0);
    }


    /**
     * 修改课程选课是否可选
     *
     * @param course
     */
    @Override
    public void updateCourseStatus(Course course) {
        CourseExample example = new CourseExample();
        CourseExample.Criteria c = example.createCriteria();
        c.andCoursenameEqualTo(course.getCoursename());
        courseMapper.updateByExample(course, example);
    }
    //zj
    @Override
    public List<Course> show() {
        return courseMapper.selBycourse("可选");
    }

    @Override
    public List<Course> recommend() {
        return courseMapper.selAll("可选", 50);
    }


    @Override
    public List<Course> showb() {
        return courseMapper.selBybi("必修");
    }

    @Override
    public List<Course> showtc(String courseteacher) {
        return courseMapper.selBytc(courseteacher);
    }

    @Override
    public List<Course> showch() {
        return courseMapper.selBych("重修","可选");
    }

}
