package tn.esprit.backendpi.Service.Classes;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import tn.esprit.backendpi.Service.Interfaces.IEmailService;

@Component
public class EmailServiceImpl implements IEmailService {
    @Autowired
    private JavaMailSender emailSender;
    public void sendSimpleMessage(String to, String subject, String htmlText) throws MessagingException {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        helper.setText(htmlText, true); // Use this or above line.
        helper.setFrom("noreply@baeldung.com");
        helper.setTo(to);
        helper.setSubject(subject);
        emailSender.send(mimeMessage);
    }
}
