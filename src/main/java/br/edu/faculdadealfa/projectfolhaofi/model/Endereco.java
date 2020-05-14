package br.edu.faculdadealfa.projectfolhaofi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco { // classe que faz ref. a DB

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DESCRICAO_ENDERECO") // infoma a coluna caso já exista a table no DB / usa um nome !=
	private String logradouro;

	@ManyToOne // vários endereços para um funcionário
	@JoinColumn(name = "funcionario_id") // qual coluna vai servir de FK no DB
	private Funcionario funcionario; // para vincular à classe Funcionário

	private Integer numero;
	private String cep;

	// alt sft S + R - getter setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
