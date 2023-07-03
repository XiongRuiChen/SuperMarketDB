package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//用户表实体类
@Getter
@Setter
public class Smbms_user implements Serializable {
    private long id;
    //主键id
    private String userCode;
    //用户编码
    private String userName;
    //用户名称
    private String userPassword;
    //用户密码
    private Integer gender;
    //性别（1:女、 2:男）
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    //出生日期
    private String phone;
    //手机
    private String address;
    //地址
    private long userRole;
    //用户角色（取自角色表-角色id）
    private long createdBy;
    //创建者（userId）
    private Date creationDate;
    //创建时间
    private long modifyBy;
    //更新者（userId）
    private Date modifyDate;
    //更新时间
    private Smbms_role smbmsRole;

    public Smbms_user(long id, String userCode, String userName, String userPassword, Integer gender, Date birthday, String phone, String address, long userRole, long createdBy, Date creationDate, long modifyBy, Date modifyDate) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.userRole = userRole;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public Smbms_user(long id, String userCode, String userName, String userPassword, Integer gender, Date birthday, String phone, String address, long userRole, long createdBy, Date creationDate, long modifyBy, Date modifyDate, Smbms_role smbmsRole) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.userRole = userRole;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.smbmsRole = smbmsRole;
    }

    @Override
    public String toString() {
        return "Smbms_user{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userRole=" + userRole +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Smbms_user() {
    }
}
