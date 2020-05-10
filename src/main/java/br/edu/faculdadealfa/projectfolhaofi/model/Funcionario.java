package br.edu.faculdadealfa.projectfolhaofi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;


//mapeamento da tabela do DB
@Entity
public class Funcionario {

	@Id //gerar id novo automaticamente
	@GeneratedValue( strategy = GenerationType.IDENTITY ) //vê a estratégia do DB, incrementa id
	private Long id;
	
	@NotBlank(message = "Informe o nome") //valida o campo para não estar em branco 
	@Length(min = 4, max = 100) //qnt máxima e mínima de caracteres
	private String nome;
	
	@CPF(message = "Informe um CPF válido")
	private String cpf;
	
	@NotNull(message = "Informe um salário válido") //validação com mensagem
	private Double salarioBase;
	
	private String cargo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario") 
	//se excluir o func, apaga também os endereços relacionados, qual o campo à ser mapeado
	private List<Endereco> enderecos;
	

	// dois construtores para que n�o precise inserir infos
	public Funcionario() {

	}

	public Funcionario(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
}
