package com.tradeshift;

import com.tradeshift.model.Message;
import com.tradeshift.model.Result;
import com.tradeshift.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by zhangleo on 09/06/15.
 */


@Path("/messages")
public class MessageResource {

    @Autowired
    private MessageService messageService;

    public MessageResource() {
    }

    public MessageResource(MessageService messageService) {
        this.messageService = messageService;
    }

    @POST
    @Path("/names/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message saveName(@PathParam("name") String name) {
        return messageService.saveMessage(name);
    }

    @GET
    @Path("/recent")
    @Produces(MediaType.APPLICATION_JSON)
    public Result recent() {
        return messageService.recent();
    }
}