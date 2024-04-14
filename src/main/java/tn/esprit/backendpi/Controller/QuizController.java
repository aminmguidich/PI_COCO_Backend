package tn.esprit.backendpi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.backendpi.Entities.Question;
import tn.esprit.backendpi.Entities.Quiz;
import tn.esprit.backendpi.Service.Classes.EmailService;

import java.io.IOException;
import java.util.List;

    @RestController
    public class QuizController {

        @Autowired
        private EmailService emailService;


        @GetMapping("/sendQuizByEmail")
        public ResponseEntity<String> sendQuizByEmail() {
            String recipientEmail = "eyayari123@gmail.com"; // Adresse e-mail du destinataire
            String quizFormLink = "https://docs.google.com/forms/d/e/1FAIpQLSc-9bgjfxmU18PWXvEtjH_DyY51roGYTv_yJ7iSIMcv1HnM-Q/viewform?usp=sf_link"; // Lien vers votre formulaire Google

            // Construire le contenu de l'e-mail
            String emailContent = "Bonjour,\n\nVeuillez remplir ce quiz : " + quizFormLink;

            // Envoyer l'e-mail
            emailService.sendQuizEmail(recipientEmail, "Quiz sur la collocation", emailContent);

            return ResponseEntity.ok("E-mail sent successfully to: " + recipientEmail);
        }
       }


