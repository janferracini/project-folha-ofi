package br.edu.faculdadealfa.projectfolhaofi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { 
	//faz o CRUD no DB <Tipo da classe, TipoID>
	//Optional<Funcionario> findById(Long id);
}
