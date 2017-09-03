package com.xie.bean;

import java.io.Serializable;

public class RelatedGoods implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer goodsId;
    private Integer relatedGoodsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getRelatedGoodsId() {
        return relatedGoodsId;
    }

    public void setRelatedGoodsId(Integer relatedGoodsId) {
        this.relatedGoodsId = relatedGoodsId;
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
        RelatedGoods other = (RelatedGoods) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
                && (this.getRelatedGoodsId() == null ? other.getRelatedGoodsId() == null : this.getRelatedGoodsId().equals(other.getRelatedGoodsId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getRelatedGoodsId() == null) ? 0 : getRelatedGoodsId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", relatedGoodsId=").append(relatedGoodsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}