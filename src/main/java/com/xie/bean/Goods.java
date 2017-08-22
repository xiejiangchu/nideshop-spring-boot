package com.xie.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable {
    private Integer id;

    private Integer categoryId;

    private String goodsSn;

    private String name;

    private Integer brandId;

    private Integer goodsNumber;

    private String keywords;

    private String goodsBrief;

    private Boolean isOnSale;

    private Integer addTime;

    private Short sortOrder;

    private Boolean isDelete;

    private Integer attributeCategory;

    /**
     * 专柜价格
     */
    private BigDecimal counterPrice;

    /**
     * 附加价格
     */
    private BigDecimal extraPrice;

    private Boolean isNew;

    /**
     * 商品单位
     */
    private String goodsUnit;

    /**
     * 商品主图
     */
    private String primaryPicUrl;

    /**
     * 商品列表图
     */
    private String listPicUrl;

    /**
     * 零售价格
     */
    private BigDecimal retailPrice;

    /**
     * 销售量
     */
    private Integer sellVolume;

    /**
     * 主sku　product_id
     */
    private Integer primaryProductId;

    /**
     * 单位价格，单价
     */
    private BigDecimal unitPrice;

    private String promotionDesc;

    private String promotionTag;

    /**
     * APP专享价
     */
    private BigDecimal appExclusivePrice;

    /**
     * 是否是APP专属
     */
    private Boolean isAppExclusive;

    private Boolean isLimited;

    private Boolean isHot;

    private String goodsDesc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getGoodsBrief() {
        return goodsBrief;
    }

    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
    }

    public Boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Short getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Short sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getAttributeCategory() {
        return attributeCategory;
    }

    public void setAttributeCategory(Integer attributeCategory) {
        this.attributeCategory = attributeCategory;
    }

    public BigDecimal getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
    }

    public BigDecimal getExtraPrice() {
        return extraPrice;
    }

    public void setExtraPrice(BigDecimal extraPrice) {
        this.extraPrice = extraPrice;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getPrimaryPicUrl() {
        return primaryPicUrl;
    }

    public void setPrimaryPicUrl(String primaryPicUrl) {
        this.primaryPicUrl = primaryPicUrl;
    }

    public String getListPicUrl() {
        return listPicUrl;
    }

    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Integer getSellVolume() {
        return sellVolume;
    }

    public void setSellVolume(Integer sellVolume) {
        this.sellVolume = sellVolume;
    }

    public Integer getPrimaryProductId() {
        return primaryProductId;
    }

    public void setPrimaryProductId(Integer primaryProductId) {
        this.primaryProductId = primaryProductId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPromotionDesc() {
        return promotionDesc;
    }

    public void setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc;
    }

    public String getPromotionTag() {
        return promotionTag;
    }

    public void setPromotionTag(String promotionTag) {
        this.promotionTag = promotionTag;
    }

    public BigDecimal getAppExclusivePrice() {
        return appExclusivePrice;
    }

    public void setAppExclusivePrice(BigDecimal appExclusivePrice) {
        this.appExclusivePrice = appExclusivePrice;
    }

    public Boolean getIsAppExclusive() {
        return isAppExclusive;
    }

    public void setIsAppExclusive(Boolean isAppExclusive) {
        this.isAppExclusive = isAppExclusive;
    }

    public Boolean getIsLimited() {
        return isLimited;
    }

    public void setIsLimited(Boolean isLimited) {
        this.isLimited = isLimited;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
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
        Goods other = (Goods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getGoodsSn() == null ? other.getGoodsSn() == null : this.getGoodsSn().equals(other.getGoodsSn()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBrandId() == null ? other.getBrandId() == null : this.getBrandId().equals(other.getBrandId()))
            && (this.getGoodsNumber() == null ? other.getGoodsNumber() == null : this.getGoodsNumber().equals(other.getGoodsNumber()))
            && (this.getKeywords() == null ? other.getKeywords() == null : this.getKeywords().equals(other.getKeywords()))
            && (this.getGoodsBrief() == null ? other.getGoodsBrief() == null : this.getGoodsBrief().equals(other.getGoodsBrief()))
            && (this.getIsOnSale() == null ? other.getIsOnSale() == null : this.getIsOnSale().equals(other.getIsOnSale()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getSortOrder() == null ? other.getSortOrder() == null : this.getSortOrder().equals(other.getSortOrder()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
            && (this.getAttributeCategory() == null ? other.getAttributeCategory() == null : this.getAttributeCategory().equals(other.getAttributeCategory()))
            && (this.getCounterPrice() == null ? other.getCounterPrice() == null : this.getCounterPrice().equals(other.getCounterPrice()))
            && (this.getExtraPrice() == null ? other.getExtraPrice() == null : this.getExtraPrice().equals(other.getExtraPrice()))
            && (this.getIsNew() == null ? other.getIsNew() == null : this.getIsNew().equals(other.getIsNew()))
            && (this.getGoodsUnit() == null ? other.getGoodsUnit() == null : this.getGoodsUnit().equals(other.getGoodsUnit()))
            && (this.getPrimaryPicUrl() == null ? other.getPrimaryPicUrl() == null : this.getPrimaryPicUrl().equals(other.getPrimaryPicUrl()))
            && (this.getListPicUrl() == null ? other.getListPicUrl() == null : this.getListPicUrl().equals(other.getListPicUrl()))
            && (this.getRetailPrice() == null ? other.getRetailPrice() == null : this.getRetailPrice().equals(other.getRetailPrice()))
            && (this.getSellVolume() == null ? other.getSellVolume() == null : this.getSellVolume().equals(other.getSellVolume()))
            && (this.getPrimaryProductId() == null ? other.getPrimaryProductId() == null : this.getPrimaryProductId().equals(other.getPrimaryProductId()))
            && (this.getUnitPrice() == null ? other.getUnitPrice() == null : this.getUnitPrice().equals(other.getUnitPrice()))
            && (this.getPromotionDesc() == null ? other.getPromotionDesc() == null : this.getPromotionDesc().equals(other.getPromotionDesc()))
            && (this.getPromotionTag() == null ? other.getPromotionTag() == null : this.getPromotionTag().equals(other.getPromotionTag()))
            && (this.getAppExclusivePrice() == null ? other.getAppExclusivePrice() == null : this.getAppExclusivePrice().equals(other.getAppExclusivePrice()))
            && (this.getIsAppExclusive() == null ? other.getIsAppExclusive() == null : this.getIsAppExclusive().equals(other.getIsAppExclusive()))
            && (this.getIsLimited() == null ? other.getIsLimited() == null : this.getIsLimited().equals(other.getIsLimited()))
            && (this.getIsHot() == null ? other.getIsHot() == null : this.getIsHot().equals(other.getIsHot()))
            && (this.getGoodsDesc() == null ? other.getGoodsDesc() == null : this.getGoodsDesc().equals(other.getGoodsDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getGoodsSn() == null) ? 0 : getGoodsSn().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBrandId() == null) ? 0 : getBrandId().hashCode());
        result = prime * result + ((getGoodsNumber() == null) ? 0 : getGoodsNumber().hashCode());
        result = prime * result + ((getKeywords() == null) ? 0 : getKeywords().hashCode());
        result = prime * result + ((getGoodsBrief() == null) ? 0 : getGoodsBrief().hashCode());
        result = prime * result + ((getIsOnSale() == null) ? 0 : getIsOnSale().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getSortOrder() == null) ? 0 : getSortOrder().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getAttributeCategory() == null) ? 0 : getAttributeCategory().hashCode());
        result = prime * result + ((getCounterPrice() == null) ? 0 : getCounterPrice().hashCode());
        result = prime * result + ((getExtraPrice() == null) ? 0 : getExtraPrice().hashCode());
        result = prime * result + ((getIsNew() == null) ? 0 : getIsNew().hashCode());
        result = prime * result + ((getGoodsUnit() == null) ? 0 : getGoodsUnit().hashCode());
        result = prime * result + ((getPrimaryPicUrl() == null) ? 0 : getPrimaryPicUrl().hashCode());
        result = prime * result + ((getListPicUrl() == null) ? 0 : getListPicUrl().hashCode());
        result = prime * result + ((getRetailPrice() == null) ? 0 : getRetailPrice().hashCode());
        result = prime * result + ((getSellVolume() == null) ? 0 : getSellVolume().hashCode());
        result = prime * result + ((getPrimaryProductId() == null) ? 0 : getPrimaryProductId().hashCode());
        result = prime * result + ((getUnitPrice() == null) ? 0 : getUnitPrice().hashCode());
        result = prime * result + ((getPromotionDesc() == null) ? 0 : getPromotionDesc().hashCode());
        result = prime * result + ((getPromotionTag() == null) ? 0 : getPromotionTag().hashCode());
        result = prime * result + ((getAppExclusivePrice() == null) ? 0 : getAppExclusivePrice().hashCode());
        result = prime * result + ((getIsAppExclusive() == null) ? 0 : getIsAppExclusive().hashCode());
        result = prime * result + ((getIsLimited() == null) ? 0 : getIsLimited().hashCode());
        result = prime * result + ((getIsHot() == null) ? 0 : getIsHot().hashCode());
        result = prime * result + ((getGoodsDesc() == null) ? 0 : getGoodsDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", name=").append(name);
        sb.append(", brandId=").append(brandId);
        sb.append(", goodsNumber=").append(goodsNumber);
        sb.append(", keywords=").append(keywords);
        sb.append(", goodsBrief=").append(goodsBrief);
        sb.append(", isOnSale=").append(isOnSale);
        sb.append(", addTime=").append(addTime);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", attributeCategory=").append(attributeCategory);
        sb.append(", counterPrice=").append(counterPrice);
        sb.append(", extraPrice=").append(extraPrice);
        sb.append(", isNew=").append(isNew);
        sb.append(", goodsUnit=").append(goodsUnit);
        sb.append(", primaryPicUrl=").append(primaryPicUrl);
        sb.append(", listPicUrl=").append(listPicUrl);
        sb.append(", retailPrice=").append(retailPrice);
        sb.append(", sellVolume=").append(sellVolume);
        sb.append(", primaryProductId=").append(primaryProductId);
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", promotionDesc=").append(promotionDesc);
        sb.append(", promotionTag=").append(promotionTag);
        sb.append(", appExclusivePrice=").append(appExclusivePrice);
        sb.append(", isAppExclusive=").append(isAppExclusive);
        sb.append(", isLimited=").append(isLimited);
        sb.append(", isHot=").append(isHot);
        sb.append(", goodsDesc=").append(goodsDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}