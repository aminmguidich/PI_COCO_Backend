package tn.esprit.backendpi.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@ToString
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idForum;
    String description;

    @ToString.Exclude
    @OneToMany(mappedBy = "postComment")
    List<CommentPost>commentPosts=new ArrayList<>();
    @ToString.Exclude
    @ManyToOne
    User userPost;
    @ToString.Exclude
    @OneToMany
    List<ReactPost>reactPosts=new ArrayList<>();


}
