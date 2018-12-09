package com.springmvc.entity;

import java.util.Date;

public class ScoreUsers {
    private String username;

    private String usercaption;

    private String serverVer;

    private String usertype;

    private Date loginDate;

    private Date createDate;

    private String open;

    private String userpwd;

    private String iscurrent;

    private String accountcode;

    private String filepath;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsercaption() {
        return usercaption;
    }

    public void setUsercaption(String usercaption) {
        this.usercaption = usercaption;
    }

    public String getServerVer() {
        return serverVer;
    }

    public void setServerVer(String serverVer) {
        this.serverVer = serverVer;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getIscurrent() {
        return iscurrent;
    }

    public void setIscurrent(String iscurrent) {
        this.iscurrent = iscurrent;
    }

    public String getAccountcode() {
        return accountcode;
    }

    public void setAccountcode(String accountcode) {
        this.accountcode = accountcode;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}