package ao.co.arrendaki.service;

import ao.co.arrendaki.model.Contrato;
import ao.co.arrendaki.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {
    
    @Autowired
    private ContratoRepository repository;

    @Autowired
    private ContaService contaService;

    @Autowired
    private ResidenciaService residenciaService;

    public Contrato salvar(Contrato contrato){
        contrato.setConta(contaService.buscarPelaChave(contrato.getConta().getPkConta()));
        contrato.setResidencia(residenciaService.buscarPelaChave(contrato.getResidencia().getPkResidencia()));
        return repository.save(contrato);
    }

    public List<Contrato> buscarTodos(){
        return repository.findAll();
    }

    public Contrato buscarPelaChave(Long chave){
        Optional<Contrato> optional = repository.findById(chave);
        if (optional.isPresent())
            return optional.get();
        return null;
    }

    public Contrato deletarPelaChave(Long chave){
        Contrato contrato = buscarPelaChave(chave);
        if(contrato != null){
            repository.delete(contrato);
            return null;
        }
        return contrato;
    }
}
