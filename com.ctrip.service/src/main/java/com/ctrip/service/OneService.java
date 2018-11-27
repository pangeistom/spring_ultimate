package com.ctrip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("prod")
@Scope(scopeName = "singleton")
public class OneService {

    @Autowired
    private OneUser user;

    @Value("产品名称")
    private String productName;

    @Value("123")
    private Long orderId;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Product [user=" + user + ", productName=" + productName + ", orderId=" + orderId + "]";
    }

    public OneService() {
        System.out.println("注解方式初始化对象");
    }
}
