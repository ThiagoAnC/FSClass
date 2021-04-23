package br.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fullstack.ctrl.exception.CursoException;
import br.fullstack.model.entities.Curso;
import br.fullstack.model.repositories.CursoRepository;

@Service
public class CursoBusiness {
	@Autowired
	private CursoRepository repository;
	
	public List<Curso> findAll(){
		return(repository.findAll());
	}
	
	public Curso findById(Integer id) throws CursoException {
		Optional<Curso> retorno = repository.findById(id);
		
		if(retorno.isEmpty()) {
			throw new CursoException("0200");
		}
		
		return retorno.get();
	}
	
	public List<Curso> findByNmCurso(String str){
		return(repository.findByNmCurso(str));
	}
	
	public Curso insert(Curso curso) throws CursoException {
		this.validarCurso(curso);
		return repository.save(curso);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Curso update(Curso curso) throws CursoException {
		this.validarCurso(curso);
		Curso cursoUpd = repository.findById(curso.getIdCurso()).get();
		cursoUpd.setNmCurso(curso.getNmCurso());
		
		return repository.save(cursoUpd);
	}
	
	private void validarCurso(Curso curso) throws CursoException {
		if(curso.getNmCurso() == null || curso.getNmCurso().length() == 0) {
			throw new CursoException("0201"); 
		}
	}
}
