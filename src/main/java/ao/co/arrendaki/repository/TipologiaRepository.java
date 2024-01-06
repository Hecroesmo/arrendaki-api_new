package ao.co.arrendaki.repository;

import ao.co.arrendaki.model.Conta;
import ao.co.arrendaki.model.Tipologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipologiaRepository extends JpaRepository<Tipologia,Long> {
}
