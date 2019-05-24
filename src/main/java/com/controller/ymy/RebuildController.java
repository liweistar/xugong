package com.controller.ymy;


import com.pojo.xlw.Course;
import com.pojo.ymy.Rebuild;
import com.service.xlw.CourseService;
import com.service.ymy.RebuildService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("rebuild")
public class RebuildController {
    @Resource
    private RebuildService rebuildService;
    @Resource
    private CourseService courseService;

    /**
     * 按照学号查询
     */
    @RequestMapping("/rebuild")
    public String Rebuild(Model model, Integer code) {
        List<Rebuild> rebuilds = rebuildService.rebuildList(code);
        if (rebuilds.size() == 0) {
            model.addAttribute("wu", "无");
        } else {
            model.addAttribute("rebuild", rebuilds.get(0));
        }

        return "rebuild/studentRebuild";
    }

    //查找所有json
    @RequestMapping("/json")
    @ResponseBody
    public List<Rebuild> rebuilds(Integer code) {
        List<Rebuild> list = rebuildService.rebuildList(code);
        return list;
    }

    /**
     * 增加重修申请
     *
     * @return
     */
    @RequestMapping("toAddRebuild")
    public String toAddRebuild(Model model, Integer code) {
        model.addAttribute("code", code);
        return "rebuild/addRebuild";
    }

    /**
     * 增加重考
     * @param rebuild
     * @return
     */
    @RequestMapping("/addRebuild")
    public String addRebuild(Model model, Rebuild rebuild) {
        rebuild.setStatus("审核中");
        rebuild.setTime(new Date());
        rebuildService.addRebuild(rebuild);
        model.addAttribute("code", rebuild.getCode());
        return "redirect:/rebuild/rebuild?code=" + rebuild.getCode();
    }

    /**
     * 查询重修申请
     *
     * @param model
     * @return
     */
    @RequestMapping("/allRebuild")
    public String list(Model model, HttpSession session) {
        List<Rebuild> list = rebuildService.queryAllRebuild();
        model.addAttribute("list", list);
        return "rebuild/allRebuild";
    }

    /**
     * json数据交互
     *
     * @return
     */
    @RequestMapping("/rebuildjson")
    public @ResponseBody
    List<Rebuild> json() {
        List<Rebuild> rebuilds = rebuildService.queryAllRebuild();
        return rebuilds;
    }

    /**
     * 修改审核状态
     * 同时将选择重修的课程的选课状态变为0
     * 改为可选
     * @param model
     * @param rebuild
     * @param course
     * @return
     */
    @RequestMapping("/updateStatus")
    @ResponseBody
    public List<Rebuild> updateStatus(Model model, Rebuild rebuild, Course course) {
        Rebuild rebuild1 = rebuildService.quaryRebuild(rebuild.getCode());
        rebuild1.setStatus("通过");
        rebuild1.setTime(new Date());
        rebuildService.updateStatus(rebuild1);
        if (rebuild1!=null) {
            Course course1 = courseService.quaryReByName(rebuild1.getRekemu());
            course1.setCoursepower("1");
            courseService.updateCourseStatus(course1);
        }
        List<Rebuild> rebuilds = rebuildService.queryAllRebuild();
        return rebuilds;
    }
}
