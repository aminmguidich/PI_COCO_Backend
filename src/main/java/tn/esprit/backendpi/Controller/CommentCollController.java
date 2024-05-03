package tn.esprit.backendpi.Controller;
import  lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.AnnouncementCarpooling;
import tn.esprit.backendpi.Entities.CommentCol;
import tn.esprit.backendpi.Service.Classes.CommandItemServiceImpl;
import tn.esprit.backendpi.Service.Classes.CommentCollImplService;
import tn.esprit.backendpi.Service.Interfaces.IAnnCarpoolingService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/CommentColl")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class CommentCollController {


    @Autowired
     CommentCollImplService commentCollImplService;

    @PostMapping("/addCommentToannooucement")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public CommentCol addComment(@RequestBody CommentCol comment) {
        System.out.println(comment.getUsername());
        return commentCollImplService.addComment(comment);
    }
    @PutMapping("/updateCommentAnn/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public CommentCol updateComment(@PathVariable Long id,@RequestBody CommentCol newcomment) {
        return commentCollImplService.updateComment(id, newcomment);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void removeComment(@PathVariable Long id) {
        commentCollImplService.removeComment(id);
    }
    @GetMapping("/allCommentsColl")
    public List<CommentCol> retrieveComments() {
        return commentCollImplService.retrieveComments();
    }
}
