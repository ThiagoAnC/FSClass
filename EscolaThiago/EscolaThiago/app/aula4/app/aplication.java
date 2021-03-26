package aula4.app;

import aula4.ctrl.AlunoCtrl;
import aula4.ctrl.CursoCtrl;
import aula4.ctrl.DisciplinaCtrl;
import aula4.ctrl.OfertaCtrl;
import aula4.ctrl.PessoaCtrl;
import aula4.ctrl.ProfessorCtrl;

import aula4.app.TesteApp;
@SuppressWarnings("unused")

public class aplication {

	public static void main(String[] args) {

		System.out.println("Começando por aqui");

		TesteApp testeApp = new TesteApp();
		
		testeApp.testeCrudDisciplina(new DisciplinaCtrl());
		testeApp.testeCrudPessoa(new PessoaCtrl());
		testeApp.testeCrudProfessor(new ProfessorCtrl(), new PessoaCtrl());
		testeApp.testeCrudOferta(new OfertaCtrl(), new DisciplinaCtrl(), new ProfessorCtrl());
		testeApp.testeCrudCurso(new CursoCtrl());
		testeApp.testeCrudAluno(new AlunoCtrl(), new PessoaCtrl(), new CursoCtrl());
		
	}
}
