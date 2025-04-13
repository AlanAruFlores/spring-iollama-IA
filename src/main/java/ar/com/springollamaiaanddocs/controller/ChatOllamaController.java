package ar.com.springollamaiaanddocs.controller;

import ar.com.springollamaiaanddocs.dto.request.PrompRequestDto;
import ar.com.springollamaiaanddocs.dto.response.MessageResponseDto;
import ar.com.springollamaiaanddocs.service.OllamaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatOllamaController {

    private final OllamaService ollamaService;

    @PostMapping("/")
    public ResponseEntity<MessageResponseDto> postProptMessage(@RequestBody PrompRequestDto prompt) {
        String chatResponse = ollamaService.generateAMessageResult(prompt);
        return ResponseEntity.ok(new MessageResponseDto(chatResponse));
    }
}
