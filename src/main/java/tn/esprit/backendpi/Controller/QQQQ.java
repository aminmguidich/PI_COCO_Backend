package tn.esprit.backendpi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.backendpi.Entities.Question;
import tn.esprit.backendpi.Service.Classes.EmailService;
import tn.esprit.backendpi.Service.Classes.QuestionService;
import tn.esprit.backendpi.Service.Classes.QuizService;

import java.util.List;

@RestController
@RequestMapping("/qqq")
@CrossOrigin("*")
public class QQQQ {
    private final String quizFormLink = "https://docs.google.com/forms/d/e/1FAIpQLSdLIVvyyOn7AKszrWB9y5EPw3QzK1_NAdqYO6Mb5_ZjlMW0Dg/viewform?usp=sf_link";

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private EmailService emailService;


    @GetMapping("/questions")
    public ResponseEntity<?> testQuestionService() {
        // Appeler des méthodes du service QuestionService pour tester
        return ResponseEntity.ok(questionService.getAllQuestions());
    }

    @GetMapping("/sendEmail")
    public ResponseEntity<String> testEmailService() {
        // Récupérer les questions de la base de données
        List<Question> questions = questionService.getAllQuestions();

        // Formatter les questions dans une chaîne de caractères
        StringBuilder quizContentBuilder = new StringBuilder();
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            quizContentBuilder.append("<h3>Question ").append(i + 1).append("</h3>");
            quizContentBuilder.append("<p>").append(question.getText()).append("</p>");
            // Ajoutez d'autres informations de la question si nécessaire
        }
        String quizContent = quizContentBuilder.toString();

        // Contenu personnalisé à inclure dans l'e-mail
        String customContent = "Voici les questions pour votre quiz sur la collocation.";

        // Envoyer l'e-mail avec les questions récupérées et le contenu personnalisé
        String recipientEmail = "eyayari123@gmail.com";
        emailService.sendQuizEmail(recipientEmail, quizContent, customContent);

        return ResponseEntity.ok("E-mail sent successfully to: " + recipientEmail);
    }


    @GetMapping("/sendQuiz")
    public ResponseEntity<String> testQuizService() {
        // Appeler une méthode du service QuizService pour tester l'envoi de quiz par e-mail
        quizService.sendQuizByEmail("eyayari123@gmail.com");
        return ResponseEntity.ok("Quiz sent successfully");
    }
}

