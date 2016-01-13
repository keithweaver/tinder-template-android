package com.weaverprojects.opentinder.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by keithweaver on 16-01-08.
 */
public class Chat implements Serializable{
    String chatId;
    String userId;
    String firstName;
    String lastName;
    String imageURL;
    ArrayList<Message> messages;

    public Chat(String chatId, String userId, String firstName, String lastName, String imageURL, ArrayList<Message> messages) {
        this.chatId = chatId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageURL = imageURL;
        this.messages = messages;
    }

    public String getChatId() {
        return chatId;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }
}
