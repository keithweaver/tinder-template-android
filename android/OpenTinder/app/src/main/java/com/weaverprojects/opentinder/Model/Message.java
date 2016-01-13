package com.weaverprojects.opentinder.Model;

import java.io.Serializable;

/**
 * Created by keithweaver on 16-01-08.
 */
public class Message implements Serializable{
    String messageId;
    long timeStamp;
    String message;
    String sentBy;

    public Message(String messageId, long timeStamp, String message, String sentBy) {
        this.messageId = messageId;
        this.timeStamp = timeStamp;
        this.message = message;
        this.sentBy = sentBy;
    }

    public String getMessageId() {
        return messageId;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getSentBy() {
        return sentBy;
    }
}
