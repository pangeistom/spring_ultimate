package com.ctrip.entity.bo;


import java.util.Date;

public class HomeInformationBo {

    public String pubProperty;

    public String getPubProperty() {
        return pubProperty;
    }

    public void setPubProperty(String pubProperty) {
        this.pubProperty = pubProperty;
    }

    private String getTestMethod(String str) {
        System.out.println("测试反射调用方法" + str);
        return "456";
    }

    private Integer homeId;

    private String address;

    private Date goTime;

    private Date datacreatTime;

    private double price;

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getGoTime() {
        return goTime;
    }

    public void setGoTime(Date goTime) {
        this.goTime = goTime;
    }

    public Date getDatacreatTime() {
        return datacreatTime;
    }

    public void setDatacreatTime(Date datacreatTime) {
        this.datacreatTime = datacreatTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HomeInformationBo{" +
                "homeId=" + homeId +
                ", address='" + address + '\'' +
                ", goTime=" + goTime +
                ", datacreatTime=" + datacreatTime +
                ", price=" + price +
                '}';
    }
}
