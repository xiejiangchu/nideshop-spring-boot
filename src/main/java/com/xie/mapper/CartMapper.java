package com.xie.mapper;

import com.xie.bean.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    Cart selectByGidAndPid(@Param("goodsId") Integer goodsId, @Param("productId") Integer productId);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKeyWithBLOBs(Cart record);

    int updateByPrimaryKey(Cart record);

    List<Cart> selectByUid(Integer uid);

    int updateCheckedByProductId(@Param("uid") Integer uid, @Param("productIds") List<Integer> productIds, @Param("checked") int checked);

    int updateNumberByProductId(@Param("uid") Integer uid, @Param("productId") Integer productId, @Param("number") int number);

    int deleteByUid(Integer uid);

    int count(Integer uid);

    int deleteByProductId(@Param("uid") Integer uid,@Param("productIds") List<Integer> productIds);
}