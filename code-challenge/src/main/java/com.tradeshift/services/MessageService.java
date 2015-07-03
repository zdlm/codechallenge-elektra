package com.tradeshift.services;

import com.tradeshift.model.Content;
import com.tradeshift.model.Message;
import com.tradeshift.model.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MessageService {

    @Autowired
    ContentService contentService;

    public MessageService() {
    }

    public MessageService(ContentService contentService) {
        this.contentService = contentService;
    }

    public Message saveMessage(String name) {
        Content content = new Content();
        content.setContent("hello " + name);
        contentService.insertData(content);
        Message message = new Message(content);
        return message;
    }

    public Result recent() {
        Result result = new Result();
        List<Message> messages = new ArrayList<Message>();
        List<com.tradeshift.domain.Content> contents = contentService.getContentList();
        for (com.tradeshift.domain.Content content : contents) {
            Content model = new Content();
            model.setContent(content.getContent());
            Message message = new Message(model);
            messages.add(message);
        }
        int messageCount = contentService.count();
        result.setMessageCount(messageCount);
        if (messages.size() > 0) {
            String lasttMessage = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(contents.get(0).getDateAdded());
            result.setLastMessage(lasttMessage);
        }
        result.setMessages(messages);
        return result;
    }
}
