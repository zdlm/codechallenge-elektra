package com.tradeshift.services;

import com.tradeshift.dao.ContentDao;
import com.tradeshift.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContentService {

    @Autowired
    public ContentDao contentDao;

    public ContentService() {
    }

    public ContentService(ContentDao contentDao) {
        this.contentDao = contentDao;
    }

    public int insertData(com.tradeshift.model.Content content) {
        Content newCondtent = new Content(content.getContent());
        return contentDao.insertData(newCondtent);
    }

    public List<Content> getContentList() {
        return contentDao.getContentList();
    }

    public int count() {
        return contentDao.count();
    }
}
