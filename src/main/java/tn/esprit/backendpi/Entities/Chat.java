package tn.esprit.backendpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.backendpi.Entities.MessageType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
public class Chat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChat;
     @Enumerated(EnumType.STRING)
     MessageType type;
     String message;
    String sender;
     @ToString.Exclude
    @JsonIgnore // To ignore serialization of this field
    @ManyToOne
    User user;


    public Chat(MessageType type, String message, String sender) {
        this.type = type;
        this.message = message;
        this.sender = sender;
    }

    public Chat(MessageType messageType, String message, User user) {
        this.message=message;
        this.type=messageType;

        this.user=user;
    }

}
