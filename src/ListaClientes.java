import java.util.*;

public class ListaClientes {
    List<Cliente> listaClientes;

    // construtor
    public ListaClientes() {
        // cadastrando os clientes
        listaClientes = Arrays.asList(
                new Cliente("Joao", "senhaJoao", "12359125744"),
                new Cliente("Maria", "senhaMaria", "11111111111"),
                new Cliente("Enzo", "senhaEnzo", "10101010101"),
                new Cliente("Valentina", "senhaValentina", "12345678910"),
                new Cliente("Livia", "senhaLivia", "12345678901"));
    }

    // método de busca pelo CPF
    Cliente buscarPorCpf(String cpf) throws ExceptionCpfNaoEncontrado {
        for (Cliente c : listaClientes) {
            if (cpf.equals(c.getCpf())) {
                return c;
            }
        }
        throw new ExceptionCpfNaoEncontrado();
    }

    public void transferir(Cliente clienteOrigem, double valor, Cliente clienteDestino) {
        clienteOrigem.getCc().sacar(valor);
        clienteDestino.getCc().depositar(valor);
    }

}
