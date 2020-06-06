package br.edu.faculdadealfa.projectfolhaofi.controller.dto;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;

//Objeto de Transferência de Dados  - DAO - conecta direto com o DB
public class FuncionarioDto {
	private Long id;
	private String nome;
	private String cpf;
	private Double salarioBase;
	private Integer codigoUsuario;

	public FuncionarioDto(Funcionario func) {
		this.id = func.getId();
		this.nome = func.getNome();
		this.cpf = func.getCpf();
		this.salarioBase = func.getSalarioBase();
		this.codigoUsuario = func.getCodigoUsuario();
	}

	public FuncionarioDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

}
