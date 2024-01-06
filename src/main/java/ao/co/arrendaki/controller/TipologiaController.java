package ao.co.arrendaki.controller;

import ao.co.arrendaki.model.Tipologia;
import ao.co.arrendaki.service.TipologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipologia")
@CrossOrigin(origins = "*",allowedHeaders = "*",
        methods = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.PATCH,
                RequestMethod.POST,
                RequestMethod.PUT})
public class TipologiaController {
    
    @Autowired
    private TipologiaService service;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Tipologia tipologia){
        return new ResponseEntity<>(service.salvar(tipologia), HttpStatus.OK);
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
