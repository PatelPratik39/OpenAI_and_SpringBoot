package com.openAIDemo.openAiSpringboot.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ChatCompletionRequest {

    private String model;
    private List<ChatMessage> messages;
    private int max_tokens=150; // set the threshold limit of tokens

    public ChatCompletionRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<ChatMessage>();
        this.messages.add(new ChatMessage("user", prompt));
    }
}
