package com.cauandev.budgeting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.openai.api.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "GEMINI_API_KEY", matches = ".+")
class GeminiChatModelIT {
    @Autowired
    OpenAiApi openAiApi;

    @Test
    void should_receiveResponse_when_chatModelIsCalled() {
        var options = OpenAiChatOptions.builder()
                .model("gemini-3.6-flash")
                .temperature(0.8)
                .responseFormat(ResponseFormat.builder().type(ResponseFormat.Type.TEXT).build())
                .build();

        var chatModel = OpenAiChatModel.builder()
                .openAiApi(openAiApi)
                .defaultOptions(options)
                .build();

        var response = chatModel.call("Gere um registro de budgeting, com descrição de gasto, valor em reais e local");

        assertThat(response).isNotEmpty();
        System.out.println(response);
    }
}
