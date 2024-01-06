package ao.co.arrendaki.repository;

import ao.co.arrendaki.model.Conta;
import ao.co.arrendaki.model.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Long> {
}
