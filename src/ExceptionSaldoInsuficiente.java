public class ExceptionSaldoInsuficiente extends Exception {
    public ExceptionSaldoInsuficiente() {
        super("Você não possui saldo suficiente para realizar esta operação. Tente novamente.");
    }
}
