package com.controller.xlw;


import com.pojo.xlw.Course;
import com.pojo.xlw.Studentinformation;
import com.pojo.xlw.Users;
import com.service.xlw.CourseService;
import com.service.xlw.StudentinformationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Resource
    private CourseService courseServiceimpl;
    @Resource
    private StudentinformationService studentinformationServiceImpl;
    //跳转到查看所有课程网页
    @RequestMapping("/allCourse")
    public String list(Model model) {
        return "/course/allCourse";
    }
    @RequestMapping("toAddCourse")
    public String toAddCourse() {
        return "addCourse";
    }
    @RequestMapping("/addCourse")
    public String addCourse(Course course) {
        courseServiceimpl.addCourse(course);
        return "redirect:/course/allCourse";
    }
    @RequestMapping("/delete")
    public String deleteCourse( Integer id) {
        courseServiceimpl.deleteCourseById(id);
        return "redirect:/course/allCourse";
    }
    @RequestMapping("toUpdateCourse")
    public String toUpdateCourse(Model model, Integer id) {
        model.addAttribute("course", courseServiceimpl.queryById(id));
        return "/course/updateCourse";
    }

    @RequestMapping("/updateCourse")
    public String updatePaper(Model model, Course course) {
        courseServiceimpl.updateCourse(course);
        return "redirect:/course/allCourse";
    }
    //查看所有课程json
    @RequestMapping("/json.action")
     @ResponseBody
    public List json(){
        List<Course> list = courseServiceimpl.queryAllCourse();

        return list;
    }
    //条件查询
    @RequestMapping("/select.action")
    @ResponseBody
    public List<Course> select(Course course){
        List<Course> list=courseServiceimpl.queryByType(course);
        return list;
    }
    @RequestMapping("/updatapower")
    public String updata(int id){
        Course course = courseServiceimpl.queryById(id);
        if("可选".equals(course.getCoursepower())){
            course.setCoursepower("不可选");
            courseServiceimpl.updateCourse(course);
        }else {
            course.setCoursepower("可选");
            courseServiceimpl.updateCourse(course);
        }
        return "redirect:/course/allCourse";
    }
     //zj
    @RequestMapping("allow")
    @ResponseBody
    public List<Course> allow() {
        return courseServiceimpl.show();
    }

    @RequestMapping("recommend")
    @ResponseBody
    public List<Course> recommend() {
        return courseServiceimpl.recommend();
    }
    @RequestMapping("again")
    @ResponseBody
    public List<Course> again() {
        return courseServiceimpl.showch();
    }
    @RequestMapping("ctable")
    @ResponseBody
    public List<Course> show(){
        return courseServiceimpl.showb();
    }
    @RequestMapping("tcourse")
    @ResponseBody
    public List<Course> showtc(HttpServletRequest req, HttpSession session){
        Users user=(Users) req.getSession().getAttribute("users1");
        List<Studentinformation> s = studentinformationServiceImpl.queryByCodeid(Integer.parseInt(user.getUsername()));
        return courseServiceimpl.showtc(s.get(0).getName());
    }
}


