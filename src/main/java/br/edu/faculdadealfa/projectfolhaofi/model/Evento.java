package br.edu.faculdadealfa.projectfolhaofi.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.edu.faculdadealfa.projectfolhaofi.model.Enuns.TipoEvento;

@Entity
public class Evento {
		
	@Id //gerar id novo automaticamente
	@GeneratedValue( strategy = GenerationType.IDENTITY ) //vê a estratégia do DB
	private Long id;
	
	private String descricao;
	private Double valor;
	
	@ManyToOne
	private Holerite holerite;
	
	//vai editar aqui ainda
	private TipoEvento tipoEvento;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Evento(String descricao, Double valor, TipoEvento tipoEvento) {
		this.descricao = descricao;
		this.valor = valor;
		this.tipoEvento = tipoEvento;
	}
	
	public Evento() {
		
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	
	public String toString() {
		return tipoEvento + " - " + descricao  + " R$" + valor ;
	}

	public Holerite getHolerite() {
		return holerite;
	}

	public void setHolerite(Holerite holerite) {
		this.holerite = holerite;
	}

}