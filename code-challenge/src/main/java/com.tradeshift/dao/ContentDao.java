package com.tradeshift.dao;

import com.tradeshift.domain.Content;

import java.util.List;

/**
 * Created by zhangleo on 16/06/15.
 */
public interface ContentDao {

    public int insertData(Content content);

    public List<Content> getContentList();

    public int count();

}
