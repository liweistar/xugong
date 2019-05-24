package com.service.impl.ymy;

import com.dao.ymy.RebuildMapper;
import com.pojo.ymy.Rebuild;
import com.pojo.ymy.RebuildExample;
import com.service.ymy.RebuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RebuildServiceImpl implements RebuildService {
    @Resource
    private RebuildMapper rebuildMapper;

    /**
     * 增加重修申请
     * @param rebuild
     */
    @Override
    public void addRebuild(Rebuild rebuild) {
        rebuildMapper.insert(rebuild);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void deleteRebuildById(Integer id) {
        rebuildMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改重修申请
     * @param rebuild
     */
    @Override
    public void updateRebuild(Rebuild rebuild) {
        rebuildMapper.updateByPrimaryKey(rebuild);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Rebuild queryById(Integer id) {
        return rebuildMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Rebuild> queryAllRebuild() {
        return rebuildMapper.queryAllRebuild();
    }

    /**
     * 根据学号查询
     * @param code
     * @return
     */
    @Override
    public List<Rebuild> rebuildList(Integer code) {
        RebuildExample example = new RebuildExample();
        RebuildExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(code);
        List<Rebuild> rebuilds = rebuildMapper.selectByExample(example);
        return rebuilds;
    }

    /**
     * 修改状态
     * @param rebuild
     */
    @Override
    public void updateStatus(Rebuild rebuild) {
        RebuildExample example=new RebuildExample();
        RebuildExample.Criteria c = example.createCriteria();
        c.andCodeEqualTo(rebuild.getCode());
        rebuildMapper.updateByExample(rebuild,example);
    }

    /**
     * 根据学号查询
     * @param code
     * @return
     */
    @Override
    public Rebuild quaryRebuild(Integer code) {
        RebuildExample example = new RebuildExample();
        RebuildExample.Criteria criteria = example.createCriteria();
        criteria.andCodeEqualTo(code);
        List<Rebuild> rebuilds = rebuildMapper.selectByExample(example);
        return rebuilds.get(0);
    }
}
