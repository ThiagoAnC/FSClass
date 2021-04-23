package br.fullstack.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.fullstack.model.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	//VER ESTAS CONSULTAS
	@Query("SELECT a FROM Aluno a WHERE a.nmAluno LIKE %:name%")
	public List<Aluno> findByNmAluno(@Param("name") String name);
	
	@Query("SELECT a FROM Aluno a WHERE a.ativo = 1")
	public List<Aluno> findByAtivo();
	
	//Fazer consulta para recuperar a lista de alunos de um determinado curso
	@Query("SELECT id_aluno FROM Aluno a WHERE a.id_curso = id")
	public List<Integer> recuperaAlunosCurso(@Param("id") Integer id);
}
