package br.edu.faculdadealfa.projectfolhaofi.model.process;

import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadealfa.projectfolhaofi.model.Evento;
import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;
import br.edu.faculdadealfa.projectfolhaofi.model.Holerite;
import br.edu.faculdadealfa.projectfolhaofi.model.Enuns.TipoEvento;
import br.edu.faculdadealfa.projectfolhaofi.model.Enuns.TipoFolha;
import br.edu.faculdadealfa.projectfolhaofi.model.interfaces.Calculo;

public class CalculoSalario implements Calculo {

	@Override
	public Holerite calcular(Funcionario func, Integer competencia) {
		
		return null;
	}

	@Override
	public List<Holerite> calcular(List<Funcionario> funcionarios, Long idInicio, Long idFim, Integer competencia) {
		List<Holerite> holerites = new ArrayList<>();

		funcionarios.forEach(func -> {
			if (func.getId() >= idInicio && func.getId() <= idFim) {
				Holerite holerite = new Holerite(1l, func, TipoFolha.SALARIO, competencia);
				List<Evento> eventos = new ArrayList<>();

				Evento salarioBase = new Evento("Sal�rio Base", func.getSalarioBase(), TipoEvento.PROVENTO);
				eventos.add(salarioBase);

				Evento inss = new Evento("INSS", ((salarioBase.getValor() / 100) * 9d), TipoEvento.DESCONTO);
				eventos.add(inss);

				holerite.setEventos(eventos);
				holerites.add(holerite);
			}
		});

		return holerites;
	}

}