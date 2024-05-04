package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.backendpi.Entities.RatingCollocation;

import java.util.Optional;


public interface RatingCollocationRepository extends JpaRepository<RatingCollocation, Long> {

}
