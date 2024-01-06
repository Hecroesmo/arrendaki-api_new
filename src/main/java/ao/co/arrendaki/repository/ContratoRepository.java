package ao.co.arrendaki.repository;

import ao.co.arrendaki.model.Conta;
import ao.co.arrendaki.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato,Long> {
}
