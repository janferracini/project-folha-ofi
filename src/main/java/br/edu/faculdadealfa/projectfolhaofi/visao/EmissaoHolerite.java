package br.edu.faculdadealfa.projectfolhaofi.visao;

import java.util.List;
import java.util.Scanner;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;
import br.edu.faculdadealfa.projectfolhaofi.model.Holerite;
import br.edu.faculdadealfa.projectfolhaofi.model.interfaces.Calculo;
import br.edu.faculdadealfa.projectfolhaofi.model.process.CalculoDecimoTer;
import br.edu.faculdadealfa.projectfolhaofi.model.process.CalculoFerias;
import br.edu.faculdadealfa.projectfolhaofi.model.process.CalculoSalario;

public class EmissaoHolerite {
	public static List<Holerite> emitirHolerite(List<Funcionario> funcionarios, Scanner s) {

		System.out.println(" ---- FOLHA DE PAGAMENTO --- ");
		System.out.println("| 1 - Salário               |");
		System.out.println("| 2 - Décimo Terceiro       |");
		System.out.println("| 3 - Férias                |");
		System.out.println("| 4 - VOLTAR                |");
		System.out.println("|---------------------------|");
		int opcao = s.nextInt();
		
		System.out.println("ID de inicio");
		Long idInicio = s.nextLong();
		System.out.println("ID final");
		Long idFim = s.nextLong();
		
		System.out.println("Digite a competência: ");
		Integer competencia = s.nextInt();

		switch (opcao) {
		case 1: // Calculo de Salário - apenas chama a função de calculo do salário
			Calculo calculoS = new CalculoSalario();
			return calculoS.calcular(funcionarios, idInicio, idFim, competencia);	
			
		case 2: // Calculo de Férias
			Calculo calculoD = new CalculoDecimoTer();
			return calculoD.calcular(funcionarios, idInicio, idFim, competencia);	
			
		case 3: // Calculo de 13�
			Calculo calculoF = new CalculoFerias();
			return calculoF.calcular(funcionarios, idInicio, idFim, competencia);	
			
		case 4: // Voltar ao MENU
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
		opcao = 0;
		return null;
	}
}
