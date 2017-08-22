package com.xie.mapper;

import com.xie.bean.CommentPicture;

public interface CommentPictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentPicture record);

    int insertSelective(CommentPicture record);

    CommentPicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentPicture record);

    int updateByPrimaryKey(CommentPicture record);
}