package tn.esprit.backendpi.Service.Interfaces;

import tn.esprit.backendpi.Entities.ReactCarpooling;

import java.util.List;

public interface IReactCarpoolingService {
    ReactCarpooling addReactCarpooling(ReactCarpooling reactCarpooling, Long annoncementId);
    ReactCarpooling updateReactCarpooling(ReactCarpooling reactCarpooling);
    void deleteReactCarpooling(Long id ,Long announcementId);
    List<ReactCarpooling> getAllReactCarpooling();
    ReactCarpooling getByIdReactCarpooling(Long id);
}
