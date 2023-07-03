package com.cssl.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


//账单表实体类
@Setter
@Getter
public class Smbms_bill implements Serializable {
    private long id;
    private String billCode;
    private String productName;
    private String productDesc;
    private String productUnit;
    private BigDecimal productCount;
    private BigDecimal totalPrice;
    private Integer isPayment;
    private long createdBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
    private long modifyBy;
    private Date modifyDate;
    private long providerId;
    private Smbms_provider smbmsProvider;

    @Override
    public String toString() {
        return "Smbms_bill{" +
                "id=" + id +
                ", billCode='" + billCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", productCount=" + productCount +
                ", totalPrice=" + totalPrice +
                ", isPayment=" + isPayment +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", providerId=" + providerId +
                '}';
    }

    public Smbms_bill(long id, String billCode, String productName, String productDesc, String productUnit, BigDecimal productCount, BigDecimal totalPrice, Integer isPayment, long createdBy, Date creationDate, long modifyBy, Date modifyDate, long providerId) {
        this.id = id;
        this.billCode = billCode;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productUnit = productUnit;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.isPayment = isPayment;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.providerId = providerId;
    }

    public Smbms_bill(long id, String billCode, String productName, String productDesc, String productUnit, BigDecimal productCount, BigDecimal totalPrice, Integer isPayment, long createdBy, Date creationDate, long modifyBy, Date modifyDate, long providerId, Smbms_provider smbmsProvider) {
        this.id = id;
        this.billCode = billCode;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productUnit = productUnit;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.isPayment = isPayment;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.providerId = providerId;
        this.smbmsProvider = smbmsProvider;
    }

    public Smbms_bill() {
    }
}
