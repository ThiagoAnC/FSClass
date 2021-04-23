package br.fullstack.ctrl.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fullstack.ctrl.exception.AlunoException;
import br.fullstack.model.entities.Aluno;
import br.fullstack.model.repositories.AlunoRepository;


@Service
public class AlunoBusiness {

	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> findAll(){
		return repository.findAll();
	}
	
	public Aluno findById(Integer id) throws AlunoException {
		Optional<Aluno> retorno = repository.findById(id);
		
		if(retorno.isEmpty()) {
			throw new AlunoException("0300");
		}
		
		return retorno.get();
	}
	
	public List<Aluno> findByNmAluno(String str){
		return(repository.findByNmAluno(str));
	}
	
	public List<Aluno> findByAtivo(){
		return(repository.findByAtivo());
	}
	
	public List<Integer> recuperaAlunosCurso(Integer id){
		return(repository.recuperaAlunosCurso(id));
	}
	
	public Aluno insert(Aluno aluno) throws AlunoException {
		this.validarAluno(aluno);
		return repository.save(aluno);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Aluno update(Aluno aluno) throws AlunoException {
		this.validarAluno(aluno);
		Aluno alunoUpd = repository.findById(aluno.getIdAluno()).get();
		alunoUpd.setAtivo(aluno.getAtivo());
		alunoUpd.setCurso(aluno.getCurso());
		alunoUpd.setDtInicio(aluno.getDtInicio());
		alunoUpd.setPessoa(aluno.getPessoa());
		
		return repository.save(alunoUpd);
		
	}
	
	private void validarAluno(Aluno aluno) throws AlunoException {
		if(aluno.getCurso() == null || aluno.getPessoa() == null) {
			throw new AlunoException("0301");
		}
	}
}
