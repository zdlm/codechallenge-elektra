package com.tradeshift.domain;

import java.util.Date;

/**
 * Created by zhangleo on 16/06/15.
 */
public class Content {

    private String content;

    private Date date_added;


    public String getContent() {
        return content;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }
}
