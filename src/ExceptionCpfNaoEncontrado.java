public class ExceptionCpfNaoEncontrado extends Exception {
    public ExceptionCpfNaoEncontrado() {
        super("CPF não cadastrado. Tente novamente.");
    }
}
