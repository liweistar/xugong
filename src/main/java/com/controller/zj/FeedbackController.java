package com.controller.zj;


import com.pojo.xlw.Users;
import com.pojo.zj.Feedback;
import com.service.zj.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FeedbackController {
    @Resource
    private FeedbackService feedbackService;

    @RequestMapping("inscon")
    public String insfb(HttpServletRequest req, HttpSession session) {
        Users user = (Users) req.getSession().getAttribute("user");
        String content = req.getParameter("content");
        int index = feedbackService.ins(user.getUsername(), content);
        if (index > 0) {
            return "redirect:teachermain.jsp";
        } else {
            return "error";
        }

    }
    // @RequestMapping("selcontent")
//    @ResponseBody
//    public List<Feedback> show(HttpServletRequest req, HttpSession session){
//      //  User user=(User)req.getSession().getAttribute("user");
//       // return feedbackService.show(user.getName());
//    //}
//}
}
