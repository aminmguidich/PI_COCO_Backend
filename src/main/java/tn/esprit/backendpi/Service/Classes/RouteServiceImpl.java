package tn.esprit.backendpi.Service.Classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.Route;
import tn.esprit.backendpi.Repository.RouteRepository;
import tn.esprit.backendpi.Service.Interfaces.IRouteService;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements IRouteService {
    private final RouteRepository routeRepository;
    @Override
    public Route addRouteCarpooling(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Route updateRouteCarpooling(Route route) {
        return routeRepository.save(route);
    }
}
