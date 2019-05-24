package com.service.impl.ymy;


import com.dao.ymy.MianMapper;
import com.pojo.ymy.Mian;
import com.pojo.ymy.MianExample;
import com.service.ymy.MianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MianServiceImpl implements MianService {
    @Resource
    private MianMapper mianMapper;

    /**
     * 增加
     * @param mian
     */
    @Override
    public void addMian(Mian mian) {
        mianMapper.insert(mian);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteMianById(Integer id) {
        mianMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param mian
     */
    @Override
    public void updateMian(Mian mian) {
        mianMapper.updateByPrimaryKey(mian);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Mian queryById(Integer id) {
        return mianMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Mian> queryAllMian() {
        return mianMapper.queryAllMian();
    }

    /**
     * 根据学号查询
     * @param code
     * @return
     */
    @Override
    public List<Mian> mianList(Integer code) {
        MianExample example = new MianExample();
        MianExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(code);
        List<Mian> mians = mianMapper.selectByExample(example);
        return mians;
    }

    /**
     * 修改状态
     * @param mian
     */
    @Override
    public void updateStatus(Mian mian) {
        MianExample example=new MianExample();
        MianExample.Criteria c = example.createCriteria();
        c.andCodeEqualTo(mian.getCode());
        mianMapper.updateByExample(mian,example);
    }

    /**
     * 根据学号查询
     * @param code
     * @return
     */
    @Override
    public Mian quaryMian(Integer code) {
        MianExample example = new MianExample();
        MianExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(code);
        List<Mian> mians = mianMapper.selectByExample(example);
        return mians.get(0);
    }
}
