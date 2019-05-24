package com.service.impl.xlw;

import com.dao.xlw.AdminMapper;
import com.pojo.xlw.Admin;
import com.service.xlw.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author level
 * @create 2019/5/6 - 21:48
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Override
    public Admin login(Admin admin) {
        return adminMapper.selectByAdmin(admin);
    }
}
