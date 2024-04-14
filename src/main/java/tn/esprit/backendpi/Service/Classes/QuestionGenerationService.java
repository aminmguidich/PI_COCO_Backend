package tn.esprit.backendpi.Service.Classes;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionGenerationService {

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/completions";
    private static final String OPENAI_API_KEY = "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";

    private final RestTemplate restTemplate;

    public QuestionGenerationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> generateQuestions(String theme, int numQuestions) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + OPENAI_API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\"prompt\": \"" + theme + "\", \"max_tokens\": 100, \"n\": " + numQuestions + "}";
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<OpenAIResponse> responseEntity = restTemplate.exchange(
                OPENAI_API_URL,
                HttpMethod.POST,
                request,
                OpenAIResponse.class
        );

        List<String> questions = new ArrayList<>();
        OpenAIResponse response = responseEntity.getBody();
        if (response != null && response.getChoices() != null) {
            for (OpenAIResponse.Choice choice : response.getChoices()) {
                questions.add(choice.getText());
            }
        }

        return questions;
    }
}
