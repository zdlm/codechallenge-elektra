package com.tradeshift.services;

import com.tradeshift.model.Content;

import java.util.List;

/**
 * Created by zhangleo on 16/06/15.
 */
public interface ContentService {

    public int insertData(Content content);

    public List<com.tradeshift.domain.Content> getContentList();

    public int count();

}
