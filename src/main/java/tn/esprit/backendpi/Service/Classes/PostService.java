package tn.esprit.backendpi.Service.Classes;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.*;
import tn.esprit.backendpi.Repository.CommentPostRepository;
import tn.esprit.backendpi.Repository.PostRepository;
import tn.esprit.backendpi.Repository.ReactPostRepository;
import tn.esprit.backendpi.Repository.UserRepository;
import tn.esprit.backendpi.Service.Interfaces.IPost;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    JavaMailSender javaMailSender;


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
    public void removeReactPost(long idReactPost) {

        //reactPostRepository.deleteById(idReactPost);
        User loggedInUser = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);

        ReactPost reactPost = reactPostRepository.findById(idReactPost).orElse(null);

        if (reactPost != null) {
            if (reactPost.getUserReactPost().getId().equals(loggedInUser.getId())) {
                reactPostRepository.deleteById(idReactPost);
            }
            else
            {
                System.out.println("you are not able to delete this react");
            }

        }
    }

    @Override
    public ReactPost checkExistingReaction(Long postId, TypeReactPost reactionType) {

        User loggedInUser = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        Post post = postRepository.findById(postId).orElse(null);
        return reactPostRepository.findByPostAndUserReactPostAndTypeReact(post, loggedInUser, reactionType);
    }







    /*********     AVANCEE     **********/

    @Override
    public List<CommentPost> getCommentsForPost(Long postId) {
        return commentPostRepository.findByPostCommentIdPost(postId);
    }
    @Override
    public List<CommentPost> getReplies(Long commentId) {
        return commentPostRepository.findByPostCoReflexiveIdCommentPost(commentId);
    }


    @Override
    public CommentPost addCommenttoPost(CommentPost comment,Long IdPost) {
        Post p =   postRepository.findById(IdPost).get();
        //currnt user
        User loggedInUser=userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        comment.setUserCommentPost(loggedInUser);

        comment.setPostComment(p);
        return commentPostRepository.save(comment);
    }
    @Override
    public CommentPost addCommentToComment(CommentPost comment, Long idComm) {
        CommentPost p =    commentPostRepository.findById(idComm).get();
        comment.setPostCoReflexive(p);
        //currnt user
        User loggedInUser=userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        comment.setUserCommentPost(loggedInUser);
        return commentPostRepository.save(comment) ;    }

    public void updatePostRating(Long postId, int nb_etoil) {
        Post post = postRepository.findById(postId).get();
        post.setNb_etoil(nb_etoil);
        postRepository.save(post);
    }

    @Override
    public ReactPost addReacttoPost(ReactPost react, Long IdPost) {
        Post p =   postRepository.findById(IdPost).orElse(null);
        User loggedInUser=userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        react.setUserReactPost(loggedInUser);
        react.setPost(p);
        return reactPostRepository.save(react) ;
    }

    @Override
    public List<ReactPost> getReactsForPost(Long postId) {
        return reactPostRepository.findByPostIdPost(postId);
    }

    @Override
    public ReactPost addTypeReacttoPost(TypeReactPost typereact, Long IdPost) {
        System.out.println(typereact);
        Post p =   postRepository.findById(IdPost).get();
        ReactPost reactPost = new ReactPost();
        //currnt user
        //User loggedInUser=userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        //reactPost.setUserReactPost(loggedInUser);

        reactPost.setTypeReact(typereact);
        reactPost.setPost(p);
        //System.out.println(loggedInUser);

        return reactPostRepository.save(reactPost);
    }

    @Override
    public List<ReactPost> getReactsForComment(Long idComment) {
        return commentPostRepository.findReactsForComment(idComment);
    }

    @Override
    public ReactPost addReactToComment(TypeReactPost typereact, Long idcomment) {
        CommentPost comment = commentPostRepository.findById(idcomment).orElse(null);
        ReactPost reactPost = new ReactPost();
        reactPost.setTypeReact(typereact);

        assert comment != null;
        if (comment != null) {
            Post post = comment.getPostComment();
            comment.getReactPostsComment().add(reactPost);
            reactPost.setPost(post);
            //currnt user
            User loggedInUser=userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
            reactPost.setUserReactPost(loggedInUser);

            reactPostRepository.save(reactPost);
        }
        return reactPost;

    }

    @Override
    public Post MeilleurPost() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);

        int etoile = 0;
        Post post = null;
        for(Post p : posts){
            if(p.getNb_etoil()>etoile){
                etoile = p.getNb_etoil();
                post=p;
            }
        }
        return post;
    }

    @Override
    public String AddWithoutBadWord(Post post) {
        BadWordImpl b = new BadWordImpl();
        if(b.filterText(post.getBody()).equals("This post contain bad word") || b.filterText(post.getPostTitle()).equals("This post contain bad word"))
            return "This post contain bad word" ;
        else {
            //currnt user
            User loggedInUser=userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
            post.setUserPost(loggedInUser);
            postRepository.save(post);
            return "add successfuly" ;
        }
    }

    //apre authentification
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
    public CommentPost UseraddCommentToComment(CommentPost comment, Long idComm, Long idUser) {
        CommentPost p =    commentPostRepository.findById(idComm).get();
        User a =   userRepository.findById(idUser).get();
        comment.setPostCoReflexive(p);
        comment.setUserCommentPost(a);
        return commentPostRepository.save(comment) ;
    }

    @Override
    public ReactPost UseraddReacttoPost(ReactPost react, Long IdPost, Long idUser) {
        Post p =   postRepository.findById(IdPost).orElse(null);
        User r =   userRepository.findById(idUser).orElse(null);
        react.setPost(p);
        react.setUserReactPost(r);
        return reactPostRepository.save(react) ;
    }

    @Override
    @Transactional
    public ReactPost UseraddReactToComment(ReactPost react, Long idcomment, Long idUser) {
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
    public void UpdatereportPost(Long postId) {
        Post post = postRepository.findById(postId).get();
        int nb = post.getNb_Signal() + 1;
        post.setNb_Signal(nb);
        postRepository.save(post);
    }



    @Override
    public void reportPost(Long IdPost){
        Post p = postRepository.findById(IdPost).get();
        p.setNb_Signal(p.getNb_Signal()+1);
        if(p.getNb_Signal() == 5) {
            postRepository.deleteById(IdPost);
            this.sendEmail("chaymaattafi3@gmail.com", "your post is deleted");

        }
        else {
            postRepository.save(p);
            this.sendEmail("chaymaattafi3@gmail.com", "post recive a new report");

        }
    }


    public void sendEmail(String Recipient,String EmailMessage) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(Recipient);
        message.setSubject("Post");
        message.setText(EmailMessage);

        javaMailSender.send(message);

    }

    @Override
    public String UserAddWithoutBadWord(Post post, Long idUser) {
        BadWordImpl b = new BadWordImpl();
        if(b.filterText(post.getBody()).equals("This post contain bad word") || b.filterText(post.getPostTitle()).equals("This post contain bad word"))
            return "This post contain bad word" ;
        else {
            post.setUserPost(userRepository.findById(idUser).get());
            postRepository.save(post);
            return "add successfuly" ;
        }
    }

    @Override
    public boolean countByUserReactPost(Long idPost) {
        Post post = postRepository.findById(idPost).orElse(null);
        User loggedInUser = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
        return (reactPostRepository.countByPostAndUserReactPost(post,loggedInUser)==0);
    }

    @Override
    public Optional<String> findUserNameAndLastNameByPostId(Long postId) {
        return postRepository.findUserPostUsernameByPostId(postId);
    }

    @Override
    public Optional<String> findUserCommentPostByIdCommentPost(Long idCommentPost) {
        return commentPostRepository.findUserCommentPostByIdCommentPost(idCommentPost);
    }

    //  @Scheduled(fixedRate = 86400000 ) //la méthode sera exécutée toutes les 24 heures, car fixedRate est défini à 86400000 millisecondes,
    @Override
    public void deletePostByTime(){
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);

        for(Post p : posts){
            if(p.getCreatedAt().isBefore(LocalDate.now().minusWeeks(1)) && p.getReactPosts().isEmpty() && p.getCommentPosts().isEmpty()){
                postRepository.delete(p);
                System.out.println("post deleted");
            }
        }
    }

}