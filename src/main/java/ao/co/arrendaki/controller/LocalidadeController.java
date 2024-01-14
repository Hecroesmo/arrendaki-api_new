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
@CrossOrigin(origins = "*", allowedHeaders = "*",
		methods = {RequestMethod.GET,
				RequestMethod.DELETE,
				RequestMethod.PATCH,
				RequestMethod.POST,
				RequestMethod.PUT})
public class LocalidadeController {

	@Autowired
	private LocalidadeService service;

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody LocalidadeRequest localidade) {
		return new ResponseEntity<>(service.salvar(localidade), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<?>> buscarLocalidades() {
		return new ResponseEntity<>(service.buscarLocalidades(), HttpStatus.OK);
	}

	@GetMapping("/paises")
	public ResponseEntity<List<?>> buscarTodosPaises() {
		return new ResponseEntity<>(service.buscarTodosPaises(), HttpStatus.OK);
	}

	@GetMapping("/filhos/{chave}")
	public ResponseEntity<List<?>> buscarTodasLocalidadePeloChavePai(@PathVariable Long chave) {
		return new ResponseEntity<>(
				service.buscarTodasLocalidadePeloChavePai(chave), HttpStatus.OK
		);
	}

	@GetMapping("/{chave}")
	public ResponseEntity<Localidade> buscarPelaChave(@PathVariable Long chave) {
		return new ResponseEntity<>(service.buscarPelaChave(chave), HttpStatus.OK);
	}

	@DeleteMapping("/{chave}")
	public void deletarPelaChave(@PathVariable Long chave) {
		service.deletarPelaChave(chave);
	}
}
