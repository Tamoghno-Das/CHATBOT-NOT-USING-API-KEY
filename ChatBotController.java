package com.example.controller;

import com.example.Dto.ChatRequest;
import com.example.exception.QuestionNotFoundException;
import com.example.service.ChatbotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ChatBotController {
    private final ChatbotService chatbotService;

    public ChatBotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @PostMapping
    public ResponseEntity<String> chat(@RequestBody ChatRequest request) {
        String username = request.getUsername();
        String question = request.getQuestion();

        if (question.equalsIgnoreCase("bye")) {
            return ResponseEntity.ok("Goodbye, " + username.toUpperCase() + "! Thanks for using.");
        }

        try {
            String answer = chatbotService.getResponse(question);
            return ResponseEntity.ok(answer);
        } catch (QuestionNotFoundException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

}
