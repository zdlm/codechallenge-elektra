package com.tradeshift.jdbc;

import com.tradeshift.domain.Content;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentRowMapper implements RowMapper<Content> {

    @Override
    public Content mapRow(ResultSet resultSet, int line) throws SQLException {
        ContentExtractor contentExtractor = new ContentExtractor();
        return contentExtractor.extractData(resultSet);
    }
}
