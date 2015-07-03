package com.tradeshift.jdbc;

import com.tradeshift.domain.Content;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentExtractor implements ResultSetExtractor<Content> {

    public Content extractData(ResultSet resultSet) throws SQLException,
            DataAccessException {

        Content content = new Content(resultSet.getString("content"), resultSet.getTimestamp("dateAdded"));
        return content;
    }
}
