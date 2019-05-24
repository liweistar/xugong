package com.service.impl.ymy;


import com.dao.ymy.RexamMapper;
import com.pojo.ymy.Rexam;
import com.pojo.ymy.RexamExample;
import com.service.ymy.RexamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RexamServiceImpl implements RexamService {
    @Resource
    private RexamMapper rexamMapper;

    /**
     * 增加重考申请
     * @param rexam
     */
    @Override
    public void addRexam(Rexam rexam) {
        rexamMapper.insert(rexam);
    }

    /**
     * 删除重考申请
     * @param id
     */
    @Override
    public void deleteRexamById(Integer id) {
        rexamMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改重考申请
     * @param rexam
     */
    @Override
    public void updateRexam(Rexam rexam) {
        rexamMapper.updateByPrimaryKey(rexam);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Rexam queryById(Integer id) {
        return rexamMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Rexam> queryAllRexam() {
        return rexamMapper.queryAllRexam();
    }

    /**
     * 根据学号查询
     * @param code
     * @return
     */
    @Override
    public List<Rexam> rexamList(Integer code) {
        RexamExample example = new RexamExample();
        RexamExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(code);
        List<Rexam> rexams = rexamMapper.selectByExample(example);
        return rexams;
    }

    /**
     * 更新审核状态
     * @param rexam
     */
    @Override
    public void updateStatus(Rexam rexam) {
        RexamExample example=new RexamExample();
        RexamExample.Criteria c = example.createCriteria();
        c.andCodeEqualTo(rexam.getCode());
        rexamMapper.updateByExample(rexam,example);
    }

    @Override
    public Rexam quaryRexam(Integer code) {
        RexamExample example = new RexamExample();
        RexamExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(code);
        List<Rexam> rexams = rexamMapper.selectByExample(example);
        return rexams.get(0);
    }
}
