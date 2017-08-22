package com.xie.service;

import com.github.pagehelper.PageInfo;
import com.xie.bean.GoodsIssue;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
public interface GoodsIssueService {

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsIssue record);

    int insertSelective(GoodsIssue record);

    GoodsIssue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsIssue record);

    int updateByPrimaryKeyWithBLOBs(GoodsIssue record);

    int updateByPrimaryKey(GoodsIssue record);

    PageInfo<GoodsIssue> selectAll(int pageNum, int pageSize);

    List<GoodsIssue> selectByGoodsId(Integer gid);
}
