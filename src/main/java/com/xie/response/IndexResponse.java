package com.xie.response;

import com.xie.bean.*;

import java.util.List;

/**
 * Created by xie on 17/8/21.
 */
public class IndexResponse {

    private List<Ad> banner;
    private List<Channel> channel;
    private List<Goods> hotGoodsList;
    private List<Goods> newGoodsList;
    private List<Brand> brandList;
    private List<Topic> topicList;
    private List<CategoryShort> categoryList;


    public List<Ad> getBanner() {
        return banner;
    }

    public void setBanner(List<Ad> banner) {
        this.banner = banner;
    }

    public List<Channel> getChannel() {
        return channel;
    }

    public void setChannel(List<Channel> channel) {
        this.channel = channel;
    }

    public List<Goods> getHotGoodsList() {
        return hotGoodsList;
    }

    public void setHotGoodsList(List<Goods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<CategoryShort> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryShort> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Goods> getNewGoodsList() {
        return newGoodsList;
    }

    public void setNewGoodsList(List<Goods> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }
}
