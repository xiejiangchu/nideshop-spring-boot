package com.xie.response;

import com.xie.bean.ProductWithGoodsSpecification;
import com.xie.bean.Specification;

import java.util.List;

/**
 * Created by xie on 17/9/5.
 */
public class GoodDetail extends GoodsDetailResponse{

    private List<Specification> specifications;

    private List<ProductWithGoodsSpecification> productWithGoodsSpecificationList;

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }

    public List<ProductWithGoodsSpecification> getProductWithGoodsSpecificationList() {
        return productWithGoodsSpecificationList;
    }

    public void setProductWithGoodsSpecificationList(List<ProductWithGoodsSpecification> productWithGoodsSpecificationList) {
        this.productWithGoodsSpecificationList = productWithGoodsSpecificationList;
    }
}
