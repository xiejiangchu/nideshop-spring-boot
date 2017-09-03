package com.xie.service;

import com.xie.bean.Comment;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
public interface CommentService {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByGoodsId(Integer gid);

    List<Comment> selectByGoodsIdAndType(Integer gid, Integer type);

    int countByGoodsIdAndType(Integer gid, Integer type);
}
