package br.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fullstack.ctrl.exception.MatriculaException;
import br.fullstack.model.entities.Matricula;
import br.fullstack.model.repositories.MatriculaRepository;

@Service
public class MatriculaBusiness {

	@Autowired
	private MatriculaRepository repository;
	
	public List<Matricula> findAll(){
		return repository.findAll();
	}
	
	public Matricula findById(Integer id) throws MatriculaException {
		Optional<Matricula> retorno = repository.findById(id);
		
		if(retorno.isEmpty()) {
			throw new MatriculaException("0400");
		}
		
		return retorno.get();
	}
	
	public Integer recuperaMatriculaAluno(Integer id) {
		return(repository.recuraMatriculaAluno(id));
	}
	
	public Matricula insert(Matricula matricula) throws MatriculaException {
		this.validarMatricula(matricula);
		return repository.save(matricula);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Matricula update(Matricula matricula) throws MatriculaException {
		this.validarMatricula(matricula);
		Matricula matriculaUpd = repository.findById(matricula.getIdMatricula()).get();
		matriculaUpd.setAluno(matricula.getAluno());
		matriculaUpd.setOferta(matricula.getOferta());
		
		return repository.save(matriculaUpd);
		
	}
	
	private void validarMatricula(Matricula matricula) throws MatriculaException {
		if(matricula.getAluno() == null || matricula.getOferta() == null) {
			throw new MatriculaException("0401");
		}
	}
}
