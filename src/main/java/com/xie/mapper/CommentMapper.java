package com.xie.mapper;

import com.xie.bean.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByGoodsId(Integer gid);

    List<Comment> selectByGoodsIdAndType(@Param("gid") Integer gid, @Param("type") Integer type);

    int countByGoodsIdAndType(@Param("gid") Integer gid, @Param("type") Integer type);
}