package com.openAIDemo.openAiSpringboot.controller;

import com.openAIDemo.openAiSpringboot.model.ChatCompletionRequest;
import com.openAIDemo.openAiSpringboot.model.ChatCompletionResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class MainController {

    private RestTemplate restTemplate ;

    @PostMapping("/prompt")
    public String getOpenAiResponse(@RequestBody String prompt){
        ChatCompletionRequest chatCompletionRequest = new ChatCompletionRequest("gpt-4o", prompt);

        ChatCompletionResponse response = restTemplate.postForObject("https://api.openai.com/v1/chat/completions",chatCompletionRequest, ChatCompletionResponse.class);

        return response.getChoices().get(0).getMessage().getContent();
    }
}
