package aula4.ctrl.negocio;

import java.util.List;

import aula4.ctrl.exception.ProfessorException;
import aula4.model.dao.ProfessorDAO;
import aula4.model.entities.Professor;

public class ProfessorNegocio {


		ProfessorDAO dao = new ProfessorDAO();
		public Professor inserir(Professor professor) throws ProfessorException {
			this.validarProfessor(professor);
			dao.inserir(professor);
			return professor;
		}
		
		public List<Professor> buscaTodos() throws ProfessorException{
			return dao.buscaTodos();	
		}
		
		public Professor buscaPorId(Integer id) throws ProfessorException {
			
			return dao.buscaPorId(id);
		}
		
		public Professor alterar(Professor professor) throws ProfessorException {		
			this.validarProfessor(professor);
			return dao.alterar(professor);
		}
		
		public void excluir(Integer id) throws ProfessorException {
			dao.excluir(id);
		}
		
		private void validarProfessor(Professor professor) throws ProfessorException {
			if (professor.getPessoa() == null) {
				throw new ProfessorException("É necessário vincular uma pessoa ao professor.");
			}
		}
}
