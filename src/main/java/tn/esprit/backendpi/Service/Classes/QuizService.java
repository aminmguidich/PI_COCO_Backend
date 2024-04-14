package tn.esprit.backendpi.Service.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuizService {

    private static final int MIN_QUESTIONS_REQUIRED_FOR_QUIZ = 5; // Nombre minimum de questions requis pour composer un quiz
    private static final int NUM_QUESTIONS_IN_QUIZ = 3; // Nombre de questions à inclure dans le quiz
    private static final String quizFormLink = "https://docs.google.com/forms/d/e/1FAIpQLSdLIVvyyOn7AKszrWB9y5EPw3QzK1_NAdqYO6Mb5_ZjlMW0Dg/viewform?usp=sf_link";

    @Autowired
    private QuestionService questionService;

    @Autowired
    private EmailService emailService;

    public void sendQuizByEmail(String recipientEmail) {
        // Récupérer toutes les questions de la base de données
        List<Question> allQuestions = questionService.getAllQuestions();

        // Sélectionner les questions à inclure dans le quiz
        List<Question> selectedQuestions = selectQuestionsForQuiz(allQuestions);

        // Composer le contenu du quiz à partir des questions sélectionnées
        String quizContent = composeQuizContent(selectedQuestions);

        // Définir le contenu de l'e-mail
        String emailContent = "Bonjour,\n\nVeuillez remplir ce quiz : " + quizFormLink;

        // Envoyer l'e-mail avec le contenu du quiz et le contenu de l'e-mail
        emailService.sendQuizEmail(recipientEmail, quizContent, emailContent);
    }

    private List<Question> selectQuestionsForQuiz(List<Question> allQuestions) {
        List<Question> selectedQuestions = new ArrayList<>();
        if (allQuestions.size() < MIN_QUESTIONS_REQUIRED_FOR_QUIZ) {
            throw new IllegalArgumentException("Pas assez de questions disponibles pour composer le quiz.");
        }
        Collections.shuffle(allQuestions);
        for (int i = 0; i < NUM_QUESTIONS_IN_QUIZ; i++) {
            selectedQuestions.add(allQuestions.get(i));
        }
        return selectedQuestions;
    }

    private String composeQuizContent(List<Question> questions) {
        StringBuilder contentBuilder = new StringBuilder();
        contentBuilder.append("<h2>Quiz sur la collocation</h2>");
        contentBuilder.append("<p>Merci de répondre au quiz suivant pour évaluer votre compatibilité avec la collocation.</p>");
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            contentBuilder.append("<h3>Question ").append(i + 1).append("</h3>");
            contentBuilder.append("<p>").append(question.getText()).append("</p>");


        }
        contentBuilder.append("<p>Après avoir répondu au quiz, votre score sera calculé automatiquement.</p>");
        contentBuilder.append("<p>Merci et bonne chance !</p>");
        return contentBuilder.toString();
    }
}
