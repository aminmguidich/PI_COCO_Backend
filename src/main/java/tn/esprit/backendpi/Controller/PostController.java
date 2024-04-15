package tn.esprit.backendpi.Controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.*;
import tn.esprit.backendpi.Service.Classes.PostService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/Post")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
//@CrossOrigin("*")
public class PostController {
    PostService service;
    /*********     Post     **********/

    @PutMapping("/updatePost")
    public Post updatePost(@RequestBody Post p) {return service.updatePost(p);}
    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post p) {return service.addPost(p);}

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


    @PostMapping("/addReacttoPost/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ReactPost addReacttoPost(@RequestBody ReactPost react,@PathVariable("id") Long IdPost) {
        return service.addReacttoPost(react, IdPost);
    }
    /*************** AVAMCEE ****************/

    @GetMapping("/retrieveAllPost")
    public List<Post> retrieveAllPost() {return service.retrieveAllPost();}
    @GetMapping("/retrievePost/{id}")
    public Post retrievePost(@PathVariable("id") long idPost) {return service.retrievePost(idPost);}
    @GetMapping("/MeilleurPost")
    public Post MeilleurPost() {
        return service.MeilleurPost();
    }
    @GetMapping("/getCommentsForPost/{id}")
    public List<CommentPost> getCommentsForPost(@PathVariable("id")Long postId) {
        return service.getCommentsForPost(postId);
    }
    @GetMapping("/getReplies/{id}")
    public List<CommentPost> getReplies(@PathVariable("id") Long commentId) {
        return service.getReplies(commentId);
    }
    @GetMapping("/getReactsForPost/{postId}")
    public List<ReactPost> getReactsForPost(@PathVariable("postId") Long postId) {
        return service.getReactsForPost(postId);
    }

    @GetMapping("/getReactsForComment/{idComment}")
    public List<ReactPost> getReactsForComment(@PathVariable("idComment") Long idComment) {
        return service.getReactsForComment(idComment);
    }

    //prend current user
    @PostMapping("/AddWithoutBadWord")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String AddWithoutBadWord(@RequestBody Post post) {
        return service.AddWithoutBadWord(post);
    }

    @PostMapping("/addCommenttoPost/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public CommentPost addCommenttoPost(@RequestBody CommentPost comment,@PathVariable("id") Long IdPost) {return service.addCommenttoPost(comment, IdPost);}

    @PostMapping("/addCommentToComment/{idComm}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public CommentPost addCommentToComment(@RequestBody CommentPost comment,@PathVariable("idComm") Long idComm) {
        return service.addCommentToComment(comment, idComm);
    }
    @PutMapping("/updatePostRating/{postId}/{nb_etoil}")
   // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void updatePostRating(@PathVariable("postId") Long postId,@PathVariable("nb_etoil") int nb_etoil) {
        service.updatePostRating(postId, nb_etoil);
    }


    @PostMapping("/addTypeReacttoPost/{IdPost}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ReactPost addTypeReacttoPost(@RequestBody TypeReactPost typereact, @PathVariable("IdPost") Long IdPost) {
        return service.addTypeReacttoPost(typereact, IdPost);
    }

    @PostMapping("/addReactToComment/{idcomment}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ReactPost addReactToComment(@RequestBody TypeReactPost typereact,@PathVariable("idcomment") Long idcomment) {
        return service.addReactToComment(typereact, idcomment);
    }

    @PutMapping("/UpdatereportPost/{postId}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void UpdatereportPost(@PathVariable("postId") Long postId) {
        service.UpdatereportPost(postId);
    }

    @PutMapping("/reportPost/{IdPost}")
    //@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void reportPost(@PathVariable("IdPost")Long IdPost) {
        service.reportPost(IdPost);
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

    @PostMapping("/UseraddReacttoPost/{IdPost}/{idUser}")
    public ReactPost UseraddReacttoPost(@RequestBody ReactPost react, @PathVariable("IdPost")Long IdPost, @PathVariable("idUser") Long idUser) {
        return service.UseraddReacttoPost(react, IdPost, idUser);
    }

    @PostMapping("/UseraddReactToComment/{idcomment}/{idUser}")
    public ReactPost UseraddReactToComment(@RequestBody ReactPost react,@PathVariable("idcomment") Long idcomment,@PathVariable("idUser") Long idUser) {
        return service.UseraddReactToComment(react, idcomment, idUser);
    }



    @PostMapping("/UserAddWithoutBadWord/{idUser}")
    public String UserAddWithoutBadWord(@RequestBody Post post, @PathVariable("idUser") Long idUser) {
        return service.UserAddWithoutBadWord(post, idUser);
    }

    @DeleteMapping("/deletePostByTime")
    public void deletePostByTime() {
        service.deletePostByTime();
    }
}
