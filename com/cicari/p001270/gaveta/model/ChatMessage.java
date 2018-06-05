package com.cicari.p001270.gaveta.model;

public class ChatMessage {
    private String message;
    private String receiverId;
    private String senderId;

    public ChatMessage(String str, String str2, String str3) {
        this.message = str;
        this.senderId = str2;
        this.receiverId = str3;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getSenderId() {
        return this.senderId;
    }

    public void setSenderId(String str) {
        this.senderId = str;
    }

    public String getReceiverId() {
        return this.receiverId;
    }

    public void setReceiverId(String str) {
        this.receiverId = str;
    }
}
