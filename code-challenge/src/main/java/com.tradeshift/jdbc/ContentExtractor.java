package com.tradeshift.jdbc;

import com.tradeshift.domain.Content;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhangleo on 16/06/15.
 */
public class ContentExtractor implements ResultSetExtractor<Content> {

    public Content extractData(ResultSet resultSet) throws SQLException,
            DataAccessException {

        Content content = new Content();

        content.setContent(resultSet.getString("content"));
        content.setDate_added(resultSet.getTimestamp("date_added"));
        return content;
    }
}
