package com.tradeshift;

import com.tradeshift.model.Content;
import com.tradeshift.model.Message;
import com.tradeshift.model.Result;
import com.tradeshift.services.MessageService;
import com.tradeshift.services.MessageServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by zhangleo on 19/06/15.
 */
public class MessageResourceTest {
    @Mock
    private static MessageService messageService;

    private static Content content;
    private static Message message;
    private static Result result;

    @InjectMocks
    MessageResource messageResource = new MessageResource(messageService);

    @BeforeClass
    public static void SetUp(){
        messageService = mock(MessageServiceImpl.class);

        content = new Content();
        content.setContent("test");
        message = new Message();
        message.setMessage(content);

        result = new Result();
        result.setMessageCount(1);

        when(messageService.saveMessage("test")).thenReturn(message);
        when(messageService.recent()).thenReturn(result);

    }

    @Test
    public void testSaveMessage(){
        Message testMessage = messageResource.saveName("test");

        assertNotNull(testMessage);
        assertEquals("test",testMessage.getMessage().getContent());

    }

    @Test
    public void testRecent(){
        Result testResult = messageResource.recent();

        assertNotNull(testResult);
        assertEquals(1,result.getMessageCount());
    }
}
