package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.CommentPost;
import tn.esprit.backendpi.Entities.Post;
import tn.esprit.backendpi.Entities.ReactPost;

import java.util.List;

public interface IPost {

    /*********     Post     **********/
    List<Post> retrieveAllPost();

    Post updatePost(Post p);

    Post addPost(Post p);

    Post retrievePost(long idPost);

    void removePost(long idPost);


    /*********     Comment Post     **********/
    List<CommentPost> retrieveAllCommentPost();

    CommentPost updateCommentPost(CommentPost c);

    CommentPost addCommentPost(CommentPost c);

    CommentPost retrieveCommentPost(long idCommentPost);

    void removeCommentPost(long idCommentPost);


    /*********     React Post     **********/
    List<ReactPost> retrieveAllReactPost();

    ReactPost updateReactPost(ReactPost r);

    ReactPost addReactPost(ReactPost r);

    ReactPost retrieveReactPost(long idReactPost);

    void removeReactPost(long idReactPost);


    /******* AVANCEE ******/

    List<CommentPost> getCommentsForPost(Long postId);

    String UserAddPost(Post post, Long idUser) ;
    CommentPost UseraddComment(CommentPost comment ,Long IdPost, Long idUser) ;
    CommentPost addCommentToComment(CommentPost comment, Long idComm, Long idUser);
     ReactPost addReacttoPost(ReactPost react , Long IdPost, Long idUser);
     ReactPost addReactToComment(ReactPost react ,Long idcomment , Long idUser) ;


    }