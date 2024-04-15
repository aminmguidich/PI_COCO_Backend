package tn.esprit.backendpi.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.backendpi.Entities.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
