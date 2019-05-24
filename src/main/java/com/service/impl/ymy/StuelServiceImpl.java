package com.service.impl.ymy;

import com.dao.ymy.StuelMapper;
import com.pojo.ymy.Stuel;
import com.pojo.ymy.StuelExample;
import com.service.ymy.StuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StuelServiceImpl implements StuelService {
    @Resource
    private StuelMapper stuelMapper;
    @Override
    public void addStuel(Stuel stuel) {
        stuelMapper.insert(stuel);
    }

    @Override
    public void deleteStuelById(Integer id) {
        stuelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateStuel(Stuel stuel) {
        stuelMapper.updateByPrimaryKey(stuel);
    }

    @Override
    public Stuel queryById(Integer id) {
        return stuelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Stuel> queryAllStuel() {
        return stuelMapper.queryAllStuel();
    }

    /**
     * 根据学号查询评价信息
     * @param code
     * @return
     */
    @Override
    public Stuel stuelList(Integer code) {
        StuelExample example = new StuelExample();
        StuelExample.Criteria criteria=example.createCriteria();
        criteria.andCodeEqualTo(code);
        List<Stuel> stuels = stuelMapper.selectByExample(example);
        return stuels.get(0);
    }

    /**
     * 学生填写评价
     * @param stuel
     */
    @Override
    public void addStuele(Stuel stuel) {
        StuelExample example=new StuelExample();
        StuelExample.Criteria c = example.createCriteria();
        c.andCodeEqualTo(stuel.getCode());
        stuelMapper.updateByExample(stuel,example);
    }
}
