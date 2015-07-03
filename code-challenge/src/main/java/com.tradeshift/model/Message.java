package com.tradeshift.model;

public class Message {

    private Content message;

    public Message(Content message) {
        this.message = message;
    }
    public Content getMessage() {
        return message;
    }
}
