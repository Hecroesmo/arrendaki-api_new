package ao.co.arrendaki.repository;

import ao.co.arrendaki.model.Localidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade,Long> {

    public List<Localidade> findAllByLocalidadePaiIsNull();

    public List<Localidade> findAllByLocalidadePaiPkLocalidade(Long pkLocalidade);
}
