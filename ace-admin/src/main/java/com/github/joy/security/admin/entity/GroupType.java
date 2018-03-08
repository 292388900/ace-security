package com.github.joy.security.admin.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="base_group_type")
public class GroupType {
    
    @Id
    private Integer id;

    private String code;

    private String name;

    private String description;

    private Date crtTime;

    private String crtUser;

    private String crtName;

    private String crtHost;

    private Date updTime;

    private String updUser;

    private String updName;

    private String updHost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser == null ? null : crtUser.trim();
    }

    public String getCrtName() {
        return crtName;
    }

    public void setCrtName(String crtName) {
        this.crtName = crtName == null ? null : crtName.trim();
    }

    public String getCrtHost() {
        return crtHost;
    }

    public void setCrtHost(String crtHost) {
        this.crtHost = crtHost == null ? null : crtHost.trim();
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser == null ? null : updUser.trim();
    }

    public String getUpdName() {
        return updName;
    }

    public void setUpdName(String updName) {
        this.updName = updName == null ? null : updName.trim();
    }

    public String getUpdHost() {
        return updHost;
    }

    public void setUpdHost(String updHost) {
        this.updHost = updHost == null ? null : updHost.trim();
    }
}