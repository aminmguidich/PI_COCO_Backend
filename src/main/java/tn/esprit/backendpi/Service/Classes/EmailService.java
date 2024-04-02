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
}