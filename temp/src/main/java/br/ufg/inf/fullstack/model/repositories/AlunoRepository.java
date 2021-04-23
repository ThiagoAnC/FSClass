package br.ufg.inf.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufg.inf.fullstack.model.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
