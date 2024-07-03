package repository;

import model.Transfert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransfertRepo extends JpaRepository<Transfert, Long> {
}
