package com.cicari.p001270.gaveta.model;

public class User1 {
    private String displayName;
    private String email;
    private String image;
    private String userId;

    public User1(String str, String str2, String str3) {
        this.userId = str;
        this.displayName = str2;
        this.email = str3;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }
}
