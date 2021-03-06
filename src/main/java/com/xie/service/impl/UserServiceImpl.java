package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.User;
import com.xie.mapper.UserMapper;
import com.xie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by xie on 16/11/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User getByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }

    @Override
    public PageInfo<User> getAllUsers(int pageNum, int pageSize) {
        PageInfo<User> page = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> userMapper.selectAll());
        return page;
    }

    @Override
    public int insert(User user) {
        Assert.notNull(user);
        return userMapper.insert(user);
    }

    @Override
    public int insertAll(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updateAll(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int checkUsername(String username) {
        return 0;
    }

    @Override
    public int checkMobile(String mobile) {
        return 0;
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int delete(User user) {
        Assert.notNull(user);
        return userMapper.deleteByPrimaryKey(user.getId());
    }

    @Override
    public int delete(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int count() {
        return 0;
    }
}
