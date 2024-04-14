package tn.esprit.backendpi.Service.Classes;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatGPTService {

    // URL de l'API ChatGPT
    private static final String CHAT_GPT_API_URL = "https://api.openai.com/v1/completions";
    // Clé API
    private final String API_KEY = "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";

    // Méthode pour générer des questions basées sur un thème spécifié et un modèle donné
    public List<String> generateQuestions(String theme, int numQuestions, String model) throws IOException {
        // Création d'un client HTTP
        HttpClient httpClient = HttpClients.createDefault();
        // Création d'une requête POST
        HttpPost httpPost = new HttpPost(CHAT_GPT_API_URL);

        // Ajout de l'en-tête d'autorisation avec la clé API
        httpPost.setHeader("Authorization", "Bearer " + API_KEY);
        // Ajout de l'en-tête Content-Type
        httpPost.setHeader("Content-Type", "application/json");

        // Construction du corps de la requête
        String requestBody = "{\"prompt\": \"" + theme + "\", \"numQuestions\": " + numQuestions + ", \"model\": \"" + model + "\"}";
        httpPost.setEntity(new StringEntity(requestBody));

        // Exécution de la requête et récupération de la réponse
        HttpResponse response = httpClient.execute(httpPost);

        // Traitement de la réponse
        List<String> questions = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        while ((line = reader.readLine()) != null) {
            questions.add(line);
        }

        return questions;
    }
}
