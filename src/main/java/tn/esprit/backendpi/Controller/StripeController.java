package tn.esprit.backendpi.Controller;

import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import tn.esprit.backendpi.Entities.CheckoutPayment;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class
StripeController {

    private final String stripeSecretKey = "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";
    private final String stripePublicKey = "your_stripe_public_key";

    @PostMapping("/payment")
    public ResponseEntity<?> createCheckoutSession(@RequestBody Map<String, Object> requestBody) {
        try {
            Stripe.apiKey = stripeSecretKey;

            Map<String, Object> params = new HashMap<>();
            params.put("payment_method_types", List.of("card"));
            params.put("line_items", requestBody.get("items"));
            params.put("mode", "payment");
            params.put("success_url", "http://localhost:4200/success"); // Replace with your success URL
            params.put("cancel_url", "http://localhost:4200/cancel"); // Replace with your cancel URL

            Session session = Session.create(params);

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("sessionId", session.getId());

            return ResponseEntity.ok(responseData);
        } catch (StripeException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating checkout session");
        }
    }
}
