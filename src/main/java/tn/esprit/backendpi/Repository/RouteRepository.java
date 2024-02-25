package tn.esprit.backendpi.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
}
