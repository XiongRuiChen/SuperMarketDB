package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


//用户角色表实体类
@Setter
@Getter
public class Smbms_role implements Serializable {
    private long id;
    private String roleCode;
    private String roleName;
    private long createdBy;
    //创建者（userId）
    private Date creationDate;
    //创建时间
    private long modifyBy;
    //更新者（userId）
    private Date modifyDate;
    //更新时间
    private Smbms_user smbmsUser;


    @Override
    public String toString() {
        return "Smbms_role{" +
                "id=" + id +
                ", roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Smbms_role(long id, String roleCode, String roleName, long createdBy, Date creationDate, long modifyBy, Date modifyDate) {
        this.id = id;
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public Smbms_role() {
    }
}
