package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.Channel;

/**
 * Created by xie on 17/8/21.
 */
public interface ChannelService {

    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

    PageInfo<Channel> selectAll(int pageNum, int pageSize);
}
