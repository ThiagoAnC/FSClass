package aula4.ctrl.negocio;

import java.util.ArrayList;
import java.util.List;

import aula4.ctrl.exception.DisciplinaException;
import aula4.ctrl.exception.OfertaException;
import aula4.ctrl.exception.ProfessorException;
import aula4.model.dao.OfertaDAO;
import aula4.model.entities.Oferta;

public class OfertaNegocio {


		OfertaDAO dao = new OfertaDAO();
		ProfessorNegocio professorNegocio = new ProfessorNegocio();
		DisciplinaNegocio disciplinaNegocio = new DisciplinaNegocio();
	
		public Oferta inserir(Oferta oferta) throws OfertaException {
			this.validarOferta(oferta);
			dao.inserir(oferta);
			return oferta;
		}
		
		// READ
		public List<Oferta> buscaTodos() throws OfertaException, ProfessorException, DisciplinaException{
			List<Oferta> ofertas =  new ArrayList<Oferta>();
			for(Oferta o : dao.buscaTodos()) {
				o.setProfessor(professorNegocio.buscaPorId(o.getProfessor().getIdProfessor()));
				o.setDisciplina(disciplinaNegocio.buscaPorId(o.getDisciplina().getIdDisciplina()));
			}
			return ofertas;	
		}
		
		public Oferta buscaPorId(Integer id) throws OfertaException, ProfessorException, DisciplinaException {
			Oferta oferta = new Oferta();
			oferta.setProfessor(professorNegocio.buscaPorId(oferta.getProfessor().getIdProfessor()));
			oferta.setDisciplina(disciplinaNegocio.buscaPorId(oferta.getDisciplina().getIdDisciplina()));
			return oferta;
		}
		
		
		// UPDATE
		
		public Oferta alterar(Oferta oferta) throws OfertaException {		
			this.validarOferta(oferta);
			return dao.alterar(oferta);
		}
		
		// DELETE
		
		public void excluir(Integer id) throws OfertaException {
			dao.excluir(id);
		}
		
		private void validarOferta(Oferta oferta) throws OfertaException {
		}
}
