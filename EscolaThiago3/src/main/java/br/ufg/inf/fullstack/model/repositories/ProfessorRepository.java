package br.ufg.inf.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufg.inf.fullstack.model.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
