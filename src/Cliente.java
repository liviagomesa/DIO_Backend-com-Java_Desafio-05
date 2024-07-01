public class Cliente {

	private String nome;
	private String senha;
	private Conta cc;
	private Conta poupanca;
	private String cpf;

	// construtor
	public Cliente(String nome, String senha, String cpf) {
		this.nome = nome;
		this.senha = senha;
		this.cc = new ContaCorrente();
		this.poupanca = new ContaPoupanca();
		this.cpf = cpf;
	}

	// toString
	@Override
	public String toString() {
		return nome + ": CC - " + cc + " // Poupanca - " + poupanca;
	}

	// getters
	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public String getCpf() {
		return cpf;
	}

	public double getSaldoCc() {
		return this.cc.getSaldo();
	}

	public double getSaldoPoupanca() {
		return this.poupanca.getSaldo();
	}

	public Conta getCc() {
		return cc;
	}

	public Conta getPoupanca() {
		return poupanca;
	}

	public void verificarValorDisponivel(double valorTransferir) throws ExceptionSaldoInsuficiente {
		if (valorTransferir > this.getSaldoCc()) {
			throw new ExceptionSaldoInsuficiente();
		}
	}

	public void verificarValorDisponivelPoupanca(double valorTransferir) throws ExceptionSaldoInsuficiente {
		if (valorTransferir > this.getSaldoPoupanca()) {
			throw new ExceptionSaldoInsuficiente();
		}
	}

	public void guardarPoupanca(double valor) {
		this.getCc().sacar(valor);
		this.getPoupanca().depositar(valor);
	}

	public void retirarPoupanca(double valor) {
		this.getPoupanca().sacar(valor);
		this.getCc().depositar(valor);
	}

}
