package aula4.ctrl.negocio;

import java.util.List;

import aula4.ctrl.exception.CursoException;
import aula4.model.dao.CursoDAO;
import aula4.model.entities.Curso;

public class CursoNegocio {


		CursoDAO dao = new CursoDAO();
	
		public Curso inserir(Curso curso) throws CursoException {
			this.validarCurso(curso);
			dao.inserir(curso);
			return curso;
		}

		// READ
		public List<Curso> buscaTodos() throws CursoException{
			return dao.buscaTodos();	
		}
		
		public Curso buscaPorId(Integer id) throws CursoException {
			
			return dao.buscaPorId(id);
		}
		
		
		// UPDATE
		
		public Curso alterar(Curso curso) throws CursoException {		
			this.validarCurso(curso);
			return dao.alterar(curso);
		}
		
		// DELETE

		public void excluir(Integer id) throws CursoException {
			dao.excluir(id);
		}
		
		private void validarCurso(Curso curso) {
			// TODO Auto-generated method stub
			
		}
}
