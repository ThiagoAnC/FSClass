package br.fullstack.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.fullstack.model.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
	//VER ESTAS CONSULTAS
	@Query("SELECT c FROM Curso c WHERE c.nmCurso LIKE %:name%")
	public List<Curso> findByNmCurso(@Param("name") String name);

}
