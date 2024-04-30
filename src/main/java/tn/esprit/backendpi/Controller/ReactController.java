package tn.esprit.backendpi.Controller;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.ReactCollocation;
import tn.esprit.backendpi.Service.Interfaces.IReact_CollService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/React")
@CrossOrigin("*")
@Transactional

public class ReactController {
  @Autowired
    private final IReact_CollService reactCollService;


    @PostMapping("/addReact_Coll")
    public ReactCollocation addReactCollocation(ReactCollocation reactCollocation, Long idCollocationAnnouncement) {
        return reactCollService.addReactCollocation(reactCollocation, idCollocationAnnouncement);
    }
    @PutMapping("/update/{id}")
    public ReactCollocation updateReactCollocation(Long id, ReactCollocation updatedReactCollocation) {
        return reactCollService.updateReactCollocation(id, updatedReactCollocation);
    }

    @GetMapping("/all")
    public List<ReactCollocation> retrieveReacts() {
        return reactCollService.retrieveReacts();
    }
    @GetMapping("/{id}")
    public ReactCollocation retrieveReact(@PathVariable("id") long idReact) {
        return reactCollService.retrieveReact(idReact);
    }

    @DeleteMapping("/delete/{id}")

    public void removeReact(long idReact) {
        reactCollService.removeReact(idReact);
    }

    @GetMapping("/nbrDisLikesParAnnoucement/{idCollocationAnnouncement}")
    public int nbrDislikesParPost(Long idCollocationAnnouncement) {
        return reactCollService.nbrDislikesParPost(idCollocationAnnouncement);
    }

    @PostMapping("/like/{idCollocationAnnouncement}")
    public ResponseEntity<ReactCollocation> likeAnnCol(@PathVariable("idCollocationAnnouncement") Long idCollocationAnnouncement) {
        ReactCollocation likedReact = reactCollService.likeAnnCol(idCollocationAnnouncement);
        return new ResponseEntity<>(likedReact, HttpStatus.OK);
    }

    @PostMapping("/dislike/{idCollocationAnnouncement}")
    public ResponseEntity<ReactCollocation> dislikeAnncol(@PathVariable("idCollocationAnnouncement") Long idCollocationAnnouncement) {
        ReactCollocation dislikedReact = reactCollService.dislikeAnncol(idCollocationAnnouncement);
        return new ResponseEntity<>(dislikedReact, HttpStatus.OK);
    }


    @PostMapping("/add/{idCollocationAnnouncement}")
    public ResponseEntity<ReactCollocation> addReactToAnnoucement(@RequestBody ReactCollocation reactCollocation, @PathVariable Long idCollocationAnnouncement) {
        ReactCollocation addedReact = reactCollService.addReactToAnnoucement(reactCollocation, idCollocationAnnouncement);
        return new ResponseEntity<>(addedReact, HttpStatus.CREATED);
    }

    @GetMapping("/nbrLikesParAnnoucement/{idCollocationAnnouncement}")
    public int nbrLikesParPost(Long idCollocationAnnouncement) {
        return reactCollService.nbrLikesParPost(idCollocationAnnouncement);
    }

}
