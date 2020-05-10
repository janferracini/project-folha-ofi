package br.edu.faculdadealfa.projectfolhaofi.model.process;

import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadealfa.projectfolhaofi.model.Evento;
import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;
import br.edu.faculdadealfa.projectfolhaofi.model.Holerite;
import br.edu.faculdadealfa.projectfolhaofi.model.Enuns.TipoEvento;
import br.edu.faculdadealfa.projectfolhaofi.model.Enuns.TipoFolha;
import br.edu.faculdadealfa.projectfolhaofi.model.interfaces.Calculo;

public class CalculoDecimoTer implements Calculo {

	@Override
	public Holerite calcular(Funcionario func, Integer competencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Holerite> calcular(List<Funcionario> funcionarios, Long idInicio, Long idFim, Integer competencia) {
		List<Holerite> holerites = new ArrayList<>();
		funcionarios.forEach(func->{ //faz um holerite para cada funcion�rio
			
			if(func.getId() >= idInicio && func.getId() <= idFim) { //toda vez que entrar em um func, vai criar um holerite.
				
				Holerite holerite = new Holerite(1l, func, TipoFolha.DECIMOTERCEIRO, competencia); //puxa direto o tipo de folha fixo
				List<Evento> eventos = new ArrayList<>(); //cria��o da lista de eventos
				
				Evento decimo = new Evento("Valor do 13� R$", (func.getSalarioBase()/12), TipoEvento.PROVENTO);
				eventos.add(decimo); //adiciona na lista de eventos para passar ao holetire
				
				Evento inss = new Evento("INSS" , ((decimo.getValor() / 100) * 9d), TipoEvento.DESCONTO); //conta retorna 9%
				eventos.add(inss);
				
				 
				holerite.setEventos(eventos); //coloca os eventos dentro do holerite do funcion�rio
				holerites.add(holerite); //adiciona o holerite na lista de holerites dos funcion�rios
			}
			
		});
		
		return holerites;
	}

}
