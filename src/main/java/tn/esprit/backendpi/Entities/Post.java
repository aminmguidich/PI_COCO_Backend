package tn.esprit.backendpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    Long idPost;
    String postTitle;
    LocalDate createdAt;
    String body;
    int nb_Signal;
    int nb_etoil;
    //String image;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "postComment",cascade = CascadeType.ALL)
    List<CommentPost>commentPosts=new ArrayList<>();

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    User userPost;


    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    List<ReactPost>reactPosts=new ArrayList<>();


}
