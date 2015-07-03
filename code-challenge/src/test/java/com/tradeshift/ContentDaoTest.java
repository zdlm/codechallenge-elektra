package com.tradeshift;

import com.tradeshift.dao.ContentDao;
import com.tradeshift.domain.Content;
import com.tradeshift.jdbc.ContentRowMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ContentDaoTest {

    private static ContentDao contentDao;
    private static JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    private static ContentRowMapper contentRowMapper = mock(ContentRowMapper.class);
    private static Content content;

    @BeforeClass
    public static void SetUp() {
        contentDao = new ContentDao(jdbcTemplate, contentRowMapper);
        content = new Content("content test 1", new Date());

    }

    @Test
    public void testInsertData() {
        contentDao.insertData(content);
        verify(jdbcTemplate).update("INSERT INTO contents (content) VALUES (?)",
                "content test 1");
    }

    @Test
    public void testGetContentList() {
        contentDao.getContentList();
        verify(jdbcTemplate).query("select * from contents order by dateAdded DESC limit 10",contentRowMapper);
    }

    @Test
    public void testCount() {
        contentDao.count();
        verify(jdbcTemplate).queryForInt("select count(*) from contents");
    }
}
