package com.tradeshift.services;

import com.tradeshift.dao.ContentDao;
import com.tradeshift.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by zhangleo on 16/06/15.
 */
public class ContentServiceImpl implements ContentService {

    @Autowired
    public ContentDao contentDao;

    public ContentServiceImpl() {
    }

    public ContentServiceImpl(ContentDao contentDao) {
        this.contentDao = contentDao;
    }

    @Override
    public int insertData(com.tradeshift.model.Content content) {
        Content domain = new Content();
        domain.setContent(content.getContent());
        return contentDao.insertData(domain);
    }

    @Override
    public List<Content> getContentList() {
        return contentDao.getContentList();
    }

    @Override
    public int count() {
        return contentDao.count();
    }
}
