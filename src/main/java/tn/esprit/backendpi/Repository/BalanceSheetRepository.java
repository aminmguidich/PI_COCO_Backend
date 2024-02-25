package tn.esprit.backendpi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backendpi.Entities.BalanceSheet;

@Repository
public interface BalanceSheetRepository extends JpaRepository<BalanceSheet,Long> {
}
