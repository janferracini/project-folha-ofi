package br.edu.faculdadealfa.projectfolhaofi.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { 
	//faz o CRUD no DB <Tipo da classe, TipoID>
	//Optional<Funcionario> findById(Long id);
	
	List<Funcionario> findByNome(String nome);
	
	Funcionario findByCpf(String cpf);
}
