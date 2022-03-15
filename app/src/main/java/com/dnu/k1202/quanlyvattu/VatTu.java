package com.dnu.k1202.quanlyvattu;

public class VatTu {
    private int avatar;
    private String name;
    private String detail;

    public VatTu() {
    }

    public VatTu(int avatar, String name, String detail) {
        this.avatar = avatar;
        this.name = name;
        this.detail = detail;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "VatTu{" +
                "avatar=" + avatar +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
