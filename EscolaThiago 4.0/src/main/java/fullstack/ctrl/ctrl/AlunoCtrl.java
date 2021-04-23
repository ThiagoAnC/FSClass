package br.fullstack.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fullstack.ctrl.business.AlunoBusiness;
import br.fullstack.ctrl.exception.AlunoException;
import br.fullstack.model.entities.Aluno;
import br.fullstack.util.Message;

@RestController
@RequestMapping(value="/alunos")
public class AlunoCtrl {
	
	@Autowired
	private AlunoBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		List<Aluno> list = business.findAll();
		if(list.size() == 0) {
			status = HttpStatus.NO_CONTENT;
			headers.add("message", Message.get("0302"));
		}
		return new ResponseEntity<List<Aluno>>(list, headers, status);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		Aluno retorno = new Aluno();
		try {
			retorno = business.findById(id);
		} catch (AlunoException e) {
			headers.add("message", Message.get(e.getMessage()));
			status = HttpStatus.NO_CONTENT;
		} catch (Exception e) {
			headers.add("message", Message.get("0002"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Aluno>(retorno, headers, status);
	}
	
	@GetMapping(value="/find/{str}")
	public ResponseEntity<List<Aluno>> findByName(@PathVariable Optional<String> str){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		List<Aluno> list = business.findByNmAluno(str.get()); 
		if(list.size() == 0) {
			status = HttpStatus.NO_CONTENT;
			headers.add("message", Message.get("0302"));
		}
		return new ResponseEntity<List<Aluno>>(list, headers, status);
	}
	
	@GetMapping(value="/findAtivo")
	public ResponseEntity<List<Aluno>> findByAtivo(){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		List<Aluno> list = business.findByAtivo();
		
		if(list.size() == 0) {
			status = HttpStatus.NO_CONTENT;
			headers.add("message", Message.get("0309"));
		}
		
		return new ResponseEntity<List<Aluno>>(list, headers, status);
	}
	
	@GetMapping(value="/findAlunos/{id}")
	public ResponseEntity<List<Integer>> recuperaAlunosCursos(@PathVariable Integer id){
		HttpHeaders headers = new HttpHeaders();
		HttpStatus status = HttpStatus.OK;
		
		List<Integer> retorno = null;
		
		try {
			retorno = business.recuperaAlunosCurso(id);
		} catch (NullPointerException e) {
			headers.add("message", Message.get("0310"));
			status = HttpStatus.NO_CONTENT;
		} catch (Exception e) {
			headers.add("message", Message.get("0002"));
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<Integer>>(retorno, headers, status);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
	
		try {
			aluno = business.insert(aluno);
			headers.add("message", Message.get("0303"));
		} catch (AlunoException e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Message.get(e.getMessage()));
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers.add("message", Message.get("0304"));
		}
	
		return new ResponseEntity<Aluno>(aluno, headers, status);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			business.delete(id);
			headers.add("message", Message.get("0305"));
		}catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers.add("message", Message.get("0306"));
		}
		return new ResponseEntity<Void>(null, headers, status);
	}
	
	@PutMapping
	public ResponseEntity<Aluno> update(@RequestBody Aluno aluno){
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			aluno = business.insert(aluno);
			headers.add("message", Message.get("0307"));
		} catch (AlunoException e) {
			status = HttpStatus.BAD_REQUEST;
			headers.add("message", Message.get(e.getMessage()));			
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			headers.add("message", Message.get("0308"));	
		}
		return new ResponseEntity<Aluno>(aluno, headers, status);
	}
}
