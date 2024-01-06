package ao.co.arrendaki.repository;

import ao.co.arrendaki.model.Localidade;
import ao.co.arrendaki.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
