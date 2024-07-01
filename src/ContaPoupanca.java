
public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupanca ===");
		super.imprimirInfosComuns();
	}
}
