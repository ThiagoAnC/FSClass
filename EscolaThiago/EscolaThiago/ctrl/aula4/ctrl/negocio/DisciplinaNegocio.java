package aula4.ctrl.negocio;

import java.util.List;

import aula4.ctrl.exception.DisciplinaException;
import aula4.model.dao.DisciplinaDAO;
import aula4.model.entities.Disciplina;

public class DisciplinaNegocio {


		DisciplinaDAO dao = new DisciplinaDAO();
	
		public Disciplina inserir(Disciplina disciplina) throws DisciplinaException {
			this.validarDisciplina(disciplina);
			dao.inserir(disciplina);
			return disciplina;
		}
		
		// READ
		public List<Disciplina> buscaTodos() throws DisciplinaException{
			return dao.buscaTodos();	
		}
		
		public Disciplina buscaPorId(Integer id) throws DisciplinaException {
			
			return dao.buscaPorId(id);
		}
		
		
		// UPDATE
		
		public Disciplina alterar(Disciplina disciplina) throws DisciplinaException {		
			this.validarDisciplina(disciplina);
			return dao.alterar(disciplina);
		}
		
		// DELETE
		
		public void excluir(Integer id) throws DisciplinaException {
			dao.excluir(id);
		}
		
		private void validarDisciplina(Disciplina disciplina) throws DisciplinaException {
			if (disciplina.getCargaHoraria() <= 0) {
				throw new DisciplinaException("Carga horária deve ter maior que 0.");
			}

			if (disciplina.getNmDisciplina() == null || disciplina.getNmDisciplina().length() == 0) {
				throw new DisciplinaException("Nome da disciplina é obrigatório.");
			}
		}
}
