package ao.co.arrendaki.repository;

import ao.co.arrendaki.model.Localidade;
import ao.co.arrendaki.model.Residencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenciaRepository extends JpaRepository<Residencia,Long> {
}
