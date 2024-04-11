package tn.esprit.backendpi.Entities;

import lombok.*;
import tn.esprit.backendpi.Entities.Enum.MessageType;

@Data
@AllArgsConstructor
public class Chat {
    // @Enumerated(EnumType.STRING)
    private MessageType type;
    String message;
    String user;
}
