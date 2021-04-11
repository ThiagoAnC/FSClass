package br.ufg.inf.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.ufg.inf.ctrl.exception.*;
import br.ufg.inf.model.dao.*;
import br.ufg.inf.model.enums.*;
import br.ufg.inf.model.entities.*;
import br.ufg.inf.ctrl.*;

public class Aplication {
	private static Pessoa insert;

	public static void main(String[] args) {
		System.out.println("Running!!!");
		//testeDisciplina();
		testeCurso();
		//testePessoa();
		//testeProfessor();
		//testeAluno();
		//testeOferta();
		//testeMatricula();
		System.out.println("Done!");
	}
	
	public static void testeDisciplina(){
		DisciplinaDAO ctrl = new DisciplinaDAO();
		
		Disciplina math = new Disciplina(null, "Math", 64);
		Disciplina eng = new Disciplina(null, "English", 32);
		
		try {
			//ctrl.inserir(math);
			//ctrl.inserir(eng);
			
			math = ctrl.buscaPorId(18);
			math.setNmDisciplina("Full Stack");
			ctrl.alterar(math);
			
			ctrl.excluir(7);
			
			Disciplina disciplina = new Disciplina(null, "Geography", 96);
			ctrl.inserir(disciplina);
			
			for(Disciplina d : ctrl.buscaTodos()) {
				System.out.println(d);
			}
			
			System.out.println("-----------------------------------");
			for(Disciplina d : ctrl.buscarPorNome("Full Stack")) {
				System.out.println(d);
			}
		} catch (DisciplinaExection e) {
			e.printStackTrace();
		}
	}
	
	public static void testeCurso(){
		CursoDAO ctrl = new CursoDAO();
		
		Curso cc = new Curso(null, "Computer Science");
		Curso softEng = new Curso(null, "Software Engineering");
		
		try {
			//ctrl.inserir(cc);
			//ctrl.inserir(softEng);
			
			softEng = ctrl.buscaPorId(1);
			softEng.setNmCurso("Physics");
			ctrl.alterar(softEng);
		
			ctrl.excluir(2);
		} catch (CursoException e) {
			e.printStackTrace();
		}
	}
	
	public static void testePessoa(){
		PessoaDAO ctrl = new PessoaDAO();
		
		Pessoa pessoa = new Pessoa(null, "John", 12345678901l, new Date(1980, 1, 10));
		
		try {
			insert = ctrl.inserir(pessoa);
			pessoa = ctrl.buscaPorId(5);
			
			pessoa.setNmPessoa("Jane Doe");
			ctrl.alterar(pessoa);
			
			ctrl.excluir(3);
		} catch (PessoaExection e) {
			e.printStackTrace();
		}
	}
		
	public static void testeOferta() {
		DisciplinaCtrl disciplinaCtrl = new DisciplinaCtrl();
		OfertaCtrl ctrl = new OfertaCtrl();
		ProfessorCtrl professorCtrl = new ProfessorCtrl();

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Oferta offer = new Oferta(null, professorCtrl.buscaPorId(5), disciplinaCtrl.buscaPorId(10), simpleDateFormat.parse("13/04/2019"), simpleDateFormat.parse("08/09/1999"), Dia.SEXTA, "12:00");
			
			ctrl.inserir(offer);
			
			Oferta oferta = ctrl.buscaPorId(05);
			oferta.setDia(Dia.QUARTA);
			ctrl.alterar(oferta);
			
			for(Oferta o : ctrl.buscaTodos()) {
				System.out.println(o);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void testeProfessor() {
		ProfessorCtrl ctrl = new ProfessorCtrl();
		PessoaCtrl pessoaCtrl = new PessoaCtrl();
		
		Professor prof = new Professor(null, pessoaCtrl.buscaPorId(5), Escolaridade.DOUTORADO);
		ctrl.inserir(prof);
		
		prof = ctrl.buscaPorId(5);
		prof.setEscolaridade(Escolaridade.MESTRADO);
		ctrl.alterar(prof);
	}
	
	public static void testeAluno() {
		PessoaCtrl pessoa = new PessoaCtrl();
		CursoCtrl course = new CursoCtrl();
		AlunoCtrl studnt = new AlunoCtrl();
		
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2021-4-9");
			
			Aluno aluno = new Aluno(null, date, true, pessoa.buscaPorId(6), course.buscaPorId(5));
			
			studnt.inserir(aluno);
			
			System.out.println(studnt.buscaPorId(2));
			
			for(Aluno al: studnt.buscaTodos()) {
				System.out.println(al);
			}
			
			System.out.println("--------------------------------------------------");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void testeMatricula() {
		AlunoCtrl studnt = new AlunoCtrl();
		OfertaCtrl offer = new OfertaCtrl();
		MatriculaCtrl mat = new MatriculaCtrl();
	
		Matricula mat1 = new Matricula(null, studnt.buscaPorId(1), offer.buscaPorId(12));
		mat.inserir(mat1);
		
		System.out.println("--------------------------------------------------");
		System.out.println("Registered Matriculations:");
		for (Matricula mats: mat.buscaTodos()) {
			System.out.println(mats);
		}
		
		//Buscando por id
		System.out.println("--------------------------------------------------");
		System.out.println("ID 5 Matriculation:");
		System.out.println(mat.buscaPorId(5));
	}
}
