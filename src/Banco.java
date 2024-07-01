import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public void imprimirOpcoes() {
		System.out.println(
				"0 - Sair\n1 - Ver saldo na conta corrente\n2 - Ver saldo na conta poupança\n3 - Pagar via Pix\n4 - Depositar na conta corrente\n5 - Guardar na poupança\n6 - Retirar da poupança");
	}

}
