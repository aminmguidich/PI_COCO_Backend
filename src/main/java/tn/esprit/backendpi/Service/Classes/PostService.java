package tn.esprit.backendpi.Service.Classes;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.*;
import tn.esprit.backendpi.Repository.CommentPostRepository;
import tn.esprit.backendpi.Repository.PostRepository;
import tn.esprit.backendpi.Repository.ReactPostRepository;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Interfaces.IPost;

import java.util.List;
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class PostService implements IPost {
    /*********     Injection     **********/

    CommentPostRepository commentPostRepository;
    PostRepository postRepository;
    ReactPostRepository reactPostRepository;
    UserRepository userRepository;

    /*********     Post     **********/
    @Override
    public List<Post> retrieveAllPost() {return postRepository.findAll();}
    @Override
    public Post updatePost(Post p) {return postRepository.save(p);}
    @Override
    public Post addPost(Post p) {return postRepository.save(p);}

    @Override
    public Post retrievePost(long idPost) {return postRepository.findById(idPost).orElse(null);}
    @Override
    public void removePost(long idPost) {postRepository.deleteById(idPost);}

    /*********     Comment Post     **********/
    @Override
    public List<CommentPost> retrieveAllCommentPost() {return commentPostRepository.findAll();}

    @Override
    public CommentPost updateCommentPost(CommentPost c) {return commentPostRepository.save(c);}
    @Override
    public CommentPost addCommentPost(CommentPost c) {return commentPostRepository.save(c);}
    @Override
    public CommentPost retrieveCommentPost(long idCommentPost) {return commentPostRepository.findById(idCommentPost).orElse(null);}
    @Override
    public void removeCommentPost(long idCommentPost) {commentPostRepository.deleteById(idCommentPost);}

    /*********     React Post     **********/
    @Override
    public List<ReactPost> retrieveAllReactPost() {return reactPostRepository.findAll();}
    @Override
    public ReactPost updateReactPost(ReactPost r) {return reactPostRepository.save(r);}
    @Override
    public ReactPost addReactPost(ReactPost r) {return reactPostRepository.save(r);}
    @Override
    public ReactPost retrieveReactPost(long idReactPost) {return reactPostRepository.findById(idReactPost).orElse(null);}
    @Override
    public void removeReactPost(long idReactPost) {reactPostRepository.deleteById(idReactPost);}




    /*********     AVANCEE     **********/

    @Override
    public List<CommentPost> getCommentsForPost(Long postId) {
        return commentPostRepository.findByPostCommentIdPost(postId);
    }
    @Override
    public String UserAddPost(Post post, Long idUser) {
            post.setUserPost(userRepository.findById(idUser).get());
            postRepository.save(post);
            return "add successfuly" ;
        }

    @Override
    public CommentPost UseraddComment(CommentPost comment, Long IdPost, Long idUser) {
        Post p =   postRepository.findById(IdPost).get();
        User a =   userRepository.findById(idUser).get();
        comment.setPostComment(p);
        comment.setUserCommentPost(a);
        return commentPostRepository.save(comment) ;    }
    @Override
    public CommentPost addCommentToComment(CommentPost comment, Long idComm, Long idUser) {
        CommentPost p =    commentPostRepository.findById(idComm).get();
        User a =   userRepository.findById(idUser).get();
        comment.setPostCoReflexive(p);
        comment.setUserCommentPost(a);
        return commentPostRepository.save(comment) ;
    }

    @Override
    public ReactPost addReacttoPost(ReactPost react, Long IdPost, Long idUser) {
        Post p =   postRepository.findById(IdPost).orElse(null);
        User r =   userRepository.findById(idUser).orElse(null);
        react.setPost(p);
        react.setUserReactPost(r);
        return reactPostRepository.save(react) ;
    }

    @Override
    @Transactional
    public ReactPost addReactToComment(ReactPost react, Long idcomment, Long idUser) {
        User user = userRepository.findById(idUser).orElse(null);
        CommentPost comment = commentPostRepository.findById(idcomment).orElse(null);
        react.setUserReactPost(user);

      //  System.out.println(comment+ "comment");

        assert comment != null;
       // System.out.println(comment.getPostComment()+ "post");
        //react.setComments(comment);
        //reactPostRepository.save(react);

        if (comment != null) {
            Post post = comment.getPostComment();
comment.getReactPostsComment().add(react);
//commentPostRepository.save(comment);

            react.setPost(post); // Associate react post with the same post as the comment
            reactPostRepository.save(react);
        }
        return react;    }

    @Override
    public List<CommentPost> getReplies(Long commentId) {
        return commentPostRepository.findByPostCoReflexiveIdCommentPost(commentId);
    }


}
