package br.edu.faculdadealfa.projectfolhaofi.model.funcoes;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;

public class ListarFuncionario {
	public static List<Funcionario> listarFunc(List<Funcionario> funcionarios, Scanner s) {
		DecimalFormat df = new DecimalFormat("##.##");
		
		for (int i = 0; i < funcionarios.size(); i++) {
			System.out.println("ID: " + funcionarios.get(i).getId());
			System.out.println("Nome: " + funcionarios.get(i).getNome());
			System.out.println("Cargo: " + funcionarios.get(i).getCargo());
			System.out.println("Sal�rio: R$" + df.format(funcionarios.get(i).getSalarioBase()));
			System.out.println("");
		}
		
		return null;
		
		
		
	}
}
