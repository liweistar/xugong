package com.controller.xlw;

import com.pojo.xlw.Lost;
import com.service.xlw.LostCardService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author level
 * @create 2019/5/7 - 12:17
 */
@Controller
@RequestMapping("/lostcard")
public class LostController {
    @Resource
    public LostCardService lostCardServiceImpl;

    @RequestMapping("/lostcard")
    public String lost(MultipartFile filename, Lost lost, Model model) throws IOException {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        String e = FilenameUtils.getExtension(filename.getOriginalFilename());
        if (e == "") {
            model.addAttribute("fall2", "请上传图片");
            return "lostcard/lostcard";
        } else {
            filename.transferTo(new File("D:/file/" + s + "." + e));
            lost.setImg(s + "." + e);
            lost.setHandle("待处理");
            lost.setReviewe("待审核");
            lost.setRecive("无");
            List<Lost> losts = lostCardServiceImpl.queryByCode(lost.getCode());

            if (losts.size() == 0) {
                lostCardServiceImpl.addLostCard(lost);
                model.addAttribute("success", "请等待管理员审核");
            } else {
                model.addAttribute("exist", "已存在");

            }


        }


        return "lostcard/lostcard";
    }

    @RequestMapping("/back")
    public String back() {
        return "student1";
    }

    //查询学生挂失状态
    @RequestMapping("status")
    @ResponseBody
    public List a(Lost lost) {
        List<Lost> losts = lostCardServiceImpl.queryByCode(lost.getCode());
        return losts;
    }

    //挂失流程完成删除数据
    @RequestMapping("delete")
    public String s(int code) {
        lostCardServiceImpl.delete(code);
        return "lostcard/lostcard";
    }
}
