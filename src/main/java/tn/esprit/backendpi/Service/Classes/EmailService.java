package tn.esprit.backendpi.Service.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendPasswordResetEmail(String email, String resetLink) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setSubject("Password Reset");
        mail.setText("Please click the link below to reset your password:\n" + resetLink);

        try {
            javaMailSender.send(mail);
        } catch (MailException e) {
            // Log error or handle accordingly
            e.printStackTrace();
        }
    }

    public void sendQuizEmail(String recipientEmail, String quizContent, String contentt) {
        try {
            // Création de l'objet SimpleMailMessage
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("hamayari71@gmail.com"); // Remplacez par l'adresse e-mail de l'expéditeur
            message.setTo(recipientEmail); // Adresse e-mail du destinataire
            message.setSubject("Quiz sur la collocation"); // Sujet de l'e-mail

            // Concaténer le contenu personnalisé avec le contenu du quiz
            String emailContent = quizContent + "\n\n" + contentt;
            message.setText(emailContent); // Contenu de l'e-mail (quiz + contenu personnalisé)

            // Envoi de l'e-mail
            javaMailSender.send(message);

            System.out.println("E-mail envoyé avec succès à : " + recipientEmail);
        } catch (Exception e) {
            System.out.println("Erreur lors de l'envoi de l'e-mail : " + e.getMessage());
        }
    }
}
