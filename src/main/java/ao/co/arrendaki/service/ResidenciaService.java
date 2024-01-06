package ao.co.arrendaki.service;

import ao.co.arrendaki.model.Residencia;
import ao.co.arrendaki.repository.ContaRepository;
import ao.co.arrendaki.repository.PessoaRepository;
import ao.co.arrendaki.repository.ResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResidenciaService {

    @Autowired
    private ContaService contaService;

    @Autowired
    private LocalidadeService localidadeService;

    @Autowired
    private ResidenciaRepository residenciaRepository;

    @Autowired
    private TipologiaService tipologiaService;
    
    public Residencia salvar(Residencia residencia){
        residencia.setProprietario(contaService.buscarPelaChave(residencia.getProprietario().getPkConta()));
        residencia.setLocalidade(localidadeService.buscarPelaChave(residencia.getLocalidade().getPkLocalidade()));
        residencia.setTipologia(tipologiaService.buscarPelaChave(residencia.getTipologia().getPkTipologia()));
        return residenciaRepository.save(residencia);
    }

    public List<Residencia> buscarTodos(){
        return residenciaRepository.findAll();
    }

    public Residencia buscarPelaChave(Long chave){
        Optional<Residencia> optional = residenciaRepository.findById(chave);
        if (optional.isPresent())
            return optional.get();
        return null;
    }

    public Residencia deletarPelaChave(Long chave){
        Residencia residencia = buscarPelaChave(chave);
        if(residencia != null){
            residenciaRepository.delete(residencia);
            return null;
        }
        return residencia;
    }
}
