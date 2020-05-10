package br.edu.faculdadealfa.projectfolhaofi.model.interfaces;

import java.util.List;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;
import br.edu.faculdadealfa.projectfolhaofi.model.Holerite;

public interface Calculo {
	public abstract Holerite calcular(Funcionario func, Integer competencia); //vai retornar holerite e tem o m�todo calcular, recebe funcion�rio
	//recebe funcion�rio e devolve holerite
	
	public abstract List<Holerite> calcular (List<Funcionario> funcionarios, Long idInicio, Long idFim, Integer conpetencia);
	//retorna lista de holetires e recebe a lista de infos da lista de funcion�rios
 }
