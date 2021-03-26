package aula4.ctrl.negocio;

import java.util.ArrayList;
import java.util.List;

import aula4.ctrl.exception.AlunoException;
import aula4.ctrl.exception.DisciplinaException;
import aula4.ctrl.exception.MatriculaException;
import aula4.ctrl.exception.OfertaException;
import aula4.ctrl.exception.ProfessorException;
import aula4.model.dao.MatriculaDAO;
import aula4.model.entities.Matricula;

public class MatriculaNegocio {


		MatriculaDAO dao = new MatriculaDAO();
		AlunoNegocio alunoNegocio = new AlunoNegocio();
		OfertaNegocio ofertaNegocio = new OfertaNegocio();
	
		public Matricula inserir(Matricula Matricula) throws MatriculaException {
			this.validarMatricula(Matricula);
			dao.inserir(Matricula);
			return Matricula;
		}
		

		// READ
		public List<Matricula> buscaTodos() throws MatriculaException, AlunoException, OfertaException, ProfessorException, DisciplinaException{
			List<Matricula> Matriculas =  new ArrayList<Matricula>();
			
			for(Matricula o : dao.buscaTodos()) {
				o.setAluno(alunoNegocio.buscaPorId(o.getAluno().getIdAluno()));
				o.setOferta(ofertaNegocio.buscaPorId(o.getOferta().getIdOferta()));
			}
			return Matriculas;	
		}
		
		public Matricula buscaPorId(Integer id) throws MatriculaException, AlunoException, OfertaException, ProfessorException, DisciplinaException {
			Matricula Matricula = new Matricula(null, null, null);
			AlunoNegocio alunonegocio = new AlunoNegocio();
			OfertaNegocio ofertanegocio = new OfertaNegocio();
			
			Matricula.setAluno(alunonegocio.buscaPorId(Matricula.getAluno().getIdAluno()));
			Matricula.setOferta(ofertanegocio.buscaPorId(Matricula.getOferta().getIdOferta()));
			return Matricula;
		}
				
		// UPDATE
		
		public Matricula alterar(Matricula Matricula) throws MatriculaException {		
			this.validarMatricula(Matricula);
			return dao.alterar(Matricula);
		}
		
		// DELETE
		
		public void excluir(Integer id) throws MatriculaException {
			dao.excluir(id);
		}
		
		private void validarMatricula(Matricula matricula) {
			// TODO Auto-generated method stub
			
		}
}
