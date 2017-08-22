package com.xie.mapper;

import com.xie.bean.GoodsIssue;

import java.util.List;

public interface GoodsIssueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsIssue record);

    int insertSelective(GoodsIssue record);

    GoodsIssue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsIssue record);

    int updateByPrimaryKeyWithBLOBs(GoodsIssue record);

    int updateByPrimaryKey(GoodsIssue record);

    List<GoodsIssue> selectAll();

    List<GoodsIssue> selectByGoodsId(Integer gid);
}