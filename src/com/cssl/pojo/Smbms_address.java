package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


//地址表实体类
@Getter
@Setter
public class Smbms_address implements Serializable {
    private long id;
    //主键ID
    private String contact;
    //联系人姓名
    private String addressDesc;
    //收货地址明细
    private String postCode;
    //邮编
    private String tel;
    //联系人电话
    private long createdBy;
    //创建者
    private Date creationDate;
    //创建时间
    private long modifyBy;
    //修改者
    private Date modifyDate;
    //修改时间
    private long userId;
    //用户ID


    public Smbms_address(long id, String contact, String addressDesc, String postCode, String tel, long createdBy, Date creationDate, long modifyBy, Date modifyDate, long userId) {
        this.id = id;
        this.contact = contact;
        this.addressDesc = addressDesc;
        this.postCode = postCode;
        this.tel = tel;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Smbms_address{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", addressDesc='" + addressDesc + '\'' +
                ", postCode='" + postCode + '\'' +
                ", tel='" + tel + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", userId=" + userId +
                '}';
    }

    public Smbms_address() {
    }
}
