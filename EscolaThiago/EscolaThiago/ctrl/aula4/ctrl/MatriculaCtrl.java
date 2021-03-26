package aula4.ctrl;

import java.util.List;

import aula4.ctrl.exception.AlunoException;
import aula4.ctrl.exception.DisciplinaException;
import aula4.ctrl.exception.MatriculaException;
import aula4.ctrl.exception.OfertaException;
import aula4.ctrl.exception.ProfessorException;
import aula4.ctrl.negocio.MatriculaNegocio;
import aula4.model.entities.Matricula;

public class MatriculaCtrl {

	MatriculaNegocio negocio = new MatriculaNegocio();

	public Matricula inserir(Matricula matricula) {
		try {
			matricula = negocio.inserir(matricula);
			System.out.println("Matricula cadastrada com sucesso: " + matricula);
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar cadastrar matricula.");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public List<Matricula> buscaTodos() throws ProfessorException, DisciplinaException {
		List<Matricula> matriculas = null;
		try {
			matriculas = negocio.buscaTodos();
		} catch (MatriculaException e) {
			System.out.println("Erro tentar buscar as matriculas cadastradas.");
			System.out.println(e.getMessage());
		} catch (OfertaException e) {
			System.out.println("Erro tentar buscar as matriculas cadastradas.");
			System.out.println(e.getMessage());
		} catch (AlunoException e) {
			System.out.println("Erro tentar buscar as matriculas cadastradas.");
			System.out.println(e.getMessage());
		}
		return matriculas;
	}

	public Matricula buscaPorId(Integer id) throws ProfessorException, DisciplinaException {
		Matricula matricula = null;
		try {
			matricula = negocio.buscaPorId(id);
		} catch (MatriculaException e) {
			System.out.println("Erro tentar buscar as matriculas cadastradas.");
			System.out.println(e.getMessage());
		} catch (OfertaException e) {
			System.out.println("Erro tentar buscar as matriculas cadastradas.");
			System.out.println(e.getMessage());
		} catch (AlunoException e) {
			System.out.println("Erro tentar buscar as matriculas cadastradas.");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public Matricula alterar(Matricula matricula) {
		try {
			matricula = negocio.alterar(matricula);
			System.out.println("Matricula alterada com sucesso: " + matricula);
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar alterar matricula com ID: " + matricula.getIdMatricula() + ".");
			System.out.println(e.getMessage());
		}
		return matricula;
	}

	public void excluir(Integer id) {
		try {
			negocio.excluir(id);
			System.out.println("Matricula excluída com sucesso.");
		} catch (MatriculaException e) {
			System.out.println("Erro ao tentar excluir matricula");
			System.out.println(e.getMessage());
		}
	}
}

