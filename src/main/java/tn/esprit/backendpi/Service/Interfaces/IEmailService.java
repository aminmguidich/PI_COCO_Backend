package tn.esprit.backendpi.Service.Interfaces;

import jakarta.mail.MessagingException;

public interface IEmailService {
    void sendSimpleMessage( String to, String subject, String text) throws MessagingException;

}
