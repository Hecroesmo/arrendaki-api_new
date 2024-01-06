package ao.co.arrendaki.service;

import ao.co.arrendaki.model.Conta;
import ao.co.arrendaki.model.Conta;
import ao.co.arrendaki.repository.ContaRepository;
import ao.co.arrendaki.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LocalidadeService localidadeService;

    public Conta salvar(Conta conta){
        Long chaveLocalidade = conta.getPessoa().getLocalidade().getPkLocalidade();
        pessoaRepository.save(conta.getPessoa());
        conta.getPessoa().setLocalidade(localidadeService.buscarPelaChave(chaveLocalidade));
        return contaRepository.save(conta);
    }

    public List<Conta> buscarTodos(){
        return contaRepository.findAll();
    }

    public Conta buscarPelaChave(Long chave){
        Optional<Conta> optional = contaRepository.findById(chave);
        if (optional.isPresent())
            return optional.get();
        return null;
    }

    public Conta deletarPelaChave(Long chave){
        Conta conta = buscarPelaChave(chave);
        if(conta != null){
            contaRepository.delete(conta);
            return null;
        }
        return conta;
    }
}
