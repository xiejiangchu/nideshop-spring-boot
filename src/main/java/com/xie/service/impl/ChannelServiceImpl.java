package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.Channel;
import com.xie.mapper.ChannelMapper;
import com.xie.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/21.
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return channelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Channel record) {
        return channelMapper.insert(record);
    }

    @Override
    public int insertSelective(Channel record) {
        return channelMapper.insertSelective(record);
    }

    @Override
    public Channel selectByPrimaryKey(Integer id) {
        return channelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Channel record) {
        return channelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Channel record) {
        return channelMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<Channel> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Channel> page = new PageInfo<Channel>(channelMapper.selectAll());
        return page;
    }
}
