package com.xie.response;

import com.xie.bean.*;

import java.util.List;

/**
 * Created by xie on 17/8/22.
 */
public class GoodsDetailResponse {
    Goods goods;
    List<GoodsGallery> goodsGalleries;
    List<GoodsAttribute> attributes;
    List<GoodsIssue> goodsIssues;
    Brand brand;
    int commentCount;
    List<Comment> hotComment;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<GoodsGallery> getGoodsGalleries() {
        return goodsGalleries;
    }

    public void setGoodsGalleries(List<GoodsGallery> goodsGalleries) {
        this.goodsGalleries = goodsGalleries;
    }

    public List<GoodsAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<GoodsAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<GoodsIssue> getGoodsIssues() {
        return goodsIssues;
    }

    public void setGoodsIssues(List<GoodsIssue> goodsIssues) {
        this.goodsIssues = goodsIssues;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public List<Comment> getHotComment() {
        return hotComment;
    }

    public void setHotComment(List<Comment> hotComment) {
        this.hotComment = hotComment;
    }
}
