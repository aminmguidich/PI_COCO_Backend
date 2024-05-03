package tn.esprit.backendpi.Service.Classes;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Security.Jwt.JwtUtils;
import tn.esprit.backendpi.Security.Services.UserDetailsImpl;
import tn.esprit.backendpi.Security.Services.UserDetailsServiceImpl;

@Service
public class ForgotPasswordService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private EmailService emailService;

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    JavaMailSender javaMailSender;

    public void sendPasswordResetEmail(String username) throws MessagingException {
        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);
        String userDetailsEmail = userDetails.getEmail();
        // Generate a password reset token
        String token = jwtUtils.generateTokenFromUsername(username);

        // Send email containing password reset link with token
        String resetLink = "http://localhost:4200/reset-password?token=" + token;
        emailService.sendPasswordResetEmail(userDetailsEmail, resetLink,javaMailSender);
    }
}
