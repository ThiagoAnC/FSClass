package br.ufg.inf.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufg.inf.fullstack.model.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
}
