package com.tradeshift;

import com.tradeshift.model.Content;
import com.tradeshift.model.Message;
import com.tradeshift.model.Result;
import com.tradeshift.services.ContentService;
import com.tradeshift.services.MessageService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zhangleo on 18/06/15.
 */
public class MessageServiceTest {

    @Mock
    private static ContentService contentService;

    @InjectMocks
    MessageService messageService = new MessageService(contentService);


    @BeforeClass
    public static void SetUp() {
        contentService = mock(ContentService.class);

        Content content = new Content();
        content.setContent("test");

        com.tradeshift.domain.Content content1 = new com.tradeshift.domain.Content("test1",new Date());
        com.tradeshift.domain.Content content2 = new com.tradeshift.domain.Content("test2",new Date());

        when(contentService.insertData(content)).thenReturn(1);
        when(contentService.getContentList()).thenReturn(Arrays.asList(content1, content2));
        when(contentService.count()).thenReturn(2);
    }

    @Test
    public void testSaveMessage() {
        Message message = messageService.saveMessage("test");
        assertNotNull(message);
        assertEquals("hello test", message.getMessage().getContent());
    }

    @Test
    public void testRecent() {
        Result result = messageService.recent();
        assertNotNull(result);
        assertEquals(2, result.getMessageCount());
    }

}
