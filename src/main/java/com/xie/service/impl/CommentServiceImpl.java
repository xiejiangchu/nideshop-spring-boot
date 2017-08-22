package com.xie.service.impl;

import com.xie.bean.Comment;
import com.xie.mapper.CommentMapper;
import com.xie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Comment record) {
        return commentMapper.insert(record);
    }

    @Override
    public int insertSelective(Comment record) {
        return commentMapper.insertSelective(record);
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment record) {
        return commentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return commentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Comment> selectByGoodsId(Integer gid) {
        return commentMapper.selectByGoodsId(gid);
    }

    @Override
    public List<Comment> selectByGoodsIdAndType(Integer gid, Integer type) {
        return commentMapper.selectByGoodsIdAndType(gid, type);
    }

    @Override
    public int countByGoodsIdAndType(Integer gid, Integer type) {
        return commentMapper.countByGoodsIdAndType(gid, type);
    }
}
