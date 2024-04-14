package tn.esprit.backendpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.backendpi.Entities.RequirementCollocation;

public interface ReqCollocationRepository extends CrudRepository<RequirementCollocation,Long> {
}
