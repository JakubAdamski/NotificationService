package com.example.lab4.dto;

import org.antlr.v4.runtime.misc.NotNull;

public class NotificationRequest {

    @NotNull
    private String content;

    @NotNull
    private String channel; // "email" or "push"

    @NotNull
    private String recipient;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}
