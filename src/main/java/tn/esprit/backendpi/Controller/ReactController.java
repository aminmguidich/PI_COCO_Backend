package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.ReactCollocation;
import tn.esprit.backendpi.Service.Interfaces.IReact_CollService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/React")
@CrossOrigin("*")

public class ReactController {
    private final IReact_CollService reactService;

    @PostMapping("/addReact_Coll")

    public ReactCollocation addReact(ReactCollocation react) {
        return reactService.addReact(react);
    }

    @PutMapping("/update/{id}")
    public ReactCollocation updateReactCollocation(@PathVariable Long id, @RequestBody ReactCollocation react) {
        return reactService.updateReactCollocation(id, react);
    }


    @GetMapping("/all")

    public List<ReactCollocation> retrieveReacts() {
        return reactService.retrieveReacts();
    }
    @GetMapping("/{id}")

    public ReactCollocation retrieveReact(long idReact) {
        return reactService.retrieveReact(idReact);
    }
    @DeleteMapping("/delete/{id}")

    public void removeReact(long idReact) {
        reactService.removeReact(idReact);
    }
}

