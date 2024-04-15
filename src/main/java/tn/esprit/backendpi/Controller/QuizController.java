package tn.esprit.backendpi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Service.Classes.EmailService;

import java.io.IOException;
import java.util.List;

    @RestController
    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
    public class QuizController {

        @Autowired
        private EmailService emailService;


        @PostMapping("/api/sendQuizByEmail")
        @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
        public ResponseEntity<String> sendQuizByEmail(@RequestBody String recipientEmail) {
            String quizFormLink = "https://docs.google.com/forms/d/e/1FAIpQLSc-9bgjfxmU18PWXvEtjH_DyY51roGYTv_yJ7iSIMcv1HnM-Q/viewform?usp=sf_link"; // Lien vers votre formulaire Google

            // Construire le contenu de l'e-mail
            String emailContent = "Bonjour,\n\nVeuillez remplir ce quiz : " + quizFormLink;

            // Envoyer l'e-mail
            emailService.sendQuizEmail(recipientEmail, "Quiz sur la collocation", emailContent);

            return ResponseEntity.ok("E-mail sent successfully to: " + recipientEmail);
        }
       }

