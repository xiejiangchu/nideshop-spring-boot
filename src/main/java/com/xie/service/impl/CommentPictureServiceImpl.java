package com.xie.service.impl;

import com.xie.bean.CommentPicture;
import com.xie.mapper.CommentPictureMapper;
import com.xie.service.CommentPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xie on 17/8/23.
 */
@Service
public class CommentPictureServiceImpl implements CommentPictureService {

    @Autowired
    private CommentPictureMapper commentPictureMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return commentPictureMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CommentPicture record) {
        return commentPictureMapper.insert(record);
    }

    @Override
    public int insertSelective(CommentPicture record) {
        return commentPictureMapper.insertSelective(record);
    }

    @Override
    public CommentPicture selectByPrimaryKey(Integer id) {
        return commentPictureMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CommentPicture record) {
        return commentPictureMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CommentPicture record) {
        return commentPictureMapper.updateByPrimaryKey(record);
    }
}
