package tn.esprit.backendpi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.CommentPost;
import tn.esprit.backendpi.Entities.Post;
import tn.esprit.backendpi.Entities.ReactPost;
import tn.esprit.backendpi.Service.Classes.PostService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class PostController {
    PostService service;
    /*********     Post     **********/
    @GetMapping("/retrieveAllPost")
    public List<Post> retrieveAllPost() {return service.retrieveAllPost();}
    @PutMapping("/updatePost")
    public Post updatePost(@RequestBody Post p) {return service.updatePost(p);}
    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post p) {return service.addPost(p);}
    @GetMapping("/retrievePost/{id}")
    public Post retrievePost(@PathVariable("id") long idPost) {return service.retrievePost(idPost);}
    @DeleteMapping("/removePost/{id}")
    public void removePost(@PathVariable("id") long idPost) {service.removePost(idPost);}

    /*********     Comment Post     **********/
    @GetMapping("/retrieveAllCommentPost")
    public List<CommentPost> retrieveAllCommentPost() {return service.retrieveAllCommentPost();}
    @PutMapping("/updateCommentPost")
    public CommentPost updateCommentPost(@RequestBody CommentPost c) {return service.updateCommentPost(c);}
    @PostMapping("/addCommentPost")
    public CommentPost addCommentPost(@RequestBody CommentPost c) {return service.addCommentPost(c);}
    @GetMapping("/retrieveCommentPost/{id}")
    public CommentPost retrieveCommentPost(@PathVariable("id") long idCommentPost) {return service.retrieveCommentPost(idCommentPost);}
    @DeleteMapping("/removeCommentPost/{id}")
    public void removeCommentPost(@PathVariable("id") long idCommentPost) {service.removeCommentPost(idCommentPost);}

    /*********     React Post     **********/
    @GetMapping("/retrieveAllReactPost")
    public List<ReactPost> retrieveAllReactPost() {return service.retrieveAllReactPost();}
    @PutMapping("/updateReactPost")
    public ReactPost updateReactPost(@RequestBody ReactPost r) {return service.updateReactPost(r);}
    @PostMapping("/addReactPost")
    public ReactPost addReactPost(@RequestBody ReactPost r) {return service.addReactPost(r);}
    @GetMapping("/retrieveReactPost/{id}")
    public ReactPost retrieveReactPost(@PathVariable("id") long idReactPost) {return service.retrieveReactPost(idReactPost);}
    @DeleteMapping("/removeReactPost/{id}")
    public void removeReactPost(@PathVariable("id") long idReactPost) {service.removeReactPost(idReactPost);}
}
