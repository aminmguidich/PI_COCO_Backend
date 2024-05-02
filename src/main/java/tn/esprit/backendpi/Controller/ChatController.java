package tn.esprit.backendpi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.backendpi.Entities.Chat;
import tn.esprit.backendpi.Entities.ChatMessage;
import tn.esprit.backendpi.Entities.MessageType;
import tn.esprit.backendpi.Entities.User;
import tn.esprit.backendpi.Repository.ChatRepository;
import tn.esprit.backendpi.Repository.UserRepository;

import java.nio.file.attribute.UserPrincipal;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/ws")
@AllArgsConstructor
@Controller
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class ChatController {
    //@Autowired
    UserRepository userRepository;
    @Autowired
    ChatRepository chatRepository;

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Chat chat(@DestinationVariable String roomId , Chat message ){
      //  System.out.println(message);
      //  message.setType(MessageType.CHAT);
       // Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
      //  UserPrincipal userPrincipal=(UserPrincipal) authentication;
      //  User loggedInUser=userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        User loggedInUser=userRepository.findByUsername(message.getSender()).orElse(null);
       // System.out.println("user:"+loggedInUser);
      //  message.setUser(loggedInUser.get());
        Chat chat = new Chat();
        chat.setUser(loggedInUser);
        chat.setMessage(message.getMessage());
        chat.setType(MessageType.CHAT);
        chat.setSender(message.getSender());
        chatRepository.save(chat);
        System.out.println(chat);
        //return new Chat(MessageType.CHAT,message.getMessage(), message.getUser());
        return chat;
    }


    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Chat sendMessageRoom(
            @Payload Chat chatMessage
    ) {
        return chatMessage;
    }

   /* @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Chat addUser(
            @Payload Chat chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        User loggedInUser=userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        System.out.println(loggedInUser);
        if (loggedInUser != null) {
        chatMessage.setUser(loggedInUser); // Add current user to the message
        }
        // Save the chat message to the database
        chatRepository.save(chatMessage);
        System.out.println(chatMessage);

        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getUser().getUsername());
        return chatMessage;
    }

   */
}
