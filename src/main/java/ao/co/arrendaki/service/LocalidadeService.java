package ao.co.arrendaki.service;

import ao.co.arrendaki.model.Localidade;
import ao.co.arrendaki.repository.LocalidadeRepository;
import ao.co.arrendaki.requestModel.LocalidadeRequest;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository repositorio;

    public Localidade salvar(LocalidadeRequest localidadeReq) {
        Localidade localidade = new Localidade();
        localidade.setDesignacao(localidadeReq.getDesignacao());

        if (localidadeReq.getLocalidadePai() != null) {
            Localidade localidadePai = repositorio.findById(localidadeReq.getLocalidadePai())
                    .orElseThrow(() -> new EntityNotFoundException("LocalidadePai com id " + localidadeReq.getLocalidadePai() + " nao      contrado"));
            localidade.setLocalidadePai(localidadePai);
        }

        return repositorio.save(localidade);
    }

//    public List<Localidade> buscarTodosPaises() {
//        return repositorio.findAllByLocalidadePaiIsNull();
//    }

    public List<Localidade> buscarLocalidades() {
        return repositorio.findAll();
    }

//    public List<Localidade> buscarTodasLocalidadePeloChavePai(Long chave) {
//        return repositorio.findAllByLocalidadePaiPkLocalidade(chave);
//    }

    public Localidade buscarPelaChave(Long chave) {
        Optional<Localidade> optional = repositorio.findById(chave);
        return optional.orElse(null);
    }

    public void deletarPelaChave(Long chave) {
        repositorio.deleteById(chave);
    }
}
