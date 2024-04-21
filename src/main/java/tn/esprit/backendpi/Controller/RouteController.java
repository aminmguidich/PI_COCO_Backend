package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.Route;
import tn.esprit.backendpi.Service.Interfaces.IRouteService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Route")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")

public class RouteController {


    private final IRouteService iRouteService;

    @PostMapping("/addRoute")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")

    public Route addRouteCarpooling(@RequestBody Route route) {
        return iRouteService.addRouteCarpooling(route);
    }

    @PutMapping("/updateRoute")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Route updateRouteCarpooling(@RequestBody Route route) {
        return iRouteService.updateRouteCarpooling(route);
    }
}

