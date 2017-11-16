package com.scoprion.mall.domain;

/**
 * @author by Administrator
 * @created on 2017/11/2/002.
 */
public class OrderExt extends Order {


    /**
     * IP地址
     */
    private String ipAddress;

    /**
     * 微信用户标识code
     */
    private String openCode;

    /**
     * 发货信息
     */
    private SendGood sendGood;

    /**
     * 收件人信息
     */
    private Delivery delivery;


    /**
     * 商品图片
     */
    private String goodMainImage;

    public OrderExt() {

    }

    public String getGoodMainImage() {
        return goodMainImage;
    }

    public void setGoodMainImage(String goodMainImage) {
        this.goodMainImage = goodMainImage;
    }

    public OrderExt(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public SendGood getSendGood() {
        return sendGood;
    }

    public void setSendGood(SendGood sendGood) {
        this.sendGood = sendGood;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getOpenCode() {
        return openCode;
    }

    public void setOpenCode(String openCode) {
        this.openCode = openCode;
    }

    @Override
    public String toString() {
        return "OrderExt{" +
                "ipAddress='" + ipAddress + '\'' +
                ", openCode='" + openCode + '\'' +
                ", sendGood=" + sendGood +
                ", delivery=" + delivery +
                ", goodMainImage='" + goodMainImage + '\'' +
                "} " + super.toString();
    }
}
