package com.xie.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Topic implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title;
    private String avatar;
    private String itemPicUrl;
    private String subtitle;
    private Integer topicCategoryId;
    private BigDecimal priceInfo;
    private String readCount;
    private String scenePicUrl;
    private Integer topicTemplateId;
    private Integer topicTagId;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getItemPicUrl() {
        return itemPicUrl;
    }

    public void setItemPicUrl(String itemPicUrl) {
        this.itemPicUrl = itemPicUrl;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getTopicCategoryId() {
        return topicCategoryId;
    }

    public void setTopicCategoryId(Integer topicCategoryId) {
        this.topicCategoryId = topicCategoryId;
    }

    public BigDecimal getPriceInfo() {
        return priceInfo;
    }

    public void setPriceInfo(BigDecimal priceInfo) {
        this.priceInfo = priceInfo;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public String getScenePicUrl() {
        return scenePicUrl;
    }

    public void setScenePicUrl(String scenePicUrl) {
        this.scenePicUrl = scenePicUrl;
    }

    public Integer getTopicTemplateId() {
        return topicTemplateId;
    }

    public void setTopicTemplateId(Integer topicTemplateId) {
        this.topicTemplateId = topicTemplateId;
    }

    public Integer getTopicTagId() {
        return topicTagId;
    }

    public void setTopicTagId(Integer topicTagId) {
        this.topicTagId = topicTagId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Topic other = (Topic) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                && (this.getAvatar() == null ? other.getAvatar() == null : this.getAvatar().equals(other.getAvatar()))
                && (this.getItemPicUrl() == null ? other.getItemPicUrl() == null : this.getItemPicUrl().equals(other.getItemPicUrl()))
                && (this.getSubtitle() == null ? other.getSubtitle() == null : this.getSubtitle().equals(other.getSubtitle()))
                && (this.getTopicCategoryId() == null ? other.getTopicCategoryId() == null : this.getTopicCategoryId().equals(other.getTopicCategoryId()))
                && (this.getPriceInfo() == null ? other.getPriceInfo() == null : this.getPriceInfo().equals(other.getPriceInfo()))
                && (this.getReadCount() == null ? other.getReadCount() == null : this.getReadCount().equals(other.getReadCount()))
                && (this.getScenePicUrl() == null ? other.getScenePicUrl() == null : this.getScenePicUrl().equals(other.getScenePicUrl()))
                && (this.getTopicTemplateId() == null ? other.getTopicTemplateId() == null : this.getTopicTemplateId().equals(other.getTopicTemplateId()))
                && (this.getTopicTagId() == null ? other.getTopicTagId() == null : this.getTopicTagId().equals(other.getTopicTagId()))
                && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getAvatar() == null) ? 0 : getAvatar().hashCode());
        result = prime * result + ((getItemPicUrl() == null) ? 0 : getItemPicUrl().hashCode());
        result = prime * result + ((getSubtitle() == null) ? 0 : getSubtitle().hashCode());
        result = prime * result + ((getTopicCategoryId() == null) ? 0 : getTopicCategoryId().hashCode());
        result = prime * result + ((getPriceInfo() == null) ? 0 : getPriceInfo().hashCode());
        result = prime * result + ((getReadCount() == null) ? 0 : getReadCount().hashCode());
        result = prime * result + ((getScenePicUrl() == null) ? 0 : getScenePicUrl().hashCode());
        result = prime * result + ((getTopicTemplateId() == null) ? 0 : getTopicTemplateId().hashCode());
        result = prime * result + ((getTopicTagId() == null) ? 0 : getTopicTagId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", avatar=").append(avatar);
        sb.append(", itemPicUrl=").append(itemPicUrl);
        sb.append(", subtitle=").append(subtitle);
        sb.append(", topicCategoryId=").append(topicCategoryId);
        sb.append(", priceInfo=").append(priceInfo);
        sb.append(", readCount=").append(readCount);
        sb.append(", scenePicUrl=").append(scenePicUrl);
        sb.append(", topicTemplateId=").append(topicTemplateId);
        sb.append(", topicTagId=").append(topicTagId);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}