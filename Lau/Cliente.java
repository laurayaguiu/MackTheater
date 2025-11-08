

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Pedido> pedidos;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pedidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void adicionaPedido(Pedido pedido) {
        if (pedido != null && !pedido.isVazio()) {
            pedidos.add(pedido);
        }
    }

    @Override
    public String toString() {
        return nome + " - CPF: " + cpf;
    }
}
