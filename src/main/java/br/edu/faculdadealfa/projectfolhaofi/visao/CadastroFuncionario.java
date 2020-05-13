package br.edu.faculdadealfa.projectfolhaofi.visao;

import java.text.DecimalFormat;
import java.util.Scanner;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;

public class CadastroFuncionario {
	
	public static Funcionario cadastrar(Scanner s) {
		DecimalFormat df = new DecimalFormat("0.##");

		//static -> chama direto, n�o precisa instanciar - n�o precisa de new cadastr...
		
		/*uma classe que serve para um processo, n�o precisa de instanciar para executar, chama direto*/
		Funcionario funcionario = new Funcionario();
		
		System.out.println("Digite o nome do funcionário: ");
		funcionario.setNome(s.next());

		System.out.println("Digite o salário de " + funcionario.getNome() + ":");
		funcionario.setSalarioBase(s.nextDouble());
		
		System.out.println("Digite o cargo de " + funcionario.getNome() + ":");
		funcionario.setCargo(s.next());

		System.out.println("Funcionario Cadastrado! \n" + "Nome: " + funcionario.getNome() + 
				"\nSalário:  R$" + df.format(funcionario.getSalarioBase()) + "\nCargo: " + funcionario.getCargo());
		System.out.println();
		
		return funcionario;
	}
}
 