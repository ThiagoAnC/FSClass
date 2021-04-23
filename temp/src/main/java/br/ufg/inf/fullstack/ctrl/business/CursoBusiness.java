package br.ufg.inf.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fullstack.model.entities.Curso;
import br.ufg.inf.fullstack.model.repositories.CursoRepository;

@Service
public class CursoBusiness {
	@Autowired
	private CursoRepository repository;
	
	public List<Curso> findAll(){
		return(repository.findAll());
	}
	
	public Curso findById(Integer id) {
		Optional<Curso> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Curso insert(Curso disciplina) {
		return repository.save(disciplina);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Curso update(Curso curso) {
		Curso cursoUpd = repository.findById(curso.getIdCurso()).get();
		curso.setNmCurso(curso.getNmCurso());
		
		return repository.save(cursoUpd);
	}
}
