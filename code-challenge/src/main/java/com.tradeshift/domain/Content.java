package com.tradeshift.domain;

import java.util.Date;

public class Content {

    private String content;

    private Date dateAdded;

    public Content(String content) {
        this.content = content;
    }

    public Content(String content, Date dateAdded) {
        this.content = content;
        this.dateAdded = dateAdded;
    }

    public String getContent() {
        return content;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
