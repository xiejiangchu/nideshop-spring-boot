package com.xie.bean;

import java.io.Serializable;

public class Feedback implements Serializable {
    private Integer msgId;

    private Integer parentId;

    private Integer userId;

    private String userName;

    private String userEmail;

    private String msgTitle;

    private Boolean msgType;

    private Boolean msgStatus;

    private Integer msgTime;

    private String messageImg;

    private Integer orderId;

    private Boolean msgArea;

    private String msgContent;

    private static final long serialVersionUID = 1L;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public Boolean getMsgType() {
        return msgType;
    }

    public void setMsgType(Boolean msgType) {
        this.msgType = msgType;
    }

    public Boolean getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Boolean msgStatus) {
        this.msgStatus = msgStatus;
    }

    public Integer getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Integer msgTime) {
        this.msgTime = msgTime;
    }

    public String getMessageImg() {
        return messageImg;
    }

    public void setMessageImg(String messageImg) {
        this.messageImg = messageImg;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Boolean getMsgArea() {
        return msgArea;
    }

    public void setMsgArea(Boolean msgArea) {
        this.msgArea = msgArea;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
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
        Feedback other = (Feedback) that;
        return (this.getMsgId() == null ? other.getMsgId() == null : this.getMsgId().equals(other.getMsgId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserEmail() == null ? other.getUserEmail() == null : this.getUserEmail().equals(other.getUserEmail()))
            && (this.getMsgTitle() == null ? other.getMsgTitle() == null : this.getMsgTitle().equals(other.getMsgTitle()))
            && (this.getMsgType() == null ? other.getMsgType() == null : this.getMsgType().equals(other.getMsgType()))
            && (this.getMsgStatus() == null ? other.getMsgStatus() == null : this.getMsgStatus().equals(other.getMsgStatus()))
            && (this.getMsgTime() == null ? other.getMsgTime() == null : this.getMsgTime().equals(other.getMsgTime()))
            && (this.getMessageImg() == null ? other.getMessageImg() == null : this.getMessageImg().equals(other.getMessageImg()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getMsgArea() == null ? other.getMsgArea() == null : this.getMsgArea().equals(other.getMsgArea()))
            && (this.getMsgContent() == null ? other.getMsgContent() == null : this.getMsgContent().equals(other.getMsgContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMsgId() == null) ? 0 : getMsgId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserEmail() == null) ? 0 : getUserEmail().hashCode());
        result = prime * result + ((getMsgTitle() == null) ? 0 : getMsgTitle().hashCode());
        result = prime * result + ((getMsgType() == null) ? 0 : getMsgType().hashCode());
        result = prime * result + ((getMsgStatus() == null) ? 0 : getMsgStatus().hashCode());
        result = prime * result + ((getMsgTime() == null) ? 0 : getMsgTime().hashCode());
        result = prime * result + ((getMessageImg() == null) ? 0 : getMessageImg().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getMsgArea() == null) ? 0 : getMsgArea().hashCode());
        result = prime * result + ((getMsgContent() == null) ? 0 : getMsgContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", msgId=").append(msgId);
        sb.append(", parentId=").append(parentId);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", msgTitle=").append(msgTitle);
        sb.append(", msgType=").append(msgType);
        sb.append(", msgStatus=").append(msgStatus);
        sb.append(", msgTime=").append(msgTime);
        sb.append(", messageImg=").append(messageImg);
        sb.append(", orderId=").append(orderId);
        sb.append(", msgArea=").append(msgArea);
        sb.append(", msgContent=").append(msgContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}