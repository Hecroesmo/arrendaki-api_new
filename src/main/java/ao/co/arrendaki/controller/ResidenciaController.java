package ao.co.arrendaki.controller;

import ao.co.arrendaki.model.Residencia;
import ao.co.arrendaki.service.FicheiroServico;
import ao.co.arrendaki.service.FicheiroServicoImpl;
import ao.co.arrendaki.service.ResidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/residencia")
@CrossOrigin(origins = "*",allowedHeaders = "*",
        methods = {RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.PATCH,
                RequestMethod.POST,
                RequestMethod.PUT})
public class ResidenciaController {
    
    @Autowired
    private ResidenciaService service;

    @Autowired
    private FicheiroServicoImpl ficheiroServico;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Residencia residencia){
        return new ResponseEntity<>(service.salvar(residencia), HttpStatus.OK);
    }

    @PostMapping("/{id}/upload-photo")
    public ResponseEntity<String> uploadPhoto(@PathVariable Long id, @RequestParam("photoFile") MultipartFile photoFile) {
        if (photoFile.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
        }

        try {
            Residencia residencia = service.buscarPelaChave(id);

            if (residencia != null) {
                residencia.setFoto(ficheiroServico.uploadImage(photoFile));
                service.salvar(residencia);
                return new ResponseEntity<>("Photo uploaded and associated with the house.", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("House not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload and associate the photo.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
