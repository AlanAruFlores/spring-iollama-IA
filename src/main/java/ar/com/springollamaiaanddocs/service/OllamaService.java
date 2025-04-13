package ar.com.springollamaiaanddocs.service;

import ar.com.springollamaiaanddocs.dto.request.PrompRequestDto;

public interface OllamaService {
    //metodo que genera un resultado por el prompt que se envie
    String generateAMessageResult(PrompRequestDto prompt);
}
