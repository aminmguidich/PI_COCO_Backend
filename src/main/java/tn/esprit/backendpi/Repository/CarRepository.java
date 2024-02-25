package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
}
