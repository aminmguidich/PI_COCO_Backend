package tn.esprit.backendpi.Controller;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.ReactCollocation;
import tn.esprit.backendpi.Repository.ReactRepository;
import tn.esprit.backendpi.Service.Interfaces.IReact_CollService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/React")
@Transactional
@CrossOrigin(origins = "http://localhost:4200", allowCredentials="true")
public class ReactController {
  @Autowired
  private final IReact_CollService reactCollService;

  @Autowired
    ReactRepository reactRepo;


  @PostMapping("/addReact_Coll")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ReactCollocation addReactCollocation(@RequestBody ReactCollocation reactCollocation) {

      System.out.println(reactCollocation.getLikes());

        return  reactRepo.save(reactCollocation);

    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ReactCollocation updateReactCollocation(@PathVariable Long id,@RequestBody ReactCollocation updatedReactCollocation) {
      System.out.println(id);
      return reactCollService.updateReactCollocation(id, updatedReactCollocation);
    }

    @GetMapping("/all")
    public List<ReactCollocation> retrieveReacts() {
        return reactCollService.retrieveReacts();
    }


}
