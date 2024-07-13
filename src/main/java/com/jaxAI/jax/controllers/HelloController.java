package com.jaxAI.jax.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {


    private ChatClient chatClient;

    public HelloController(ChatClient.Builder chatClientBuilder){
        this.chatClient = chatClientBuilder.build();
    }



    @GetMapping("/hello")
    public List<Generation> hello(){
        String message = "Hello. Who are you?";
        PromptTemplate promptTemplate = new PromptTemplate(message);
        Prompt prompt = promptTemplate.create();
        ChatClient.ChatClientRequest.CallPromptResponseSpec responseSpec = chatClient.prompt(prompt).call();
        return responseSpec.chatResponse().getResults();

    }

}
