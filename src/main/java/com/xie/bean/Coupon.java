package com.xie.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Coupon implements Serializable {
    private static final long serialVersionUID = 1L;
    private Short id;
    private String name;
    private BigDecimal typeMoney;
    private Byte sendType;
    private BigDecimal minAmount;
    private BigDecimal maxAmount;
    private Integer sendStartDate;
    private Integer sendEndDate;
    private Integer useStartDate;
    private Integer useEndDate;
    private BigDecimal minGoodsAmount;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTypeMoney() {
        return typeMoney;
    }

    public void setTypeMoney(BigDecimal typeMoney) {
        this.typeMoney = typeMoney;
    }

    public Byte getSendType() {
        return sendType;
    }

    public void setSendType(Byte sendType) {
        this.sendType = sendType;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getSendStartDate() {
        return sendStartDate;
    }

    public void setSendStartDate(Integer sendStartDate) {
        this.sendStartDate = sendStartDate;
    }

    public Integer getSendEndDate() {
        return sendEndDate;
    }

    public void setSendEndDate(Integer sendEndDate) {
        this.sendEndDate = sendEndDate;
    }

    public Integer getUseStartDate() {
        return useStartDate;
    }

    public void setUseStartDate(Integer useStartDate) {
        this.useStartDate = useStartDate;
    }

    public Integer getUseEndDate() {
        return useEndDate;
    }

    public void setUseEndDate(Integer useEndDate) {
        this.useEndDate = useEndDate;
    }

    public BigDecimal getMinGoodsAmount() {
        return minGoodsAmount;
    }

    public void setMinGoodsAmount(BigDecimal minGoodsAmount) {
        this.minGoodsAmount = minGoodsAmount;
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
        Coupon other = (Coupon) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getTypeMoney() == null ? other.getTypeMoney() == null : this.getTypeMoney().equals(other.getTypeMoney()))
                && (this.getSendType() == null ? other.getSendType() == null : this.getSendType().equals(other.getSendType()))
                && (this.getMinAmount() == null ? other.getMinAmount() == null : this.getMinAmount().equals(other.getMinAmount()))
                && (this.getMaxAmount() == null ? other.getMaxAmount() == null : this.getMaxAmount().equals(other.getMaxAmount()))
                && (this.getSendStartDate() == null ? other.getSendStartDate() == null : this.getSendStartDate().equals(other.getSendStartDate()))
                && (this.getSendEndDate() == null ? other.getSendEndDate() == null : this.getSendEndDate().equals(other.getSendEndDate()))
                && (this.getUseStartDate() == null ? other.getUseStartDate() == null : this.getUseStartDate().equals(other.getUseStartDate()))
                && (this.getUseEndDate() == null ? other.getUseEndDate() == null : this.getUseEndDate().equals(other.getUseEndDate()))
                && (this.getMinGoodsAmount() == null ? other.getMinGoodsAmount() == null : this.getMinGoodsAmount().equals(other.getMinGoodsAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTypeMoney() == null) ? 0 : getTypeMoney().hashCode());
        result = prime * result + ((getSendType() == null) ? 0 : getSendType().hashCode());
        result = prime * result + ((getMinAmount() == null) ? 0 : getMinAmount().hashCode());
        result = prime * result + ((getMaxAmount() == null) ? 0 : getMaxAmount().hashCode());
        result = prime * result + ((getSendStartDate() == null) ? 0 : getSendStartDate().hashCode());
        result = prime * result + ((getSendEndDate() == null) ? 0 : getSendEndDate().hashCode());
        result = prime * result + ((getUseStartDate() == null) ? 0 : getUseStartDate().hashCode());
        result = prime * result + ((getUseEndDate() == null) ? 0 : getUseEndDate().hashCode());
        result = prime * result + ((getMinGoodsAmount() == null) ? 0 : getMinGoodsAmount().hashCode());
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
        sb.append(", typeMoney=").append(typeMoney);
        sb.append(", sendType=").append(sendType);
        sb.append(", minAmount=").append(minAmount);
        sb.append(", maxAmount=").append(maxAmount);
        sb.append(", sendStartDate=").append(sendStartDate);
        sb.append(", sendEndDate=").append(sendEndDate);
        sb.append(", useStartDate=").append(useStartDate);
        sb.append(", useEndDate=").append(useEndDate);
        sb.append(", minGoodsAmount=").append(minGoodsAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}