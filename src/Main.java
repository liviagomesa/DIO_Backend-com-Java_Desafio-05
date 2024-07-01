import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ExceptionSaldoInsuficiente, ExceptionCpfNaoEncontrado {
		// criando o objeto scanner para leitura de entradas do usuário no console
		Scanner scanner = new Scanner(System.in);

		// inicialização do banco
		Banco banco = new Banco();
		banco.setNome("Stellar");
		System.out.println("Seja bem-vindo ao banco " + banco.getNome());

		// inicialização da lista de clientes
		ListaClientes listaClientes = new ListaClientes();

		// processo de login
		Cliente clienteLogado = null;
		while (clienteLogado == null) {
			try {
				System.out.println("Digite o CPF do titular da conta que deseja acessar: ");
				String cpf = scanner.nextLine();
				Cliente clienteEncontrado = listaClientes.buscarPorCpf(cpf);

				System.out.println("Agora, digite a senha: ");
				String senha = scanner.nextLine();
				if (!clienteEncontrado.getSenha().equals(senha)) {
					throw new ExceptionSenhaInvalida();
				} else {
					clienteLogado = clienteEncontrado;
					System.out.println("Olá, " + clienteLogado.getNome()
							+ "! Você está logado.");
					banco.imprimirOpcoes();
				}

			} catch (ExceptionCpfNaoEncontrado e) {
				System.out.println(e.getMessage());
			} catch (ExceptionSenhaInvalida e) {
				System.out.println(e.getMessage());
			}
		}

		// mostrar opções para o usuário logado
		int opcaoDesejada = -1;
		while (opcaoDesejada != 0) {
			try {
				System.out.println(
						"Digite a opção desejada:");
				opcaoDesejada = scanner.nextInt();
				scanner.nextLine();
				switch (opcaoDesejada) {
					// sair
					case 0:
						break;
					// ver saldo cc
					case 1:
						System.out.println(
								"Seu saldo disponível na conta corrente é de R$" + clienteLogado.getSaldoCc());
						break;
					// ver saldo poupanca
					case 2:
						System.out.println(
								"Seu saldo disponível na conta poupança é de R$" + clienteLogado.getSaldoPoupanca());
						break;
					// transferir
					case 3:
						System.out.println("Digite o valor que deseja transferir (seu saldo disponível é de R$"
								+ clienteLogado.getSaldoCc() + "):");
						double valorTransferir = scanner.nextDouble();
						scanner.nextLine();
						clienteLogado.verificarValorDisponivel(valorTransferir);

						String confirmacao = "n";
						Cliente clienteDestino = null;
						while (!confirmacao.equals("s")) {
							System.out.println("Digite o CPF do cliente de destino:");
							String cpfDestino = scanner.nextLine();
							clienteDestino = listaClientes.buscarPorCpf(cpfDestino);
							System.out.println(
									"Você deseja transferir para " + clienteDestino.getNome() + ", confirma? (s/n)");
							confirmacao = scanner.nextLine();
						}
						listaClientes.transferir(clienteLogado, valorTransferir, clienteDestino);
						System.out.println("Transferência realizada com sucesso. Saldo restante: R$"
								+ clienteLogado.getSaldoCc());
						break;
					// depositar
					case 4:
						System.out.println("Digite o valor que deseja depositar:");
						double valorDepositar = scanner.nextDouble();
						scanner.nextLine();
						clienteLogado.getCc().depositar(valorDepositar);
						System.out.println("Depósito realizado com sucesso. Saldo atual: R$"
								+ clienteLogado.getSaldoCc());
						break;
					// guardar na poupanca
					case 5:
						System.out.println("Digite o valor que deseja guardar na poupança:");
						double valorGuardar = scanner.nextDouble();
						scanner.nextLine();
						clienteLogado.verificarValorDisponivel(valorGuardar);
						clienteLogado.guardarPoupanca(valorGuardar);
						System.out.println("Valor guardado com sucesso.");
						break;
					// retirar da poupanca
					case 6:
						System.out.println("Digite o valor que deseja retirar da poupança:");
						double valorRetirar = scanner.nextDouble();
						scanner.nextLine();
						clienteLogado.verificarValorDisponivelPoupanca(valorRetirar);
						clienteLogado.retirarPoupanca(valorRetirar);
						System.out.println("Valor retirado com sucesso.");
						break;
					default:
						System.out.println(
								"Entrada inválida. Digite a opção desejada:");
						banco.imprimirOpcoes();
						break;
				}
			} catch (ExceptionSaldoInsuficiente e) {
				System.out.println(e.getMessage());
			} catch (ExceptionCpfNaoEncontrado e) {
				System.out.println(e.getMessage());
			}
		}

		scanner.close();
	}
}
