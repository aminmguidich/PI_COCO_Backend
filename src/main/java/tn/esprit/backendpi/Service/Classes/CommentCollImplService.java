package tn.esprit.backendpi.Service.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import tn.esprit.backendpi.Entities.CommentCol;
import tn.esprit.backendpi.Entities.Contract;
import tn.esprit.backendpi.Repository.CommandRepository;
import tn.esprit.backendpi.Repository.CommentCollRepository;
import tn.esprit.backendpi.Service.Interfaces.IcommentColl;

import java.util.List;
@Service
public class CommentCollImplService implements IcommentColl {
@Autowired
    CommentCollRepository commentCollRepository;
    @Override
    public CommentCol addComment(CommentCol comment) {
        return commentCollRepository.save(comment) ;
    }

    @Override
    public CommentCol updateComment(Long id, CommentCol newcomment) {
        CommentCol existingComment = commentCollRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Contract not found with ID : " + id));

        existingComment.setComment(newcomment.getComment());


        // Update other fields if necessary

        return commentCollRepository.save(existingComment);
    }

    @Override
    public void removeComment(long idComment) {
        commentCollRepository.deleteById(idComment);
    }

    @Override
    public List<CommentCol> retrieveComments() {
        return commentCollRepository.findAll();
    }
}
