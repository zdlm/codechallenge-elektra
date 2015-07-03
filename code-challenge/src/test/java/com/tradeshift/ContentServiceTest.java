package com.tradeshift;

import com.tradeshift.dao.ContentDao;
import com.tradeshift.domain.Content;
import com.tradeshift.services.ContentService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zhangleo on 17/06/15.
 */
public class ContentServiceTest {

    @Mock
    private static ContentDao mockedContentDao;
    private static Content content1;
    private static Content content2;

    @InjectMocks
    ContentService contentService = new ContentService(mockedContentDao);

    @BeforeClass
    public static void SetUp() {
        mockedContentDao = mock(ContentDao.class);
        content1 = new Content("content test 1",new Date());
        content2 = new Content("content test 2",new Date());

        when(mockedContentDao.insertData(content1)).thenReturn(0);
        when(mockedContentDao.getContentList()).thenReturn(Arrays.asList(content1, content2));
        when(mockedContentDao.count()).thenReturn(2);

    }

    @Test
    public void testInsertData() {
        com.tradeshift.model.Content content = new com.tradeshift.model.Content();
        content.setContent("content test3");
        int result = contentService.insertData(content);
        assertEquals(0, result);
    }

    @Test
    public void testGetContentList() {
        List<Content> contents = contentService.getContentList();
        assertEquals(2, contents.size());
        Content content = contents.get(0);
        assertEquals("content test 1", content.getContent());
    }

    @Test
    public void testCount() {
        int count = contentService.count();
        assertEquals(2, count);
    }

}
