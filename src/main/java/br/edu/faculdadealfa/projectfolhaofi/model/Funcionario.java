package br.edu.faculdadealfa.projectfolhaofi.model;

import java.time.LocalDateTime;
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

import br.edu.faculdadealfa.projectfolhaofi.controller.dto.FuncionarioDto;

//mapeamento da tabela do DB
@Entity
public class Funcionario extends TemplateTable {

	@Id // gerar id novo automaticamente
	@GeneratedValue(strategy = GenerationType.IDENTITY) // vê a estratégia do DB, incrementa id
	private Long id;

	@NotBlank(message = "Informe o nome") // valida o campo para não estar em branco
	@Length(min = 4, max = 100) // qnt máxima e mínima de caracteres
	private String nome;

	@NotNull(message= "Informe um CPF")
	@CPF(message = "Informe um CPF válido") // também tem CNPJ
	private String cpf;

	@NotNull(message = "Informe o salário") // validação com mensagem
	private Double salarioBase;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario") // "funcionario" vem da CLASSE Endereco
	// se excluir o func, apaga também os endereços relacionados, qual o campo à ser
	// mapeado
	private List<Endereco> enderecos;
	// cria uma lista de endereços para o funcionário
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
	private List<Holerite> holerites;
	
	private String cargo;

	// dois construtores para que n�o precise inserir infos
	public Funcionario() {

	}
	
	public Funcionario(FuncionarioDto dto) {
		this.nome = dto.getNome();
		this.cpf = dto.getCpf();
		this.salarioBase = dto.getSalarioBase();
		
		this.setCodigoUsuario(dto.getCodigoUsuario());
		this.setDataAlteracao(LocalDateTime.now());
	}
	

	public Funcionario(String nome, Double salarioBase) {
		this.nome = nome;
		this.salarioBase = salarioBase;
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
	
	public List<Holerite> getHolerites() {
		return holerites;
	}

	public void setHolerites(List<Holerite> holerites) {
		this.holerites = holerites;
	}

	

}
