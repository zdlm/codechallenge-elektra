package com.tradeshift;

import com.tradeshift.dao.ContentDao;
import com.tradeshift.dao.ContentDaoImpl;
import com.tradeshift.domain.Content;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zhangleo on 17/06/15.
 */
public class ContentDaoTest {

    private static ContentDao mockedContentDao;
    private static Content content1;
    private static Content content2;

    @BeforeClass
    public static void SetUp() {
        mockedContentDao = mock(ContentDaoImpl.class);
        content1 = new Content();
        content1.setContent("content test 1");
        content1.setDate_added(new Date());

        content2 = new Content();
        content2.setContent("content test 2");
        content2.setDate_added(new Date());

        when(mockedContentDao.insertData(content1)).thenReturn(1);
        when(mockedContentDao.getContentList()).thenReturn(Arrays.asList(content1, content2));
        when(mockedContentDao.count()).thenReturn(2);

    }

    @Test
    public void testInsertData() {
        int result = mockedContentDao.insertData(content1);
        assertEquals(1, result);
    }

    @Test
    public void testGetContentList() {
        List<Content> contents = mockedContentDao.getContentList();
        assertEquals(2, contents.size());
        Content content = contents.get(0);
        assertEquals("content test 1", content.getContent());
    }

    @Test
    public void testCount() {
        int count = mockedContentDao.count();
        assertEquals(2, count);
    }
}
