package br.edu.faculdadealfa.projectfolhaofi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;
import br.edu.faculdadealfa.projectfolhaofi.model.funcoes.CadastroFuncionario;
import br.edu.faculdadealfa.projectfolhaofi.model.funcoes.EmissaoHolerite;
import br.edu.faculdadealfa.projectfolhaofi.model.funcoes.ListarFuncionario;


@SpringBootApplication
public class ProjectFolhaOfiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectFolhaOfiApplication.class, args);
		DecimalFormat df = new DecimalFormat("0.##");
		Scanner s = new Scanner(System.in);
		List<Funcionario> funcionarios = new ArrayList<>();
		int opcao = 0;
		int contId = 0;

		do {

			System.out.println(" ----------  MENU  --------- ");
			System.out.println("| 1 - Funcionário           |");
			System.out.println("| 2 - Folha de pagamento    |");
			System.out.println("| 3 - SAIR                  |");
			System.out.println(" --------------------------- ");
			opcao = s.nextInt();

			switch (opcao) {
			case 1:// Escolha funcionário
				System.out.println(" ------  FUNCIONÁRIOS ------ ");
				System.out.println("| 1 - Cadastrar Funcionário |");
				System.out.println("| 2 - Listar Funcionários   |");
				System.out.println("| 3 - Voltar                |");
				System.out.println(" --------------------------- ");
				opcao = s.nextInt();
					switch (opcao) {
					case 1:
						contId++;
						System.out.println("Cadastro nº " + contId );
						//int i = 0; // constante - não cadastra com variavel
						//estático
						funcionarios.add(CadastroFuncionario.cadastrar(s)); // adiciona à lista
						break;
						
						
						
						
					case 2:
						System.out.println("Funcionários Cadastrados:");
						
						ListarFuncionario.listarFunc(funcionarios, s);
						
						
						break;
					case 3: //volta ao menu
						opcao = 1;
						break;
					default:
						System.out.println("Opção inválida.");
						break;
					}
				
	
				break;

			case 2: // calculo folha		
				EmissaoHolerite.emitirHolerite(funcionarios, s).forEach(holerite -> { // estático - chama sem instanciar
																						// ( = new ) / foreach - método
																						// de lista
					System.out.println("-------- " + holerite.getTipoFolha().getDescricao() + " --------");
					System.out.println("Funcionário " + holerite.getFuncionario().getNome());
					System.out.println("Salário R$"+ df.format(holerite.getFuncionario().getSalarioBase()));
					System.out.println("Cargo: " + holerite.getFuncionario().getCargo());
					System.out.println("Competência: " + holerite.getCompetencia());
					System.out.println("");
					holerite.getEventos().forEach(evento->{ //puxa a lista de eventos, para cada evento, adiciona uma linha
						//vai listar os proventos e descontos
						System.out.println(evento.toString());
					});
					//calculo dos totais
					System.out.println("");
					System.out.println("Vencimentos: R$" + df.format(holerite.getVencimentos()));
					System.out.println("Descontos: R$" + df.format(holerite.getDescontos()));
					System.out.println("Total: R$" + df.format(holerite.getTotal()));
					System.out.println("");
				});; //retorna a lista de holerites
				
				
				break;
			case 3: // sair
				System.out.println("Saindo da aplicação...");
				break;
			
			
			
			default:
				System.out.println("Você digitou uma tecla inválida, informe [1 | 2 | 3]");
				break;
			}
		} while (opcao != 3);
		s.close(); // encerra o objeto scanner
	}

}