package br.edu.faculdadealfa.projectfolhaofi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.edu.faculdadealfa.projectfolhaofi.model.Enuns.TipoEvento;
import br.edu.faculdadealfa.projectfolhaofi.model.Enuns.TipoFolha;

//CTRL SFT O - importa o que falta

@Entity
public class Holerite {

	@Id // gerar id novo automaticamente
	@GeneratedValue(strategy = GenerationType.IDENTITY) // vê a estratégia do DB, incrementa id
	private Long id;

	@ManyToOne // Vários holerites para um func
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "holerite")
	private List<Evento> eventos;

	private TipoFolha tipoFolha;
	private Integer competencia = 0;
	private Double vencimentos = new Double(0);
	private Double descontos = new Double(0);

	public Holerite(Long id, Funcionario funcionario, TipoFolha tipoFolha, Integer competencia) {
		this.id = id;
		this.funcionario = funcionario;
		this.tipoFolha = tipoFolha;
		this.competencia = competencia;
	}

	public Holerite() {

	}

	public Double getVencimentos() {
		return vencimentos;
	}

	public void setVencimentos(Double vencimentos) {
		this.vencimentos = vencimentos;
	}

	public Double getDescontos() {
		return descontos;
	}

	public void setDescontos(Double descontos) {
		this.descontos = descontos;
	}

	public Double getTotal() {
		return (vencimentos - descontos);
	}

	/*
	 * public void setTotal(Double total) { this.total = vencimentos - descontos; }
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public TipoFolha getTipoFolha() {
		return tipoFolha;
	}

	public void setTipoFolha(TipoFolha tipoFolha) {
		this.tipoFolha = tipoFolha;
	}

	public Integer getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Integer competencia) {
		this.competencia = competencia;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		eventos.forEach(evento -> {
			if (evento.getTipoEvento().equals(TipoEvento.PROVENTO)) {
				vencimentos = vencimentos + evento.getValor();
			}

			if (evento.getTipoEvento().equals(TipoEvento.DESCONTO)) {
				descontos = descontos + evento.getValor();
			}

		});
		this.eventos = eventos;
	}

}
