package tn.esprit.backendpi.Service.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenTriviaAPIService {

    private static final String API_URL = "https://opentdb.com/api.php";

    @Autowired
    private RestTemplate restTemplate;

    public String getQuestionsFromAPI(int numberOfQuestions, String subject) {
        String urlWithParams = API_URL + "?amount=" + numberOfQuestions + "&category=" + subject;
        return restTemplate.getForObject(urlWithParams, String.class);
    }
}
