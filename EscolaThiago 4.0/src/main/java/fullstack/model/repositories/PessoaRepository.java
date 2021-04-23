package br.fullstack.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fullstack.model.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
