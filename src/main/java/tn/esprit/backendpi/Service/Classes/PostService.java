package tn.esprit.backendpi.Service.Classes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.*;
import tn.esprit.backendpi.Repository.CommentPostRepository;
import tn.esprit.backendpi.Repository.PostRepository;
import tn.esprit.backendpi.Repository.ReactPostRepository;
import tn.esprit.backendpi.Service.Interfaces.IPost;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class PostService implements IPost {
    /*********     Injection     **********/

    CommentPostRepository commentPostRepository;
    PostRepository postRepository;
    ReactPostRepository reactPostRepository;

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
}
