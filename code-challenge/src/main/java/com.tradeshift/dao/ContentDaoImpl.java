package com.tradeshift.dao;

import com.tradeshift.domain.Content;
import com.tradeshift.jdbc.ContentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangleo on 16/06/15.
 */
public class ContentDaoImpl implements ContentDao {

    @Autowired
    DataSource dataSource;

    @Override
    public int insertData(Content content) {

        String sql = "INSERT INTO contents "
                + "(content) VALUES (?)";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate.update(
                sql,
                new Object[]{content.getContent()});

    }

    @Override
    public List<Content> getContentList() {
        List contentList = new ArrayList();

        String sql = "select * from contents order by date_added DESC limit 10";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        contentList = jdbcTemplate.query(sql, new ContentRowMapper());
        return contentList;
    }

    @Override
    public int count() {
        String sql = "select count(*) from contents";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForInt(sql);
    }

}
