package ar.com.springollamaiaanddocs.service;

import ar.com.springollamaiaanddocs.dto.request.PrompRequestDto;
import ar.com.springollamaiaanddocs.exceptions.ResponseNotExistsException;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OllamaServiceImpl implements OllamaService{

    @Autowired
    private OllamaChatModel ollamaModel;

    //metodo que genera un resultado por el prompt que se envie
    @Override
    public String generateAMessageResult(PrompRequestDto prompt){
        OllamaOptions options = new OllamaOptions();
        //modelo de nuestro llama3.2
        options.setModel("llama3.2");

        //creamos la respuesta para el prompt
        ChatResponse response = ollamaModel.call(new Prompt(prompt.getMessage(), options));

        if(response == null)
            throw new ResponseNotExistsException("Error: the prompt not exists");

        return response.getResult().getOutput().getText();
    }


}
