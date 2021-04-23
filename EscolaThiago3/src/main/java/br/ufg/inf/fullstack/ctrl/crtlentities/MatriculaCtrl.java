package br.ufg.inf.fullstack.ctrl.crtlentities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.fullstack.ctrl.business.MatriculaBusiness;
import br.ufg.inf.fullstack.ctrl.exception.MatriculaException;
import br.ufg.inf.fullstack.model.entities.Matricula;

@RestController
@RequestMapping(value="/matriculas")
public class MatriculaCtrl {
	
	@Autowired
	private MatriculaBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Matricula>> findAll() throws MatriculaException{
		List<Matricula> list = business.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Matricula> findById(@PathVariable Integer id) throws MatriculaException{
		Matricula retorno = business.findById(id);
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping
	public ResponseEntity<Matricula> insert(@RequestBody Matricula matricula) throws MatriculaException{
		matricula = business.insert(matricula);
		return ResponseEntity.ok().body(matricula);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		business.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Matricula> update(@RequestBody Matricula matricula) throws MatriculaException{
		matricula = business.insert(matricula);
		return ResponseEntity.ok().body(matricula);
	}
	
}
