package com.tradeshift.dao;

import com.tradeshift.domain.Content;
import com.tradeshift.jdbc.ContentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class ContentDao {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbcTemplate = null;
    ContentRowMapper contentRowMapper = null;

    public ContentDao() {
    }

    public ContentDao(JdbcTemplate jdbcTemplate, ContentRowMapper contentRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.contentRowMapper = contentRowMapper;
    }

    public int insertData(Content content) {

        String sql = "INSERT INTO contents "
                + "(content) VALUES (?)";

        if(jdbcTemplate == null){
            jdbcTemplate = new JdbcTemplate(dataSource);
        }

        return jdbcTemplate.update(
                sql,
                new Object[]{content.getContent()});

    }

    public List<Content> getContentList() {
        List contentList = new ArrayList();

        String sql = "select * from contents order by dateAdded DESC limit 10";

        if(jdbcTemplate == null){
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        if(contentRowMapper == null){
            contentRowMapper = new ContentRowMapper();
        }
        contentList = jdbcTemplate.query(sql, contentRowMapper);
        return contentList;
    }

    public int count() {
        String sql = "select count(*) from contents";
        if(jdbcTemplate == null){
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate.queryForInt(sql);
    }

}
