package com.example.springboot.user.domain;

public class UserDomain {
    private Integer uid;

    private String phone;

    private String username;

    private String avatarUrl;

    private Byte gender;

    private String province;

    private String city;

    private Integer lastLoginedAt;

    private Integer lastLoginedIp;

    private Integer createdAt;

    private Integer updatedAt;

    private Byte status;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getLastLoginedAt() {
        return lastLoginedAt;
    }

    public void setLastLoginedAt(Integer lastLoginedAt) {
        this.lastLoginedAt = lastLoginedAt;
    }

    public Integer getLastLoginedIp() {
        return lastLoginedIp;
    }

    public void setLastLoginedIp(Integer lastLoginedIp) {
        this.lastLoginedIp = lastLoginedIp;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}