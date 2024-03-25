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
@CrossOrigin("*")
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




    /*************** AVAMCEE ****************/
    @GetMapping("/getCommentsForPost/{id}")
    public List<CommentPost> getCommentsForPost(@PathVariable("id")Long postId) {
        return service.getCommentsForPost(postId);
    }

    @GetMapping("/getReplies/{id}")
    public List<CommentPost> getReplies(@PathVariable("id") Long commentId) {
        return service.getReplies(commentId);
    }

    @PostMapping("/addCommenttoPost/{id}")
    public CommentPost addCommenttoPost(@RequestBody CommentPost comment,@PathVariable("id") Long IdPost) {return service.addCommenttoPost(comment, IdPost);}
    @PostMapping("/addCommentToComment/{idComm}")
    public CommentPost addCommentToComment(@RequestBody CommentPost comment,@PathVariable("idComm") Long idComm) {
        return service.addCommentToComment(comment, idComm);
    }

    @PutMapping("/updatePostRating/{postId}/{nb_etoil}")
    public void updatePostRating(@PathVariable("postId") Long postId,@PathVariable("nb_etoil") int nb_etoil) {
        service.updatePostRating(postId, nb_etoil);
    }

    //apre authentification
    @PostMapping("/UserAddPost/{id}")
    public String UserAddPost(@RequestBody Post post, @PathVariable("id")Long idUser) {
        return service.UserAddPost(post, idUser);
    }
    @PostMapping("/UseraddComment/{IdPost}/{idUser}")
    public CommentPost UseraddComment(@RequestBody CommentPost comment,@PathVariable("IdPost") Long IdPost,@PathVariable("idUser") Long idUser) {
        return service.UseraddComment(comment, IdPost, idUser);
    }
    @PostMapping("/UseraddCommentToComment/{idComm}/{idUser}")
    public CommentPost UseraddCommentToComment(@RequestBody CommentPost comment, @PathVariable("idComm")Long idComm, @PathVariable("idUser") Long idUser) {
        return service.UseraddCommentToComment(comment, idComm, idUser);
    }

    @PostMapping("/addReacttoPost/{IdPost}/{idUser}")
    public ReactPost addReacttoPost(@RequestBody ReactPost react, @PathVariable("IdPost")Long IdPost, @PathVariable("idUser") Long idUser) {
        return service.addReacttoPost(react, IdPost, idUser);
    }

    @PostMapping("/addReactToComment/{idcomment}/{idUser}")
    public ReactPost addReactToComment(@RequestBody ReactPost react,@PathVariable("idcomment") Long idcomment,@PathVariable("idUser") Long idUser) {
        return service.addReactToComment(react, idcomment, idUser);
    }



}
