package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.RatingCarpooling;
import tn.esprit.backendpi.Entities.ReactCarpooling;

import java.util.List;

public interface IReactCarpoolingService {
    ReactCarpooling addReactCarpooling(ReactCarpooling reactCarpooling);
    ReactCarpooling updateReactCarpooling(ReactCarpooling reactCarpooling);
    void deleteReactCarpooling(Long id );
    List<ReactCarpooling> getAllReactCarpooling();
    ReactCarpooling getByIdReactCarpooling(Long id);
}
