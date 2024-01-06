package ao.co.arrendaki.controller;

import ao.co.arrendaki.model.Conta;
import ao.co.arrendaki.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
@CrossOrigin(origins = "*",allowedHeaders = "*",
        methods = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.PATCH,
                RequestMethod.POST,
                RequestMethod.PUT})
public class ContaController {
    
    @Autowired
    private ContaService service;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Conta conta){
        return new ResponseEntity<>(service.salvar(conta), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<?>> buscarTodos(){
        return new ResponseEntity<>(service.buscarTodos(),HttpStatus.OK);
    }

    @GetMapping("/{chave}")
    public ResponseEntity<?> buscarPeloId(@PathVariable Long chave){
        return new ResponseEntity<>(service.buscarPelaChave(chave),HttpStatus.OK);
    }

    @DeleteMapping("/{chave}")
    public ResponseEntity<?> eliminar(@PathVariable Long chave){
        return new ResponseEntity<>(service.deletarPelaChave(chave),HttpStatus.OK);
    }
}
