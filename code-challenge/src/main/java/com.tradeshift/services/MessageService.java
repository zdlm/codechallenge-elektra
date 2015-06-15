package com.tradeshift.services;

import com.tradeshift.model.Message;
import com.tradeshift.model.Result;

/**
 * Created by zhangleo on 16/06/15.
 */
public interface MessageService {
    public Message saveMessage(String name);

    public Result recent();
}
