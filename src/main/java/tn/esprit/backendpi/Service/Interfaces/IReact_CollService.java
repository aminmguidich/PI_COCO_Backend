package tn.esprit.backendpi.Service.Interfaces;


import tn.esprit.backendpi.Entities.ReactCollocation;

import java.util.List;

public interface IReact_CollService {
    ReactCollocation addReact(ReactCollocation react);
    ReactCollocation updateReactCollocation(Long id, ReactCollocation updatedReactCollocation);
    void removeReact (long idReact);
    List<ReactCollocation> retrieveReacts ();
    ReactCollocation retrieveReact (long idReact);
}
