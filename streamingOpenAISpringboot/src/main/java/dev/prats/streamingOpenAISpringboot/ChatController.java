package dev.prats.streamingOpenAISpringboot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @PostMapping("/chat")
    public String chat(@RequestParam String message) {
        // Replace this with your AI model integration logic
        if (message.isEmpty()) {
            return "Please provide a message.";
        }
        return chatClient.prompt().user(message).call().content();
    }
//     i used stream() here to get streaming data like stream of messages

    @GetMapping("/stream")
    public Flux<String> chatWithStream(@RequestParam String message){
        return chatClient.prompt().user(message).stream().content();
    }
}
