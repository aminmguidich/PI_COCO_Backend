package tn.esprit.backendpi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.backendpi.Entities.Chat;
import tn.esprit.backendpi.Entities.ChatMessage;
import tn.esprit.backendpi.Entities.Enum.MessageType;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class ChatController {

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public Chat chat(@DestinationVariable String roomId , Chat message){
        System.out.println(message);
        return new Chat(MessageType.CHAT,message.getMessage(), message.getUser());
    }

  /*  @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage
    ) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }*/
}
