package com.xie.bean;

/**
 * Created by xie on 17/9/27.
 */
public class OrderHandleOption {

    /**
     * 取消操作
     */
    private boolean cancel;
    /**
     * 删除
     */
    private boolean delete;
    /**
     * 支付
     */
    private boolean pay;
    /**
     * 评论
     */
    private boolean comment;
    /**
     * 确认收货
     */
    private boolean delivery;
    /**
     * 完成订单
     */
    private boolean confirm;
    /**
     * 退换货
     */
    private boolean ret;
    /**
     * 再次购买
     */
    private boolean buy;

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }
}
