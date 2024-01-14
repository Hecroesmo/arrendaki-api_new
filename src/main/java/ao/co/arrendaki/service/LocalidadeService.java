package ao.co.arrendaki.service;

import ao.co.arrendaki.model.Localidade;
import ao.co.arrendaki.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository repositorio;

    public Localidade salvar(Localidade localidade) {
//        Localidade localidade = new Localidade();
//        localidade.setDesignacao(localidadeReq.getDesignacao());
//
//        if (localidadeReq.getLocalidadePai() > 0) {
//            Localidade localidadePai = new Localidade();
//            localidadePai.setPkLocalidade(localidadeReq.getLocalidadePai());
//            localidade.setLocalidadePai(localidadePai);
//        }

        return repositorio.save(localidade);
    }

    public List<Localidade> buscarTodosPaises() {
        return repositorio.findAllByLocalidadePaiIsNull();
    }

    public List<Localidade> buscarLocalidades() {
        return repositorio.findAll();
    }

    public List<Localidade> buscarTodasLocalidadePeloChavePai(Long chave) {
        return repositorio.findAllByLocalidadePaiPkLocalidade(chave);
    }

    public Localidade buscarPelaChave(Long chave) {
        Optional<Localidade> optional = repositorio.findById(chave);
        return optional.orElse(null);
    }

    public Localidade deletarPelaChave(Long chave) {
        Localidade localidade = buscarPelaChave(chave);
        if (localidade != null) {
            repositorio.delete(localidade);
            return null;
        }
        return localidade;
    }
}
