package ao.co.arrendaki.controller;

import ao.co.arrendaki.model.Localidade;
import ao.co.arrendaki.requestModel.LocalidadeRequest;
import ao.co.arrendaki.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidade")
@CrossOrigin(origins = "*",allowedHeaders = "*",
        methods = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.PATCH,
                RequestMethod.POST,
                RequestMethod.PUT})
public class LocalidadeController {

    @Autowired
    private LocalidadeService service;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody LocalidadeRequest localidade){
        return new ResponseEntity<>(service.salvar(localidade), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<?>> buscarPaises(){
        return new ResponseEntity<>(service.buscarTodosPaises(),HttpStatus.OK);
    }

    @GetMapping("/{chave}")
    public ResponseEntity<List<?>> buscarLocalidadesPelaChave(@PathVariable Long chave){
        return new ResponseEntity<>(service.buscarTodasLocalidadePeloChavePai(chave),HttpStatus.OK);
    }

    @DeleteMapping("/{chave}")
    public ResponseEntity<?> eliminar(@PathVariable Long chave){
        return new ResponseEntity<>(service.deletarPelaChave(chave),HttpStatus.OK);
    }
}
