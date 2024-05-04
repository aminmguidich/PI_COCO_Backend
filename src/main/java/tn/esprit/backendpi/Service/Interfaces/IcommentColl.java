package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.Command;
import tn.esprit.backendpi.Entities.CommentCol;

import java.util.List;

public interface IcommentColl {
    CommentCol addComment(CommentCol comment);
    CommentCol updateComment (Long id,CommentCol newcomment);
    void removeComment (long idComment);
    List<CommentCol> retrieveComments ();
}
