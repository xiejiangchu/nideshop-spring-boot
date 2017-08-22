package com.xie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.bean.GoodsIssue;
import com.xie.mapper.GoodsIssueMapper;
import com.xie.service.GoodsIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
@Service
public class GoodsIssueServiceImpl implements GoodsIssueService {

    @Autowired
    private GoodsIssueMapper goodsIssueMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return goodsIssueMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GoodsIssue record) {
        return goodsIssueMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsIssue record) {
        return goodsIssueMapper.insertSelective(record);
    }

    @Override
    public GoodsIssue selectByPrimaryKey(Integer id) {
        return goodsIssueMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsIssue record) {
        return goodsIssueMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(GoodsIssue record) {
        return goodsIssueMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsIssue record) {
        return goodsIssueMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo<GoodsIssue> selectAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<GoodsIssue> page = new PageInfo<GoodsIssue>(goodsIssueMapper.selectAll());
        return page;
    }

    @Override
    public List<GoodsIssue> selectByGoodsId(Integer gid) {
        return goodsIssueMapper.selectByGoodsId(gid);
    }
}
