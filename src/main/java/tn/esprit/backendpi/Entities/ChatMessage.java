package tn.esprit.backendpi.Entities;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import tn.esprit.backendpi.Entities.Enum.MessageType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

   // @Enumerated(EnumType.STRING)
    private MessageType type;

    private String content;
    private String sender;
}
