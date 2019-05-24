package com.service.impl.xlw;

import com.dao.xlw.UsersMapper;
import com.pojo.xlw.Users;
import com.service.xlw.LoginUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author level
 * @create 2019/5/15 - 15:47
 */
@Service
public class LoginUserServiceImpl implements LoginUserService {
    @Resource
    public UsersMapper usersMapperImpl;

    @Override
    public Users login(Users user) {

        return usersMapperImpl.selectByUsers(user);
    }
}
