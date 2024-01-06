package ao.co.arrendaki.service;

import ao.co.arrendaki.model.Tipologia;
import ao.co.arrendaki.repository.TipologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipologiaService {
    
    @Autowired
    private TipologiaRepository repository;

    public Tipologia salvar(Tipologia tipologia){
        return repository.save(tipologia);
    }

    public List<Tipologia> buscarTodos(){
        return repository.findAll();
    }

    public Tipologia buscarPelaChave(Long chave){
        Optional<Tipologia> optional = repository.findById(chave);
        if (optional.isPresent())
            return optional.get();
        return null;
    }

    public Tipologia deletarPelaChave(Long chave){
        Tipologia tipologia = buscarPelaChave(chave);
        if(tipologia != null){
            repository.delete(tipologia);
            return null;
        }
        return tipologia;
    }
}
