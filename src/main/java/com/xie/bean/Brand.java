package com.xie.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Brand implements Serializable {
    private Integer id;

    private String name;

    private String listPicUrl;

    private String simpleDesc;

    private String picUrl;

    private Byte sortOrder;

    private Boolean isShow;

    private BigDecimal floorPrice;

    private String appListPicUrl;

    private Boolean isNew;

    private String newPicUrl;

    private Byte newSortOrder;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }

    public String getSimpleDesc() {
        return simpleDesc;
    }

    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    public String getAppListPicUrl() {
        return appListPicUrl;
    }

    public void setAppListPicUrl(String appListPicUrl) {
        this.appListPicUrl = appListPicUrl;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getNewPicUrl() {
        return newPicUrl;
    }

    public void setNewPicUrl(String newPicUrl) {
        this.newPicUrl = newPicUrl;
    }

    public Byte getNewSortOrder() {
        return newSortOrder;
    }

    public void setNewSortOrder(Byte newSortOrder) {
        this.newSortOrder = newSortOrder;
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
        Brand other = (Brand) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getListPicUrl() == null ? other.getListPicUrl() == null : this.getListPicUrl().equals(other.getListPicUrl()))
            && (this.getSimpleDesc() == null ? other.getSimpleDesc() == null : this.getSimpleDesc().equals(other.getSimpleDesc()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getSortOrder() == null ? other.getSortOrder() == null : this.getSortOrder().equals(other.getSortOrder()))
            && (this.getIsShow() == null ? other.getIsShow() == null : this.getIsShow().equals(other.getIsShow()))
            && (this.getFloorPrice() == null ? other.getFloorPrice() == null : this.getFloorPrice().equals(other.getFloorPrice()))
            && (this.getAppListPicUrl() == null ? other.getAppListPicUrl() == null : this.getAppListPicUrl().equals(other.getAppListPicUrl()))
            && (this.getIsNew() == null ? other.getIsNew() == null : this.getIsNew().equals(other.getIsNew()))
            && (this.getNewPicUrl() == null ? other.getNewPicUrl() == null : this.getNewPicUrl().equals(other.getNewPicUrl()))
            && (this.getNewSortOrder() == null ? other.getNewSortOrder() == null : this.getNewSortOrder().equals(other.getNewSortOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getListPicUrl() == null) ? 0 : getListPicUrl().hashCode());
        result = prime * result + ((getSimpleDesc() == null) ? 0 : getSimpleDesc().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getSortOrder() == null) ? 0 : getSortOrder().hashCode());
        result = prime * result + ((getIsShow() == null) ? 0 : getIsShow().hashCode());
        result = prime * result + ((getFloorPrice() == null) ? 0 : getFloorPrice().hashCode());
        result = prime * result + ((getAppListPicUrl() == null) ? 0 : getAppListPicUrl().hashCode());
        result = prime * result + ((getIsNew() == null) ? 0 : getIsNew().hashCode());
        result = prime * result + ((getNewPicUrl() == null) ? 0 : getNewPicUrl().hashCode());
        result = prime * result + ((getNewSortOrder() == null) ? 0 : getNewSortOrder().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", listPicUrl=").append(listPicUrl);
        sb.append(", simpleDesc=").append(simpleDesc);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", isShow=").append(isShow);
        sb.append(", floorPrice=").append(floorPrice);
        sb.append(", appListPicUrl=").append(appListPicUrl);
        sb.append(", isNew=").append(isNew);
        sb.append(", newPicUrl=").append(newPicUrl);
        sb.append(", newSortOrder=").append(newSortOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}