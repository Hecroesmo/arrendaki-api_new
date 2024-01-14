package ao.co.arrendaki.controller;

import ao.co.arrendaki.model.Contrato;
import ao.co.arrendaki.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contrato")
@CrossOrigin(origins = "*", allowedHeaders = "*",
		methods = {RequestMethod.GET,
				RequestMethod.DELETE,
				RequestMethod.PATCH,
				RequestMethod.POST,
				RequestMethod.PUT})
public class ContratoController {

	@Autowired
	private ContratoService service;

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Contrato contrato) {
		return new ResponseEntity<>(service.salvar(contrato), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<?>> buscarTodos() {
		return new ResponseEntity<>(service.buscarTodos(), HttpStatus.OK);
	}

	@GetMapping("/{chave}")
	public ResponseEntity<?> buscarPeloId(@PathVariable Long chave) {
		return new ResponseEntity<>(service.buscarPelaChave(chave), HttpStatus.OK);
	}

	@DeleteMapping("/{chave}")
	public ResponseEntity<?> eliminar(@PathVariable Long chave) {
		return new ResponseEntity<>(service.deletarPelaChave(chave), HttpStatus.OK);
	}
}
