package tn.esprit.backendpi.Service.Classes;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CODE_LENGTH = 6;
    public static String generateVerificationCode() {
        SecureRandom random = new SecureRandom();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(randomIndex));
        }
        return code.toString();
    }
    public void sendVerificationCodeByEmail(String email, String verificationCode,String username, JavaMailSender javaMailSender) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setSubject("Verification Code for Your New Account");
        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Account Activation</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            background-color: #f4f4f4;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 10px auto;\n" +
                "            padding: 20px;\n" +
                "            background-color: #fff;\n" +
                "            border-radius: 5px;\n" +
                "            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n" +
                "        }\n" +
                "        .activation-code {\n" +
                "            font-size: 36px;\n" +
                "            text-align: center;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        .activation-link {\n" +
                "            display: block;\n" +
                "            text-align: center;\n" +
                "            margin-top: 20px;\n" +
                "        }\n" +
                "        .activation-link a {\n" +
                "            display: inline-block;\n" +
                "            padding: 10px 20px;\n" +
                "            background-color: #007bff;\n" +
                "            color: #fff;\n" +
                "            text-decoration: none;\n" +
                "            border-radius: 5px;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <h1>Account Activation</h1>\n" +
                "    <p class=\"greeting\">Hello, "+username+"</p>\n" +
                "    <p>Thank you for signing up! Please use the following verification code to activate your account:</p>\n" +
                "    <div class=\"activation-code\">" + verificationCode + "</div>\n" +
                "    <div class=\"activation-link\">\n" +
                "        <a href=\"http://localhost:4200/verify\" target=\"_blank\">Activate your account</a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        helper.setText(htmlContent, true);

        javaMailSender.send(message);
    }

    public void sendPasswordResetEmail(String email, String resetLink, JavaMailSender javaMailSender) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(email);
        helper.setSubject("Password Reset");

        String htmlContent = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Password Reset</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            background-color: #f4f4f4;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 10px auto;\n" +
                "            padding: 20px;\n" +
                "            background-color: #fff;\n" +
                "            border-radius: 5px;\n" +
                "            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n" +
                "        }\n" +
                "        .reset-link {\n" +
                "            display: block;\n" +
                "            text-align: center;\n" +
                "            margin-top: 20px;\n" +
                "        }\n" +
                "        .reset-link a {\n" +
                "            display: inline-block;\n" +
                "            padding: 10px 20px;\n" +
                "            background-color: #007bff;\n" +
                "            color: #fff;\n" +
                "            text-decoration: none;\n" +
                "            border-radius: 5px;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <h1>Password Reset</h1>\n" +
                "    <p>You requested to reset your password. Please click the button below to proceed:</p>\n" +
                "    <div class=\"reset-link\">\n" +
                "        <a href=\"" + resetLink + "\" target=\"_blank\">Reset Password</a>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        helper.setText(htmlContent, true);

        javaMailSender.send(message);
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



    // Add constructor for JavaMailSender injection
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // true indicates multipart message
            helper.setFrom("saidbrahmi202@outlook.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            javaMailSender.send(message);
        } catch (MailException | MessagingException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }


}
