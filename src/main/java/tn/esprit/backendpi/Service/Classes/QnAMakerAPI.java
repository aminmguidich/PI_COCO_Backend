package tn.esprit.backendpi.Service.Classes;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import tn.esprit.backendpi.Entities.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QnAMakerAPI {

    private static final String API_URL = "https://votre-api-de-questions-reponses.com/questions";

    // Méthode pour récupérer des questions à partir de l'API de questions-réponses
    public List<Question> getQuestionsBySubject(String subject, int numberOfQuestions) {
        List<Question> questions = new ArrayList<>();

        // Préparation des paramètres de la requête
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Appel à l'API de questions-réponses
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = API_URL + "?subject=" + subject + "&numberOfQuestions=" + numberOfQuestions;
        ResponseEntity<Question[]> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                Question[].class);

        // Traitement de la réponse
        if (response.getStatusCode() == HttpStatus.OK) {
            questions = Arrays.asList(response.getBody());
        } else {
            // Gérer les erreurs de l'API, par exemple journaliser l'erreur ou lancer une exception
            System.out.println("Erreur lors de la récupération des questions de l'API de questions-réponses");
        }

        return questions;
    }
}
