package tn.esprit.backendpi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backendpi.Entities.Route;
import tn.esprit.backendpi.Service.Interfaces.IRouteService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Route")
@CrossOrigin("*")

public class RouteController {
    private final IRouteService iRouteService;

    @PostMapping("/addRoute")
    public Route addRouteCarpooling(@RequestBody Route route) {
        return iRouteService.addRouteCarpooling(route);
    }
}
