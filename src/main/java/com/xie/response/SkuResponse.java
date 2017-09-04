package com.xie.response;

import com.xie.bean.GoodsSpecification;

import java.util.List;

/**
 * Created by xie on 17/9/4.
 */
public class SkuResponse {

    private Integer specificationId;

    private String name;

    List<GoodsSpecification> valueList;


    public Integer getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsSpecification> getValueList() {
        return valueList;
    }

    public void setValueList(List<GoodsSpecification> valueList) {
        this.valueList = valueList;
    }
}
