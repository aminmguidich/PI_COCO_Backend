package tn.esprit.backendpi.Service.Classes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Security.Jwt.JwtUtils;
import tn.esprit.backendpi.Security.Services.UserDetailsImpl;
import tn.esprit.backendpi.Security.Services.UserDetailsServiceImpl;


@Service
public class ResetPasswordService {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void resetPassword(String token, String newPassword) {
        // Extract username from token
        String usernameFromJwtToken = jwtUtils.getUserNameFromJwtToken(token);

        // Load user details by username
        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(usernameFromJwtToken);

        // Get the user entity from the loaded UserDetails
        User user = userRepository.findByUsername(usernameFromJwtToken)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        // Encode the new password
        String encodedPassword = passwordEncoder.encode(newPassword);

        // Update user's password with the encoded password
        user.setPassword(encodedPassword);

        // Save the updated user in the database
        userRepository.save(user);
    }
}