package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

//供货商表实体类
@Getter
@Setter
public class Smbms_provider implements Serializable {
    private long id;
    private String proCode;
    private String proName;
    private String proDesc;
    private String proContact;
    private String proPhone;
    private String proAddress;
    private String proFax;
    private long createdBy;
    //创建者（userId）
    private Date creationDate;
    //创建时间
    private long modifyBy;
    //更新者（userId）
    private Date modifyDate;
    //更新时间
    private Smbms_bill smbmsBill;


    public Smbms_provider(long id, String proCode, String proName, String proDesc, String proContact, String proPhone, String proAddress, String proFax, long createdBy, Date creationDate, long modifyBy, Date modifyDate) {
        this.id = id;
        this.proCode = proCode;
        this.proName = proName;
        this.proDesc = proDesc;
        this.proContact = proContact;
        this.proPhone = proPhone;
        this.proAddress = proAddress;
        this.proFax = proFax;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public Smbms_provider(long id, String proCode, String proName, String proDesc, String proContact, String proPhone, String proAddress, String proFax, long createdBy, Date creationDate, long modifyBy, Date modifyDate, Smbms_bill smbmsBill) {
        this.id = id;
        this.proCode = proCode;
        this.proName = proName;
        this.proDesc = proDesc;
        this.proContact = proContact;
        this.proPhone = proPhone;
        this.proAddress = proAddress;
        this.proFax = proFax;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.smbmsBill = smbmsBill;
    }

    @Override
    public String toString() {
        return "Smbms_provider{" +
                "id=" + id +
                ", proCode='" + proCode + '\'' +
                ", proName='" + proName + '\'' +
                ", proDesc='" + proDesc + '\'' +
                ", proContact='" + proContact + '\'' +
                ", proPhone='" + proPhone + '\'' +
                ", proAddress='" + proAddress + '\'' +
                ", proFax='" + proFax + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Smbms_provider() {
    }
}
