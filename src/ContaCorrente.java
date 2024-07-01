
public class ContaCorrente extends Conta {

	public ContaCorrente() {
		super();
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}

}
