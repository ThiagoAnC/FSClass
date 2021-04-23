package br.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fullstack.model.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
