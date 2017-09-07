package com.xie.service.impl;

import com.xie.bean.Product;
import com.xie.bean.ProductWithGoodsSpecification;
import com.xie.mapper.ProductMapper;
import com.xie.service.GoodsSpecificationService;
import com.xie.service.ProductService;
import com.xie.utils.MallConstants;
import org.apache.http.util.TextUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xie on 17/8/24.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private GoodsSpecificationService goodsSpecificationService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public Product selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyAndGid(Product record) {
        return productMapper.updateByPrimaryKeyAndGid(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Product> selectByGoodsId(Integer goodsId) {
        return productMapper.selectByGoodsId(goodsId);
    }

    @Override
    public List<ProductWithGoodsSpecification> selectFullByGoodsId(Integer goodsId) {
        List<Product> productList = productMapper.selectByGoodsId(goodsId);
        List<ProductWithGoodsSpecification> productWithGoodsSpecificationList = productList.stream().map(item -> {
            ProductWithGoodsSpecification productWithGoodsSpecification = new ProductWithGoodsSpecification();
            BeanUtils.copyProperties(item, productWithGoodsSpecification);
            if(!TextUtils.isEmpty(item.getGoodsSpecificationIds())){
                List<Integer> ids = Arrays.stream(item.getGoodsSpecificationIds().split(MallConstants.SPECIFICATION_SPLIT)).map(i -> Integer.parseInt(i)).collect(Collectors.toList());
                if (ids != null && ids.size() > 0) {
                    productWithGoodsSpecification.setGoodsSpecificationList(goodsSpecificationService.selectByPrimaryKeyAndGoodsId(ids, goodsId));
                }
            }

            return productWithGoodsSpecification;
        }).collect(Collectors.toList());
        return productWithGoodsSpecificationList;
    }

    @Override
    public Product selectByPrimaryKeyAndGid(Integer id, Integer goodsId) {
        return productMapper.selectByPrimaryKeyAndGid(id, goodsId);
    }

    @Override
    public Product selectByGoodsSn(String goodsSn) {
        return productMapper.selectByGoodsSn(goodsSn);
    }
}
