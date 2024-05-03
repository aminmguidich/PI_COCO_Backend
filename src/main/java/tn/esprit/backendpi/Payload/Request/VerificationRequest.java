package tn.esprit.backendpi.Payload.Request;

import lombok.Getter;

@Getter
public class VerificationRequest {
    private String verificationCode;

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}

