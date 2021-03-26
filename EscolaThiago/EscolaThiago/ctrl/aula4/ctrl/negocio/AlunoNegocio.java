package aula4.ctrl.negocio;

import java.util.List;

import aula4.ctrl.exception.AlunoException;
import aula4.model.dao.AlunoDAO;
import aula4.model.entities.Aluno;

public class AlunoNegocio {


		AlunoDAO dao = new AlunoDAO();
		public Aluno inserir(Aluno aluno) throws AlunoException {
			this.validarAluno(aluno);
			dao.inserir(aluno);
			return aluno;
		}
		
		public List<Aluno> buscaTodos() throws AlunoException{
			return dao.buscaTodos();	
		}
		
		public Aluno buscaPorId(Integer id) throws AlunoException {		
			return dao.buscaPorId(id);
		}
		
		public Aluno alterar(Aluno aluno) throws AlunoException {		
			this.validarAluno(aluno);
			return dao.alterar(aluno);
		}
		
		public void excluir(Integer id) throws AlunoException {
			dao.excluir(id);
		}
		
		private void validarAluno(Aluno aluno) throws AlunoException {
			if (aluno.getPessoa() == null) {
				throw new AlunoException("É necessário vincular uma pessoa ao aluno.");
			}
		}
}
