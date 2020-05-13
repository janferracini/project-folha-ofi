package br.edu.faculdadealfa.projectfolhaofi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;
import br.edu.faculdadealfa.projectfolhaofi.model.repository.FuncionarioRepository;

// quando faz a anotação controlller, ele vai importar o controller do pacote spring
// diz que ela quem vai fazer o controle entre a visao e os models

@RestController //requisições rest - classe controladora entre a visão e o modelo
@RequestMapping("funcionario") //quando chamar o endereço da app, cai nesse controlador

public class FuncionarioController {

	@Autowired
	FuncionarioRepository repository;  //fala qual classe vai ser o repositório (injeção de dependencia)

	// metodo salvar
	public Funcionario salvar(Funcionario funcionario) {
		return repository.save(funcionario);
	}

	// listar
	@GetMapping("listar")
	public List<Funcionario> listar() {
		return repository.findAll();
	}
	
	public Funcionario buscarPorId(Long id) {
		return repository.getOne(id);
	}

	// remover
	public Boolean remover(Funcionario funcionario) {
		repository.delete(funcionario);
		return true;
	}
}