package tn.esprit.backendpi.Payload.Request;

public class ForgotPasswordRequest {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.username = email;
    }
}
