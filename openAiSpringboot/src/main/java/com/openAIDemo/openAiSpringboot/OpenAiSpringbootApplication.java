package com.openAIDemo.openAiSpringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OpenAiSpringbootApplication {

	@Value("${OPEN_AI_KEY}")
	private String openAiKey;

	public static void main(String[] args) {
		SpringApplication.run(OpenAiSpringbootApplication.class, args);
		System.err.println(" 🧑🏻‍💻Springboot OpenAi Application Started 🤖");
//		System.out.println("OpenAI Key: " + openAiKey);

	}

	@Bean
	public RestTemplate restTemplate(){
		RestTemplate template = new RestTemplate();
		template.getInterceptors().add(( (request, body, execution) -> {
			request.getHeaders().add("Authorization", "Bearer "+openAiKey);
			return execution.execute(request,body);
		}));
		return template;
	}

}


//