package com.app.doctrinabackend.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.doctrinabackend.domain.Professor;
import com.app.doctrinabackend.services.ProfessorService;

@RestController
@RequestMapping(value = "/profs")
public class ProfessorResource {

	@Autowired
	private ProfessorService service; // acessa o servico

	// lista os professores por id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Professor obj = service.buscar(id);
		return ResponseEntity.ok(obj);
	}

	// recebe um professor e cadastra ela no BD
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Professor obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build(); //cria o codigo 201, que é o codigo de cadastro
	}
}
