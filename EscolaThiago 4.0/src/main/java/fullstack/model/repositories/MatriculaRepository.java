package br.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.fullstack.model.entities.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{
	//VER ESTAS CONSULTAS
	//Fazer consulta para recuperar matricula de um determinado aluno
	@Query("SELECT matricula FROM Matricula m WHERE m.id_aluno = id")
	public Integer recuraMatriculaAluno(@Param("id") Integer id);
}
